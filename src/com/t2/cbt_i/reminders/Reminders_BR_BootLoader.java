package com.t2.cbt_i.reminders;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class Reminders_BR_BootLoader extends BroadcastReceiver {

	RemindersData cData60a=null;
	// Boot intent action name
	private static final String BOOT_ACTION_NAME = "android.intent.action.BOOT_COMPLETED";


	@Override
	public void onReceive(Context c, Intent intent) {

		if (BOOT_ACTION_NAME.equals(intent.getAction())) {
			if( cData60a == null ) {
				cData60a = new RemindersData(c);
				cData60a.setAllAlarms();
			}
		}

	}

}