package com.t2.cbt_i.learn;


import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity43a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_43a);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_CBTiGlossary );
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility( View.INVISIBLE );
		
		// top left HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	finish();		// make sure we close the splash screen so the user won't come back when it presses back key
            	Intent i = new Intent(getApplicationContext(), DashActivity.class );
            	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	startActivity(i);
            	CBTi_Activity43a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
            }
        }); 
	}

	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity43a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}