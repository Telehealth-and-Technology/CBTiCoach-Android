package com.t2.cbt_i.mysleep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;

public class AssessmentMainActivity extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentmain);
		
		// middle buttons
		((Button)findViewById(R.id.bTakeAssessment)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentMainActivity.this, AssessmentStartActivity.class );
				AssessmentMainActivity.this.startActivity(i);
				AssessmentMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		((Button)findViewById(R.id.bResultsHistory)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		
				Intent i = new Intent(AssessmentMainActivity.this, AssessmentHistoryGraphActivity.class );
				AssessmentMainActivity.this.startActivity(i);
				AssessmentMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		((Button)findViewById(R.id.bScheduleAssessments)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button 23a

				Intent i = new Intent(AssessmentMainActivity.this, AssessmentScheduleReminderActivity.class );
				AssessmentMainActivity.this.startActivity(i);
				AssessmentMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});  
	}	
	

	
	

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AssessmentMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}
