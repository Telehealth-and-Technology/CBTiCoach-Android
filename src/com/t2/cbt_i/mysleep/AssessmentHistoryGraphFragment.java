package com.t2.cbt_i.mysleep;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class AssessmentHistoryGraphFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmenthistorygraph, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_History));
		
		// middle buttons
		((Button) getView().findViewById(R.id.bShowAssessmentDetails)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();					    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.assessmentfragment, new AssessmentHistoryListFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bClearHistory)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Build the dialog
				AlertDialog.Builder alert = new AlertDialog.Builder(getSherlockActivity());
				alert.setTitle(getString(R.string.s_32cTitle));
				alert.setMessage(R.string.s_32c);
				alert.setIcon(R.drawable.cbti_icon);
				alert.setCancelable(false);
				alert.setNegativeButton(R.string.s_Dismiss, null);
				alert.setPositiveButton(R.string.s_Continue, new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int whichButton)
					{
						AssessmentStartData cData31b = new AssessmentStartData(getSherlockActivity());
						cData31b.alISIData.clear();
						cData31b.saveData();

						getFragmentManager().popBackStack();
					}
				});
				alert.create().show();
			}
		});
	}

	private AssessmentStartData cData31b;

	@Override
	public void onResume()
	{
		super.onResume();
		cData31b = new AssessmentStartData(getSherlockActivity());
		if (cData31b.alISIData.isEmpty() && !AssessmentMainFragment.goingBacktoMain)
		{
			final FragmentManager fm = getFragmentManager();
			//Pop the back stack to prevent a infinite loop of going to the history fragment and then back to the blankhistory one and so on
			fm.popBackStack();
		    final FragmentTransaction ft = fm.beginTransaction();					    
		    ft.addToBackStack(null);
		    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
	        ft.replace(R.id.assessmentfragment, new AssessmentBlankHistoryFragment());
		    ft.commit();
		}
		else
		{
			LinearLayout layout = (LinearLayout) getView().findViewById(R.id.chart);
			initChart();
			addData();
			mChart = ChartFactory.getLineChartView(getSherlockActivity(), mDataset, mRenderer);
			// mChart.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_mysleepassessment));
			layout.addView(mChart);
		}
	}

	private GraphicalView mChart;
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	private XYSeries mCurrentSeries;
	private XYSeriesRenderer mCurrentRenderer;

	private void initChart()
	{
		mCurrentSeries = new XYSeries("");
		mDataset.addSeries(mCurrentSeries);
		mCurrentRenderer = new XYSeriesRenderer();
		mRenderer.addSeriesRenderer(mCurrentRenderer);
		mRenderer.setXTitle("Week");
		mRenderer.setYTitle("Symptoms");
		mRenderer.setYAxisMin(0);
		mRenderer.setYAxisMax(28);
		mRenderer.setYLabels(0);
		mRenderer.setXLabels(0);
		mRenderer.setYLabelsAlign(Align.LEFT);
		mRenderer.setGridColor(0xffffff);
		mRenderer.setShowLabels(true);
		mRenderer.setShowGrid(true);
		mRenderer.setShowAxes(true);
		mRenderer.addYTextLabel(3.5, "None");
		mRenderer.addYTextLabel(7, " 7");
		mRenderer.addYTextLabel(10.5, "Mild");
		mRenderer.addYTextLabel(14, "14");
		mRenderer.addYTextLabel(17.5, "Moderate");
		mRenderer.addYTextLabel(21, "21");
		mRenderer.addYTextLabel(24.5, "Severe");
		mRenderer.setMargins(new int[] { 60, 60, 60, 60 });
		mRenderer.setPanEnabled(false);

		mRenderer.setApplyBackgroundColor(true);
		// mRenderer.setBackgroundColor(0xffffff);
		mRenderer.setAxisTitleTextSize(40);
		mRenderer.setLabelsTextSize(30);

		mCurrentRenderer.setLineWidth(3.0f);
		mCurrentRenderer.setFillBelowLine(true);
		mCurrentRenderer.setFillBelowLineColor(Color.argb(80, 204, 85, 0));
		mCurrentRenderer.setColor(Color.rgb(204, 85, 0));
	}

	private void addData()
	{

		ArrayList<Integer> alData = new ArrayList<Integer>();
		ArrayList<Integer> alDate = new ArrayList<Integer>();
		Calendar c = Calendar.getInstance();
		AssessmentQuestionnaireData cData31c;
		int iDateYear = -1;
		int iDateWeek = -1;
		int iPileCtr = 0; // how many entries in pile
		int iPile = 0;
		for (int i = 0; i < cData31b.alISIData.size(); i++)
		{
			cData31c = cData31b.alISIData.get(i);
			c.setTime(new Date(cData31c.lDate));
			int iYear = c.get(Calendar.YEAR);
			int iWeek = c.get(Calendar.WEEK_OF_YEAR);
			if ((iDateYear == -1) || ((iDateYear == iYear) && (iDateWeek == iWeek)))
			{
				iPile += cData31c.iCumScore; // if same week then percolate the
												// data
				iPileCtr++;
				iDateYear = iYear;
				iDateWeek = iWeek;
			}
			else
			{ // done percolating
				alData.add(iPile / iPileCtr);
				alDate.add(iDateWeek);
				iPile = cData31c.iCumScore;
				iPileCtr = 1;
				iDateYear = iYear;
				iDateWeek = iWeek;
			}
		}
		alData.add(iPile / iPileCtr); // the last pile
		alDate.add(iDateWeek);
		for (int i = 0; i < alData.size(); i++)
		{
			mCurrentSeries.add(alDate.get(i), alData.get(i));
			mRenderer.addXTextLabel(alDate.get(i), String.format("%d", alDate.get(i)));
		}
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_assessmenthelp);
		i.putExtra("RID_Text", R.string.s_32ehelp);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
