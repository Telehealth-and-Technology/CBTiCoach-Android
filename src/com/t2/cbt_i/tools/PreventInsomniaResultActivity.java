package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;

public class PreventInsomniaResultActivity extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_preventinsomniaresults);

		Bundle b = getIntent().getExtras();
		if( !(b.getBoolean("PREVENT01")) ) {
			((LinearLayout)findViewById(R.id.llPrevent01)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR01)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR01)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, SleepHabitsGetOutOfBedOnTimeActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT02")) ) {
			((LinearLayout)findViewById(R.id.llPrevent02)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR02)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR02)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, SleepHabitsGoToBedOnlyWhenSleepyActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT03")) ) {
			((LinearLayout)findViewById(R.id.llPrevent03)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR03)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR03)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, SleepHabitsGetOutOfBedWhenCantSleepActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT04")) ) {
			((LinearLayout)findViewById(R.id.llPrevent04)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR04)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR04)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, QuiteMindWindingDownActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT05")) ) {
			((LinearLayout)findViewById(R.id.llPrevent05)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR05)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR05)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, QuiteMindScheduleWorryTimeActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT06")) ) {
			((LinearLayout)findViewById(R.id.llPrevent06)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR06)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR06)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, SleepHabitsCaffeineActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT07")) ) {
			((LinearLayout)findViewById(R.id.llPrevent07)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR07)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR07)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, SleepHabitsSleepEnvironmentSetupActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		if( !(b.getBoolean("PREVENT08")) ) {
			((LinearLayout)findViewById(R.id.llPrevent08)).setVisibility(View.GONE);
			((LinearLayout)findViewById(R.id.llToolR08)).setVisibility(View.GONE);
		} else
			((TextView)findViewById(R.id.tToolR08)).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {		// handle the about button

					Intent i = new Intent(PreventInsomniaResultActivity.this, QuiteMindMainActivity.class );
					PreventInsomniaResultActivity.this.startActivity(i);
					PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			});
		
		

	}	
	
	

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		PreventInsomniaResultActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}
