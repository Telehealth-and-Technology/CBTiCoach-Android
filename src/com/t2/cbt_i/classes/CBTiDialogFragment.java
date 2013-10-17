package com.t2.cbt_i.classes;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.actionbarsherlock.app.SherlockDialogFragment;

public class CBTiDialogFragment extends SherlockDialogFragment
{
	private int iTime = 0;
	private int iHour = 0;
	private int iMinute = 0;
	private boolean convertTime = false;
	private TimePickerDialog.OnTimeSetListener listener;
	
	public void showDialog(int time, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		convertTime = true;
		listener = l;
		iTime = time;
		this.show(manager, "dialog");
	}
	public void showDialog(int hour, int min, TimePickerDialog.OnTimeSetListener l, FragmentManager manager)
	{
		listener = l;
		iHour = hour;
		iMinute = min;
		this.show(manager, "dialog");
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		if(convertTime)
			return new TimePickerDialog(getSherlockActivity(), listener, iTime / 60, iTime % 60, false);
		else
			return new TimePickerDialog(getSherlockActivity(), listener, iHour, iMinute, false);
	}
}
