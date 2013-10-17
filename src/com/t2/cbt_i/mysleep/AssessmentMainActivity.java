package com.t2.cbt_i.mysleep;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class AssessmentMainActivity extends CBTi_BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentmain);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		AssessmentMainActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}
