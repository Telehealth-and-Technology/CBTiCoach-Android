package com.t2.cbt_i.splash;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.DashActivity;


public class SplashActivity10d extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash10d);
		
		((Button)findViewById(R.id.iContinue)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	finish();		// make sure we close the splash screen so the user won't come back when it presses back key
            	Intent i = new Intent(SplashActivity10d.this, DashActivity.class );
            	SplashActivity10d.this.startActivity(i);
            }
        });
		
		
	}


}