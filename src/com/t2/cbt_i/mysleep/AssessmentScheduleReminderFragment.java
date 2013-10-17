package com.t2.cbt_i.mysleep;

import java.util.Calendar;

import android.app.Dialog;
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
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;

public class AssessmentScheduleReminderFragment extends CBTi_BaseFragment
{
	private int iInitialHourOfDay;
	private int iInitialMin;
	RemindersData cData60a;
	static final int TIME_DIALOG_ID = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentschedulereminder, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getSherlockActivity().getResources().getString(R.string.s_AddtomyCalendar));
		
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
		((TextView) getView().findViewById(R.id.tTakeAssessmentTime)).setOnClickListener(new View.OnClickListener()
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
		((TextView) getView().findViewById(R.id.tTakeAssessmentTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iTAmin));
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

	public Dialog showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			if (iInitialHourOfDay == 0)
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
			cData60a.iTAmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
			((TextView) getView().findViewById(R.id.tTakeAssessmentTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iTAmin));
		}
	};

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
