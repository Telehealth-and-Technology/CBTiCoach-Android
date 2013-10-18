package com.t2.cbt_i.tools;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class PreventInsomniaActivity extends CBTi_BaseActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_preventinsomnia);
		final FragmentManager fm = getSupportFragmentManager();
		final FragmentTransaction ft = fm.beginTransaction();
		if(fm.getBackStackEntryCount() == 0)
		{
			ft.replace(R.id.preventinsomniafragment, new PreventInsomniaFragment());
			ft.commit();
		}

	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		PreventInsomniaActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}
