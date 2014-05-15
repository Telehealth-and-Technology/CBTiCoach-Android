/*
 * INeedMoreSleepQuestionnaireResultData
 * Class used to store the results data of a INeedMoreSleep questionnaire
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
package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;

public class INeedMoreSleepQuestionnaireResultData
{
	public long lQuestionaireDate = 0;
	public Boolean bAdd15 = false;
	public Boolean bAdd30 = false;
	public int iScore = -1;

	Activity c;

	public INeedMoreSleepQuestionnaireResultData(Activity c)
	{ // build an object from disk if possible
		this.c = c;
		loadData();
	}

	public INeedMoreSleepQuestionnaireResultData(Activity c, DataInputStream dis)
	{
		this.c = c;
		try
		{
			readData(dis);
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Reads data from the DataInputStream
	 * @param dis
	 * @throws IOException
	 */
	private void readData(DataInputStream dis) throws IOException
	{
		lQuestionaireDate = dis.readLong();
		bAdd15 = dis.readBoolean();
		bAdd30 = dis.readBoolean();
		iScore = dis.readInt();

	}

	/**
	 * Writes data to the DataOutputStream
	 * @param dos
	 * @throws IOException
	 */
	public void writeData(DataOutputStream dos) throws IOException
	{
		dos.writeLong(lQuestionaireDate);
		dos.writeBoolean(bAdd15);
		dos.writeBoolean(bAdd30);
		dos.writeInt(iScore);
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_23a";

	/**
	 * Saves data to file
	 */
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
			writeData(out);

			out.flush();
			out.close();
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Loads the data from file
	 */
	void loadData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			readData(in);
			in.close();
		}
		catch (Exception e)
		{

		}
	}

	/**
	 * Checks if an entry was made within the last 7 days
	 * @return True if one was made within 7 days
	 */
	public Boolean inLastWeek()
	{ // see if entry made in last 7 days
		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY, 0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		int iJulianDay = cc.get(Calendar.DAY_OF_YEAR); // Julian today
		cc.set(Calendar.DAY_OF_YEAR, iJulianDay - 6); // Julian 7 days ago (Base)
		long lMinDate = cc.getTimeInMillis(); // if before this older tna a week

		if (lQuestionaireDate == 0)
			return false;
		return lQuestionaireDate >= lMinDate;
	}
}
