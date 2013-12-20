/*
* SplashActivity.java
* Activity used to manage each of the Splash fragments.
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright © 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright © 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
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
    }

    private void showHome() {
        final Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
