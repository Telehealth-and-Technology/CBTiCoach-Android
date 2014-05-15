/*
 * AssessmentQuestionnaireData.java
 * Class to hold all of the data associated with the assessment questionnaire
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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;

import com.t2.cbt_i.R;

public class AssessmentQuestionnaireData
{

	public int iQuestion = -1;
	public Boolean b0 = false;
	public Boolean b1 = false;
	public Boolean b2 = false;
	public Boolean b3 = false;
	public Boolean b4 = false;

	public long lDate = -1;
	public int iScore[] = { -1, -1, -1, -1, -1, -1, -1 };
	public int iCumScore = -1;

	Activity c;

	public AssessmentQuestionnaireData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_31c";

	/**
	 * Saves the assessment questionnaire data to file
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
	 * Writes the data to the DataOutputStream
	 * @param out
	 */
	public void writeData(DataOutputStream out)
	{
		try
		{
			out.writeInt(iQuestion);
			out.writeBoolean(b0);
			out.writeBoolean(b1);
			out.writeBoolean(b2);
			out.writeBoolean(b3);
			out.writeBoolean(b4);
			out.writeLong(lDate);
			for (int i = 0; i < 7; i++)
				out.writeInt(iScore[i]);
			out.writeInt(iCumScore);
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Reads in the data from file
	 */
	public void loadData()
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
	 * Reads the data in from the DataInputStream
	 * @param in
	 */
	public void readData(DataInputStream in)
	{
		try
		{
			iQuestion = in.readInt();
			b0 = in.readBoolean();
			b1 = in.readBoolean();
			b2 = in.readBoolean();
			b3 = in.readBoolean();
			b4 = in.readBoolean();
			lDate = in.readLong();

			for (int i = 0; i < 7; i++)
				iScore[i] = in.readInt();
			iCumScore = in.readInt();
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * Deletes the data file
	 */
	public void deleteData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the subdirectory if it exists
			File file = new File(dir, sFilename);
			file.delete();
		}
		catch (Exception e)
		{

		}
	}

	@Override
	public String toString()
	{
		Calendar cc = Calendar.getInstance();
		cc.setTimeInMillis(lDate);
		SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy, EEEE");
		return (format.format(cc.getTime()) + "    " + c.getString(R.string.s_Score) + iCumScore);
	}

}
