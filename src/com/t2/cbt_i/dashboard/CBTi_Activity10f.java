package com.t2.cbt_i.dashboard;


import android.os.Bundle;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity10f extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_10f);
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
	
	
	
}