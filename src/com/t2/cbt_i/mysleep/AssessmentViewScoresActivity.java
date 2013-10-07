package com.t2.cbt_i.mysleep;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;



public class AssessmentViewScoresActivity extends BaseABSNHActivity {

	AssessmentQuestionnaireData cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentviewscores);
		
		AssessmentStartData cData31b = new AssessmentStartData( this );
		Bundle b = getIntent().getExtras();
		int iEntry = b.getInt("POS");
		cData31c = cData31b.alISIData.get(iEntry);

		// done Button
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentViewScoresActivity.this, AssessmentHistoryListActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				AssessmentViewScoresActivity.this.startActivity(i);
				AssessmentViewScoresActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// schedule Button
		((Button)findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentViewScoresActivity.this, AssessmentScheduleReminderActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				AssessmentViewScoresActivity.this.startActivity(i);
				AssessmentViewScoresActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});


	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AssessmentViewScoresActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
		
	@Override
	protected void onResume() {
		super.onResume();
		
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