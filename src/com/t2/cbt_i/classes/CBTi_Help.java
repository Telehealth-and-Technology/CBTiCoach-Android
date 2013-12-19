/*
* CBTi_Help.java
* Activity used to display help information
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

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class CBTi_Help extends CBTi_BaseActivity
{
	int iText, iImg, iTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_help);

		Bundle b = getIntent().getExtras();

		if ((iText = b.getInt("RID_Text")) != 0)
		{
			((TextView) findViewById(R.id.tvHelp)).setText(iText);
		}

		if ((iImg = b.getInt("RID_Img")) != 0)
			((ImageView) findViewById(R.id.ivHelp)).setImageResource(iImg);

		if ((iTitle = b.getInt("RID_Title")) != 0)
			getSupportActionBar().setTitle(iTitle);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		CBTi_Help.this.overridePendingTransition(R.anim.slide_down, R.anim.slide_down2);
	}
}