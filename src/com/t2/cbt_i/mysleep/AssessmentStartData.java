/*
 * AssessmentStartData.java
 * Class used to store assessment entry data
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
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;

public class AssessmentStartData
{

	public Boolean bProvider = true;
	public ArrayList<AssessmentQuestionnaireData> alISIData;

	Activity c;

	public AssessmentStartData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_31b";

	/**
	 * Saves the data to file
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

			out.writeBoolean(bProvider);
			int iSize = alISIData.size();
			out.writeInt(iSize);
			for (int i = 0; i < iSize; i++)
			{
				alISIData.get(i).writeData(out);
			}

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
		alISIData = new ArrayList<AssessmentQuestionnaireData>();
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			bProvider = in.readBoolean();
			int iNumEntry = in.readInt();
			while (iNumEntry-- > 0)
			{
				AssessmentQuestionnaireData cData31c = new AssessmentQuestionnaireData(c);
				cData31c.readData(in);
				if (cData31c.iCumScore != -1)
					alISIData.add(cData31c);
			}

			in.close();
		}
		catch (Exception e)
		{

		}
	}

//	public Boolean alreadyExists()
//	{
//		Calendar cc = Calendar.getInstance();
//		cc.set(Calendar.HOUR_OF_DAY, 0);
//		cc.set(Calendar.MINUTE, 0);
//		cc.set(Calendar.SECOND, 0);
//		cc.set(Calendar.MILLISECOND, 0);
//		return alreadyExists(cc.getTimeInMillis());
//	}
//
//	public Boolean alreadyExists(long lDateTime)
//	{
//		if (alISIData.isEmpty())
//			return false;
//		long lLastISI = alISIData.get(alISIData.size() - 1).lDate;
//		return lLastISI != lDateTime;
//	}

	/**
	 * Adds the assessment questionnaire timestamp
	 */
	public void addEntry(AssessmentQuestionnaireData cData31c)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		cData31c.lDate = c.getTimeInMillis();
		alISIData.add(cData31c);
	}

	/**
	 * Checks to see if any data entries have been entered within the last week
	 * @return True if there are entries were entered within a week
	 */
	public Boolean withinAWeek()
	{
		Boolean bRetval = false;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		int iJulian = c.get(Calendar.DAY_OF_YEAR);
		iJulian -= 7;
		c.set(Calendar.DAY_OF_YEAR, iJulian);
		long lWeekAgo = c.getTimeInMillis();
		for (int i = 0; i < alISIData.size(); i++)
		{
			if (alISIData.get(i).lDate > lWeekAgo)
			{
				bRetval = true;
				break;
			}
		}

		return bRetval;
	}

}
