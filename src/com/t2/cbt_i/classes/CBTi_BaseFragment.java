/*
* CBTi_BaseFragment.java
* Fragment that serves as the base fragment for each fragment in CBTi and handles interacts that each fragment will have to handle
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
import android.text.TextUtils;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.t2.cbt_i.R;
import com.t2.cbt_i.about.AboutMainActivity;
import com.t2.cbt_i.dashboard.DashboardFragment;
import com.t2.cbt_i.settings.SettingsActivity;

public abstract class CBTi_BaseFragment extends SherlockFragment
{
	protected String previousActionbarTitle = "";
	protected boolean goingToHelp = false;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		ActionBar bar = getSherlockActivity().getSupportActionBar();
		previousActionbarTitle = TextUtils.isEmpty(bar.getTitle()) ? "" : bar.getTitle().toString();
	}
	
	@Override
	public void onStart()
	{
		super.onStart();
		if(goingToHelp)
		{
			goingToHelp = false;
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.dashboard_menu, menu);
		if(!(this instanceof DashboardFragment))
		{
			menu.findItem(R.id.menu_about).setVisible(false);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent;
		switch (item.getItemId())
		{
		case R.id.menu_help:
			getHelp();
			break;
		case R.id.menu_about:
			intent = new Intent(getSherlockActivity(), AboutMainActivity.class);
			startActivity(intent);
			break;
		case R.id.menu_settings:
			intent = new Intent(getSherlockActivity(), SettingsActivity.class);
			startActivity(intent);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}

	@Override
	public void onPause()
	{
		super.onPause();
		int TabCount = getSherlockActivity().getSupportActionBar().getTabCount();
		if(!TextUtils.isEmpty(previousActionbarTitle) &&  TabCount == 0 && !goingToHelp)
		{
			getSherlockActivity().getSupportActionBar().setTitle(previousActionbarTitle);
		}
	}

	public abstract void getHelp();
}
