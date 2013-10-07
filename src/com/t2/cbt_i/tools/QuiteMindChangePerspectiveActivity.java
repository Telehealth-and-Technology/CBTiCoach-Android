package com.t2.cbt_i.tools;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.ThoughtActivity;


public class QuiteMindChangePerspectiveActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_quitemindchangeperspective);
	
		// Middle Worried About Sleep 
		((Button)findViewById(R.id.bWorriedAboutSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), ThoughtActivity.class );
				i.putExtra("THINKABOUT", true);
				startActivity(i);
				QuiteMindChangePerspectiveActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// Middle Worried About Trauma
		((Button)findViewById(R.id.bWorriedAboutTrauma)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), ThoughtActivity.class );
				i.putExtra("THINKABOUT", false);
				startActivity(i);
				QuiteMindChangePerspectiveActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}

	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		QuiteMindChangePerspectiveActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsperspective);
		i.putExtra("RID_Text", R.string.s_35e2);
		startActivity(i);
		QuiteMindChangePerspectiveActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}