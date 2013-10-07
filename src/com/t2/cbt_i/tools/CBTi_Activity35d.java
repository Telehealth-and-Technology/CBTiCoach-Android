package com.t2.cbt_i.tools;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.reminders.Reminders_BR_WorryTime;
import com.t2.cbt_i.reminders.RemindersData;
import com.t2.cbt_i.reminders.RemindersData.ALARMS;



public class CBTi_Activity35d extends BaseABSActivity {	

	RemindersData cData60a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35d);

		cData60a = new RemindersData(this);

		// Worry Time Reminder
		((Button)findViewById(R.id.bWorryTimeReminder)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				cData60a.bWorryTimeReminder = ((ToggleButton)findViewById(R.id.bWorryTimeReminder)).isChecked();
				if ( !cData60a.bWorryTimeReminder ) {
					((RelativeLayout)findViewById(R.id.rlWorryTime)).setVisibility(View.GONE);
				}
				else {
					((RelativeLayout)findViewById(R.id.rlWorryTime)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Worry Time Reminder Time Picker
		((TextView)findViewById(R.id.tWorryTimeReminderTime)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				iInitialHourOfDay = 15;		// remember to initialize these
				iInitialMin = 32;
				iNextClass = Reminders_BR_WorryTime.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});

		enableWTDayOfWeek();

	}	

	private void enableWTDayOfWeek() {
		Spinner sSpin = (Spinner) findViewById(R.id.sWorryTimeDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData60a.iWTDayofWeek, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}



	


	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity35d.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}

	/**
	 *  A callback listener that implements the
	 *  {@link android.widget.AdapterView.OnItemSelectedListener} interface
	 *  For views based on adapters, this interface defines the methods available
	 *  when the user selects an item from the View.
	 *
	 */
	public class myOnItemSelectedListener implements OnItemSelectedListener {

		/**
		 *  Constructor
		 *  @param c - The activity that displays the Spinner.
		 *  @param ad - The Adapter view that
		 *  @param id - where to put the result;
		 *    controls the Spinner.
		 *  Instantiate a new listener object.
		 */
		public myOnItemSelectedListener() {
		}

		/**
		 * When the user selects an item in the spinner, this method is invoked by the callback
		 * chain. Android calls the item selected listener for the spinner, which invokes the
		 * onItemSelected method.
		 *
		 * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(
		 *  android.widget.AdapterView, android.view.View, int, long)
		 * @param parent - the AdapterView for this listener
		 * @param v - the View for this listener
		 * @param pos - the 0-based position of the selection in the mLocalAdapter
		 * @param row - the 0-based row number of the selection in the View
		 */
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {
		}

		/**
		 * The definition of OnItemSelectedListener requires an override
		 * of onNothingSelected(), even though this implementation does not use it.
		 * @param parent - The View for this Listener
		 */
		public void onNothingSelected(AdapterView<?> parent) {
		}
	}

	@Override
	protected void onPause() {
		cData60a.iWTDayofWeek  = ((Spinner)findViewById(R.id.sWorryTimeDay)).getSelectedItemPosition();
		cData60a.saveData();			// save data to file
		cData60a.setAnAlarm(ALARMS.WorryTime);
		super.onPause();
	}

	@Override
	protected void onResume() {
		cData60a = new RemindersData(this);	// initialize data from stored object
		renderData();
		cData60a.cancelAnAlarm(ALARMS.WorryTime);
		super.onResume();
	}

	private void renderData() {
		// worry time reminder
		((ToggleButton)findViewById(R.id.bWorryTimeReminder)).setChecked( cData60a.bWorryTimeReminder );
		((TextView)findViewById(R.id.tWorryTimeReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWTmin) );
		if ( !cData60a.bWorryTimeReminder ) {
			((RelativeLayout)findViewById(R.id.rlWorryTime)).setVisibility(View.GONE);
		}
		else {
			((RelativeLayout)findViewById(R.id.rlWorryTime)).setVisibility(View.VISIBLE);
		}

	}

	private Class<Reminders_BR_WorryTime> iNextClass;					// tells the alarm where to wake up
	

	static final int TIME_DIALOG_ID = 1;
	int iPicker;						// used to figure what to do with picked time
	int iInitialHourOfDay;				// if zero we default to current time
	int iInitialMin;
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			if( iInitialHourOfDay == 0 ) {
				Calendar onscene  = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin       = onscene.get(Calendar.MINUTE);
			}
			return new TimePickerDialog(this, mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
		}
		return null;
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
			if( iNextClass == Reminders_BR_WorryTime.class) {
				cData60a.iWTmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tWorryTimeReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWTmin) );
			}
		}
	};
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(CBTi_Activity35d.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsworrytime);
		i.putExtra("RID_Text", R.string.s_35dhelp);
		CBTi_Activity35d.this.startActivity(i);
		CBTi_Activity35d.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
