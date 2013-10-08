package com.t2.cbt_i.reminders;


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
import com.t2.cbt_i.mysleep.UpdateSleepPrescriptionData;


public class RemindersMainActivity extends BaseABSActivity {
	
	RemindersData cData60a;
	UpdateSleepPrescriptionData cData22a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminders_main);
		
		cData60a = new RemindersData(this);
	
		// Sleep Diary Reminder Toggle Button 
		((Button)findViewById(R.id.bSleepDiaryReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bSleepDiaryReminder = ((ToggleButton)findViewById(R.id.bSleepDiaryReminder)).isChecked();
				if ( !cData60a.bSleepDiaryReminder ) {
					findViewById(R.id.rlRreminderTime).setVisibility(View.GONE);
				}
				else {
					findViewById(R.id.rlRreminderTime).setVisibility(View.VISIBLE);
					((TextView)findViewById(R.id.tSleepDiaryReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
				}
			}
		});
		
		// Sleep Diary Reminder Time Picker
		((TextView)findViewById(R.id.tSleepDiaryReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iSDRmin;
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSDRmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSDRmin) % 60;
				iNextClass = Reminders_BR_SleepDiary.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		
		
		// Wind Down Time Reminder Toggle Button 
		((Button)findViewById(R.id.bWindDownTimeReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bWindDownTimeReminder = ((ToggleButton)findViewById(R.id.bWindDownTimeReminder)).isChecked();
				if ( !cData60a.bWindDownTimeReminder ) {
					((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.GONE);
				}
				else {
					((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});
		
		// Wind Down Time Reminder Time Picker
		((TextView)findViewById(R.id.tWindDownTimeReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iWDTmin;	
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iWDTmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iWDTmin) % 60;
				iNextClass = Reminders_BR_WindDown.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		// Prescribed Bed Time Reminder
		((Button)findViewById(R.id.bPrescribedBedTimeReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bPrescribedBedTimeReminder = ((ToggleButton)findViewById(R.id.bPrescribedBedTimeReminder)).isChecked();
				if ( !cData60a.bPrescribedBedTimeReminder ) {
					((TextView)findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.GONE);
				}
				else {
					((TextView)findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});
		
		// Prescribed Wake Time Reminder
		((Button)findViewById(R.id.bPrescribedWakeTimeReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bPrescribedWakeTimeReminder = ((ToggleButton)findViewById(R.id.bPrescribedWakeTimeReminder)).isChecked();
				if ( !cData60a.bPrescribedWakeTimeReminder ) {
					((TextView)findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.GONE);
				}
				else {
					((TextView)findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});
		
		enableUSPDayOfWeek();
		// Update Sleep Prescription Reminder
		((Button)findViewById(R.id.bUpdateSleepPrescriptionReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bUpdateSleepPrescriptionReminder = ((ToggleButton)findViewById(R.id.bUpdateSleepPrescriptionReminder)).isChecked();
				if ( !cData60a.bUpdateSleepPrescriptionReminder ) {
					findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.GONE);
				}
				else {
					findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.VISIBLE);
				}
			}
		});

		
		
		// Update Sleep Prescription Time Picker
		((TextView)findViewById(R.id.tUpdateSleepPrescriptionTime)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iUSPmin;
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iUSPmin) / 60;	
				iInitialMin = cData60a.timeFrom4pm(cData60a.iUSPmin) % 60;
				iNextClass = Reminders_BR_UpdateSleepPrescription.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		enableTADayOfWeek();
		enableTARepeat();
		// Take Assessment Reminder
		((Button)findViewById(R.id.bTakeAssessmentReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bTakeAssessmentReminder = ((ToggleButton)findViewById(R.id.bTakeAssessmentReminder)).isChecked();
				if ( !cData60a.bTakeAssessmentReminder ) {
					findViewById(R.id.rlTakeAssessment).setVisibility(View.GONE);
				}
				else {
					findViewById(R.id.rlTakeAssessment).setVisibility(View.VISIBLE);
				}
			}
		});
		
		// Take Assessment Reminder Time Picker
		((TextView)findViewById(R.id.tTakeAssessmentTime)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iTAmin;
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iTAmin) / 60;		
				iInitialMin = cData60a.timeFrom4pm(cData60a.iTAmin) % 60;
				iNextClass = Reminders_BR_TakeAssessment.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});

		
		
		// Stop Caffeine Reminder
		((Button)findViewById(R.id.bStopCaffeineReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				cData60a.bStopCaffeineReminder = ((ToggleButton)findViewById(R.id.bStopCaffeineReminder)).isChecked();
				if ( !cData60a.bStopCaffeineReminder ) {
					((TextView)findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.GONE);
				}
				else {
					((TextView)findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
				}
			}
		});
		
		// Stop Caffeine Reminder Time Picker
		((TextView)findViewById(R.id.tStopCaffeineReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iSCmin;	
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSCmin) / 60;		
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSCmin) % 60;
				iNextClass = Reminders_BR_StopCaffeine.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});

		enableWTDayOfWeek();
		// Worry Time Reminder
		((Button)findViewById(R.id.bWorryTimeReminder)).setOnClickListener(new View.OnClickListener() {
			@Override
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
			@Override
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iWTmin;
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iWTmin) / 60;		
				iInitialMin = cData60a.timeFrom4pm(cData60a.iWTmin) % 60;
				iNextClass = Reminders_BR_WorryTime.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		
		
		// Reset Reminders
		((Button)findViewById(R.id.bResetReminders)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {			// handle the about button
				cData60a.resetData();				// reset to default values
				renderData();
				cData60a.cancelAllAlarms();
			}
		});
	}




	private void enableUSPDayOfWeek() {
		Spinner sSpin = (Spinner) findViewById(R.id.sUpdateSleepPrescriptionDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.Days, android.R.layout.simple_spinner_dropdown_item);
        sSpin.setAdapter(aa);
        sSpin.setSelection(cData60a.iUSPDayofWeek, true);
        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
        sSpin.setOnItemSelectedListener(spinnerListener);
	}
	
	private void enableTADayOfWeek() {
		Spinner sSpin = (Spinner) findViewById(R.id.sTakeAssessmentDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.Days, android.R.layout.simple_spinner_dropdown_item);
        sSpin.setAdapter(aa);
        sSpin.setSelection(cData60a.iTADayofWeek, true);
        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
        sSpin.setOnItemSelectedListener(spinnerListener);
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
	
	private void enableTARepeat() {
		Spinner sSpin = (Spinner) findViewById(R.id.sTakeAssessmentRepeat);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.Repeat, android.R.layout.simple_spinner_dropdown_item);
        sSpin.setAdapter(aa);
        sSpin.setSelection(cData60a.iTARepeat, true);
        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
        sSpin.setOnItemSelectedListener(spinnerListener);
	}
	
	/**
     *  A callback listener that implements the
     *  {@link android.widget.AdapterView.OnItemSelectedListener} interface
     *  For views based on adapters, this interface defines the methods available
     *  when the user selects an item from the View.
     *
     */
    public class myOnItemSelectedListener implements OnItemSelectedListener {
       
        public myOnItemSelectedListener() {
        }

        @Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {
        }

        @Override
		public void onNothingSelected(AdapterView<?> parent) {
        }
    }

	@Override
	protected void onPause() {
		cData60a.iUSPDayofWeek = ((Spinner)findViewById(R.id.sUpdateSleepPrescriptionDay)).getSelectedItemPosition();
		cData60a.iTADayofWeek  = ((Spinner)findViewById(R.id.sTakeAssessmentDay)).getSelectedItemPosition();
		cData60a.iTARepeat     = ((Spinner)findViewById(R.id.sTakeAssessmentRepeat)).getSelectedItemPosition();
		cData60a.iWTDayofWeek  = ((Spinner)findViewById(R.id.sWorryTimeDay)).getSelectedItemPosition();
		
		cData60a.saveData();			// save data to file
		cData60a.setAllAlarms();
		super.onPause();
	}

	@Override
	protected void onResume() {
		cData60a = new RemindersData(this);	// initialize data from stored object
		cData22a = new UpdateSleepPrescriptionData(this);
		cData60a.cancelAllAlarms();
		renderData();
		super.onResume();
	}
	
	private void renderData() {
		// sleep diary reminder time
		((ToggleButton)findViewById(R.id.bSleepDiaryReminder)).setChecked(cData60a.bSleepDiaryReminder);
		((TextView)findViewById(R.id.tSleepDiaryReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
		if ( !cData60a.bSleepDiaryReminder ) {
			findViewById(R.id.rlRreminderTime).setVisibility(View.GONE);
		}
		else {
			findViewById(R.id.rlRreminderTime).setVisibility(View.VISIBLE);
		}

		// wind down time reminder
		((ToggleButton)findViewById(R.id.bWindDownTimeReminder)).setChecked( cData60a.bWindDownTimeReminder );
		((TextView)findViewById(R.id.tWindDownTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWDTmin) );
		if ( !cData60a.bWindDownTimeReminder ) {
			((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.GONE);
		}
		else {
			((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
		}

		// prescribed bed time reminder
		((ToggleButton)findViewById(R.id.bPrescribedBedTimeReminder)).setChecked( cData60a.bPrescribedBedTimeReminder );
		((TextView)findViewById(R.id.tPrescribedBedTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData22a.iSP_PBTimemin) );
		if ( !cData60a.bPrescribedBedTimeReminder ) {
			((TextView)findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.GONE);
		}
		else {
			((TextView)findViewById(R.id.tPrescribedBedTimeReminder)).setVisibility(View.VISIBLE);
		}

		// prescribed wake time reminder
		((ToggleButton)findViewById(R.id.bPrescribedWakeTimeReminder)).setChecked( cData60a.bPrescribedWakeTimeReminder );
		((TextView)findViewById(R.id.tPrescribedWakeTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData22a.iSP_PWTimemin) );
		if ( !cData60a.bPrescribedWakeTimeReminder ) {
			((TextView)findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.GONE);
		}
		else {
			((TextView)findViewById(R.id.tPrescribedWakeTimeReminder)).setVisibility(View.VISIBLE);
		}

		// update sleep prescription reminder
		((ToggleButton)findViewById(R.id.bUpdateSleepPrescriptionReminder)).setChecked( cData60a.bUpdateSleepPrescriptionReminder );
		((TextView)findViewById(R.id.tUpdateSleepPrescriptionTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iUSPmin) );
		if ( !cData60a.bUpdateSleepPrescriptionReminder ) {
			findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.GONE);
		}
		else {
			findViewById(R.id.rlUpdateSleepPrescription).setVisibility(View.VISIBLE);
		}

		// take assessment reminder
		((ToggleButton)findViewById(R.id.bTakeAssessmentReminder)).setChecked( cData60a.bTakeAssessmentReminder );
		((TextView)findViewById(R.id.tTakeAssessmentTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iTAmin) );
		if ( !cData60a.bTakeAssessmentReminder ) {
			findViewById(R.id.rlTakeAssessment).setVisibility(View.GONE);
		}
		else {
			findViewById(R.id.rlTakeAssessment).setVisibility(View.VISIBLE);
		}

		// stop caffeine reminder
		((ToggleButton)findViewById(R.id.bStopCaffeineReminder)).setChecked( cData60a.bStopCaffeineReminder );
		((TextView)findViewById(R.id.tStopCaffeineReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSCmin) );
		if ( !cData60a.bStopCaffeineReminder ) {
			((TextView)findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.GONE);
		}
		else {
			((TextView)findViewById(R.id.tStopCaffeineReminder)).setVisibility(View.VISIBLE);
		}

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

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		RemindersMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}

	static final int TIME_DIALOG_ID = 1;
	int iInitialHourOfDay;				// if zero we default to current time
	int iInitialMin=0;
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			if( iInitialHourOfDay == -1 ) {
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
			if( iNextClass == Reminders_BR_SleepDiary.class ) {
				cData60a.iSDRmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tSleepDiaryReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
			}
			else if( iNextClass == Reminders_BR_WindDown.class) {
				cData60a.iWDTmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tWindDownTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWDTmin) );
			}
			else if( iNextClass == Reminders_BR_TakeAssessment.class) {
				cData60a.iTAmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tTakeAssessmentTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iTAmin) );
			}
			else if( iNextClass == Reminders_BR_StopCaffeine.class) {
				cData60a.iSCmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tStopCaffeineReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSCmin) );
			}
			else if( iNextClass == Reminders_BR_WorryTime.class) {
				cData60a.iWTmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tWorryTimeReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWTmin) );
			}
			else if( iNextClass == Reminders_BR_UpdateSleepPrescription.class) {
				cData60a.iUSPmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tUpdateSleepPrescriptionTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iUSPmin) );
			}
		}
	};

	private Class<?> iNextClass;					// tells the alarm where to wake up
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(RemindersMainActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_homereminder);
		i.putExtra("RID_Text", R.string.s_60d);
		RemindersMainActivity.this.startActivity(i);
		RemindersMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
	}
}