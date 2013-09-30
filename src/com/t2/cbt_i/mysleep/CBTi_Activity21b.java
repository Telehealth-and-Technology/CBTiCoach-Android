package com.t2.cbt_i.mysleep;


import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity21b extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_21b);
	}




	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity21b.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
}