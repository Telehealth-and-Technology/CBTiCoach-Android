package com.t2.cbt_i.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.DashActivity;



public class SplashActivity10a extends Activity {

	//how long until we go to the next activity
	protected int iSplashTime = 3000; 
	private Handler handler;
	private Runnable myRunnable;
	private Boolean bForceSplash = false;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		try {
			ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
			Bundle bundle = ai.metaData;
			bForceSplash = bundle.getBoolean("bForceSplash");
			iSplashTime = bundle.getInt("iSplashTime");
		} catch (Exception e) {
			Log.d("DEBUG", "Failed to load meta-data, NameNotFound: " + e.getMessage());
			iSplashTime = 3000;
		}

		// see if we need to splash or not
		SharedPreferences prefs = this.getSharedPreferences( "CBTiPrefs", Context.MODE_PRIVATE);
		Boolean bSplashedAlready = prefs.getBoolean("bSplashedAlready", false);
		if( bSplashedAlready && !bForceSplash )
			jumpTo( DashActivity.class );
		else {
			setContentView(R.layout.splash10a);				// show splash screen
			handler = new Handler();
			myRunnable = new Runnable() {
				public void run() {
					jumpTo(SplashActivity10b.class);
				}
			};
			handler.postDelayed( myRunnable, iSplashTime ); 
			// time in milliseconds (1 sec = 1000 millis) until the run() called
		}
	}


	//Function that will handle the touch
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			handler.removeCallbacks(myRunnable);
			jumpTo(SplashActivity10b.class);
		}
		return true;
	}

	private void jumpTo( Class<?> cTarget ) {
		finish();		// make sure we close the splash screen so the user won't come back when it presses back key
		Intent intent = new Intent(SplashActivity10a.this, cTarget );
		SplashActivity10a.this.startActivity(intent);
	}
}