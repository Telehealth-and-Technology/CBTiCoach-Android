package com.t2.cbt_i.reminders;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.t2.cbt_i.R;


public class CBTi_ActivityRemBRWindDown extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		WakeLocker.acquire(context);
		CharSequence cMsg = context.getResources().getString(R.string.s_remWindDown);
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		Notification noti = new NotificationCompat.Builder(context) 		// notification, no extra actions
			.setContentTitle(cMsg)
			.setContentIntent(PendingIntent.getActivity(context,0,new Intent(),Intent.FLAG_ACTIVITY_NEW_TASK))
			.setSmallIcon(R.drawable.cbti_icon)
			.setSound(alarmSound)
			.build(); 
		noti.flags |= Notification.FLAG_AUTO_CANCEL;	// Hide the notification after its selected

		((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(7707, noti); 
	}

}