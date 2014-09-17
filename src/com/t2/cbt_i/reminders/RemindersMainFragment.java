/*
 * RemindersMainFragment.java
 * Fragment used as the graphical interface for the user to alter and set all of their reminders
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
package com.t2.cbt_i.reminders;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTiDialogFragment;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.mysleep.UpdateSleepPrescriptionData;

public class RemindersMainFragment extends CBTi_BaseFragment
{
	RemindersData cData60a;
	UpdateSleepPrescriptionData cData22a;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.reminders_main, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);

		cData60a = new RemindersData(getSherlockActivity());

		// Sleep Diary Reminder Toggle Button
		((Button) getView().findViewById(R.id.bSleepDiaryReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bSleepDiaryReminder = ((ToggleButton) getView().findViewById(R.id.bSleepDiaryReminder)).isChecked();
				if (!cData60a.bSleepDiaryReminder)
				{
					getView().findViewById(R.id.rlRreminderTime).setVisibility(View.GONE);
				}
				else
				{
					getView().findViewById(R.id.rlRreminderTime).setVisibility(View.VISIBLE);
					((Button) getView().findViewById(R.id.tSleepDiaryReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
				}
			}
		});

		// Sleep Diary Reminder Time Picker
		((Button) getView().findViewById(R.id.tSleepDiaryReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iSDRmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSDRmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSDRmin) % 60;
				iNextClass = Reminders_BR_SleepDiary.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		// Wind Down Time Reminder Toggle Button
		((Button) getView().findViewById(R.id.bWindDownTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bWindDownTimeReminder = ((ToggleButton) getView().findViewById(R.id.bWindDownTimeReminder)).isChecked();
				if (!cData60a.bWindDownTimeReminder)
				{
					((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.GONE);
				}
				else
				{
					((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Wind Down Time Reminder Time Picker
		((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iWDTmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iWDTmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iWDTmin) % 60;
				iNextClass = Reminders_BR_WindDown.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		// Prescribed Bed Time Reminder
		((Button) getView().findViewById(R.id.bPrescribedBedTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bPrescribedBedTimeReminder = ((ToggleButton) getView().findViewById(R.id.bPrescribedBedTimeReminder)).isChecked();
				if (!cData60a.bPrescribedBedTimeReminder)
				{
					((Button) getView().findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.GONE);
				}
				else
				{
					((Button) getView().findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Prescribed Wake Time Reminder
		((Button) getView().findViewById(R.id.bPrescribedWakeTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bPrescribedWakeTimeReminder = ((ToggleButton) getView().findViewById(R.id.bPrescribedWakeTimeReminder)).isChecked();
				if (!cData60a.bPrescribedWakeTimeReminder)
				{
					((TextView) getView().findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.GONE);
				}
				else
				{
					((TextView) getView().findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		enableUSPDayOfWeek();
		// Update Sleep Prescription Reminder
		((Button) getView().findViewById(R.id.bUpdateSleepPrescriptionReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bUpdateSleepPrescriptionReminder = ((ToggleButton) getView().findViewById(R.id.bUpdateSleepPrescriptionReminder)).isChecked();
				if (!cData60a.bUpdateSleepPrescriptionReminder)
				{
					getView().findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.GONE);
				}
				else
				{
					getView().findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.VISIBLE);
				}
			}
		});

		// Update Sleep Prescription Time Picker
		((Button) getView().findViewById(R.id.tUpdateSleepPrescriptionTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iUSPmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iUSPmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iUSPmin) % 60;
				iNextClass = Reminders_BR_UpdateSleepPrescription.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		enableTADayOfWeek();
		enableTARepeat();
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
				iInitialHourOfDay = cData60a.iTAmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iTAmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iTAmin) % 60;
				iNextClass = Reminders_BR_TakeAssessment.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		// Stop Caffeine Reminder
		((Button) getView().findViewById(R.id.bStopCaffeineReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bStopCaffeineReminder = ((ToggleButton) getView().findViewById(R.id.bStopCaffeineReminder)).isChecked();
				if (!cData60a.bStopCaffeineReminder)
				{
					((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.GONE);
				}
				else
				{
					((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Stop Caffeine Reminder Time Picker
		((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iSCmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSCmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSCmin) % 60;
				iNextClass = Reminders_BR_StopCaffeine.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		enableWTDayOfWeek();
		// Worry Time Reminder
		((Button) getView().findViewById(R.id.bWorryTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bWorryTimeReminder = ((ToggleButton) getView().findViewById(R.id.bWorryTimeReminder)).isChecked();
				if (!cData60a.bWorryTimeReminder)
				{
					((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.GONE);
				}
				else
				{
					((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Worry Time Reminder Time Picker
		((Button) getView().findViewById(R.id.tWorryTimeReminderTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = cData60a.iWTmin;
				if (iInitialHourOfDay != -1)
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iWTmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iWTmin) % 60;
				iNextClass = Reminders_BR_WorryTime.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		// Reset Reminders
		((Button) getView().findViewById(R.id.bResetReminders)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				showDialog(CONFIRM_RESET_DIALOG);
			}
		});
	}

	/**
	 * Creates the update sleep prescription days spinner
	 */
	private void enableUSPDayOfWeek()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sUpdateSleepPrescriptionDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iUSPDayofWeek, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * Creates the take assessment days spinner
	 */
	private void enableTADayOfWeek()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sTakeAssessmentDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iTADayofWeek, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * Creates the worry time days spinner
	 */
	private void enableWTDayOfWeek()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sWorryTimeDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iWTDayofWeek, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * Creates the take assessment repeat spinner
	 */
	private void enableTARepeat()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sTakeAssessmentRepeat);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Repeat, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iTARepeat, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * A callback listener that implements the {@link android.widget.AdapterView.OnItemSelectedListener} interface For views based on adapters, this interface
	 * defines the methods available when the user selects an item from the View.
	 * 
	 */
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

	@Override
	public void onPause()
	{
		cData60a.iUSPDayofWeek = ((Spinner) getView().findViewById(R.id.sUpdateSleepPrescriptionDay)).getSelectedItemPosition();
		cData60a.iTADayofWeek = ((Spinner) getView().findViewById(R.id.sTakeAssessmentDay)).getSelectedItemPosition();
		cData60a.iTARepeat = ((Spinner) getView().findViewById(R.id.sTakeAssessmentRepeat)).getSelectedItemPosition();
		cData60a.iWTDayofWeek = ((Spinner) getView().findViewById(R.id.sWorryTimeDay)).getSelectedItemPosition();

		cData60a.saveData(); // save data to file
		cData60a.setAllAlarms();
		super.onPause();
	}

	@Override
	public void onResume()
	{
		cData60a = new RemindersData(getSherlockActivity()); // initialize data
																// from stored
		// object
		cData22a = new UpdateSleepPrescriptionData(getSherlockActivity(), this.getView());
		cData60a.cancelAllAlarms();
		renderData();
		super.onResume();
	}

	/**
	 * Displays all reminder data
	 */
	private void renderData()
	{
		// sleep diary reminder time
		((ToggleButton) getView().findViewById(R.id.bSleepDiaryReminder)).setChecked(cData60a.bSleepDiaryReminder);
		((Button) getView().findViewById(R.id.tSleepDiaryReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
		if (!cData60a.bSleepDiaryReminder)
		{
			getView().findViewById(R.id.rlRreminderTime).setVisibility(View.GONE);
		}
		else
		{
			getView().findViewById(R.id.rlRreminderTime).setVisibility(View.VISIBLE);
		}

		// wind down time reminder
		((ToggleButton) getView().findViewById(R.id.bWindDownTimeReminder)).setChecked(cData60a.bWindDownTimeReminder);
		((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWDTmin));
		if (!cData60a.bWindDownTimeReminder)
		{
			((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.GONE);
		}
		else
		{
			((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
		}

		// prescribed bed time reminder
		((ToggleButton) getView().findViewById(R.id.bPrescribedBedTimeReminder)).setChecked(cData60a.bPrescribedBedTimeReminder);
		((Button) getView().findViewById(R.id.tPrescribedBedTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData22a.iSP_PBTimemin));
		if (!cData60a.bPrescribedBedTimeReminder)
		{
			((Button) getView().findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.GONE);
		}
		else
		{
			((Button) getView().findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.VISIBLE);
		}

		// prescribed wake time reminder
		((ToggleButton) getView().findViewById(R.id.bPrescribedWakeTimeReminder)).setChecked(cData60a.bPrescribedWakeTimeReminder);
		((TextView) getView().findViewById(R.id.tPrescribedWakeTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData22a.iSP_PWTimemin));
		if (!cData60a.bPrescribedWakeTimeReminder)
		{
			((TextView) getView().findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.GONE);
		}
		else
		{
			((TextView) getView().findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.VISIBLE);
		}

		// update sleep prescription reminder
		((ToggleButton) getView().findViewById(R.id.bUpdateSleepPrescriptionReminder)).setChecked(cData60a.bUpdateSleepPrescriptionReminder);
		((Button) getView().findViewById(R.id.tUpdateSleepPrescriptionTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iUSPmin));
		if (!cData60a.bUpdateSleepPrescriptionReminder)
		{
			getView().findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.GONE);
		}
		else
		{
			getView().findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.VISIBLE);
		}

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

		// stop caffeine reminder
		((ToggleButton) getView().findViewById(R.id.bStopCaffeineReminder)).setChecked(cData60a.bStopCaffeineReminder);
		((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSCmin));
		if (!cData60a.bStopCaffeineReminder)
		{
			((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.GONE);
		}
		else
		{
			((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
		}

		// worry time reminder
		((ToggleButton) getView().findViewById(R.id.bWorryTimeReminder)).setChecked(cData60a.bWorryTimeReminder);
		((Button) getView().findViewById(R.id.tWorryTimeReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWTmin));
		if (!cData60a.bWorryTimeReminder)
		{
			((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.GONE);
		}
		else
		{
			((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.VISIBLE);
		}

	}

	static final int TIME_DIALOG_ID = 1;
	static final int CONFIRM_RESET_DIALOG = 2;
	int iInitialHourOfDay; // if zero we default to current time
	int iInitialMin = 0;

	/**
	 * Creates and shows a dialog according to the id
	 * @param id
	 */
	public void showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			CBTiDialogFragment dia = new CBTiDialogFragment();
			if (iInitialHourOfDay == -1)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin = onscene.get(Calendar.MINUTE);
			}
			dia.showTimeDialog(iInitialHourOfDay, iInitialMin, mTimeSetListener, getFragmentManager());
			break;
		case CONFIRM_RESET_DIALOG:
			AlertDialog.Builder build = new AlertDialog.Builder(getActivity());
			build.setMessage(getString(R.string.s_confirmResetAllReminders))
				.setPositiveButton(R.string.s_OK, new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						cData60a.resetData(); // reset to default values
						renderData();
						cData60a.cancelAllAlarms();
					}
				})
				.setNegativeButton(R.string.s_No, new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which) { }
				})
				.show();
			break;
		}
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			if (iNextClass == Reminders_BR_SleepDiary.class)
			{
				cData60a.iSDRmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tSleepDiaryReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSDRmin));
			}
			else if (iNextClass == Reminders_BR_WindDown.class)
			{
				cData60a.iWDTmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWDTmin));
			}
			else if (iNextClass == Reminders_BR_TakeAssessment.class)
			{
				cData60a.iTAmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tTakeAssessmentTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iTAmin));
			}
			else if (iNextClass == Reminders_BR_StopCaffeine.class)
			{
				cData60a.iSCmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tStopCaffeineReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSCmin));
			}
			else if (iNextClass == Reminders_BR_WorryTime.class)
			{
				cData60a.iWTmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tWorryTimeReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWTmin));
			}
			else if (iNextClass == Reminders_BR_UpdateSleepPrescription.class)
			{
				cData60a.iUSPmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tUpdateSleepPrescriptionTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iUSPmin));
			}
		}
	};

	private Class<?> iNextClass; // tells the alarm where to wake up

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_homereminder);
		i.putExtra("RID_Text", R.string.s_60d);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}