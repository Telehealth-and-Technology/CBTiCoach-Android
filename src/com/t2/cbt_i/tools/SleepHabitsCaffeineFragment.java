package com.t2.cbt_i.tools;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Context;
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
import com.t2.cbt_i.reminders.Reminders_BR_StopCaffeine;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;

public class SleepHabitsCaffeineFragment extends CBTi_BaseFragment
{
	SleepHabitsCaffeineLimtData cData34i;
	RemindersData cData60a;
	AlarmManager alarmManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitscaffeine, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle("Caffeine Goals");

		cData34i = new SleepHabitsCaffeineLimtData(getSherlockActivity());
		cData60a = new RemindersData(getSherlockActivity());
		alarmManager = (AlarmManager) getSherlockActivity().getSystemService(Context.ALARM_SERVICE);

		enableDCDLPicker();

		// Stop Caffeine Reminder
		((Button) getView().findViewById(R.id.bStopCaffeineReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				cData60a.bStopCaffeineReminder = ((ToggleButton) getView().findViewById(R.id.bStopCaffeineReminder)).isChecked();
				if (!cData60a.bStopCaffeineReminder)
				{
					((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.INVISIBLE);
				}
				else
				{
					((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Stop Caffeine Reminder Time Picker
		((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iInitialHourOfDay = 15; // remember to initialize these
				iInitialMin = 32;
				iNextClass = Reminders_BR_StopCaffeine.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

	}

	@Override
	public void onResume()
	{
		cData34i = new SleepHabitsCaffeineLimtData(getSherlockActivity());
		((Spinner) getView().findViewById(R.id.sDailyCaffeineDrinkLimit)).setSelection(cData34i.iDailyCaffeineDrinkLimit, true);

		cData60a = new RemindersData(getSherlockActivity());
		cData60a.cancelAnAlarm(ALARMS.StopCaffeine);
		// stop caffeine reminder
		((ToggleButton) getView().findViewById(R.id.bStopCaffeineReminder)).setChecked(cData60a.bStopCaffeineReminder);
		((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSCmin));
		if (!cData60a.bStopCaffeineReminder)
		{
			((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.INVISIBLE);
		}
		else
		{
			((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
		}
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData34i.iDailyCaffeineDrinkLimit = ((Spinner) getView().findViewById(R.id.sDailyCaffeineDrinkLimit)).getSelectedItemPosition();
		cData34i.saveData();
		cData60a.setAnAlarm(ALARMS.StopCaffeine);
		cData60a.saveData();
		super.onPause();
	}
	
	@Override
	public void getHelp() { }

	static final int TIME_DIALOG_ID = 1;
	int iPicker; // used to figure what to do with picked time
	int iInitialHourOfDay; // if zero we default to current time
	int iInitialMin;

	private Dialog showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			if (iInitialHourOfDay == 0)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
			}
			return new TimePickerDialog(getSherlockActivity(), mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
		}
		return null;
	}

	private Class<Reminders_BR_StopCaffeine> iNextClass;
	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{

			if (iNextClass == Reminders_BR_StopCaffeine.class)
			{
				cData60a.iSCmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((TextView) getView().findViewById(R.id.tStopCaffeineReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iSCmin));
			}
		}
	};

	private void enableDCDLPicker()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sDailyCaffeineDrinkLimit);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.DCDL, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData34i.iDailyCaffeineDrinkLimit, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * A callback listener that implements the
	 * {@link android.widget.AdapterView.OnItemSelectedListener} interface For
	 * views based on adapters, this interface defines the methods available
	 * when the user selects an item from the View.
	 * 
	 */
	public class myOnItemSelectedListener implements OnItemSelectedListener
	{

		/**
		 * Constructor
		 * 
		 * @param c
		 *            - The activity that displays the Spinner.
		 * @param ad
		 *            - The Adapter view that
		 * @param id
		 *            - where to put the result; controls the Spinner.
		 *            Instantiate a new listener object.
		 */
		public myOnItemSelectedListener()
		{
		}

		/**
		 * When the user selects an item in the spinner, this method is invoked
		 * by the callback chain. Android calls the item selected listener for
		 * the spinner, which invokes the onItemSelected method.
		 * 
		 * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView,
		 *      android.view.View, int, long)
		 * @param parent
		 *            - the AdapterView for this listener
		 * @param v
		 *            - the View for this listener
		 * @param pos
		 *            - the 0-based position of the selection in the
		 *            mLocalAdapter
		 * @param row
		 *            - the 0-based row number of the selection in the View
		 */
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row)
		{
		}

		/**
		 * The definition of OnItemSelectedListener requires an override of
		 * onNothingSelected(), even though this implementation does not use it.
		 * 
		 * @param parent
		 *            - The View for this Listener
		 */
		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
		}
	}
}
