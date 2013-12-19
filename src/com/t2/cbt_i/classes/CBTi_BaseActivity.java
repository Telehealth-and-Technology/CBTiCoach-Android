/*
* CBTi_BaseActivity.java
* Activity that serves as the base activity for every activity in CBTi and handles interacts that each activity will have to handle
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
package com.t2.cbt_i.classes;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.flurry.android.FlurryAgent;
import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.DashboardActivity;
import com.t2.cbt_i.settings.SettingsData;

public class CBTi_BaseActivity extends SherlockFragmentActivity
{
	private static Boolean bFlurryEnabled = false;

	// private static Boolean bProvideUsageData;

	@Override
	protected void onStart()
	{
		super.onStart();
		SettingsData cData50b = new SettingsData(this);
		bFlurryEnabled = cData50b.bProvideUsageData;
		if (bFlurryEnabled)
			FlurryAgent.onStartSession(this, "3WMX22DG599MF9986NDV");
	}

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_topbar));
//		getSupportActionBar().setHomeButtonEnabled(true);
//		((View)getWindow().getDecorView().findViewById(android.R.id.home).getParent().getParent()).setContentDescription(getString(R.string.blankcontentdescription));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			if (!(this instanceof DashboardActivity))
			{
				Intent intent = new Intent(this, DashboardActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
			else
			{
				((DashboardActivity) this).setPage(0);
			}
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		if (bFlurryEnabled)
			FlurryAgent.onEndSession(this);
	}

}
