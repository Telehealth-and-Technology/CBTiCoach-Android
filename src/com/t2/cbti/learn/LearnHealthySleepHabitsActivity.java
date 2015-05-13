/*
* LearnHealthySleepHabitsActivity.java
* Activity used to display information with regards to healthy sleep habits
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright � 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright � 2009-2014 Contributors. All Rights Reserved.
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
package com.t2.cbti.learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTi_BaseActivity;
import com.t2.cbti.classes.CBTi_Help;

public class LearnHealthySleepHabitsActivity extends CBTi_BaseActivity 
{
	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		setContentView(R.layout.learn_healthysleephabits);
		// middle button 1
		((Button)findViewById(R.id.bWorryinginBed)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshworryinginbed);
				i.putExtra("RID_Text",  R.string.s_learnsh_01);
				i.putExtra("RID_Title", R.string.s_learnsh_01t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 2
		((Button)findViewById(R.id.bWatchingtheClock)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshwatchingtheclock);
				i.putExtra("RID_Text",  R.string.s_learnsh_02);
				i.putExtra("RID_Title", R.string.s_learnsh_02t);
				startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 3
		((Button)findViewById(R.id.bNapping)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshnapping);
				i.putExtra("RID_Text",  R.string.s_learnsh_03);
				i.putExtra("RID_Title", R.string.s_learnsh_03t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 4
		((Button)findViewById(R.id.bWindingDown)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshwindingdown);
				i.putExtra("RID_Text",  R.string.s_learnsh_04);
				i.putExtra("RID_Title", R.string.s_learnsh_04t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 5
		((Button)findViewById(R.id.bUsingtheBedroom)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshusingthebedroom);
				i.putExtra("RID_Text",  R.string.s_learnsh_05);
				i.putExtra("RID_Title", R.string.s_learnsh_05t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 6
		((Button)findViewById(R.id.bEating)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnsheating);
				i.putExtra("RID_Text",  R.string.s_learnsh_06);
				i.putExtra("RID_Title", R.string.s_learnsh_06t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 7
		((Button)findViewById(R.id.bCaffeineUse)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshcaffeineuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_07);
				i.putExtra("RID_Title", R.string.s_learnsh_07t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 8
		((Button)findViewById(R.id.bExercise)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshexercise);
				i.putExtra("RID_Text",  R.string.s_learnsh_08);
				i.putExtra("RID_Title", R.string.s_learnsh_08t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 9
		((Button)findViewById(R.id.bAlcoholUse)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshalcoholuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_09);
				i.putExtra("RID_Title", R.string.s_learnsh_09t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 10
		((Button)findViewById(R.id.bNicotineUse)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshnicotineuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_10);
				i.putExtra("RID_Title", R.string.s_learnsh_10t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 11
		((Button)findViewById(R.id.bGettingComfortable)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(LearnHealthySleepHabitsActivity.this, CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshgettingcomfortable);
				i.putExtra("RID_Text",  R.string.s_learnsh_11);
				i.putExtra("RID_Title", R.string.s_learnsh_11t);
				LearnHealthySleepHabitsActivity.this.startActivity(i);
				LearnHealthySleepHabitsActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}
}