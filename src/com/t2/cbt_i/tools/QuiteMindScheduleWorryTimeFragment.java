package com.t2.cbt_i.tools;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
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
import com.t2.cbt_i.reminders.Reminders_BR_WorryTime;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;

public class QuiteMindScheduleWorryTimeFragment extends CBTi_BaseFragment
{
	RemindersData cData60a;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindscheduleworrytime, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_WorryTime));

		cData60a = new RemindersData(getSherlockActivity());

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
		((TextView) getView().findViewById(R.id.tWorryTimeReminderTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				int time = cData60a.timeFrom4pm(cData60a.iWTmin);
				iInitialHourOfDay = time / 60;
				iInitialMin = time % 60;
				iNextClass = Reminders_BR_WorryTime.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		enableWTDayOfWeek();

	}

	@Override
	public void onResume()
	{
		cData60a = new RemindersData(getSherlockActivity()); // initialize data from stored object
		renderData();
		cData60a.cancelAnAlarm(ALARMS.WorryTime);
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData60a.iWTDayofWeek = ((Spinner) getView().findViewById(R.id.sWorryTimeDay)).getSelectedItemPosition();
		cData60a.saveData(); // save data to file
		cData60a.setAnAlarm(ALARMS.WorryTime);
		super.onPause();
	}

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

	private void renderData()
	{
		// worry time reminder
		((ToggleButton) getView().findViewById(R.id.bWorryTimeReminder)).setChecked(cData60a.bWorryTimeReminder);
		((TextView) getView().findViewById(R.id.tWorryTimeReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWTmin));
		if (!cData60a.bWorryTimeReminder)
		{
			((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.GONE);
		}
		else
		{
			((RelativeLayout) getView().findViewById(R.id.rlWorryTime)).setVisibility(View.VISIBLE);
		}

	}

	private Class<Reminders_BR_WorryTime> iNextClass; // tells the alarm where
														// to wake up

	static final int TIME_DIALOG_ID = 1;
	int iPicker; // used to figure what to do with picked time
	int iInitialHourOfDay; // if zero we default to current time
	int iInitialMin;

	private Dialog showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			CBTiDialogFragment dia = new CBTiDialogFragment();
			if (iInitialHourOfDay == 0)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin = onscene.get(Calendar.MINUTE);
			}
			dia.showDialog(iInitialHourOfDay, iInitialMin, mTimeSetListener, getFragmentManager());
			//return new TimePickerDialog(getSherlockActivity(), mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
		}
		return null;
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			if (iNextClass == Reminders_BR_WorryTime.class)
			{
				cData60a.iWTmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((TextView) getView().findViewById(R.id.tWorryTimeReminderTime)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWTmin));
			}
		}
	};

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsworrytime);
		i.putExtra("RID_Text", R.string.s_35dhelp);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
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
