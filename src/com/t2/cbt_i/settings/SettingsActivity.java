/*
* SettingsActivity.java
* Activity that serves as the settings menu
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
package com.t2.cbt_i.settings;

import java.io.File;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class SettingsActivity extends CBTi_BaseActivity
{
	SettingsData cData50b;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle(getString(R.string.s_Settings));
		setContentView(R.layout.settings_main);

		// middle buttons
		((Button) findViewById(R.id.bResetData)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				new AlertDialog.Builder(SettingsActivity.this).setTitle(R.string.app_name).setIcon(R.drawable.cbti_icon)
						.setMessage(R.string.s_ResetAllUserData).setCancelable(false)
						.setPositiveButton(R.string.s_Continue, new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int id)
							{
								resetAllUserData();
							}
						})
						.setNegativeButton(R.string.s_Cancel, null)
						.create()
						.show();
			}
		});
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		SettingsActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}

	private String sSubDir = "/CBTi_Data/";

	private void resetAllUserData()
	{

		try
		{
			// open the subdirectory
			File dir = new File(getFilesDir(), sSubDir);

			if (dir.isDirectory())
			{ // delete each file in the directory
				String[] children = dir.list();
				for (int i = 0; i < children.length; i++)
				{
					new File(dir, children[i]).delete();
				}
				Toast.makeText(SettingsActivity.this, "User Data Reset", Toast.LENGTH_SHORT).show();
			}
		}
		catch (Exception e)
		{
			Toast.makeText(SettingsActivity.this, "User Data Reset Error", Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	protected void onPause()
	{
		cData50b.saveData(); // save data to file
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		cData50b = new SettingsData(this);
		super.onResume();
	}

}