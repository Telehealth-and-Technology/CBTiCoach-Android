/*
 * QuiteMindWindingDownFragment.java
 * Fragment used to display all of the winding down activities along with highlighting the ones the user has chosen
 *
 * Created by Brad Catlett on 10/21/13.
 *
 * CBT-i Coach
 *
 * Copyright � 2009-2014 United States Government as represented by
 * the Chief Information Officer of the National Center for Telehealth
 * and Technology. All Rights Reserved.
 *
 * Copyright � 2009-2014 Contributors. All Rights Reserved.
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
package com.t2.cbti.tools;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTiDialogFragment;
import com.t2.cbti.classes.CBTi_BaseFragment;
import com.t2.cbti.classes.CBTi_Help;
import com.t2.cbti.reminders.RemindersData;
import com.t2.cbti.reminders.Reminders_BR_WindDown;
import com.t2.cbti.reminders.RemindersData.ALARMS;

public class QuiteMindWindingDownFragment extends CBTi_BaseFragment
{
	QuiteMindWindingDownData cData35a1;
	RemindersData cData60a;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindwindingdown, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_WindingDown));
		setHasOptionsMenu(true);

		// Wind Down Time Reminder Toggle Button
		((Button) getView().findViewById(R.id.bWindDownTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				cData60a.bWindDownTimeReminder = ((ToggleButton) getView().findViewById(R.id.bWindDownTimeReminder)).isChecked();
				if (!cData60a.bWindDownTimeReminder)
				{
					((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.INVISIBLE);
				}
				else
				{
					((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
				}
			}
		});

		// Wind Down Time Reminder Time Picker
		((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				iNextClass = Reminders_BR_WindDown.class;
				showDialog(TIME_DIALOG_ID);
			}
		});

		((CheckBox) getView().findViewById(R.id.cbWind01)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind02)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind03)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind04)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind05)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind06)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind07)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind08)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind09)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind10)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind11)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind12)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind13)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind14)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind15)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind16)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind17)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind18)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind19)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind20)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind21)).setOnClickListener(WindOCL);
		((CheckBox) getView().findViewById(R.id.cbWind22)).setOnClickListener(WindOCL);
	}

	// On click listener for button1
	/**
	 * Toggled the checkbox state and records the change
	 */
	final OnClickListener WindOCL = new OnClickListener()
	{
		@Override
		public void onClick(final View v)
		{

			Boolean bState = false;
			int id = v.getId();
			int iButton = 0;

			int iStart = 0;
			if (id == R.id.llWind01 || id == R.id.cbWind01)
			{
				iStart = 0;
				iButton = R.id.cbWind01;
			}
			else if (id == R.id.llWind02 || id == R.id.cbWind02)
			{
				iStart = 1;
				iButton = R.id.cbWind02;
			}
			else if (id == R.id.llWind03 || id == R.id.cbWind03)
			{
				iStart = 2;
				iButton = R.id.cbWind03;
			}
			else if (id == R.id.llWind04 || id == R.id.cbWind04)
			{
				iStart = 3;
				iButton = R.id.cbWind04;
			}
			else if (id == R.id.llWind05 || id == R.id.cbWind05)
			{
				iStart = 4;
				iButton = R.id.cbWind05;
			}
			else if (id == R.id.llWind06 || id == R.id.cbWind06)
			{
				iStart = 5;
				iButton = R.id.cbWind06;
			}
			else if (id == R.id.llWind07 || id == R.id.cbWind07)
			{
				iStart = 6;
				iButton = R.id.cbWind07;
			}
			else if (id == R.id.llWind08 || id == R.id.cbWind08)
			{
				iStart = 7;
				iButton = R.id.cbWind08;
			}
			else if (id == R.id.llWind09 || id == R.id.cbWind09)
			{
				iStart = 8;
				iButton = R.id.cbWind09;
			}
			else if (id == R.id.llWind10 || id == R.id.cbWind10)
			{
				iStart = 9;
				iButton = R.id.cbWind10;
			}
			else if (id == R.id.llWind11 || id == R.id.cbWind11)
			{
				iStart = 10;
				iButton = R.id.cbWind11;
			}
			else if (id == R.id.llWind12 || id == R.id.cbWind12)
			{
				iStart = 11;
				iButton = R.id.cbWind12;
			}
			else if (id == R.id.llWind13 || id == R.id.cbWind13)
			{
				iStart = 12;
				iButton = R.id.cbWind13;
			}
			else if (id == R.id.llWind14 || id == R.id.cbWind14)
			{
				iStart = 13;
				iButton = R.id.cbWind14;
			}
			else if (id == R.id.llWind15 || id == R.id.cbWind15)
			{
				iStart = 14;
				iButton = R.id.cbWind15;
			}
			else if (id == R.id.llWind16 || id == R.id.cbWind16)
			{
				iStart = 15;
				iButton = R.id.cbWind16;
			}
			else if (id == R.id.llWind17 || id == R.id.cbWind17)
			{
				iStart = 16;
				iButton = R.id.cbWind17;
			}
			else if (id == R.id.llWind18 || id == R.id.cbWind18)
			{
				iStart = 17;
				iButton = R.id.cbWind18;
			}
			else if (id == R.id.llWind19 || id == R.id.cbWind19)
			{
				iStart = 18;
				iButton = R.id.cbWind19;
			}
			else if (id == R.id.llWind20 || id == R.id.cbWind20)
			{
				iStart = 19;
				iButton = R.id.cbWind20;
			}
			else if (id == R.id.llWind21 || id == R.id.cbWind21)
			{
				iStart = 20;
				iButton = R.id.cbWind21;
			}
			else if (id == R.id.llWind22 || id == R.id.cbWind22)
			{
				iStart = 21;
				iButton = R.id.cbWind22;
			}

			if (v.getClass().getSimpleName().equalsIgnoreCase("LinearLayout"))
			{
				bState = !((CheckBox) getView().findViewById(iButton)).isChecked();
				((CheckBox) getView().findViewById(iButton)).setChecked(bState);
			}
			else
			{
				if (v.isSelected())
					v.setSelected(false);
				else
					v.setSelected(true);
				bState = ((CheckBox) getView().findViewById(iButton)).isChecked();
			}
			cData35a1.bWind[cData35a1.iMap[iStart]] = bState; // scrape new state to data store

			// if (bState)
			// { // if checked then re order display
			// if (iStart > 0)
			// {
			// int iHold = cData35a1.iMap[iStart];
			// for (; iStart > 0; iStart--)
			// cData35a1.iMap[iStart] = cData35a1.iMap[iStart - 1];
			// cData35a1.iMap[0] = iHold;
			// }
			// }
			// cData35a1.renderData();
		}
	};

	@Override
	public void onResume()
	{
		cData35a1 = new QuiteMindWindingDownData(getSherlockActivity());
		cData35a1.renderData();

		cData60a = new RemindersData(getSherlockActivity());
		cData60a.cancelAnAlarm(ALARMS.WindDownTime);
		// wind down time reminder
		((ToggleButton) getView().findViewById(R.id.bWindDownTimeReminder)).setChecked(cData60a.bWindDownTimeReminder);
		((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWDTmin));
		if (!cData60a.bWindDownTimeReminder)
		{
			((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.INVISIBLE);
		}
		else
		{
			((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setVisibility(View.VISIBLE);
			int time = cData60a.timeFrom4pm(cData60a.iWDTmin);
			iInitialHourOfDay = time / 60;
			iInitialMin = time % 60;
		}
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData35a1.saveData();
		cData60a.saveData();
		cData60a.setAnAlarm(ALARMS.WindDownTime);
		super.onPause();
	}

	static final int TIME_DIALOG_ID = 1;
	int iPicker; // used to figure what to do with picked time
	int iInitialHourOfDay; // if zero we default to current time
	int iInitialMin;

	/**
	 * Creates and shows a dialog given the id
	 * 
	 * @param id
	 * @return
	 */
	private void showDialog(int id)
	{
		switch (id)
		{
		case TIME_DIALOG_ID:
			CBTiDialogFragment dia = new CBTiDialogFragment();
			if (iInitialHourOfDay == 0)
			{
				Calendar onscene = Calendar.getInstance();
				iInitialHourOfDay = onscene.get(Calendar.HOUR_OF_DAY);
				iInitialMin = onscene.get(Calendar.MINUTE);
			}
			dia.showTimeDialog(iInitialHourOfDay, iInitialMin, mTimeSetListener, getFragmentManager());
			// return new TimePickerDialog(getSherlockActivity(), mTimeSetListener, iInitialHourOfDay, iInitialMin, false);
		}
	}

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			if (iNextClass == Reminders_BR_WindDown.class)
			{
				cData60a.iWDTmin = cData60a.timeTo4pm((hourOfDay * 60) + minute);
				((Button) getView().findViewById(R.id.tWindDownTimeReminder)).setText(cData60a.formattedTimeFrom4pm(cData60a.iWDTmin));
			}

		}
	};

	private Class<Reminders_BR_WindDown> iNextClass; // tells the alarm where to wake up

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolshelpwindingdown);
		i.putExtra("RID_Text", R.string.s_35e1);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
