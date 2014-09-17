/*
 * AssessmentScheduleReminderFragment.java
 * Fragment used to schedule a reminder for the user to take assessments
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

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTiDialogFragment;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;

public class AssessmentScheduleReminderFragment extends CBTi_BaseFragment
{
	private int iInitialHourOfDay;
	private int iInitialMin;
	RemindersData cData60a;
	static final int TIME_DIALOG_ID = 1;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentschedulereminder, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_AddtomyCalendar));

		// Take Assessment Reminder
		((Button) getView().findViewById(R.id.bTakeAssessmentReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bTakeAssessmentReminder = ((ToggleButton) getView().findViewById(R.id.bTakeAssessmentReminder)).isChecked();
				if (!cData60a.bTakeAssessmentReminder)
				{
					getView().findViewById(R.id.rlTakeAssessment).setVisibility(View.GONE);
				}
				else
				{
					getView().findViewById(R.id.rlTakeAssessment).setVisibility(View.VISIBLE);
				}
			}
		});

		// Take Assessment Reminder Time Picker
		((Button) getView().findViewById(R.id.tTakeAssessmentTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iTAmin / 60;
				iInitialMin = cData60a.iTAmin % 60;
				showDialog(TIME_DIALOG_ID);
			}
		});

	}

	@Override
	public void onResume()
	{
		cData60a = new RemindersData(getSherlockActivity()); // initialize data from stored
		// object
		cData60a.cancelAnAlarm(ALARMS.TakeAssessment);
		// take assessment reminder
		((ToggleButton) getView().findViewById(R.id.bTakeAssessmentReminder)).setChecked(cData60a.bTakeAssessmentReminder);
		((Button) getView().findViewById(R.id.tTakeAssessmentTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iTAmin));
		if (!cData60a.bTakeAssessmentReminder)
		{
			getView().findViewById(R.id.rlTakeAssessment).setVisibility(View.GONE);
		}
		else
		{
			getView().findViewById(R.id.rlTakeAssessment).setVisibility(View.VISIBLE);
		}

		enableTADayOfWeek();
		enableTARepeat();

		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData60a.iTADayofWeek = ((Spinner) getView().findViewById(R.id.sTakeAssessmentDay)).getSelectedItemPosition();
		cData60a.iTARepeat = ((Spinner) getView().findViewById(R.id.sTakeAssessmentRepeat)).getSelectedItemPosition();
		cData60a.setAnAlarm(ALARMS.TakeAssessment);
		cData60a.saveData(); // save data to file
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}

	/**
	 * Creates and shows a dialog depending on the given id
	 * @param id
	 */
	public void showDialog(int id)
	{
		CBTiDialogFragment dia = new CBTiDialogFragment();
		switch (id)
		{
		case TIME_DIALOG_ID:
			if (iInitialHourOfDay == 0)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin = onscene.get(Calendar.MINUTE);
			}
			// return new TimePickerDialog(getSherlockActivity(), mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
			dia.showTimeDialog(iInitialHourOfDay, iInitialMin, mTimeSetListener, getFragmentManager());
			break;
		}
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData60a.iTAmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
			((Button) getView().findViewById(R.id.tTakeAssessmentTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iTAmin));
		}
	};

	/**
	 * Creates the days spinner
	 */
	private void enableTADayOfWeek()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sTakeAssessmentDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iTADayofWeek, true);
		sSpin.setContentDescription(getString(R.string.s_Days));
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * Creates the repeat period spinner
	 */
	private void enableTARepeat()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sTakeAssessmentRepeat);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Repeat, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iTARepeat, true);
		sSpin.setContentDescription(getString(R.string.s_ReminderRecurrence));
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	public class myOnItemSelectedListener implements OnItemSelectedListener
	{
		public myOnItemSelectedListener()
		{
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row)
		{
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
		}
	}
}
