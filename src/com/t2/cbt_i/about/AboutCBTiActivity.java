package com.t2.cbt_i.about;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class AboutCBTiActivity extends CBTi_BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_cbti);

		((TextView) findViewById(R.id.tvCBTi)).setMovementMethod(new ScrollingMovementMethod());
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		AboutCBTiActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}