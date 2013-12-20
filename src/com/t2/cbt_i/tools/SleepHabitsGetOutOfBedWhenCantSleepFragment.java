/*
* SleepHabitsGetOutOfBedWhenCantSleepFragment.java
* Fragment used to display all of the activities to do when you can sleep and need to get out of bed
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
package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class SleepHabitsGetOutOfBedWhenCantSleepFragment extends CBTi_BaseFragment
{

	SleepHabitsGetOutOfBedWhenCantSleepData cData34c1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitsgetoutofbedwhencantsleep, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_GetoutofBedWhenyoucantSleep));
		setHasOptionsMenu(true);

		cData34c1 = new SleepHabitsGetOutOfBedWhenCantSleepData(getSherlockActivity());

		((CheckBox) getView().findViewById(R.id.cbCantSleep01)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep02)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep03)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep04)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep05)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep06)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep07)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep08)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep09)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep10)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep11)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep12)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep13)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep14)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep15)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep16)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep17)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep18)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep19)).setOnClickListener(CantSleepOCL);
		((CheckBox) getView().findViewById(R.id.cbCantSleep20)).setOnClickListener(CantSleepOCL);
	}

	// On click listener for button1
	final OnClickListener CantSleepOCL = new OnClickListener()
	{
		@Override
		public void onClick(final View v)
		{

			Boolean bState = false;
			int id = v.getId();
			int iButton = 0;

			int iStart = 0;
			if (id == R.id.llCantSleep01 || id == R.id.cbCantSleep01)
			{
				iStart = 0;
				iButton = R.id.cbCantSleep01;
			}
			else if (id == R.id.llCantSleep02 || id == R.id.cbCantSleep02)
			{
				iStart = 1;
				iButton = R.id.cbCantSleep02;
			}
			else if (id == R.id.llCantSleep03 || id == R.id.cbCantSleep03)
			{
				iStart = 2;
				iButton = R.id.cbCantSleep03;
			}
			else if (id == R.id.llCantSleep04 || id == R.id.cbCantSleep04)
			{
				iStart = 3;
				iButton = R.id.cbCantSleep04;
			}
			else if (id == R.id.llCantSleep05 || id == R.id.cbCantSleep05)
			{
				iStart = 4;
				iButton = R.id.cbCantSleep05;
			}
			else if (id == R.id.llCantSleep06 || id == R.id.cbCantSleep06)
			{
				iStart = 5;
				iButton = R.id.cbCantSleep06;
			}
			else if (id == R.id.llCantSleep07 || id == R.id.cbCantSleep07)
			{
				iStart = 6;
				iButton = R.id.cbCantSleep07;
			}
			else if (id == R.id.llCantSleep08 || id == R.id.cbCantSleep08)
			{
				iStart = 7;
				iButton = R.id.cbCantSleep08;
			}
			else if (id == R.id.llCantSleep09 || id == R.id.cbCantSleep09)
			{
				iStart = 8;
				iButton = R.id.cbCantSleep09;
			}
			else if (id == R.id.llCantSleep10 || id == R.id.cbCantSleep10)
			{
				iStart = 9;
				iButton = R.id.cbCantSleep10;
			}
			else if (id == R.id.llCantSleep11 || id == R.id.cbCantSleep11)
			{
				iStart = 10;
				iButton = R.id.cbCantSleep11;
			}
			else if (id == R.id.llCantSleep12 || id == R.id.cbCantSleep12)
			{
				iStart = 11;
				iButton = R.id.cbCantSleep12;
			}
			else if (id == R.id.llCantSleep13 || id == R.id.cbCantSleep13)
			{
				iStart = 12;
				iButton = R.id.cbCantSleep13;
			}
			else if (id == R.id.llCantSleep14 || id == R.id.cbCantSleep14)
			{
				iStart = 13;
				iButton = R.id.cbCantSleep14;
			}
			else if (id == R.id.llCantSleep15 || id == R.id.cbCantSleep15)
			{
				iStart = 14;
				iButton = R.id.cbCantSleep15;
			}
			else if (id == R.id.llCantSleep16 || id == R.id.cbCantSleep16)
			{
				iStart = 15;
				iButton = R.id.cbCantSleep16;
			}
			else if (id == R.id.llCantSleep17 || id == R.id.cbCantSleep17)
			{
				iStart = 16;
				iButton = R.id.cbCantSleep17;
			}
			else if (id == R.id.llCantSleep18 || id == R.id.cbCantSleep18)
			{
				iStart = 17;
				iButton = R.id.cbCantSleep18;
			}
			else if (id == R.id.llCantSleep19 || id == R.id.cbCantSleep19)
			{
				iStart = 18;
				iButton = R.id.cbCantSleep19;
			}
			else if (id == R.id.llCantSleep20 || id == R.id.cbCantSleep20)
			{
				iStart = 19;
				iButton = R.id.cbCantSleep20;
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
			// scrape new state to data store
			cData34c1.bCantSleep[cData34c1.iMap[iStart]] = bState;

//			if (bState)
//			{ // if checked then place at top
//				if (iStart > 0)
//				{
//					int iHold = cData34c1.iMap[iStart];
//					for (; iStart > 0; iStart--)
//						cData34c1.iMap[iStart] = cData34c1.iMap[iStart - 1];
//					cData34c1.iMap[0] = iHold;
//				}
//			}
//			cData34c1.renderData();
		}
	};

	@Override
	public void onResume()
	{
		cData34c1 = new SleepHabitsGetOutOfBedWhenCantSleepData(getSherlockActivity());
		cData34c1.renderData();
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData34c1.saveData();
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsgetoutofbedwhenyoucantsleep);
		i.putExtra("RID_Text", R.string.s_34e1);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
