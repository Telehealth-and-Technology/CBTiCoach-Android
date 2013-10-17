package com.t2.cbt_i.mysleep;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class UpdateSleepPrescriptionActivity extends CBTi_BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_updatesleepprescription);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}