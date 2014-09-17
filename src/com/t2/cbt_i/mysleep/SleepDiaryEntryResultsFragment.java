/*
 * SleepDiaryEntryResultsFragment.java
 * Fragment used to show the results or summary of a sleep diary entry
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class SleepDiaryEntryResultsFragment extends CBTi_BaseFragment
{
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_sleepdairyentryresults, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_SleepData));

		// DONE
		((Button) getView().findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				getFragmentManager().popBackStack();
				getFragmentManager().popBackStack();
				// Intent i = new Intent(getSherlockActivity(), SleepDairyMainActivity.class);
				// i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				// getSherlockActivity().startActivity(i);
				// getSherlockActivity().overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
			}
		});
	}

	@Override
	public void onResume()
	{
		super.onResume();
		SleepDiaryEntryData cData21c = new SleepDiaryEntryData(getSherlockActivity());

		int hour = cData21c.iTIBDailymin / 60;
		int minute = cData21c.iTIBDailymin % 60;
		String s = String.format(getString(R.string.s_TotalTimeInBed), hour, minute);
		((TextView) getView().findViewById(R.id.tTotalTimeInBed)).setText(s);
		((TextView) getView().findViewById(R.id.tTotalTimeInBed))
				.setContentDescription(String.format(getString(R.string.s_TotalTimeInBedDesc), hour, minute));

		hour = cData21c.iTSTDailymin / 60;
		minute = cData21c.iTSTDailymin % 60;
		s = String.format(getString(R.string.s_TotalTimeAsleep), hour, minute);
		((TextView) getView().findViewById(R.id.tTotalTimeAsleep)).setText(s);
		((TextView) getView().findViewById(R.id.tTotalTimeAsleep))
				.setContentDescription(String.format(getString(R.string.s_TotalTimeAsleepDesc), hour, minute));

		s = String.format(getString(R.string.s_SleepEfficiency), cData21c.iSEDaily);
		((TextView) getView().findViewById(R.id.tSleepEfficiency)).setText(s + "%");
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}
}
