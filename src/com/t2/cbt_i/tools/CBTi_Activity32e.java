package com.t2.cbt_i.tools;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;

public class CBTi_Activity32e extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31a);

		((ImageButton)findViewById(R.id.ibTopLeft)).setVisibility(View.INVISIBLE);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_Assessment);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
	}	
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity32e.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}
