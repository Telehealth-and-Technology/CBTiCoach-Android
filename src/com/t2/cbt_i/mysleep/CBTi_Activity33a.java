package com.t2.cbt_i.mysleep;

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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashboardActivity;
import com.t2.cbt_i.reminders.CBTi_Data60a;
import com.t2.cbt_i.reminders.CBTi_Data60a.ALARMS;

public class CBTi_Activity33a extends BaseABSNHActivity {
	private int iInitialHourOfDay;
	private int iInitialMin;
	CBTi_Data60a cData60a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_33a);

		// Take Assessment Reminder
		((Button)findViewById(R.id.bTakeAssessmentReminder)).setOnClickListener(new View.OnClickListener() {
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
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iTAmin/60;		
				iInitialMin = cData60a.iTAmin%60;
				showDialog(TIME_DIALOG_ID);
			}	
		});

		
	}	

	

	static final int TIME_DIALOG_ID = 1;

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity33a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
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
			cData60a.iTAmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
			((TextView)findViewById(R.id.tTakeAssessmentTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iTAmin) );
		}
	};

	
	
	private void enableTADayOfWeek() {
		Spinner sSpin = (Spinner) findViewById(R.id.sTakeAssessmentDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this, R.array.Days, android.R.layout.simple_spinner_dropdown_item);
        sSpin.setAdapter(aa);
        sSpin.setSelection(cData60a.iTADayofWeek, true);
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
	
	@Override
	protected void onPause() {
		cData60a.iTADayofWeek  = ((Spinner)findViewById(R.id.sTakeAssessmentDay)).getSelectedItemPosition();
		cData60a.iTARepeat     = ((Spinner)findViewById(R.id.sTakeAssessmentRepeat)).getSelectedItemPosition();
		cData60a.setAnAlarm(ALARMS.TakeAssessment);
		cData60a.saveData();			// save data to file
		super.onPause();
	}

	@Override
	protected void onResume() {
		cData60a = new CBTi_Data60a(this);	// initialize data from stored object
		cData60a.cancelAnAlarm(ALARMS.TakeAssessment);
		// take assessment reminder
		((ToggleButton)findViewById(R.id.bTakeAssessmentReminder)).setChecked( cData60a.bTakeAssessmentReminder );
		((TextView)findViewById(R.id.tTakeAssessmentTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iTAmin) );
		if ( !cData60a.bTakeAssessmentReminder ) {
			findViewById(R.id.rlTakeAssessment).setVisibility(View.GONE);
		}
		else {
			findViewById(R.id.rlTakeAssessment).setVisibility(View.VISIBLE);
		}

		enableTADayOfWeek();
		enableTARepeat();

		super.onResume();
	}

	public class myOnItemSelectedListener implements OnItemSelectedListener {
		public myOnItemSelectedListener() {
		}

		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {
		}

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
