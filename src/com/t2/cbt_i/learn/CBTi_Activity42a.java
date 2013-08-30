package com.t2.cbt_i.learn;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity42a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_42a);
		
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_HealthySleepHabits );
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility( View.INVISIBLE );
	
		// top left HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	finish();		// make sure we close the splash screen so the user won't come back when it presses back key
            	Intent i = new Intent(getApplicationContext(), DashActivity.class );
            	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	startActivity(i);
            	CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
            }
        }); 
		
		// middle button 1
		((Button)findViewById(R.id.bWorryinginBed)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshworryinginbed);
				i.putExtra("RID_Text",  R.string.s_learnsh_01);
				i.putExtra("RID_Title", R.string.s_learnsh_01t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 2
		((Button)findViewById(R.id.bWatchingtheClock)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshwatchingtheclock);
				i.putExtra("RID_Text",  R.string.s_learnsh_02);
				i.putExtra("RID_Title", R.string.s_learnsh_02t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 3
		((Button)findViewById(R.id.bNapping)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshnapping);
				i.putExtra("RID_Text",  R.string.s_learnsh_03);
				i.putExtra("RID_Title", R.string.s_learnsh_03t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 4
		((Button)findViewById(R.id.bWindingDown)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshwindingdown);
				i.putExtra("RID_Text",  R.string.s_learnsh_04);
				i.putExtra("RID_Title", R.string.s_learnsh_04t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 5
		((Button)findViewById(R.id.bUsingtheBedroom)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshusingthebedroom);
				i.putExtra("RID_Text",  R.string.s_learnsh_05);
				i.putExtra("RID_Title", R.string.s_learnsh_05t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 6
		((Button)findViewById(R.id.bEating)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnsheating);
				i.putExtra("RID_Text",  R.string.s_learnsh_06);
				i.putExtra("RID_Title", R.string.s_learnsh_06t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 7
		((Button)findViewById(R.id.bCaffeineUse)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshcaffeineuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_07);
				i.putExtra("RID_Title", R.string.s_learnsh_07t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 8
		((Button)findViewById(R.id.bExercise)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshexercise);
				i.putExtra("RID_Text",  R.string.s_learnsh_08);
				i.putExtra("RID_Title", R.string.s_learnsh_08t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 9
		((Button)findViewById(R.id.bAlcoholUse)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshalcoholuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_09);
				i.putExtra("RID_Title", R.string.s_learnsh_09t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 10
		((Button)findViewById(R.id.bNicotineUse)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshnicotineuse);
				i.putExtra("RID_Text",  R.string.s_learnsh_10);
				i.putExtra("RID_Title", R.string.s_learnsh_10t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 11
		((Button)findViewById(R.id.bGettingComfortable)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learnshgettingcomfortable);
				i.putExtra("RID_Text",  R.string.s_learnsh_11);
				i.putExtra("RID_Title", R.string.s_learnsh_11t);
				startActivity(i);
				CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}

	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity42a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}