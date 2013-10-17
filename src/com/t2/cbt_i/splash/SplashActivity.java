package com.t2.cbt_i.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.DashboardActivity;

public class SplashActivity extends SherlockFragmentActivity 
{

    private boolean mSplashDisplayed;

    private boolean mEulaAccepted;

    private boolean mDisclaimerAccepted;

    private SharedPreferences mPrefs;
    
	protected int iSplashTime = 3000; 
	private Handler handler;

    public void onAcceptDisclaimerClick(View v) 
    {
        mDisclaimerAccepted = true;
        mPrefs.edit()
                .putBoolean(getString(R.string.prf_disclaimer_accepted), mDisclaimerAccepted)
                .commit();
        showHome();
    }

    public void onAcceptEulaClick(View v) 
    {
        mEulaAccepted = true;
        mPrefs.edit()
                .putBoolean(getString(R.string.prf_eula_accepted), mEulaAccepted)
                .commit();

        showDisclaimer(false);
    }
    
	@Override
	protected void onCreate(Bundle state) 
	{
		getSupportActionBar().hide();
		super.onCreate(state);
		setContentView(R.layout.splash_home);
		
		handler = new Handler();
		mPrefs = this.getSharedPreferences( "CBTiPrefs", Context.MODE_PRIVATE);
        mEulaAccepted = mPrefs.getBoolean(getString(R.string.prf_eula_accepted), false);
        mDisclaimerAccepted = mPrefs.getBoolean(getString(R.string.prf_disclaimer_accepted), false);
        mSplashDisplayed = state != null;
		if (state == null) 
		{
            final FragmentManager fm = getSupportFragmentManager();
            final FragmentTransaction ft = fm.beginTransaction();

            if(!mSplashDisplayed)
            {
            	ft.add(R.id.launch_fragments, new LogoSplashFragment());
	            handler.postDelayed(new Runnable() 
	            {
	                @Override
					public void run() 
	                {
	                    mSplashDisplayed = true;
	                    if (!mEulaAccepted) 
	                    {
	                        showEula(false);
	                    } 
	                    else if (!mDisclaimerAccepted) 
	                    {                    	
	                        showDisclaimer(false);
	                    } 
	                    else 
	                    {
	                        showHome();
	                    }
	                }
	            }, 2500);
	        }
            else if (!mEulaAccepted) 
	        {
	            showEula(true);
	        } 
	        else if (!mDisclaimerAccepted) 
	        {
	            showDisclaimer(true);
	        } 
	        else 
	        {
	            showHome();
	            return;
	        }
            ft.commit();
		}
	}

    private void showDisclaimer(boolean initial) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();

        if (initial) {
            ft.add(R.id.launch_fragments, new WelcomeToCBTiSplashFragment());
        } else {
            ft.replace(R.id.launch_fragments, new WelcomeToCBTiSplashFragment());
        }

        ft.setTransition(initial ? FragmentTransaction.TRANSIT_FRAGMENT_OPEN : FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        getSupportActionBar().setTitle("Welcome to CPT Coach");
        getSupportActionBar().show();
    }

    private void showEula(boolean initial) {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();

        if (initial) {
            ft.add(R.id.launch_fragments, new EULASplashFragment());
        } else {
            ft.replace(R.id.launch_fragments, new EULASplashFragment());
        }

        ft.setTransition(initial ? FragmentTransaction.TRANSIT_FRAGMENT_OPEN : FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        getSupportActionBar().setTitle("End User License Agreement");
        getSupportActionBar().show();
    }

    private void showHome() {
        final Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
