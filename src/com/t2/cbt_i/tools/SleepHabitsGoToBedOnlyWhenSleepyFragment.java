/*
* SleepHabitsGoToBedOnlyWhenSleepyFragment.java
* Fragment used to display all of the activities to do in order to get sleepy so you can go to bed
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

import android.annotation.SuppressLint;
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

public class SleepHabitsGoToBedOnlyWhenSleepyFragment extends CBTi_BaseFragment
{
	SleepHabitsGoToBedOnlyWhenSleepyData cData34c;

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_GotoBedOnlyWhenSleepy));
		setHasOptionsMenu(true);

		((CheckBox) getView().findViewById(R.id.cbAwake01)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake02)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake03)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake04)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake05)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake06)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake07)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake08)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake09)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake10)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake11)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake12)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake13)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake14)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake15)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake16)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake17)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake18)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake19)).setOnClickListener(awakeOCL);
		((CheckBox) getView().findViewById(R.id.cbAwake20)).setOnClickListener(awakeOCL);
	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitsgotobedonlywhensleepy, null);
	}

	// On click listener for button1
	final OnClickListener awakeOCL = new OnClickListener()
	{
		@Override
		public void onClick(final View v)
		{
			Boolean bState = false;
			int id = v.getId();
			int iButton = 0;

			int iStart = 0;
			if (id == R.id.llAwake01 || id == R.id.cbAwake01)
			{
				iStart = 0;
				iButton = R.id.cbAwake01;
			}
			else if (id == R.id.llAwake02 || id == R.id.cbAwake02)
			{
				iStart = 1;
				iButton = R.id.cbAwake02;
			}
			else if (id == R.id.llAwake03 || id == R.id.cbAwake03)
			{
				iStart = 2;
				iButton = R.id.cbAwake03;
			}
			else if (id == R.id.llAwake04 || id == R.id.cbAwake04)
			{
				iStart = 3;
				iButton = R.id.cbAwake04;
			}
			else if (id == R.id.llAwake05 || id == R.id.cbAwake05)
			{
				iStart = 4;
				iButton = R.id.cbAwake05;
			}
			else if (id == R.id.llAwake06 || id == R.id.cbAwake06)
			{
				iStart = 5;
				iButton = R.id.cbAwake06;
			}
			else if (id == R.id.llAwake07 || id == R.id.cbAwake07)
			{
				iStart = 6;
				iButton = R.id.cbAwake07;
			}
			else if (id == R.id.llAwake08 || id == R.id.cbAwake08)
			{
				iStart = 7;
				iButton = R.id.cbAwake08;
			}
			else if (id == R.id.llAwake09 || id == R.id.cbAwake09)
			{
				iStart = 8;
				iButton = R.id.cbAwake09;
			}
			else if (id == R.id.llAwake10 || id == R.id.cbAwake10)
			{
				iStart = 9;
				iButton = R.id.cbAwake10;
			}
			else if (id == R.id.llAwake11 || id == R.id.cbAwake11)
			{
				iStart = 10;
				iButton = R.id.cbAwake11;
			}
			else if (id == R.id.llAwake12 || id == R.id.cbAwake12)
			{
				iStart = 11;
				iButton = R.id.cbAwake12;
			}
			else if (id == R.id.llAwake13 || id == R.id.cbAwake13)
			{
				iStart = 12;
				iButton = R.id.cbAwake13;
			}
			else if (id == R.id.llAwake14 || id == R.id.cbAwake14)
			{
				iStart = 13;
				iButton = R.id.cbAwake14;
			}
			else if (id == R.id.llAwake15 || id == R.id.cbAwake15)
			{
				iStart = 14;
				iButton = R.id.cbAwake15;
			}
			else if (id == R.id.llAwake16 || id == R.id.cbAwake16)
			{
				iStart = 15;
				iButton = R.id.cbAwake16;
			}
			else if (id == R.id.llAwake17 || id == R.id.cbAwake17)
			{
				iStart = 16;
				iButton = R.id.cbAwake17;
			}
			else if (id == R.id.llAwake18 || id == R.id.cbAwake18)
			{
				iStart = 17;
				iButton = R.id.cbAwake18;
			}
			else if (id == R.id.llAwake19 || id == R.id.cbAwake19)
			{
				iStart = 18;
				iButton = R.id.cbAwake19;
			}
			else if (id == R.id.llAwake20 || id == R.id.cbAwake20)
			{
				iStart = 19;
				iButton = R.id.cbAwake20;
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
			cData34c.bAwake[cData34c.iMap[iStart]] = bState;

//			if (bState)
//			{ // if checked then place at top
//				if (iStart > 0)
//				{
//					int iHold = cData34c.iMap[iStart];
//					for (; iStart > 0; iStart--)
//						cData34c.iMap[iStart] = cData34c.iMap[iStart - 1];
//					cData34c.iMap[0] = iHold;
//				}
//			}
//			cData34c.renderData();
		}
	};

	@Override
	public void onResume()
	{
		cData34c = new SleepHabitsGoToBedOnlyWhenSleepyData(getSherlockActivity());
		cData34c.renderData();
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData34c.saveData();
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsgotobedonlywhensleepy);
		i.putExtra("RID_Text", R.string.s_34e);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
