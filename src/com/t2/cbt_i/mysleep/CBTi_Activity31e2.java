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


public class CBTi_Activity31e2 extends CBTi_BaseActivity {

	CBTi_Data31b cData31b;
	CBTi_Data31c cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31e2);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Feedback);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31e2.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31e2.this.startActivity(i);
				CBTi_Activity31e2.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// done Button
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31e2.this, CBTi_Activity31a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31e2.this.startActivity(i);
				CBTi_Activity31e2.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity31e2.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
	@Override
	protected void onPause() {
		super.onPause();
	}

		
	@Override
	protected void onResume() {
		super.onResume();
		
		cData31b = new CBTi_Data31b(this);
		cData31c = cData31b.alISIData.get(cData31b.alISIData.size()-1);
			
		((TextView)findViewById(R.id.tISIScore)).setText(String.format(getString(R.string.s_ISI_Score), cData31c.iCumScore));	
		((TextView)findViewById(R.id.tISIScore01)).setText(String.format(getString(R.string.s_ISI_Score01), cData31c.iScore[0]));	
		((TextView)findViewById(R.id.tISIScore02)).setText(String.format(getString(R.string.s_ISI_Score02), cData31c.iScore[1]));
		((TextView)findViewById(R.id.tISIScore03)).setText(String.format(getString(R.string.s_ISI_Score03), cData31c.iScore[2]));
		((TextView)findViewById(R.id.tISIScore04)).setText(String.format(getString(R.string.s_ISI_Score04), cData31c.iScore[3]));
		((TextView)findViewById(R.id.tISIScore05)).setText(String.format(getString(R.string.s_ISI_Score05), cData31c.iScore[4]));
		((TextView)findViewById(R.id.tISIScore06)).setText(String.format(getString(R.string.s_ISI_Score06), cData31c.iScore[5]));
		((TextView)findViewById(R.id.tISIScore07)).setText(String.format(getString(R.string.s_ISI_Score07), cData31c.iScore[6]));
	}
	
	
}