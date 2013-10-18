package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;

public class AssessmentMainActivity extends CBTi_BaseActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mysleep_assessmentmain);
		final FragmentManager fm = getSupportFragmentManager();
	    final FragmentTransaction ft = fm.beginTransaction();
	    if(fm.getBackStackEntryCount() == 0)
	    {
	    	ft.replace(R.id.assessmentfragment, new AssessmentMainFragment());
		    ft.commit();
	    }
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		AssessmentMainActivity.this.overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
	}
}
