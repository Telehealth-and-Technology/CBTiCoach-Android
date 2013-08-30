package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;

public class CBTi_Activity35a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35a);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_QuietYourMind);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity35a.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolsquietyourmind);
				i.putExtra("RID_Text", R.string.s_35b);
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bWindingDown)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a1.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bScheduleWorryTime)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35d.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bChangeYourPerspective)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35e.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bObserveThoughtsCloudsintheSky)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a15.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bObserveSensationsBodyScan)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a16.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryForest)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a12.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryCountryRoad)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a13.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryBeach)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a14.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bProgressiveMuscleRelaxation)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a11.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bBreathingTool)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a.this, CBTi_Activity35a10.class );
				CBTi_Activity35a.this.startActivity(i);
				CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity35a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}
