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

public class CBTi_Activity21j extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_21j);
		
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Assessment);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
		
		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity21j.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity21j.this.startActivity(i);
				CBTi_Activity21j.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// DONE
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity21j.this, CBTi_Activity21a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity21j.this.startActivity(i);
				CBTi_Activity21j.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
				
	}	
	
	
	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity21j.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}

	@Override
	protected void onResume() {
		super.onResume();
		CBTi_Data21c cData21c = new CBTi_Data21c(this);
		
		String s = String.format( getString(R.string.s_TotalTimeInBed), cData21c.iTIBDailymin/60, cData21c.iTIBDailymin%60 );
		((TextView)findViewById(R.id.tTotalTimeInBed)).setText(s);
		
		s = String.format( getString(R.string.s_TotalTimeAsleep), cData21c.iTSTDailymin/60, cData21c.iTSTDailymin%60 );
		((TextView)findViewById(R.id.tTotalTimeAsleep)).setText(s);
		
		s = String.format( getString(R.string.s_SleepEfficiency), cData21c.iSEDaily );
		((TextView)findViewById(R.id.tSleepEfficiency)).setText(s+"%");
	}
}
