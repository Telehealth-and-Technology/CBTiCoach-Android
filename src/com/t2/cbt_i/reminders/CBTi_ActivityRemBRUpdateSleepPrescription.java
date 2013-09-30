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
import com.t2.cbt_i.mysleep.CBTi_Activity22a;


public class CBTi_ActivityRemBRUpdateSleepPrescription extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		WakeLocker.acquire(context);
		CharSequence cMsg = context.getResources().getString(R.string.s_UpdateSleepPrescription);
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		
		Intent iTgt = new Intent(context, CBTi_Activity22a.class);	// prepare target intent
		iTgt.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pIntent = PendingIntent.getActivity(context, 0, iTgt, 0);
		Notification noti = new NotificationCompat.Builder(context) 		// notification, no extra actions
			.setContentTitle(cMsg)
        	.setContentText("Launch CBT-i")
        	.setSmallIcon(R.drawable.cbti_icon)
        	.setSound(alarmSound)
        	.setContentIntent(pIntent)
        	.build(); 
		noti.flags |= Notification.FLAG_AUTO_CANCEL;	// Hide the notification after its selected

		((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(7706, noti); 
	}

}