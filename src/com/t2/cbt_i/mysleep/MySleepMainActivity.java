package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class MySleepMainActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_main);
	
		// middle buttons
		((Button)findViewById(R.id.bSleepDiary)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(MySleepMainActivity.this, SleepDairyMainActivity.class );
				MySleepMainActivity.this.startActivity(i);
				MySleepMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bUpdateSleepPrescription)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(MySleepMainActivity.this, UpdateSleepPrescriptionActivity.class );
				MySleepMainActivity.this.startActivity(i);
				MySleepMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bINeedMoreSleep)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button 23a

				Intent i = new Intent(MySleepMainActivity.this, INeedMoreSleepMainActivity.class );
				MySleepMainActivity.this.startActivity(i);
				MySleepMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bAssessment)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button 23a

				Intent i = new Intent(MySleepMainActivity.this, AssessmentMainActivity.class );
				MySleepMainActivity.this.startActivity(i);
				MySleepMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});


	}
	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		MySleepMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(MySleepMainActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_learnusingbedroom);
		i.putExtra("RID_Text", R.string.s_20b);
		MySleepMainActivity.this.startActivity(i);
		MySleepMainActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}