/*
* AssessmentResultsFragment.java
* Fragment used to display the results of an assessment. Appears after an assessment is taken or when a user views an older assessment
* from their history
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright � 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright � 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
package com.t2.cbti.mysleep;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTi_BaseFragment;

public class AssessmentResultsFragment extends CBTi_BaseFragment
{
	private AssessmentStartData cData31b;
	private AssessmentQuestionnaireData cData31c;
	private boolean backButtonPressed = true;
	
	@SuppressLint("InflateParams")
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