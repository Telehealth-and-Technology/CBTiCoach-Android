package com.t2.cbt_i.classes;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

public class CBTi_TimePickerDialog extends TimePickerDialog
{

	public CBTi_TimePickerDialog(Context context, OnTimeSetListener callBack, int hourOfDay, int minute, boolean is24HourView)
	{
		super(context, callBack, hourOfDay, minute, is24HourView);
	}

	@Override
	public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
	{
		//Commented out to prevent the title from being overwritten
		//super.onTimeChanged(view, hourOfDay, minute);
	}

}
