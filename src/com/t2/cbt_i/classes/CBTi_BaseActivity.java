package com.t2.cbt_i.classes;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.flurry.android.FlurryAgent;
import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.DashboardActivity;
import com.t2.cbt_i.settings.SettingsData;

public class CBTi_BaseActivity extends SherlockFragmentActivity
{
	private static Boolean bFlurryEnabled = false;

//	private static Boolean bProvideUsageData;

	@Override
	protected void onStart()
	{
		super.onStart();
		SettingsData cData50b = new SettingsData(this);
		bFlurryEnabled = cData50b.bProvideUsageData;
		if (bFlurryEnabled)
			FlurryAgent.onStartSession(this, "3WMX22DG599MF9986NDV");
	}

	@Override
	protected void onCreate(Bundle arg0)
	{
		super.onCreate(arg0);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_topbar));
		getSupportActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case android.R.id.home:
			if (!(this instanceof DashboardActivity))
			{
				Intent intent = new Intent(this, DashboardActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
			else
			{
				((DashboardActivity) this).setPage(0);
			}
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		if (bFlurryEnabled)
			FlurryAgent.onEndSession(this);
	}

}
