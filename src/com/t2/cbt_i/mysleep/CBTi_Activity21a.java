package com.t2.cbt_i.mysleep;


import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.reminders.CBTi_Data60a;
import com.t2.cbt_i.reminders.CBTi_Data60a.ALARMS;


public class CBTi_Activity21a extends BaseABSActivity {

	CBTi_Data60a cData60a;
	CBTi_Data21a cData21a;
	ArrayAdapter<CBTi_Data21c> aa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_21a);
		
		cData60a = new CBTi_Data60a( this );

		// Reminder Toggle Button 
		((Button)findViewById(R.id.bSleepDiaryReminder)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				cData60a.bSleepDiaryReminder = ((ToggleButton)findViewById(R.id.bSleepDiaryReminder)).isChecked();
				if ( !cData60a.bSleepDiaryReminder ) {
					findViewById(R.id.remindertime).setVisibility(View.GONE);
				}
				else {
					findViewById(R.id.remindertime).setVisibility(View.VISIBLE);
					((TextView)findViewById(R.id.tSleepDiaryReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
				}
			}
		});
		
		((TextView)findViewById(R.id.tSleepDiaryReminderTime)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				iInitialHourOfDay = cData60a.iSDRmin;
				if( iInitialHourOfDay != -1 )
					iInitialHourOfDay = cData60a.timeFrom4pm(cData60a.iSDRmin) / 60;
				iInitialMin = cData60a.timeFrom4pm(cData60a.iSDRmin) % 60;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		// set up mid bar
		((Button)findViewById(R.id.midLeft)).setVisibility(View.INVISIBLE);
		((Button)findViewById(R.id.midRight)).setText(R.string.s_NewEntry);

		// New Entry Button 
		((Button)findViewById(R.id.midRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity21a.this, CBTi_Activity21c.class );
				i.putExtra("NEW", true);
				new CBTi_Data21c(CBTi_Activity21a.this).deleteData();
				CBTi_Activity21a.this.startActivity(i);
				CBTi_Activity21a.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});

		

	}
	
	



	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity21a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	private static int iColorsID[] = { R.drawable.pbprogress1, R.drawable.pbprogress1, R.drawable.pbprogress1, R.drawable.pbprogress1, 
                                       R.drawable.pbprogress1, R.drawable.pbprogress2, R.drawable.pbprogress2, R.drawable.pbprogress3 };
	private void updateProgressBar(int iProg) {
		ProgressBar pbWeek = (ProgressBar)findViewById(R.id.progressBar);
		Rect bounds = pbWeek.getProgressDrawable().getBounds();
		pbWeek.setProgressDrawable(getResources().getDrawable(iColorsID[iProg]));
		pbWeek.getProgressDrawable().setBounds(bounds);
		pbWeek.setProgress(pbWeek.getProgress()+1);
		
		//pbWeek.setProgressDrawable(getResources().getDrawable(iColorsID[iProg]));
		
		pbWeek.setProgress(iProg);
		((TextView)findViewById(R.id.tPastWeeks)).setText( getResources().getString(R.string.s_PastWeeks)+iProg+"/7" );
	}
	
	TimePickerDialog tp;
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
		
	private TimePickerDialog.OnTimeSetListener mTimeSetListener =
			new TimePickerDialog.OnTimeSetListener() {
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
			cData60a.iSDRmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
			((TextView)findViewById(R.id.tSleepDiaryReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
		}
	};

		        
	@Override
	protected void onPause() {
		cData60a.saveData();			// save data to file
		cData60a.setAnAlarm( ALARMS.SleepDiary );
		super.onPause();
	}

	private ListView lv;
	//private ArrayList<String> aList;
	
	@Override
	protected void onResume() {
		cData21a = new CBTi_Data21a(this);
		
		cData60a = new CBTi_Data60a(this);	// initialize data from stored object
		cData60a.cancelAnAlarm(ALARMS.SleepDiary);
		
		((ToggleButton)findViewById(R.id.bSleepDiaryReminder)).setChecked( cData60a.bSleepDiaryReminder );
		((TextView)findViewById(R.id.tSleepDiaryReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
		if ( !cData60a.bSleepDiaryReminder ) {
			findViewById(R.id.remindertime).setVisibility(View.GONE);
		}
		else {
			findViewById(R.id.remindertime).setVisibility(View.VISIBLE);
			((TextView)findViewById(R.id.tSleepDiaryReminderTime)).setText( cData60a.formattedTimeFrom4pm(cData60a.iSDRmin) );
		}

		updateProgressBar( cData21a.iPastWeek );
		
		// Find the ListView resource. 
	    lv = (ListView) findViewById( R.id.lvSleepData );
	    aa = new ArrayAdapter<CBTi_Data21c>(this, R.layout.sleepdatarow, cData21a.alSleepDiary);
	    lv.setAdapter(aa);
		lv.setEmptyView(findViewById(R.id.tSleepDataEmpty));
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Intent i = new Intent(CBTi_Activity21a.this, CBTi_Activity21c.class );
				i.putExtra("NEW", false);
				i.putExtra("POS", position);
				CBTi_Activity21a.this.startActivityForResult(i,1);
				CBTi_Activity21a.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		
		super.onResume();
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(CBTi_Activity21a.this, CBTi_Activity21b.class );
		CBTi_Activity21a.this.startActivity(i);
		CBTi_Activity21a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}