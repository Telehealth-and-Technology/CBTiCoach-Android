package com.t2.cbt_i.tools;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;
import com.t2.cbt_i.reminders.CBTi_ActivityRemBRWindDown;
import com.t2.cbt_i.reminders.CBTi_Data60a;
import com.t2.cbt_i.reminders.CBTi_Data60a.ALARMS;


public class CBTi_Activity35a1 extends CBTi_BaseActivity {
	
	CBTi_Data35a1 cData35a1;
	CBTi_Data60a  cData60a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35a1);
		
		//alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_WindingDown);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity35a1.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity35a1.this.startActivity(i);
				CBTi_Activity35a1.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity35a1.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolshelpwindingdown);
				i.putExtra("RID_Text", R.string.s_35e1);
				CBTi_Activity35a1.this.startActivity(i);
				CBTi_Activity35a1.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		// Wind Down Time Reminder Toggle Button 
		((Button)findViewById(R.id.bWindDownTimeReminder)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				cData60a.bWindDownTimeReminder = ((ToggleButton)findViewById(R.id.bWindDownTimeReminder)).isChecked();
				if ( !cData60a.bWindDownTimeReminder ) {
					((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.INVISIBLE);
				}
				else {
					((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Wind Down Time Reminder Time Picker
		((TextView)findViewById(R.id.tWindDownTimeReminder)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				iInitialHourOfDay = 15;		// remember to initialize these
				iInitialMin = 32;
				iNextClass = CBTi_ActivityRemBRWindDown.class;
				showDialog(TIME_DIALOG_ID);
			}	
		});
		
		((LinearLayout)findViewById(R.id.llWind01)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind02)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind03)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind04)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind05)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind06)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind07)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind08)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind09)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind10)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind11)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind12)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind13)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind14)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind15)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind16)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind17)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind18)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind19)).setOnClickListener( WindOCL );
		((LinearLayout)findViewById(R.id.llWind20)).setOnClickListener( WindOCL );
		
		((ImageButton)findViewById(R.id.bWind01)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind02)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind03)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind04)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind05)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind06)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind07)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind08)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind09)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind10)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind11)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind12)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind13)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind14)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind15)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind16)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind17)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind18)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind19)).setOnClickListener( WindOCL );
		((ImageButton)findViewById(R.id.bWind20)).setOnClickListener( WindOCL );
		
	}	
	
	//On click listener for button1
    final OnClickListener WindOCL = new OnClickListener() {
        public void onClick(final View v) {
        	
        	Boolean bState = false;
        	int id = v.getId();
        	int iButton = 0;
        	
        	int iStart=0;
        	if( id==R.id.llWind01 || id==R.id.bWind01 ) {
        		iStart = 0;
        		iButton = R.id.bWind01;
        	}
        	else if( id==R.id.llWind02 || id==R.id.bWind02 ) {
        		iStart = 1;
        		iButton = R.id.bWind02;
        	}
        	else if( id == R.id.llWind03 || id==R.id.bWind03 ) {
        		iStart = 2;
        		iButton = R.id.bWind03;
        	}
        	else if( id == R.id.llWind04 || id==R.id.bWind04 ) {
        		iStart = 3;
        		iButton = R.id.bWind04;
        	}
        	else if( id == R.id.llWind05 || id==R.id.bWind05 ) {
        		iStart = 4;
        		iButton = R.id.bWind05;
        	}
        	else if( id == R.id.llWind06 || id==R.id.bWind06 ) {
        		iStart = 5;
        		iButton = R.id.bWind06;
        	}
        	else if( id == R.id.llWind07 || id==R.id.bWind07 ) {
        		iStart = 6;
        		iButton = R.id.bWind07;
        	}
        	else if( id == R.id.llWind08 || id==R.id.bWind08 ) {
        		iStart = 7;
        		iButton = R.id.bWind08;
        	}
        	else if( id == R.id.llWind09 || id==R.id.bWind09 ) {
        		iStart = 8;
        		iButton = R.id.bWind09;
        	}
        	else if( id == R.id.llWind10 || id==R.id.bWind10 ) {
        		iStart = 9;
        		iButton = R.id.bWind10;
        	}
        	else if( id == R.id.llWind11 || id==R.id.bWind11 ) {
        		iStart = 10;
        		iButton = R.id.bWind11;
        	}
        	else if( id == R.id.llWind12 || id==R.id.bWind12 ) {
        		iStart = 11;
        		iButton = R.id.bWind12;
        	}
        	else if( id == R.id.llWind13 || id==R.id.bWind13 ) {
        		iStart = 12;
        		iButton = R.id.bWind13;
        	}
        	else if( id == R.id.llWind14 || id==R.id.bWind14 ) {
        		iStart = 13;
        		iButton = R.id.bWind14;
        	}
        	else if( id == R.id.llWind15 || id==R.id.bWind15 ) {
        		iStart = 14;
        		iButton = R.id.bWind15;
        	}
        	else if( id == R.id.llWind16 || id==R.id.bWind16 ) {
        		iStart = 15;
        		iButton = R.id.bWind16;
        	}
        	else if( id == R.id.llWind17 || id==R.id.bWind17 ) {
        		iStart = 16;
        		iButton = R.id.bWind17;
        	}
        	else if( id == R.id.llWind18 || id==R.id.bWind18 ) {
        		iStart = 17;
        		iButton = R.id.bWind18;
        	}
        	else if( id == R.id.llWind19 || id==R.id.bWind19 ) {
        		iStart = 18;
        		iButton = R.id.bWind19;
        	}
        	else if( id == R.id.llWind20 || id==R.id.bWind20 ) {
        		iStart = 19;
        		iButton = R.id.bWind20;
        	}
        	else if( id == R.id.llWind21 || id==R.id.bWind21 ) {
        		iStart = 20;
        		iButton = R.id.bWind21;
        	}
        	else if( id == R.id.llWind22 || id==R.id.bWind22 ) {
        		iStart = 21;
        		iButton = R.id.bWind22;
        	}
        	
        	if( v.getClass().getSimpleName().equalsIgnoreCase("LinearLayout") ) {
        		bState = !((ImageButton)findViewById(iButton)).isSelected();
        	   	((ImageButton)findViewById(iButton)).setSelected(bState);
        	}
        	else {
        		if (v.isSelected())
        			v.setSelected(false);
        		else 
        			v.setSelected(true);
        		bState = ((ImageButton)findViewById(iButton)).isSelected();
        	}
        	cData35a1.bWind[cData35a1.iMap[iStart]] = bState;		// scrape new state to data store

        	if( bState ) {		// if checked then re order display
        		if( iStart > 0 ) {
        			int iHold = cData35a1.iMap[iStart];
        			for( ; iStart>0 ; iStart-- ) 
        				cData35a1.iMap[iStart] = cData35a1.iMap[iStart-1];
        			cData35a1.iMap[0] = iHold;
        		}
        	}
        	cData35a1.renderData();
        }
    };
	
	


	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity35a1.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}



	@Override
	protected void onPause() {
		cData35a1.saveData();
		cData60a.saveData();
		cData60a.setAnAlarm(ALARMS.WindDownTime);
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData35a1 = new CBTi_Data35a1(this);
		cData35a1.renderData();
		
		cData60a = new CBTi_Data60a(this);
		cData60a.cancelAnAlarm(ALARMS.WindDownTime);
		// wind down time reminder
		((ToggleButton)findViewById(R.id.bWindDownTimeReminder)).setChecked( cData60a.bWindDownTimeReminder );
		((TextView)findViewById(R.id.tWindDownTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWDTmin) );
		if ( !cData60a.bWindDownTimeReminder ) {
			((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.INVISIBLE);
		}
		else {
			((TextView)findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
		}
		super.onResume();
	}
	
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
			if( iNextClass == CBTi_ActivityRemBRWindDown.class) {
				cData60a.iWDTmin = cData60a.timeTo4pm( (hourOfDay*60) + minute );
				((TextView)findViewById(R.id.tWindDownTimeReminder)).setText( cData60a.formattedTimeFrom4pm(cData60a.iWDTmin) );
			}
			
		}
	};

	private Class<CBTi_ActivityRemBRWindDown> iNextClass;					// tells the alarm where to wake up
	
}
