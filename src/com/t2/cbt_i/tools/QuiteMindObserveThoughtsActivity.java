package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindObserveThoughtsActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_quitemindobservethoughts);

		// middle buttons
		((Button)findViewById(R.id.bAudioGuided)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindObserveThoughtsActivity.this, QuiteMindObserveThoughtsContentActivity.class );
				i.putExtra("RID", R.id.bAudioGuided);
				QuiteMindObserveThoughtsActivity.this.startActivity(i);
				QuiteMindObserveThoughtsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bSelfGuided)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(QuiteMindObserveThoughtsActivity.this, QuiteMindObserveThoughtsContentActivity.class );
				i.putExtra("RID", R.id.bSelfGuided);
				QuiteMindObserveThoughtsActivity.this.startActivity(i);
				QuiteMindObserveThoughtsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		
		
	}	
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		QuiteMindObserveThoughtsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(QuiteMindObserveThoughtsActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsobservethoughtscloudsinthesky);
		i.putExtra("RID_Text", R.string.s_35a15help);
		QuiteMindObserveThoughtsActivity.this.startActivity(i);
		QuiteMindObserveThoughtsActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
