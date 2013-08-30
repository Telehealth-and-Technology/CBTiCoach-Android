package com.t2.cbt_i.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.about.CBTi_Activity50a;
import com.t2.cbt_i.learn.CBTi_Activity40a;
import com.t2.cbt_i.mysleep.CBTi_Activity20a;
import com.t2.cbt_i.mysleep.CBTi_Data22a;
import com.t2.cbt_i.reminders.CBTi_Activity60a;
import com.t2.cbt_i.tools.CBTi_Activity30a;


public class DashActivity extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_info_details);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);
		((TextView)findViewById(R.id.tvTopTitle)).setText(R.string.s_Home);
						
		// topLeft Button
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {		// handle the about button
                 
            	Intent i = new Intent(DashActivity.this, CBTi_Activity50a.class );
            	DashActivity.this.startActivity(i);
            	DashActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
            }
        });
		
		// topRight Button
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button
		                 
		    	Intent i = new Intent(DashActivity.this, CBTi_Activity10f.class );
		    	DashActivity.this.startActivity(i);
		    	DashActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
		    }
		});
		
		// MySleep Button
		((Button)findViewById(R.id.b10mysleep)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button
				                 
		    	Intent i = new Intent(DashActivity.this, CBTi_Activity20a.class );
		    	DashActivity.this.startActivity(i);
		    	DashActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
		
		// Learn Button
		((Button)findViewById(R.id.b10learn)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button
						                 
		    	Intent i = new Intent(DashActivity.this, CBTi_Activity40a.class );
		    	DashActivity.this.startActivity(i);
		    	DashActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
		
		// Tools Button
		((Button)findViewById(R.id.b10tools)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button
								                 
		    	Intent i = new Intent(DashActivity.this, CBTi_Activity30a.class );
		    	DashActivity.this.startActivity(i);
		    	DashActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			    }
		});
		
		// Reminders Button
		((Button)findViewById(R.id.b10reminders)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button
							                 
		    	Intent i = new Intent(DashActivity.this, CBTi_Activity60a.class );
		    	DashActivity.this.startActivity(i);
		    	DashActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		    }
		});
	}

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
	//	// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.main, menu);
	//	return true;
	//}

	@Override
	protected void onResume() {
		super.onResume();
		
		// fetch the data and display either the sleep prescription or the msg
		CBTi_Data22a cData22a = new CBTi_Data22a( this );
		cData22a.displaySleepPrescription();
		
	}
	
	
	
}
