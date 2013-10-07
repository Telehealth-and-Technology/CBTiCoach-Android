package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindObserveSensationsActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_quitemindobservesensations);

		// middle buttons
		((Button)findViewById(R.id.bAudioGuided)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindObserveSensationsActivity.this, QuiteMindObserveSensationsContentActivity.class );
				i.putExtra("RID", R.id.bAudioGuided);
				QuiteMindObserveSensationsActivity.this.startActivity(i);
				QuiteMindObserveSensationsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bSelfGuided)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindObserveSensationsActivity.this, QuiteMindObserveSensationsContentActivity.class );
				i.putExtra("RID", R.id.bSelfGuided);
				QuiteMindObserveSensationsActivity.this.startActivity(i);
				QuiteMindObserveSensationsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}	
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		QuiteMindObserveSensationsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(QuiteMindObserveSensationsActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsobservesensationsbodyscan);
		i.putExtra("RID_Text", R.string.s_35a16help);
		QuiteMindObserveSensationsActivity.this.startActivity(i);
		QuiteMindObserveSensationsActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
