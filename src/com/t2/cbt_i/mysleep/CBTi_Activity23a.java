package com.t2.cbt_i.mysleep;


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


public class CBTi_Activity23a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_23a);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText(R.string.s_NeedSleep);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity23a.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity23a.this.startActivity(i);
				CBTi_Activity23a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity23a.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_mysleepineedmoresleep);
				i.putExtra("RID_Text", R.string.s_23b);
				CBTi_Activity23a.this.startActivity(i);
				CBTi_Activity23a.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		// Start Questionnaire Button
		((Button)findViewById(R.id.bStartQuestionaire)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				CBTi_Data23c cData23c = new CBTi_Data23c(CBTi_Activity23a.this);
				cData23c.deleteData();
				Intent i = new Intent(CBTi_Activity23a.this, CBTi_Activity23c.class );
				CBTi_Activity23a.this.startActivity(i);
				CBTi_Activity23a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}

	
	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity23a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}