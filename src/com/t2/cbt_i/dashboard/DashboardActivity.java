package com.t2.cbt_i.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.learn.LearnMainActivity;
import com.t2.cbt_i.mysleep.MySleepMainActivity;
import com.t2.cbt_i.mysleep.UpdateSleepPrescriptionData;
import com.t2.cbt_i.reminders.RemindersMainActivity;
import com.t2.cbt_i.tools.ToolsMainActivity;


public class DashboardActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	
		// MySleep Button
		((Button)findViewById(R.id.b10mysleep)).setOnClickListener(new View.OnClickListener() {
		    @Override
			public void onClick(View v) {		// handle the about button   
		    	
		    	Intent i = new Intent(DashboardActivity.this, MySleepMainActivity.class );
		    	DashboardActivity.this.startActivity(i);
		    	DashboardActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
		
		// Learn Button
		((Button)findViewById(R.id.b10learn)).setOnClickListener(new View.OnClickListener() {
		    @Override
			public void onClick(View v) {		// handle the about button			                 
		    	Intent i = new Intent(DashboardActivity.this, LearnMainActivity.class );
		    	DashboardActivity.this.startActivity(i);
		    	DashboardActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
		
		// Tools Button
		((Button)findViewById(R.id.b10tools)).setOnClickListener(new View.OnClickListener() {
		    @Override
			public void onClick(View v) {		// handle the about button				                 
		    	Intent i = new Intent(DashboardActivity.this, ToolsMainActivity.class );
		    	DashboardActivity.this.startActivity(i);
		    	DashboardActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// Reminders Button
		((Button)findViewById(R.id.b10reminders)).setOnClickListener(new View.OnClickListener() {
		    @Override
			public void onClick(View v) {		// handle the about button		                 
		    	Intent i = new Intent(DashboardActivity.this, RemindersMainActivity.class );
		    	DashboardActivity.this.startActivity(i);
		    	DashboardActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		// fetch the data and display either the sleep prescription or the msg
		UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData( this );
		cData22a.displaySleepPrescription();
		
	}
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		int ht = ((Button)findViewById(R.id.b10mysleep)).getHeight();
		int wi = ((Button)findViewById(R.id.b10mysleep)).getWidth();
		int sc = Math.min(ht,wi) / 18;
		((TextView)findViewById(R.id.t10mysleep)).setTextSize(sc);
		((TextView)findViewById(R.id.t10tools)).setTextSize(sc);
		((TextView)findViewById(R.id.t10learn)).setTextSize(sc);
		((TextView)findViewById(R.id.t10reminders)).setTextSize(sc);
	    super.onWindowFocusChanged(hasFocus);
	}

	
	//@Override
	@Override
	public void getHelp() {			// called to render help screen
		startActivity( new Intent(this, DashboardHelpActivity.class) ); 
		overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
	
	
}
