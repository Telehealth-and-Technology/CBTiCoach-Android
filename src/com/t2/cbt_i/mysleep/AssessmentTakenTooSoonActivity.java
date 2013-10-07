package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;



public class AssessmentTakenTooSoonActivity extends BaseABSNHActivity {

	AssessmentStartData cData31b;
	AssessmentQuestionnaireData cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmenttakentoosoon);
	
		// schedule Button
		((Button)findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentTakenTooSoonActivity.this, AssessmentScheduleReminderActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				AssessmentTakenTooSoonActivity.this.startActivity(i);
				AssessmentTakenTooSoonActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// take now Button
		((Button)findViewById(R.id.bTakeAssessmentNow)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentTakenTooSoonActivity.this, AssessmentQuestionnaireActivity.class );
				AssessmentQuestionnaireData cData31c = new AssessmentQuestionnaireData(AssessmentTakenTooSoonActivity.this);
				cData31c.deleteData();			// start with a clean slate
				AssessmentTakenTooSoonActivity.this.startActivity(i);
				AssessmentTakenTooSoonActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(AssessmentTakenTooSoonActivity.this, AssessmentMainActivity.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		AssessmentTakenTooSoonActivity.this.startActivity(i);
		AssessmentTakenTooSoonActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
	@Override
	protected void onPause() {
		super.onPause();
	}

		
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
}