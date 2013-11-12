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

	public void showTimeDialog(int time, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		convertTime = true;
		tListener = l;
		iTime = time;
		this.show(manager, "dialog");
	}

	public void showTimeDialog(int hour, int min, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		tListener = l;
		iHour = hour;
		iMinute = min;
		this.show(manager, "dialog");
	}

	public void showTimeDialogWithTitle(String title, int time, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		convertTime = true;
		writeTitle = true;
		this.title = title;
		tListener = l;
		iTime = time;
		this.show(manager, "dialog");
	}

	public void showTimeDialogWithTitle(String title, int hour, int min, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		writeTitle = true;
		this.title = title;
		tListener = l;
		iHour = hour;
		iMinute = min;
		this.show(manager, "dialog");
	}

	public void showDateDialog(int year, int month, int day, OnDateSetListener l, FragmentManager manager)
	{
		showDateDialog = true;
		dListener = l;
		iYear = year;
		iMonth = month;
		iDay = day;
		this.show(manager, "dialog");
	}

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
