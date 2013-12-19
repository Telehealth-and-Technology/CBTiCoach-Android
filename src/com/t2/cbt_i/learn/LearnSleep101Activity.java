/*
* LearnSleep101Activity.java
* Activity used to display common information about sleep and CBTi
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
package com.t2.cbt_i.learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class LearnSleep101Activity extends CBTi_BaseActivity
{

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.learn_sleep101);
		
		// middle button 1
		((Button) findViewById(R.id.bWhatIsCBTi)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101whatiscbti);
				i.putExtra("RID_Text", R.string.s_learn101_1);
				i.putExtra("RID_Title", R.string.s_learn101_1t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 2
		((Button) findViewById(R.id.bWhyDoWeSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101whydowesleep);
				i.putExtra("RID_Text", R.string.s_learn101_2);
				i.putExtra("RID_Title", R.string.s_learn101_2t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 3
		((Button) findViewById(R.id.bStagesOfSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101stagesofsleep);
				i.putExtra("RID_Text", R.string.s_learn101_3);
				i.putExtra("RID_Title", R.string.s_learn101_3t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 4
		((Button) findViewById(R.id.bSleepRegulators)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101sleepregulators);
				i.putExtra("RID_Text", R.string.s_learn101_4);
				i.putExtra("RID_Title", R.string.s_learn101_4t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 5
		((Button) findViewById(R.id.bSleepinessvsTiredness)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101sleepinessvstiredness);
				i.putExtra("RID_Text", R.string.s_learn101_5);
				i.putExtra("RID_Title", R.string.s_learn101_5t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 6
		((Button) findViewById(R.id.bPTSDandSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101ptsdandsleep);
				i.putExtra("RID_Text", R.string.s_learn101_6);
				i.putExtra("RID_Title", R.string.s_learn101_6t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 7
		((Button) findViewById(R.id.bNightmares)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101nightmares);
				i.putExtra("RID_Text", R.string.s_learn101_7);
				i.putExtra("RID_Title", R.string.s_learn101_7t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 8
		((Button) findViewById(R.id.bWeaponsandSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101weaponsandsleep);
				i.putExtra("RID_Text", R.string.s_learn101_8);
				i.putExtra("RID_Title", R.string.s_learn101_8t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 9
		((Button) findViewById(R.id.bDepressionandSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101depressionandsleep);
				i.putExtra("RID_Text", R.string.s_learn101_9);
				i.putExtra("RID_Title", R.string.s_learn101_9t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 10
		((Button) findViewById(R.id.bSleepApnea)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101sleepapnea);
				i.putExtra("RID_Text", R.string.s_learn101_10);
				i.putExtra("RID_Title", R.string.s_learn101_10t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// middle button 11
		((Button) findViewById(R.id.bMedications)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(LearnSleep101Activity.this, CBTi_Help.class);
				i.putExtra("RID_Img", R.drawable.buddy_learn101medications);
				i.putExtra("RID_Text", R.string.s_learn101_11);
				i.putExtra("RID_Title", R.string.s_learn101_11t);
				LearnSleep101Activity.this.startActivity(i);
				LearnSleep101Activity.this.overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}
}