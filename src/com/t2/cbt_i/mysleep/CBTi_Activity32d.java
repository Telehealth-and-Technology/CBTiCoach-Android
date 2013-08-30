package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity32d extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_32d);

		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
		((TextView)findViewById(R.id.tvTopTitle)).setVisibility(View.INVISIBLE);
		
		// Top Left HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				finish();		// make sure we close the splash screen so the user won't come back when it presses back key
				Intent i = new Intent(getApplicationContext(), DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				CBTi_Activity32d.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		}); 

		// Middle New Sleep Habits 
		((Button)findViewById(R.id.bTakeAssessmentNow)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Activity31b.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				CBTi_Activity32d.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}

	
			
		

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), CBTi_Activity31a.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		CBTi_Activity32d.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}