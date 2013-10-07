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
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class AssessmentHistoryGraphActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmenthistorygraph);

		// middle buttons
		((Button)findViewById(R.id.bShowAssessmentDetails)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentHistoryGraphActivity.this, AssessmentHistoryListActivity.class );
				AssessmentHistoryGraphActivity.this.startActivity(i);
				AssessmentHistoryGraphActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bClearHistory)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				// Build the dialog
				AlertDialog.Builder alert = new AlertDialog.Builder(AssessmentHistoryGraphActivity.this);
				alert.setTitle(getString(R.string.s_32cTitle));
				alert.setMessage(R.string.s_32c);
				alert.setIcon(R.drawable.cbti_icon);
				alert.setCancelable(false);
				alert.setNegativeButton(R.string.s_Dismiss, null);
				alert.setPositiveButton(R.string.s_Continue, new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int whichButton) {
		            	AssessmentStartData cData31b = new AssessmentStartData(AssessmentHistoryGraphActivity.this);
		    			cData31b.alISIData.clear();
		    			cData31b.saveData();
		    			Intent i = new Intent(AssessmentHistoryGraphActivity.this, AssessmentMainActivity.class );
		    			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		    			AssessmentHistoryGraphActivity.this.startActivity(i);
		    			AssessmentHistoryGraphActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);   
		            }
		        });
				alert.create().show();
			}
		});
	}	




	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AssessmentHistoryGraphActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}


	private AssessmentStartData cData31b;
	public GraphicalView mChartView = null;
	@Override
	protected void onResume() {
		super.onResume();
		cData31b = new AssessmentStartData( this );
		if( cData31b.alISIData.isEmpty() ) {
			Intent i = new Intent(AssessmentHistoryGraphActivity.this, AssessmentBlankHistoryActivity.class );
			AssessmentHistoryGraphActivity.this.startActivity(i);
			AssessmentHistoryGraphActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		}
		else {
			LinearLayout layout = (LinearLayout) findViewById(R.id.chart);
			if (mChart == null) {
				initChart();
				//addSampleData();
				addData();
				mChart = ChartFactory.getLineChartView(this, mDataset, mRenderer);
				//mChart.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_mysleepassessment));
				layout.addView(mChart);
			} else {
				mChart.repaint();
			}
		}
	}



	private GraphicalView mChart;
	private XYMultipleSeriesDataset  mDataset = new XYMultipleSeriesDataset();
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	private XYSeries mCurrentSeries;
	private XYSeriesRenderer mCurrentRenderer;

	private void initChart() {
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
		mRenderer.addYTextLabel(  3.5, "None");
		mRenderer.addYTextLabel(  7, " 7");
		mRenderer.addYTextLabel( 10.5, "Mild");
		mRenderer.addYTextLabel( 14, "14");
		mRenderer.addYTextLabel( 17.5, "Moderate");
		mRenderer.addYTextLabel( 21, "21");
		mRenderer.addYTextLabel( 24.5, "Severe");
		mRenderer.setMargins(new int[] { 60, 60, 60, 60 });
		mRenderer.setPanEnabled(false);
		
		mRenderer.setApplyBackgroundColor(true);
		//mRenderer.setBackgroundColor(0xffffff);
		mRenderer.setAxisTitleTextSize(40);
		mRenderer.setLabelsTextSize(30);

		mCurrentRenderer.setLineWidth(3.0f);
		mCurrentRenderer.setFillBelowLine(true);
		mCurrentRenderer.setFillBelowLineColor(Color.argb(80, 204, 85, 0));
		mCurrentRenderer.setColor(Color.rgb(204, 85, 0));
	}

	
	private void addData() {

		ArrayList<Integer> alData = new ArrayList<Integer>();
		ArrayList<Integer> alDate = new ArrayList<Integer>();
		Calendar c = Calendar.getInstance();
		AssessmentQuestionnaireData cData31c;
		int iDateYear = -1;
		int iDateWeek = -1;
		int iPileCtr = 0;										// how many entries in pile
		int iPile = 0;
		for( int i=0 ; i<cData31b.alISIData.size() ; i++ ) {
			cData31c = cData31b.alISIData.get(i);
			c.setTime(new Date(cData31c.lDate));
			int iYear = c.get(Calendar.YEAR);
			int iWeek = c.get(Calendar.WEEK_OF_YEAR);
			if( (iDateYear==-1) || ((iDateYear==iYear) && (iDateWeek==iWeek)) ) {	
				iPile += cData31c.iCumScore;					// if same week then percolate the data
				iPileCtr++;
				iDateYear = iYear;
				iDateWeek = iWeek;
			}
			else {												// done percolating
				alData.add( iPile/iPileCtr );
				alDate.add( iDateWeek );
				iPile = cData31c.iCumScore;
				iPileCtr = 1;
				iDateYear = iYear;
				iDateWeek = iWeek;
			}
		}
		alData.add( iPile/iPileCtr );							// the last pile
		alDate.add( iDateWeek );
		for( int i=0 ; i<alData.size() ; i++ ) {
			mCurrentSeries.add(alDate.get(i), alData.get(i) );
			mRenderer.addXTextLabel( alDate.get(i), String.format("%d",alDate.get(i)));
		}
	}
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(AssessmentHistoryGraphActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_assessmenthelp);
		i.putExtra("RID_Text", R.string.s_32ehelp);
		AssessmentHistoryGraphActivity.this.startActivity(i);
		AssessmentHistoryGraphActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
