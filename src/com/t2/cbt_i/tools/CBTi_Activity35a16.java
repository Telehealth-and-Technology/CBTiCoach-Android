package com.t2.cbt_i.tools;

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

public class CBTi_Activity35a16 extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35a16);

		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_bodyscan);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity35a16.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity35a16.this.startActivity(i);
				CBTi_Activity35a16.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity35a16.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolsobservesensationsbodyscan);
				i.putExtra("RID_Text", R.string.s_35a16help);
				CBTi_Activity35a16.this.startActivity(i);
				CBTi_Activity35a16.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bAudioGuided)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a16.this, CBTi_Activity35a26.class );
				i.putExtra("RID", R.id.bAudioGuided);
				CBTi_Activity35a16.this.startActivity(i);
				CBTi_Activity35a16.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// middle buttons
		((Button)findViewById(R.id.bSelfGuided)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button

				Intent i = new Intent(CBTi_Activity35a16.this, CBTi_Activity35a26.class );
				i.putExtra("RID", R.id.bSelfGuided);
				CBTi_Activity35a16.this.startActivity(i);
				CBTi_Activity35a16.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}	
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity35a16.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}
