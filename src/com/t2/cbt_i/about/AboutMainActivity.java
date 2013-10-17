package com.t2.cbt_i.about;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class AboutMainActivity extends CBTi_BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_main);

		getSupportActionBar().setTitle("About");

	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		AboutMainActivity.this.overridePendingTransition(R.anim.slide_down, R.anim.slide_down2);
	}
}