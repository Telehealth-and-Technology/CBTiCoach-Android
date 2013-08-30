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


public class CBTi_Activity41a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_41a);

		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Sleep101 );
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility( View.INVISIBLE );
		
		// top left HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	finish();		// make sure we close the splash screen so the user won't come back when it presses back key
            	Intent i = new Intent(getApplicationContext(), DashActivity.class );
            	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	startActivity(i);
            	CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
            }
        }); 
		
		// middle button 1
		((Button)findViewById(R.id.bWhatIsCBTi)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101whatiscbti);
				i.putExtra("RID_Text",  R.string.s_learn101_1);
				i.putExtra("RID_Title", R.string.s_learn101_1t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 2
		((Button)findViewById(R.id.bWhyDoWeSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101whydowesleep);
				i.putExtra("RID_Text",  R.string.s_learn101_2);
				i.putExtra("RID_Title", R.string.s_learn101_2t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 3
		((Button)findViewById(R.id.bStagesOfSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101stagesofsleep);
				i.putExtra("RID_Text",  R.string.s_learn101_3);
				i.putExtra("RID_Title", R.string.s_learn101_3t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// middle button 4
		((Button)findViewById(R.id.bSleepRegulators)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101sleepregulators);
				i.putExtra("RID_Text",  R.string.s_learn101_4);
				i.putExtra("RID_Title", R.string.s_learn101_4t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 5
		((Button)findViewById(R.id.bSleepinessvsTiredness)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101sleepinessvstiredness);
				i.putExtra("RID_Text",  R.string.s_learn101_5);
				i.putExtra("RID_Title", R.string.s_learn101_5t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 6
		((Button)findViewById(R.id.bPTSDandSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img", R.drawable.buddy_learn101ptsdandsleep);
				i.putExtra("RID_Text",  R.string.s_learn101_6);
				i.putExtra("RID_Title", R.string.s_learn101_6t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 7
		((Button)findViewById(R.id.bNightmares)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101nightmares);
				i.putExtra("RID_Text",  R.string.s_learn101_7);
				i.putExtra("RID_Title", R.string.s_learn101_7t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 8
		((Button)findViewById(R.id.bWeaponsandSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101weaponsandsleep);
				i.putExtra("RID_Text",  R.string.s_learn101_8);
				i.putExtra("RID_Title", R.string.s_learn101_8t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 9
		((Button)findViewById(R.id.bDepressionandSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101depressionandsleep);
				i.putExtra("RID_Text",  R.string.s_learn101_9);
				i.putExtra("RID_Title", R.string.s_learn101_9t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 10
		((Button)findViewById(R.id.bSleepApnea)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101sleepapnea);
				i.putExtra("RID_Text",  R.string.s_learn101_10);
				i.putExtra("RID_Title", R.string.s_learn101_10t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 

		// middle button 11
		((Button)findViewById(R.id.bMedications)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",   R.drawable.buddy_learn101medications);
				i.putExtra("RID_Text",  R.string.s_learn101_11);
				i.putExtra("RID_Title", R.string.s_learn101_11t);
				startActivity(i);
				CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}

	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity41a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}