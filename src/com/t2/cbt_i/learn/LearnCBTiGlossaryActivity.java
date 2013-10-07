package com.t2.cbt_i.learn;


import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class LearnCBTiGlossaryActivity extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_cbtiglossary);
	}

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		LearnCBTiGlossaryActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}