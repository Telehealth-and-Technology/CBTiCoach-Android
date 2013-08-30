package com.t2.cbt_i.dashboard;

import android.app.Activity;
//import com.flurry.android.FlurryAgent;

public class CBTi_BaseActivity extends Activity{
	//private static Boolean bFlurryEnabled = false;

	//private static Boolean bProvideUsageData;
	@Override
	protected void onStart() {
		super.onStart();
		//CBTi_Data50b cData50b = new CBTi_Data50b( this );
		//bFlurryEnabled = cData50b.bProvideUsageData;
		//if(bFlurryEnabled) 
		//	FlurryAgent.onStartSession(this, "3WMX22DG599MF9986NDV");
	}
	 
	@Override
	protected void onStop() {
		super.onStop();		
		//if(bFlurryEnabled)
		//	FlurryAgent.onEndSession(this);
	}


}
