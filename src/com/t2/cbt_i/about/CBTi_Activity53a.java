package com.t2.cbt_i.about;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity53a extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_53a);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity53a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}