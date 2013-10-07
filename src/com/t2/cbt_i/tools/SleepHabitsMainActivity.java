package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashboardActivity;

public class SleepHabitsMainActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_sleephabitsmain);

		// middle buttons
		((Button)findViewById(R.id.bSetCaffeineGoals)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(SleepHabitsMainActivity.this, SleepHabitsCaffeineActivity.class );
				SleepHabitsMainActivity.this.startActivity(i);
				SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		((Button)findViewById(R.id.bSetUpYourSleepEnvironment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(SleepHabitsMainActivity.this, SleepHabitsSleepEnvironmentSetupActivity.class );
				SleepHabitsMainActivity.this.startActivity(i);
				SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		((Button)findViewById(R.id.bGotoBedOnlyWhenSleepy)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(SleepHabitsMainActivity.this, SleepHabitsGoToBedOnlyWhenSleepyActivity.class );
				SleepHabitsMainActivity.this.startActivity(i);
				SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});  
		
		((Button)findViewById(R.id.bGetoutofBedWhenyoucantSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(SleepHabitsMainActivity.this, SleepHabitsGetOutOfBedWhenCantSleepActivity.class );
				SleepHabitsMainActivity.this.startActivity(i);
				SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});  
		
		((Button)findViewById(R.id.bGetoutofBedatyourPrescribedTime)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(SleepHabitsMainActivity.this, SleepHabitsGetOutOfBedOnTimeActivity.class );
				SleepHabitsMainActivity.this.startActivity(i);
				SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});  
	}	
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(SleepHabitsMainActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolscreatenewsleephabits);
		i.putExtra("RID_Text", R.string.s_34b);
		SleepHabitsMainActivity.this.startActivity(i);
		SleepHabitsMainActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
