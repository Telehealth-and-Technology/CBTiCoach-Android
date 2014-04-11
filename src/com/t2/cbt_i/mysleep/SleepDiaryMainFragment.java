/*
* SleepDiaryMainFragment.java
* Fragment used to display a list of all sleep diary entries and allow the user to setup a reminder to fill out sleep diary entries
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

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemClickListener;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;

public class SleepDiaryMainFragment extends CBTi_BaseFragment
{
	RemindersData cData60a;
	SleepDiaryData cData21a;
	ArrayAdapter<SleepDiaryEntryData> aa;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_sleepdairymain_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_SleepDiary));
		setHasOptionsMenu(true);
		
		cData60a = new RemindersData(getSherlockActivity());

		// Reminder Toggle Button
		((Button) getView().findViewById(R.id.bSleepDiaryReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bSleepDiaryReminder = ((ToggleButton) getView().findViewById(R.id.bSleepDiaryReminder)).isChecked();
				if (!cData60a.bSleepDiaryReminder)
				{
					getView().findViewById(R.id.remindertime).setVisibility(View.GONE);
				}
				else
				{
					getView().findViewById(R.id.remindertime).setVisibility(View.VISIBLE);
					((TextView) getView().findViewById(R.id.tSleepDiaryReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
				}
			}
		});

		((TextView) getView().findViewById(R.id.tSleepDiaryReminderTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iSDRmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSDRmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSDRmin) % 60;
				showDialog(TIME_DIALOG_ID);
			}
		});

		// set up mid bar
		((Button) getView().findViewById(R.id.midLeft)).setVisibility(View.INVISIBLE);
		((Button) getView().findViewById(R.id.midRight)).setText(R.string.s_NewEntry);

		// New Entry Button
		((Button) getView().findViewById(R.id.midRight)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    
			    SleepDiaryEntryFragment frag = new SleepDiaryEntryFragment();
				new SleepDiaryEntryData(getSherlockActivity()).deleteData();
			    Bundle bun = new Bundle();
			    bun.putBoolean("NEW", true);
			    frag.setArguments(bun);

			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleepdairyfragment, frag);
			    ft.commit();
			}
		});
	}

	private static int iColorsID[] = { R.drawable.pbprogress1, R.drawable.pbprogress1, R.drawable.pbprogress1, R.drawable.pbprogress1, R.drawable.pbprogress1,
			R.drawable.pbprogress2, R.drawable.pbprogress2, R.drawable.pbprogress3 };

	private void updateProgressBar(int iProg)
	{
		ProgressBar pbWeek = (ProgressBar) getView().findViewById(R.id.progressBar);
		Rect bounds = pbWeek.getProgressDrawable().getBounds();
		pbWeek.setProgressDrawable(getResources().getDrawable(iColorsID[iProg]));
		pbWeek.getProgressDrawable().setBounds(bounds);
		pbWeek.setProgress(pbWeek.getProgress() + 1);

		// pbWeek.setProgressDrawable(getResources().getDrawable(iColorsID[iProg]));

		pbWeek.setProgress(iProg);
		((TextView) getView().findViewById(R.id.tPastWeeks)).setText(getResources().getString(R.string.s_PastWeeks) + " " + iProg + "/7");
		((TextView) getView().findViewById(R.id.tPastWeeks)).setContentDescription(getResources().getString(R.string.s_PastWeeks) + " " + iProg + "of 7");
	}

	TimePickerDialog tp;
	static final int TIME_DIALOG_ID = 1;
	int iInitialHourOfDay; // if zero we default to current time
	int iInitialMin = 0;

	private Dialog showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			if (iInitialHourOfDay == -1)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin = onscene.get(Calendar.MINUTE);
			}
			return new TimePickerDialog(getSherlockActivity(), mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
		}
		return null;
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData60a.iSDRmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
			((TextView) getView().findViewById(R.id.tSleepDiaryReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
		}
	};

	@Override
	public void onPause()
	{
		cData60a.saveData(); // save data to file
		cData60a.setAnAlarm(ALARMS.SleepDiary);
		super.onPause();
	}

	private ListView lv;

	// private ArrayList<String> aList;

	@Override
	public void onResume()
	{
		cData21a = new SleepDiaryData(getSherlockActivity());

		cData60a = new RemindersData(getSherlockActivity()); // initialize data
																// from stored
		// object
		cData60a.cancelAnAlarm(ALARMS.SleepDiary);

		((ToggleButton) getView().findViewById(R.id.bSleepDiaryReminder)).setChecked(cData60a.bSleepDiaryReminder);
		((TextView) getView().findViewById(R.id.tSleepDiaryReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
		if (!cData60a.bSleepDiaryReminder)
		{
			getView().findViewById(R.id.remindertime).setVisibility(View.GONE);
		}
		else
		{
			getView().findViewById(R.id.remindertime).setVisibility(View.VISIBLE);
			((TextView) getView().findViewById(R.id.tSleepDiaryReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
		}

		updateProgressBar(cData21a.iPastWeek);

		// Find the ListView resource.
		lv = (ListView) getView().findViewById(R.id.lvSleepData);
		aa = new ArrayAdapter<SleepDiaryEntryData>(getSherlockActivity(), R.layout.sleepdatarow, cData21a.alSleepDiary);
		lv.setAdapter(aa);
		lv.setEmptyView(getView().findViewById(R.id.tSleepDataEmpty));
		lv.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    
			    SleepDiaryEntryFragment frag = new SleepDiaryEntryFragment();
			    Bundle bun = new Bundle();
			    bun.putBoolean("NEW", false);
			    bun.putInt("POS", position);
			    frag.setArguments(bun);
			    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleepdairyfragment, frag);
			    ft.commit();
			}
		});

		super.onResume();
	}

	@Override
	public void getHelp()
	{
		final FragmentManager fm = getFragmentManager();
		CBTi_BaseFragment current = (CBTi_BaseFragment) fm.findFragmentById(R.id.sleepdairyfragment);
		if(!(current instanceof SleepDiaryMainFragment))
		{
			this.goingToHelp = true;
			current.getHelp();
			Intent i = new Intent(getSherlockActivity(), SleepDiaryHelpActivity.class);
			getSherlockActivity().startActivity(i);
			getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
		}
		else
		{
			this.goingToHelp = true;
			Intent i = new Intent(getSherlockActivity(), SleepDiaryHelpActivity.class);
			getSherlockActivity().startActivity(i);
			getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
		}
	}

}
