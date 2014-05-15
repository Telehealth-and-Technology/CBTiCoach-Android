/*
* RemindersData.java
* Class used to store all the data associated with reminders
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright © 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright © 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
package com.t2.cbt_i.reminders;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.t2.cbt_i.R;
import com.t2.cbt_i.mysleep.UpdateSleepPrescriptionData;

public class RemindersData
{

	public final long[] INTERVALS = { 1000 * 60 * 60 * 24 * 7, // weekly
			1000 * 60 * 60 * 24 * 7 * 2, // every other week
			1000 * 60 * 60 * 24 * 7 * 4, // monthly
			1000 * 60 * 60 * 24 * 7 * 4 * 3, // every three months
			0, // never
			1000 * 60 * 60 * 24 // daily
	};

	public long WEEKLY = INTERVALS[0];
	public long BIWEEKLY = INTERVALS[1];
	public long MONTHLY = INTERVALS[2];
	public long MONTHLY3 = INTERVALS[2];
	public long NEVER = INTERVALS[4];
	public long DAILY = INTERVALS[5];

	public Boolean bSleepDiaryReminder = false;
	public int iSDRmin = 1200;

	public Boolean bWindDownTimeReminder = false;
	public int iWDTmin = 180;

	public Boolean bPrescribedBedTimeReminder = false;

	public Boolean bPrescribedWakeTimeReminder = false;;

	public Boolean bUpdateSleepPrescriptionReminder = false;
	public int iUSPDayofWeek = 1;
	public int iUSPmin = 0;

	public Boolean bTakeAssessmentReminder = false;
	public int iTADayofWeek = 1;
	public int iTARepeat = 0;
	public int iTAmin = 1080;

	public Boolean bStopCaffeineReminder = false;
	public int iSCmin = 0;

	public Boolean bWorryTimeReminder = false;
	public int iWTDayofWeek = 1;
	public int iWTmin = 0;

	private Context c;

	public RemindersData(Context c)
	{
		this.c = c;
		loadData();
	}

	/**
	 * Calculates the time to 4pm from the given time
	 * @param iTime
	 * @return
	 */
	public int timeTo4pm(int iTime)
	{ // we store the times as based off 4pm 24 hour clock
		int iHour = iTime / 60 - 16; // so we can compare them
		if (iHour < 0)
			iHour += 24;
		return (iHour * 60) + (iTime % 60);
	}

	/**
	 * Calculates the time from 4pm to the given time
	 * @param iTime
	 * @return
	 */
	public int timeFrom4pm(int iTime)
	{ // this will translate them for display
		int iHour = (iTime / 60) + 16;
		if (iHour > 24)
			iHour -= 24;
		return (iHour * 60) + (iTime % 60);
	}

	/**
	 * Formats the time from 4pm using the given time into a string
	 * @param iTime
	 * @return Formatted string
	 */
	public String formattedTimeFrom4pm(int iTime)
	{
		if (iTime == -1)
		{
			Activity a = (Activity) c;
			return a.getString(R.string.s_NoData);
		}
		else
		{
			iTime = timeFrom4pm(iTime);
			int iHour = iTime / 60;
			String sAMPM = ((iTime / 60 >= 12) ? "PM" : "AM");
			;
			if (iHour > 12)
				iHour -= 12;
			return (String.format("%d:%02d %s", iHour, iTime % 60, sAMPM));
		}
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_60a";

	/**
	 * Saves the data to file
	 */
	public void saveData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);

			out.writeBoolean(bSleepDiaryReminder);
			out.writeInt(iSDRmin);

			out.writeBoolean(bWindDownTimeReminder);
			out.writeInt(iWDTmin);

			out.writeBoolean(bPrescribedBedTimeReminder);

			out.writeBoolean(bPrescribedWakeTimeReminder);

			out.writeBoolean(bUpdateSleepPrescriptionReminder);
			out.writeInt(iUSPDayofWeek);
			out.writeInt(iUSPmin);

			out.writeBoolean(bTakeAssessmentReminder);
			out.writeInt(iTADayofWeek);
			out.writeInt(iTARepeat);
			out.writeInt(iTAmin);

			out.writeBoolean(bStopCaffeineReminder);
			out.writeInt(iSCmin);

			out.writeBoolean(bWorryTimeReminder);
			out.writeInt(iWTDayofWeek);
			out.writeInt(iWTmin);

			out.flush();
			out.close();
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Loads data from file
	 */
	void loadData()
	{
		resetData();
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			bSleepDiaryReminder = in.readBoolean();
			iSDRmin = in.readInt();

			bWindDownTimeReminder = in.readBoolean();
			iWDTmin = in.readInt();

			bPrescribedBedTimeReminder = in.readBoolean();

			bPrescribedWakeTimeReminder = in.readBoolean();

			bUpdateSleepPrescriptionReminder = in.readBoolean();
			iUSPDayofWeek = in.readInt();
			iUSPmin = in.readInt();

			bTakeAssessmentReminder = in.readBoolean();
			iTADayofWeek = in.readInt();
			iTARepeat = in.readInt();
			iTAmin = in.readInt();

			bStopCaffeineReminder = in.readBoolean();
			iSCmin = in.readInt();

			bWorryTimeReminder = in.readBoolean();
			iWTDayofWeek = in.readInt();
			iWTmin = in.readInt();

			in.close();
		}
		catch (Exception e)
		{

		}
	}

	/**
	 * Resets all data to default values
	 */
	public void resetData()
	{
		UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData(c);

		bSleepDiaryReminder = false;
		iSDRmin = 1200; // 12pm

		bWindDownTimeReminder = false;
		iWDTmin = cData22a.iSP_PBTimemin;
		if (cData22a.iSP_PBTimemin != -1)
			iWDTmin -= 30;
		else
			iWDTmin = 180;

		bPrescribedBedTimeReminder = false;

		bPrescribedWakeTimeReminder = false;

		bUpdateSleepPrescriptionReminder = false;
		iUSPDayofWeek = 1;
		iUSPmin = 0; // 10am

		bTakeAssessmentReminder = false;
		iTADayofWeek = 1;
		iTARepeat = 0;
		iTAmin = 1080; // 10am

		bStopCaffeineReminder = false;
		iSCmin = cData22a.iSP_PBTimemin;
		if (cData22a.iSP_PBTimemin != -1)
			iSCmin = cData22a.iSP_PBTimemin - 120;
		else
			iSCmin = 0;

		bWorryTimeReminder = false;
		iWTDayofWeek = 1;
		iWTmin = 0;
	}

	/**
	 * Creates and registers an alarm given the time, days and interval
	 * @param iTimemin
	 * @param cClass
	 * @param lInterval
	 * @param iDayOfWeek
	 */
	private void setAlarm2(int iTimemin, Class<?> cClass, long lInterval, int iDayOfWeek)
	{
		if ((iTimemin != -1) && (lInterval != NEVER))
		{
			iTimemin = timeFrom4pm(iTimemin);
			int iHour24 = iTimemin / 60;
			int iMin = iTimemin % 60;
			AlarmManager am = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(c, 0, new Intent(c, cClass), 0);
			Calendar ccTGT = Calendar.getInstance(); // set unchecked target
														// time
			ccTGT.set(Calendar.DAY_OF_WEEK, iDayOfWeek + 1);
			ccTGT.set(Calendar.HOUR_OF_DAY, iHour24);
			ccTGT.set(Calendar.MINUTE, iMin);

			if (ccTGT.getTimeInMillis() < System.currentTimeMillis())
			{
				int iDays = 0; // how many days to skip ahead

				if (lInterval == DAILY) // now tweak the target based on the
										// interval
					iDays = 1;
				else if (lInterval == WEEKLY) // now tweak the target based on
												// the interval
					iDays = 7;
				else if (lInterval == BIWEEKLY) // now tweak the target based on
												// the interval
					iDays = 14;
				else if (lInterval == MONTHLY) // now tweak the target based on
												// the interval
					iDays = 30;
				else if (lInterval == MONTHLY3) // now tweak the target based on
												// the interval
					iDays = 90;
				ccTGT.set(Calendar.DAY_OF_YEAR, ccTGT.get(Calendar.DAY_OF_YEAR) + iDays);
			}

			am.cancel(pendingIntent); // get rid of any old alarms for this
										// intent
			am.setRepeating(AlarmManager.RTC_WAKEUP, ccTGT.getTimeInMillis(), lInterval, pendingIntent);
			// Toast.makeText(c, String.format(
			// "CBTi-Coach Alarms Configured - %2d-%2d-%2d  %2d:%2d  %d",
			// ccTGT.get(Calendar.MONTH)+1, ccTGT.get(Calendar.DAY_OF_MONTH),
			// ccTGT.get(Calendar.YEAR),
			// ccTGT.get(Calendar.HOUR), ccTGT.get(Calendar.MINUTE),
			// ccTGT.get(Calendar.DAY_OF_WEEK)), Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * Creates and registers an alarm given the time and interval
	 * @param iTimemin
	 * @param cClass
	 * @param lInterval
	 */
	private void setAlarm(int iTimemin, Class<?> cClass, long lInterval)
	{
		if (iTimemin != -1)
		{
			iTimemin = timeFrom4pm(iTimemin);
			int iHour24 = iTimemin / 60;
			int iMin = iTimemin % 60;
			AlarmManager am = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(c, 0, new Intent(c, cClass), 0);
			Calendar calendar = Calendar.getInstance();
			int iCurTime = calendar.get(Calendar.HOUR_OF_DAY) * 100 + calendar.get(Calendar.MINUTE);
			int iTgtTime = iHour24 * 100 + iMin;
			if (iTgtTime <= iCurTime) // if time has passed set for tomorrow to
										// start
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
			calendar.set(Calendar.HOUR_OF_DAY, iHour24);
			calendar.set(Calendar.MINUTE, iMin);
			am.cancel(pendingIntent); // get rid of any old alarms for this
										// intent
			if (lInterval != NEVER)
			{
				am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), lInterval, pendingIntent);
				// Toast.makeText(c, String.format(
				// "CBTi-Coach Alarms Configured - %2d-%2d-%2d  %2d:%2d  %d",
				// calendar.get(Calendar.MONTH)+1,
				// calendar.get(Calendar.DAY_OF_MONTH),
				// calendar.get(Calendar.YEAR),
				// calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),
				// calendar.get(Calendar.DAY_OF_WEEK)),
				// Toast.LENGTH_LONG).show();
			}
		}
	}

	/**
	 * Unregisters an alarm
	 * @param i
	 */
	private void cancelAlarm(Intent i)
	{
		AlarmManager am = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(c, 0, i, 0);
		am.cancel(pendingIntent); // get rid of any old alarms for this intent
	}

	/**
	 * Alarm enum
	 * @author braden.catlett
	 *
	 */
	public enum ALARMS
	{
		SleepDiary, WindDownTime, PrescribedBedTime, PrescribedWakeTime, UpdateSleepPrescription, TakeAssessment, StopCaffeine, WorryTime
	}

	/**
	 * Cancels an alarm according to the given enum value
	 * @param alarmCode
	 */
	public void cancelAnAlarm(ALARMS alarmCode)
	{

		switch (alarmCode)
		{
		case SleepDiary:
			cancelAlarm(new Intent(c, Reminders_BR_SleepDiary.class));
			break;

		case WindDownTime:
			cancelAlarm(new Intent(c, Reminders_BR_WindDown.class));
			break;

		case PrescribedBedTime:
			cancelAlarm(new Intent(c, Reminders_BR_PrescribedBedTime.class));
			break;

		case PrescribedWakeTime:
			cancelAlarm(new Intent(c, Reminders_BR_PrescribedWakeTime.class));
			break;

		case UpdateSleepPrescription:
			cancelAlarm(new Intent(c, Reminders_BR_UpdateSleepPrescription.class));
			break;

		case TakeAssessment:
			cancelAlarm(new Intent(c, Reminders_BR_TakeAssessment.class));
			break;

		case StopCaffeine:
			cancelAlarm(new Intent(c, Reminders_BR_StopCaffeine.class));
			break;

		case WorryTime:
			cancelAlarm(new Intent(c, Reminders_BR_WorryTime.class));
			break;
		}
	}

	/**
	 * Cancels all alarms
	 */
	public void cancelAllAlarms()
	{
		cancelAnAlarm(ALARMS.SleepDiary);
		cancelAnAlarm(ALARMS.WindDownTime);
		cancelAnAlarm(ALARMS.PrescribedBedTime);
		cancelAnAlarm(ALARMS.PrescribedWakeTime);
		cancelAnAlarm(ALARMS.UpdateSleepPrescription);
		cancelAnAlarm(ALARMS.TakeAssessment);
		cancelAnAlarm(ALARMS.StopCaffeine);
		cancelAnAlarm(ALARMS.WorryTime);
	}

	/**
	 * Sets all alarms
	 */
	public void setAllAlarms()
	{

		if (bSleepDiaryReminder)
			setAnAlarm(ALARMS.SleepDiary);
		if (bWindDownTimeReminder)
			setAnAlarm(ALARMS.WindDownTime);
		if (bPrescribedBedTimeReminder)
			setAnAlarm(ALARMS.PrescribedBedTime);
		if (bPrescribedWakeTimeReminder)
			setAnAlarm(ALARMS.PrescribedWakeTime);
		if (bUpdateSleepPrescriptionReminder)
			setAnAlarm(ALARMS.UpdateSleepPrescription);
		if (bTakeAssessmentReminder)
			setAnAlarm(ALARMS.TakeAssessment);
		if (bStopCaffeineReminder)
			setAnAlarm(ALARMS.StopCaffeine);
		if (bWorryTimeReminder)
			setAnAlarm(ALARMS.WorryTime);
	}

	/**
	 * Sets an alarm according to the given enum value
	 * @param alarmCode
	 */
	public void setAnAlarm(ALARMS alarmCode)
	{
		switch (alarmCode)
		{

		case SleepDiary:
			setAlarm(iSDRmin, Reminders_BR_SleepDiary.class, DAILY);
			break;

		case WindDownTime:
			setAlarm(iWDTmin, Reminders_BR_WindDown.class, DAILY);
			break;

		case PrescribedBedTime:
			UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData(c);
			setAlarm(cData22a.iSP_PBTimemin, Reminders_BR_PrescribedBedTime.class, DAILY);
			break;

		case PrescribedWakeTime:
			cData22a = new UpdateSleepPrescriptionData(c);
			setAlarm(cData22a.iSP_PWTimemin, Reminders_BR_PrescribedWakeTime.class, DAILY);
			break;

		case UpdateSleepPrescription:
			setAlarm2(iUSPmin, Reminders_BR_UpdateSleepPrescription.class, WEEKLY, iUSPDayofWeek);
			break;

		case TakeAssessment:
			setAlarm2(iTAmin, Reminders_BR_TakeAssessment.class, INTERVALS[iTARepeat], iTADayofWeek);
			break;

		case StopCaffeine:
			setAlarm(iSCmin, Reminders_BR_StopCaffeine.class, DAILY);
			break;

		case WorryTime:
			setAlarm2(iWTmin, Reminders_BR_WorryTime.class, WEEKLY, iWTDayofWeek);
			break;
		}
	}
}
