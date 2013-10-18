package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentResultsFragment extends CBTi_BaseFragment
{
	private AssessmentStartData cData31b;
	private AssessmentQuestionnaireData cData31c;
	private boolean backButtonPressed = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentresults, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Feedback));

		// done Button
		((Button) getView().findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Calling one pop makes onPause go twice which is why there is only one here. We want onPause to go after
				getFragmentManager().popBackStack();
			}
		});

		// schedule Button
		((Button) getView().findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				backButtonPressed = false;
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();					    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.assessmentfragment, new AssessmentScheduleReminderFragment());
			    ft.commit();
			}
		});
	}

	@Override
	public void onResume()
	{
		super.onResume();
		
		if(!backButtonPressed)
			backButtonPressed = true;
		
		cData31b = new AssessmentStartData(getSherlockActivity());
		cData31c = new AssessmentQuestionnaireData(getSherlockActivity());
		int iRid;
		int iThisScore = cData31b.alISIData.get(cData31b.alISIData.size() - 1).iCumScore;
		if (cData31b.bProvider)
			iRid = R.string.s_ISIFeedProv;
		else
		{
			Boolean bFirst = (cData31b.alISIData.size() == 1);

			if (bFirst == true)
			{
				if (iThisScore < 10)
					iRid = R.string.s_ISIFeed1;
				else
					iRid = R.string.s_ISIFeed2;
			}
			else
			{
				int iPrevScore = cData31b.alISIData.get(cData31b.alISIData.size() - 2).iCumScore;

				if (iThisScore < 10 && iPrevScore < 10)
					iRid = R.string.s_ISIFeed3;
				else if (iThisScore >= 10 && iPrevScore < 10)
					iRid = R.string.s_ISIFeed4;
				else
					iRid = R.string.s_ISIFeed5;

			}
		}
		((TextView) getView().findViewById(R.id.tISIFeed)).setText(iRid);

		((TextView) getView().findViewById(R.id.tISIScore)).setText(String.format(getString(R.string.s_ISI_Score), cData31c.iCumScore));
		((TextView) getView().findViewById(R.id.tISIScore01)).setText(String.format(getString(R.string.s_ISI_Score01), cData31c.iScore[0]));
		((TextView) getView().findViewById(R.id.tISIScore02)).setText(String.format(getString(R.string.s_ISI_Score02), cData31c.iScore[1]));
		((TextView) getView().findViewById(R.id.tISIScore03)).setText(String.format(getString(R.string.s_ISI_Score03), cData31c.iScore[2]));
		((TextView) getView().findViewById(R.id.tISIScore04)).setText(String.format(getString(R.string.s_ISI_Score04), cData31c.iScore[3]));
		((TextView) getView().findViewById(R.id.tISIScore05)).setText(String.format(getString(R.string.s_ISI_Score05), cData31c.iScore[4]));
		((TextView) getView().findViewById(R.id.tISIScore06)).setText(String.format(getString(R.string.s_ISI_Score06), cData31c.iScore[5]));
		((TextView) getView().findViewById(R.id.tISIScore07)).setText(String.format(getString(R.string.s_ISI_Score07), cData31c.iScore[6]));
	}

	@Override
	public void onStop()
	{
		super.onStop();
		if(backButtonPressed)
		{
			AssessmentMainFragment.goingBacktoMain = true;
			try
			{
				getFragmentManager().popBackStack();
				getFragmentManager().popBackStack();
				getFragmentManager().popBackStack();
				getFragmentManager().popBackStack();
			}
			catch(Exception ex){}
		}
	}
	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}
}