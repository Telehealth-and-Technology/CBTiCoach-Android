package com.t2.cbt_i.about;

import android.os.Bundle;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class AboutProjectPartnersActivity extends CBTi_BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_projectpartners);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		AboutProjectPartnersActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}