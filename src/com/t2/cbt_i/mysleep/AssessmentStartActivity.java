package com.t2.cbt_i.mysleep;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class AssessmentStartActivity extends BaseABSActivity {

	AssessmentStartData cData31b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentstart);

		// ProviderToggle Button 
		((ToggleButton)findViewById(R.id.bProvider)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button
			}
		});
		
		// Take Assessment Button 
		((Button)findViewById(R.id.bTakeNow)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the button
				Intent i = new Intent(AssessmentStartActivity.this, AssessmentQuestionnaireActivity.class );
				AssessmentQuestionnaireData cData31c = new AssessmentQuestionnaireData(AssessmentStartActivity.this);
				cData31c.deleteData();			// start with a clean slate
				AssessmentStartActivity.this.startActivity(i);
				AssessmentStartActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AssessmentStartActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
		
	static final int DIALOG_ISIERROR = 1;

	@Override
	protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case DIALOG_ISIERROR:
	    	new AlertDialog.Builder(this).setMessage(getString(R.string.s_ISIError)).setPositiveButton("OK", null).create().show();
			break;
	    }
	    return null;
	}

	
		        
	@Override
	protected void onPause() {
		cData31b.bProvider = ((ToggleButton)findViewById(R.id.bProvider)).isChecked();
		cData31b.saveData();			// save data to file
		super.onPause();
	}

	
	@Override
	protected void onResume() {
		cData31b = new AssessmentStartData(this);
		
		if( cData31b.withinAWeek()) {
			Intent i = new Intent(AssessmentStartActivity.this, AssessmentTakenTooSoonActivity.class );
			AssessmentStartActivity.this.startActivity(i);
			AssessmentStartActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		}
		else {
			((ToggleButton)findViewById(R.id.bProvider)).setChecked( cData31b.bProvider );
		}
		
		super.onResume();
	}
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(AssessmentStartActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_assessmenthelp);
		i.putExtra("RID_Text", R.string.s_31bhelp);
		AssessmentStartActivity.this.startActivity(i);
		AssessmentStartActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}