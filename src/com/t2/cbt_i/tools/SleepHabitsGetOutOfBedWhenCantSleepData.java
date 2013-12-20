/*
* SleepHabitsGetOutOfBedWhenCantSleepData.java
* Class used to hold and store all data associated with get out of bed when cant sleep
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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class SleepHabitsGetOutOfBedWhenCantSleepData
{

	Boolean bCantSleep[] = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[] = { R.string.s_CantSleep01, R.string.s_CantSleep02, R.string.s_CantSleep03, R.string.s_CantSleep04, R.string.s_CantSleep05,
			R.string.s_CantSleep06, R.string.s_CantSleep07, R.string.s_CantSleep08, R.string.s_CantSleep09, R.string.s_CantSleep10, R.string.s_CantSleep11,
			R.string.s_CantSleep12, R.string.s_CantSleep13, R.string.s_CantSleep14, R.string.s_CantSleep15, R.string.s_CantSleep16, R.string.s_CantSleep17,
			R.string.s_CantSleep18, R.string.s_CantSleep19, R.string.s_CantSleep20 };

	Activity c;

	public SleepHabitsGetOutOfBedWhenCantSleepData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c1";

	public void saveData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);

			for (int i = 0; i < bCantSleep.length; i++)
				out.writeBoolean(bCantSleep[i]);
			for (int i = 0; i < iMap.length; i++)
				out.writeInt(iMap[i]);

			out.flush();
			out.close();
		}
		catch (Exception e)
		{
		}
	}

	void loadData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			for (int i = 0; i < bCantSleep.length; i++)
				bCantSleep[i] = in.readBoolean();
			for (int i = 0; i < iMap.length; i++)
				iMap[i] = in.readInt();

			in.close();
		}
		catch (Exception e)
		{

		}
	}

	public void renderData()
	{
		reOrderMap();

		((CheckBox) c.findViewById(R.id.cbCantSleep01)).setChecked(bCantSleep[iMap[0]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep02)).setChecked(bCantSleep[iMap[1]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep03)).setChecked(bCantSleep[iMap[2]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep04)).setChecked(bCantSleep[iMap[3]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep05)).setChecked(bCantSleep[iMap[4]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep06)).setChecked(bCantSleep[iMap[5]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep07)).setChecked(bCantSleep[iMap[6]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep08)).setChecked(bCantSleep[iMap[7]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep09)).setChecked(bCantSleep[iMap[8]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep10)).setChecked(bCantSleep[iMap[9]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep11)).setChecked(bCantSleep[iMap[10]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep12)).setChecked(bCantSleep[iMap[11]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep13)).setChecked(bCantSleep[iMap[12]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep14)).setChecked(bCantSleep[iMap[13]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep15)).setChecked(bCantSleep[iMap[14]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep16)).setChecked(bCantSleep[iMap[15]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep17)).setChecked(bCantSleep[iMap[16]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep18)).setChecked(bCantSleep[iMap[17]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep19)).setChecked(bCantSleep[iMap[18]]);
		((CheckBox) c.findViewById(R.id.cbCantSleep20)).setChecked(bCantSleep[iMap[19]]);

		((TextView) c.findViewById(R.id.tCantSleep01)).setText(iID[iMap[0]]);
		((TextView) c.findViewById(R.id.tCantSleep02)).setText(iID[iMap[1]]);
		((TextView) c.findViewById(R.id.tCantSleep03)).setText(iID[iMap[2]]);
		((TextView) c.findViewById(R.id.tCantSleep04)).setText(iID[iMap[3]]);
		((TextView) c.findViewById(R.id.tCantSleep05)).setText(iID[iMap[4]]);
		((TextView) c.findViewById(R.id.tCantSleep06)).setText(iID[iMap[5]]);
		((TextView) c.findViewById(R.id.tCantSleep07)).setText(iID[iMap[6]]);
		((TextView) c.findViewById(R.id.tCantSleep08)).setText(iID[iMap[7]]);
		((TextView) c.findViewById(R.id.tCantSleep09)).setText(iID[iMap[8]]);
		((TextView) c.findViewById(R.id.tCantSleep10)).setText(iID[iMap[9]]);
		((TextView) c.findViewById(R.id.tCantSleep11)).setText(iID[iMap[10]]);
		((TextView) c.findViewById(R.id.tCantSleep12)).setText(iID[iMap[11]]);
		((TextView) c.findViewById(R.id.tCantSleep13)).setText(iID[iMap[12]]);
		((TextView) c.findViewById(R.id.tCantSleep14)).setText(iID[iMap[13]]);
		((TextView) c.findViewById(R.id.tCantSleep15)).setText(iID[iMap[14]]);
		((TextView) c.findViewById(R.id.tCantSleep16)).setText(iID[iMap[15]]);
		((TextView) c.findViewById(R.id.tCantSleep17)).setText(iID[iMap[16]]);
		((TextView) c.findViewById(R.id.tCantSleep18)).setText(iID[iMap[17]]);
		((TextView) c.findViewById(R.id.tCantSleep19)).setText(iID[iMap[18]]);
		((TextView) c.findViewById(R.id.tCantSleep20)).setText(iID[iMap[19]]);
	}

	private void reOrderMap()
	{ // move checked items to top of list
		int i, j;
		for (i = 0; i < bCantSleep.length; i++)
		{
			if (bCantSleep[iMap[i]] == false)
			{ // when you find an unchecked item
				for (j = i + 1; j < bCantSleep.length; j++)
				{ // look for another checked item
					if (bCantSleep[iMap[j]])
					{ // found one
						int iHold = iMap[i];
						iMap[i] = iMap[j];
						iMap[j] = iHold;
						break;
					}
				}
			}
		}

	}

}
