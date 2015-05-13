/*
 * DashboardFragment.java
 * Fragment used as main menu which handles the menu button clicks
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
package com.t2.cbti.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTi_BaseFragment;
import com.t2.cbti.mysleep.UpdateSleepPrescriptionData;

public class DashboardFragment extends CBTi_BaseFragment
{

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.dashboardfragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		setHasOptionsMenu(true);

		// MySleep Button
		((Button) getView().findViewById(R.id.b10mysleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// MySleep
				((DashboardActivity) getSherlockActivity()).setPage(1);
			}
		});

		// Learn Button
		((Button) getView().findViewById(R.id.b10learn)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Learn
				((DashboardActivity) getSherlockActivity()).setPage(3);
			}
		});

		// Tools Button
		((Button) getView().findViewById(R.id.b10tools)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Tools
				((DashboardActivity) getSherlockActivity()).setPage(2);
			}
		});

		// Reminders Button
		((Button) getView().findViewById(R.id.b10reminders)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Reminders
				((DashboardActivity) getSherlockActivity()).setPage(4);
			}
		});

		((RelativeLayout) getView().findViewById(R.id.rlpb)).setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//The Sleep Prescription RelativeLayout was given a onClickListener to make accessibility to thing its a button so clicking
				//on the background layout wouldn't read the sleep prescription but clicking on this will.
			}
		});
	}

	@Override
	public void onResume()
	{
		super.onResume();

		// fetch the data and display either the sleep prescription or the msg
		UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData(getSherlockActivity(), this.getView());
		cData22a.displaySleepPrescription();
	}

	// @Override
	// public void onWindowFocusChanged(boolean hasFocus)
	// {
	// int ht = ((Button)getView().findViewById(R.id.b10mysleep)).getHeight();
	// int wi = ((Button)getView().findViewById(R.id.b10mysleep)).getWidth();
	// int sc = Math.min(ht,wi) / 18;
	// ((TextView)getView().findViewById(R.id.t10mysleep)).setTextSize(sc);
	// ((TextView)getView().findViewById(R.id.t10tools)).setTextSize(sc);
	// ((TextView)getView().findViewById(R.id.t10learn)).setTextSize(sc);
	// ((TextView)getView().findViewById(R.id.t10reminders)).setTextSize(sc);
	// super.onWindowFocusChanged(hasFocus);
	// }

	// @Override
	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		startActivity(new Intent(getSherlockActivity(), DashboardHelpActivity.class));
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
