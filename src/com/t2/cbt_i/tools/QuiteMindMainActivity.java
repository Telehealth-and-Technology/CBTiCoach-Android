package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindMainActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_quitemindmain);
	
		// middle buttons
		((Button)findViewById(R.id.bWindingDown)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindWindingDownActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bScheduleWorryTime)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindScheduleWorryTimeActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bChangeYourPerspective)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindChangePerspectiveActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bObserveThoughtsCloudsintheSky)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindObserveThoughtsActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bObserveSensationsBodyScan)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindObserveSensationsActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryForest)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindForestImageryActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryCountryRoad)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindCountryRoadImageryActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bGuidedImageryBeach)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindBeachImageryActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bProgressiveMuscleRelaxation)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindProgressiveMuscleRelaxationActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bBreathingTool)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindMainActivity.this, QuiteMindBreathingToolActivity.class );
				QuiteMindMainActivity.this.startActivity(i);
				QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(QuiteMindMainActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsquietyourmind);
		i.putExtra("RID_Text", R.string.s_35b);
		QuiteMindMainActivity.this.startActivity(i);
		QuiteMindMainActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
