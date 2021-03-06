/*
* PreventInsomniaResultFragment.java
* Fragment that displays information based off of what the user checked in PreventInsomniaFragment
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
package com.t2.cbti.tools;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTi_BaseFragment;

public class PreventInsomniaResultFragment extends CBTi_BaseFragment
{
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_preventinsomniaresults, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Feedback));

		Bundle b = this.getArguments();
		if (!(b.getBoolean("PREVENT01")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent01)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR01)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR01)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new SleepHabitsGetOutOfBedOnTimeFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// SleepHabitsGetOutOfBedOnTimeFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT02")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent02)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR02)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR02)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new SleepHabitsGoToBedOnlyWhenSleepyFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// SleepHabitsGoToBedOnlyWhenSleepyFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT03")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent03)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR03)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR03)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new SleepHabitsGetOutOfBedWhenCantSleepFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// SleepHabitsGetOutOfBedWhenCantSleepFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT04")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent04)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR04)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR04)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new QuiteMindWindingDownFragment());
					ft.commit();

					// Intent i = new Intent(getSherlockActivity(),
					// QuiteMindWindingDownFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT05")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent05)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR05)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR05)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new QuiteMindScheduleWorryTimeFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// QuiteMindScheduleWorryTimeFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT06")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent06)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR06)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR06)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new SleepHabitsCaffeineFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// SleepHabitsCaffeineFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT07")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent07)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR07)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR07)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, new SleepHabitsSleepEnvironmentSetupFragment());
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// SleepHabitsSleepEnvironmentSetupFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

		if (!(b.getBoolean("PREVENT08")))
		{
			((LinearLayout) getView().findViewById(R.id.llPrevent08)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llToolR08)).setVisibility(View.GONE);
		}
		else
			((TextView) getView().findViewById(R.id.tToolR08)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{ // handle the about button
					final FragmentManager fm = getFragmentManager();
					final FragmentTransaction ft = fm.beginTransaction();
					QuiteMindMainFragment quite = new QuiteMindMainFragment();
					quite.preventOptionsMenu = true;
					ft.addToBackStack(null);
					ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
					ft.replace(R.id.preventinsomniafragment, quite);
					ft.commit();
					// Intent i = new Intent(getSherlockActivity(),
					// QuiteMindMainFragment.class);
					// getSherlockActivity().startActivity(i);
					// getSherlockActivity().overridePendingTransition(R.anim.slide_left,
					// R.anim.slide_left2);
				}
			});

	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}
}
