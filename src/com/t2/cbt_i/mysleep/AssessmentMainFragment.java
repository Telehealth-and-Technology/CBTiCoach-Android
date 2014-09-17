/*
* AssessmentMainFragment.java
* Fragment that will serve as the assessment main menu
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright © 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright © 2009-2014 Contributors. All Rights Reserved.
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
package com.t2.cbt_i.mysleep;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentMainFragment extends CBTi_BaseFragment
{
	public static boolean goingBacktoMain = false;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentmain_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Assessment));

		// middle buttons
		((Button) getView().findViewById(R.id.bTakeAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentStartFragment());
				ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bResultsHistory)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentHistoryGraphFragment());
				ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bScheduleAssessments)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
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
	public void getHelp()
	{
		final FragmentManager fm = getFragmentManager();
		CBTi_BaseFragment current = (CBTi_BaseFragment) fm.findFragmentById(R.id.assessmentfragment);
		if (!(current instanceof AssessmentMainFragment))
		{
			this.goingToHelp = true;
			current.getHelp();
		}
		this.goingToHelp = true;
	}

}
