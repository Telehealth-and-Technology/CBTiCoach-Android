/*
* CBTiDialogFragment.java
* DialogFragment used to control how the Date/Time picker dialogs appear within CBTi
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
package com.t2.cbt_i.classes;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.actionbarsherlock.app.SherlockDialogFragment;

public class CBTiDialogFragment extends SherlockDialogFragment
{
	private String title = "";
	private int iTime = 0;
	private int iHour = 0;
	private int iMinute = 0;
	private int iDay = 0;
	private int iMonth = 0;
	private int iYear = 0;
	private boolean convertTime = false;
	private boolean writeTitle = false;
	private boolean showDateDialog = false;
	private boolean is24hour = false;
	private TimePickerDialog.OnTimeSetListener tListener;
	private DatePickerDialog.OnDateSetListener dListener;

	/**
	 * Shows a time dialog with the given time
	 * @param time
	 * @param l
	 * @param manager
	 */
	public void showTimeDialog(int time, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		convertTime = true;
		tListener = l;
		iTime = time;
		this.show(manager, "dialog");
	}

	/**
	 * Shows a time dialog with the given hour and minute
	 * @param hour
	 * @param min
	 * @param l
	 * @param manager
	 */
	public void showTimeDialog(int hour, int min, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		tListener = l;
		iHour = hour;
		iMinute = min;
		this.show(manager, "dialog");
	}

	/**
	 * Shows a time dialog with the given time and title
	 * @param title
	 * @param time
	 * @param l
	 * @param manager
	 */
	public void showTimeDialogWithTitle(String title, int time, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		convertTime = true;
		writeTitle = true;
		this.title = title;
		tListener = l;
		iTime = time;
		this.show(manager, "dialog");
	}

	/**
	 * Shows a time dialog with the given hour and minute and title
	 * @param title
	 * @param hour
	 * @param min
	 * @param l
	 * @param manager
	 */
	public void showTimeDialogWithTitle(String title, int hour, int min, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		writeTitle = true;
		this.title = title;
		tListener = l;
		iHour = hour;
		iMinute = min;
		this.show(manager, "dialog");
	}

	/**
	 * Shows a date dialog with the given year, month, and day
	 * @param year
	 * @param month
	 * @param day
	 * @param l
	 * @param manager
	 */
	public void showDateDialog(int year, int month, int day, OnDateSetListener l, FragmentManager manager)
	{
		showDateDialog = true;
		dListener = l;
		iYear = year;
		iMonth = month;
		iDay = day;
		this.show(manager, "dialog");
	}

	/**
	 * Sets 24hourMode to the given boolean value
	 * @param isEnabled
	 */
	public void set24hourMode(boolean isEnabled)
	{
		is24hour = isEnabled;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		if (showDateDialog)
		{
			return new DatePickerDialog(getSherlockActivity(), dListener, iYear, iMonth, iDay);
		}
		else
		{
			TimePickerDialog tia;

			if (writeTitle)
			{
				if (convertTime)
					tia = new CBTi_TimePickerDialog(getSherlockActivity(), tListener, iTime / 60, iTime % 60, is24hour);
				else
					tia = new CBTi_TimePickerDialog(getSherlockActivity(), tListener, iHour, iMinute, is24hour);
				tia.setTitle(title);
			}
			else
			{
				if (convertTime)
					tia = new TimePickerDialog(getSherlockActivity(), tListener, iTime / 60, iTime % 60, is24hour);
				else
					tia = new TimePickerDialog(getSherlockActivity(), tListener, iHour, iMinute, is24hour);
			}

			return tia;
		}
	}
}
