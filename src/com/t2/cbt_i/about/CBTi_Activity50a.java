package com.t2.cbt_i.about;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity50a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_50a);
	
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
		((TextView)findViewById(R.id.tvTopTitle)).setText(R.string.s_About);
						
		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {		// handle the about button
                 
            	Intent i = new Intent(CBTi_Activity50a.this, DashActivity.class );
            	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	CBTi_Activity50a.this.startActivity(i);
            	CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
            }
        });
		
		// mid Button CBTi Coach
		((Button)findViewById(R.id.bCBTi)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity51a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// mid Button Project Team
		((Button)findViewById(R.id.bPTS)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity52a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Project Partners
		((Button)findViewById(R.id.bPP)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity53a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Settings
		((Button)findViewById(R.id.bSettings)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity50b.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}