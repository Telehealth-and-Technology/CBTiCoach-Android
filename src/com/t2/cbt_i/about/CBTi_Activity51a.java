package com.t2.cbt_i.about;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity51a extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_51a);
	
		((TextView)findViewById(R.id.tvCBTi)).setMovementMethod(new ScrollingMovementMethod());					
	}

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity51a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}