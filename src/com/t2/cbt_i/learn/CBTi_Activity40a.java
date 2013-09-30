package com.t2.cbt_i.learn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class CBTi_Activity40a extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_40a);
	
		// Middle Sleep101 
		((Button)findViewById(R.id.bSleep101)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Activity41a.class );
				startActivity(i);
				CBTi_Activity40a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// Middle Healthy Sleep Habits 
		((Button)findViewById(R.id.bHealthySleepHabits)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Activity42a.class );
				startActivity(i);
				CBTi_Activity40a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// Middle CBT-i Glossary 
		((Button)findViewById(R.id.bCBTiGlossary)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Activity43a.class );
				startActivity(i);
				CBTi_Activity40a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}

	
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity40a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_homelearn);
		i.putExtra("RID_Text", R.string.s_40b);
		startActivity( i ); 
		overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}