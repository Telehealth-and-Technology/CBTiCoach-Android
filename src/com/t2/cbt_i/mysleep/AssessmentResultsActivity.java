package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class AssessmentResultsActivity extends BaseABSNHActivity {

	AssessmentStartData cData31b;
	AssessmentQuestionnaireData cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentresults);

		// done Button
		((Button)findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentResultsActivity.this, AssessmentMainActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				AssessmentResultsActivity.this.startActivity(i);
				AssessmentResultsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// schedule Button
		((Button)findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(AssessmentResultsActivity.this, AssessmentScheduleReminderActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				AssessmentResultsActivity.this.startActivity(i);
				AssessmentResultsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(AssessmentResultsActivity.this, AssessmentMainActivity.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		AssessmentResultsActivity.this.startActivity(i);
		AssessmentResultsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
	@Override
	protected void onPause() {
		super.onPause();
	}

		
	@Override
	protected void onResume() {
		super.onResume();
		
		cData31b = new AssessmentStartData(this);
		cData31c = new AssessmentQuestionnaireData(this);
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