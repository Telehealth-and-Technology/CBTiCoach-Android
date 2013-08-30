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


public class CBTi_Activity31e extends CBTi_BaseActivity {

	CBTi_Data31b cData31b;
	CBTi_Data31c cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31e);

		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Feedback);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31e.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31e.this.startActivity(i);
				CBTi_Activity31e.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// done Button
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31e.this, CBTi_Activity31a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31e.this.startActivity(i);
				CBTi_Activity31e.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// schedule Button
		((Button)findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31e.this, CBTi_Activity33a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31e.this.startActivity(i);
				CBTi_Activity31e.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(CBTi_Activity31e.this, CBTi_Activity31a.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		CBTi_Activity31e.this.startActivity(i);
		CBTi_Activity31e.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
	@Override
	protected void onPause() {
		super.onPause();
	}

		
	@Override
	protected void onResume() {
		super.onResume();
		
		cData31b = new CBTi_Data31b(this);
		cData31c = new CBTi_Data31c(this);
		int iRid;
		int iThisScore = cData31b.alISIData.get(cData31b.alISIData.size()-1).iCumScore;
		if( cData31b.bProvider )
			iRid = R.string.s_ISIFeedProv;
		else {
			Boolean bFirst = (cData31b.alISIData.size() == 1);
						
			if( bFirst == true ) {
				if( iThisScore < 10 )
					iRid = R.string.s_ISIFeed1;
				else
					iRid = R.string.s_ISIFeed2;
			}
			else {
				int iPrevScore = cData31b.alISIData.get(cData31b.alISIData.size()-2).iCumScore;
				
				if( iThisScore<10 && iPrevScore<10 )
					iRid = R.string.s_ISIFeed3;
				else if( iThisScore>=10 && iPrevScore<10 )
					iRid = R.string.s_ISIFeed4;
				else
					iRid = R.string.s_ISIFeed5;
				
			}
		}
		((TextView)findViewById(R.id.tISIFeed)).setText(iRid);	
			
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