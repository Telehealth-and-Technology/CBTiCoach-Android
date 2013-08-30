package com.t2.cbt_i.dashboard;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;


public class CBTi_Activity10f extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_10f);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setVisibility( View.INVISIBLE );
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Help);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility( View.INVISIBLE );
	}


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity10f.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
}