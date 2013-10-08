package com.t2.cbt_i.splash;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;


public class EULASplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_eula);
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		((Button)findViewById(R.id.iAccept)).setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View v) {	// Perform action on click
                // do not splash again
            	SharedPreferences prefs = getSharedPreferences("CBTiPrefs", Context.MODE_PRIVATE);
            	SharedPreferences.Editor pEdit = prefs.edit();
            	pEdit.putBoolean( "bSplashedAlready", true );
            	pEdit.commit();
            	            	
            	finish();		// make sure we close the splash screen so the user won't come back when it presses back key
            	Intent i = new Intent(EULASplashActivity.this, WelcomeToCBTiSplashActivity.class );
            	EULASplashActivity.this.startActivity(i);
            }
        });
	}


}