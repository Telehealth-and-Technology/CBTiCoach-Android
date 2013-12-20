/*
* QuiteMindWindingDownData.java
* Class used to store and hold all data associated with the winding down fragment
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

public class QuiteMindWindingDownData
{

	Boolean bWind[] = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
	int iID[] = { R.string.s_Wind01, R.string.s_Wind02, R.string.s_Wind03, R.string.s_Wind04, R.string.s_Wind05, R.string.s_Wind06, R.string.s_Wind07,
			R.string.s_Wind08, R.string.s_Wind09, R.string.s_Wind10, R.string.s_Wind11, R.string.s_Wind12, R.string.s_Wind13, R.string.s_Wind14,
			R.string.s_Wind15, R.string.s_Wind16, R.string.s_Wind17, R.string.s_Wind18, R.string.s_Wind19, R.string.s_Wind20, R.string.s_Wind21,
			R.string.s_Wind22 };

	Activity c;

	public QuiteMindWindingDownData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_35a1";

	public void saveData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if  it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);

			for (int i = 0; i < bWind.length; i++)
				out.writeBoolean(bWind[i]);
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
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			for (int i = 0; i < bWind.length; i++)
				bWind[i] = in.readBoolean();
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

		((CheckBox) c.findViewById(R.id.cbWind01)).setChecked(bWind[iMap[0]]);
		((CheckBox) c.findViewById(R.id.cbWind02)).setChecked(bWind[iMap[1]]);
		((CheckBox) c.findViewById(R.id.cbWind03)).setChecked(bWind[iMap[2]]);
		((CheckBox) c.findViewById(R.id.cbWind04)).setChecked(bWind[iMap[3]]);
		((CheckBox) c.findViewById(R.id.cbWind05)).setChecked(bWind[iMap[4]]);
		((CheckBox) c.findViewById(R.id.cbWind06)).setChecked(bWind[iMap[5]]);
		((CheckBox) c.findViewById(R.id.cbWind07)).setChecked(bWind[iMap[6]]);
		((CheckBox) c.findViewById(R.id.cbWind08)).setChecked(bWind[iMap[7]]);
		((CheckBox) c.findViewById(R.id.cbWind09)).setChecked(bWind[iMap[8]]);
		((CheckBox) c.findViewById(R.id.cbWind10)).setChecked(bWind[iMap[9]]);
		((CheckBox) c.findViewById(R.id.cbWind11)).setChecked(bWind[iMap[10]]);
		((CheckBox) c.findViewById(R.id.cbWind12)).setChecked(bWind[iMap[11]]);
		((CheckBox) c.findViewById(R.id.cbWind13)).setChecked(bWind[iMap[12]]);
		((CheckBox) c.findViewById(R.id.cbWind14)).setChecked(bWind[iMap[13]]);
		((CheckBox) c.findViewById(R.id.cbWind15)).setChecked(bWind[iMap[14]]);
		((CheckBox) c.findViewById(R.id.cbWind16)).setChecked(bWind[iMap[15]]);
		((CheckBox) c.findViewById(R.id.cbWind17)).setChecked(bWind[iMap[16]]);
		((CheckBox) c.findViewById(R.id.cbWind18)).setChecked(bWind[iMap[17]]);
		((CheckBox) c.findViewById(R.id.cbWind19)).setChecked(bWind[iMap[18]]);
		((CheckBox) c.findViewById(R.id.cbWind20)).setChecked(bWind[iMap[19]]);
		((CheckBox) c.findViewById(R.id.cbWind21)).setChecked(bWind[iMap[20]]);
		((CheckBox) c.findViewById(R.id.cbWind22)).setChecked(bWind[iMap[21]]);

		((TextView) c.findViewById(R.id.tWind01)).setText(iID[iMap[0]]);
		((TextView) c.findViewById(R.id.tWind02)).setText(iID[iMap[1]]);
		((TextView) c.findViewById(R.id.tWind03)).setText(iID[iMap[2]]);
		((TextView) c.findViewById(R.id.tWind04)).setText(iID[iMap[3]]);
		((TextView) c.findViewById(R.id.tWind05)).setText(iID[iMap[4]]);
		((TextView) c.findViewById(R.id.tWind06)).setText(iID[iMap[5]]);
		((TextView) c.findViewById(R.id.tWind07)).setText(iID[iMap[6]]);
		((TextView) c.findViewById(R.id.tWind08)).setText(iID[iMap[7]]);
		((TextView) c.findViewById(R.id.tWind09)).setText(iID[iMap[8]]);
		((TextView) c.findViewById(R.id.tWind10)).setText(iID[iMap[9]]);
		((TextView) c.findViewById(R.id.tWind11)).setText(iID[iMap[10]]);
		((TextView) c.findViewById(R.id.tWind12)).setText(iID[iMap[11]]);
		((TextView) c.findViewById(R.id.tWind13)).setText(iID[iMap[12]]);
		((TextView) c.findViewById(R.id.tWind14)).setText(iID[iMap[13]]);
		((TextView) c.findViewById(R.id.tWind15)).setText(iID[iMap[14]]);
		((TextView) c.findViewById(R.id.tWind16)).setText(iID[iMap[15]]);
		((TextView) c.findViewById(R.id.tWind17)).setText(iID[iMap[16]]);
		((TextView) c.findViewById(R.id.tWind18)).setText(iID[iMap[17]]);
		((TextView) c.findViewById(R.id.tWind19)).setText(iID[iMap[18]]);
		((TextView) c.findViewById(R.id.tWind20)).setText(iID[iMap[19]]);
		((TextView) c.findViewById(R.id.tWind21)).setText(iID[iMap[20]]);
		((TextView) c.findViewById(R.id.tWind22)).setText(iID[iMap[21]]);

	}

	private void reOrderMap()
	{ // move checked items to top of list
		int i, j;
		for (i = 0; i < bWind.length; i++)
		{
			if (bWind[iMap[i]] == false)
			{ // when you find an unchecked item
				for (j = i + 1; j < bWind.length; j++)
				{ // look for another checked item
					if (bWind[iMap[j]])
					{ // found one and swap
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
