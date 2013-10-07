package com.t2.cbt_i.mysleep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;

public class SleepDairyEntryResultsActivity extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_sleepdairyentryresults);
		
		// DONE
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(SleepDairyEntryResultsActivity.this, SleepDairyMainActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				SleepDairyEntryResultsActivity.this.startActivity(i);
				SleepDairyEntryResultsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});			
	}	
	
	
	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		SleepDairyEntryResultsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		SleepDairyEntryData cData21c = new SleepDairyEntryData(this);
		
		String s = String.format( getString(R.string.s_TotalTimeInBed), cData21c.iTIBDailymin/60, cData21c.iTIBDailymin%60 );
		((TextView)findViewById(R.id.tTotalTimeInBed)).setText(s);
		
		s = String.format( getString(R.string.s_TotalTimeAsleep), cData21c.iTSTDailymin/60, cData21c.iTSTDailymin%60 );
		((TextView)findViewById(R.id.tTotalTimeAsleep)).setText(s);
		
		s = String.format( getString(R.string.s_SleepEfficiency), cData21c.iSEDaily );
		((TextView)findViewById(R.id.tSleepEfficiency)).setText(s+"%");
	}
}
