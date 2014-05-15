/*
 * SleepDiaryData.java
 * Class used to store all of the Sleep Diary entries
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

public class SleepDiaryData
{
	int iPastWeek = 0;
	int iTIBWeeklymin = -1; // these are in minutes
	int iTSTWeeklymin = -1; // these are in minutes
	int iSEWeekly = -1;

	ArrayList<SleepDiaryEntryData> alSleepDiary;

	Activity c;

	public SleepDiaryData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_21a";

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

			reorderSleepDiaries();

			int iSize = alSleepDiary.size();
			out.writeInt(iSize);

			for (int i = 0; i < iSize; i++)
			{
				SleepDiaryEntryData cObj = alSleepDiary.get(i); // grab the next object and serialize it
				cObj.writeData(out);
			}

			out.flush();
			out.close();
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Loads data from file
	 */
	void loadData()
	{
		alSleepDiary = new ArrayList<SleepDiaryEntryData>();
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			// iPastWeek = in.readInt();

			int iNumEntry = in.readInt();
			while (iNumEntry-- > 0)
			{
				alSleepDiary.add(new SleepDiaryEntryData(c, in));
			}

			updatePastWeek();

			in.close();
		}
		catch (Exception e)
		{

		}
	}

	/**
	 * Updates iTIBWeeklymin, iTSTWeeklymin and iSEWeekly based off the last week
	 */
	private void updatePastWeek()
	{
		Calendar cc = Calendar.getInstance();
		int iJulianDay = cc.get(Calendar.DAY_OF_YEAR); // Julian today
		int iMinDay = iJulianDay - 6; // Julian 7 days ago (Base)
		Boolean[] bWeek = { false, false, false, false, false, false, false };
		// 1 for each of last 7 days
		for (int ii = 0; ii < 7; ii++)
		{ // one week is the max
			if (ii < alSleepDiary.size())
			{
				cc.setTimeInMillis((alSleepDiary.get(ii)).lSDETime);
				if (cc.get(Calendar.DAY_OF_YEAR) >= iMinDay)
				{ // if entry part of current week
					bWeek[cc.get(Calendar.DAY_OF_WEEK) - 1] = true;
					iTIBWeeklymin += alSleepDiary.get(ii).iTIBDailymin;
					iTSTWeeklymin += alSleepDiary.get(ii).iTSTDailymin;
					iSEWeekly += alSleepDiary.get(ii).iSEDaily;
				}
			}
			else
				break;
		}
		iPastWeek = 0; // update the counter
		for (int ii = 0; ii < 7; ii++)
			if (bWeek[ii])
				iPastWeek++;

		if (iPastWeek > 0)
		{
			iTIBWeeklymin /= iPastWeek;
			iTSTWeeklymin /= iPastWeek;
			iSEWeekly /= iPastWeek;
			if (iSEWeekly < 0 || iSEWeekly > 100)
				iSEWeekly = -1;
		}
	}

	/**
	 * Sorts the sleep diaries based off of SDE time
	 */
	private void reorderSleepDiaries()
	{
		ArrayList<SleepDiaryEntryData> alSleepDiaryNew = new ArrayList<SleepDiaryEntryData>();
		int iIndexOfNewest;

		int iLen = alSleepDiary.size();
		for (int ii = 0; ii < iLen; ii++)
		{
			iIndexOfNewest = 0;
			for (int i = 1; i < alSleepDiary.size(); i++)
			{ // go through the rest looking for newest
				if (alSleepDiary.get(i).lSDETime > alSleepDiary.get(iIndexOfNewest).lSDETime)
				{
					iIndexOfNewest = i;
				}
			}
			alSleepDiaryNew.add(alSleepDiary.get(iIndexOfNewest));
			alSleepDiary.remove(iIndexOfNewest);
		}
		alSleepDiary = alSleepDiaryNew;
	}

	/**
	 * Checks to see if the date time already exists
	 * @param lDateTime
	 * @return True if it does
	 */
	public Boolean alreadyExists(long lDateTime)
	{
		for (int i = 0; i < alSleepDiary.size(); i++)
			if ((alSleepDiary.get(i)).lSDETime == lDateTime)
				return true;
		return false;
	}

}
