package com.t2.cbt_i.mysleep;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class SleepDairyHelpActivity extends CBTi_BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_sleepdairyhelp);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		SleepDairyHelpActivity.this.overridePendingTransition(R.anim.slide_down, R.anim.slide_down2);
	}
}