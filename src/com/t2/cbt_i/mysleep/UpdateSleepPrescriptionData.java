/*
 * UpdateSleepPrescriptionData.java
 * Class used to hold and store all data associated with the user's sleep prescription
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

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class UpdateSleepPrescriptionData
{

	public int iSP_PBTimemin = -1;
	public int ii_PBTime = 0; // set to 1 any time this is set to keep count
	public int iSP_PWTimemin = -1;
	public int iSP_SleepEfficiency = -1;
	public Boolean bManUpdate = true;
	public int iBedtimemin = 0;
	public int iWaketimemin = 0;
	public int iAutoWaketimemin = 0;
	public int iUSPDayofWeek = 0;

	private Context c;
	private View contentView;

	public UpdateSleepPrescriptionData(Context c)
	{ // build an object from disk if possible
		this.c = c;
		this.contentView = null;
		loadData();
	}

	public UpdateSleepPrescriptionData(Context c, View v)
	{ // build an object from disk if possible
		this.c = c;
		this.contentView = v;
		loadData();
	}

	public UpdateSleepPrescriptionData(Context c, DataInputStream dis)
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

	private void readData(DataInputStream dis) throws IOException
	{
		iSP_PBTimemin = dis.readInt();
		ii_PBTime = dis.readInt();
		iSP_PWTimemin = dis.readInt();
		iSP_SleepEfficiency = dis.readInt();
		bManUpdate = dis.readBoolean();
		iBedtimemin = dis.readInt();
		iWaketimemin = dis.readInt();
		iAutoWaketimemin = dis.readInt();
		iUSPDayofWeek = dis.readInt();
	}

	public void writeData(DataOutputStream dos) throws IOException
	{

		dos.writeInt(iSP_PBTimemin);
		dos.writeInt(ii_PBTime);
		dos.writeInt(iSP_PWTimemin);
		dos.writeInt(iSP_SleepEfficiency);
		dos.writeBoolean(bManUpdate);
		dos.writeInt(iBedtimemin);
		dos.writeInt(iWaketimemin);
		dos.writeInt(iAutoWaketimemin);
		dos.writeInt(iUSPDayofWeek);
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_22a";

	public void saveData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
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

	void loadData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
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

	public void displaySleepPrescription()
	{
		String efficiency = "";
		if (iSP_PBTimemin == -2)
		{
			((TextView) contentView.findViewById(R.id.tvSPNote)).setVisibility(View.GONE);
			((TextView) contentView.findViewById(R.id.tvSPNote2)).setVisibility(View.VISIBLE);
			((LinearLayout) contentView.findViewById(R.id.tvSP)).setVisibility(View.GONE);
		}
		else if (iSP_PBTimemin != -1)
		{
			Activity c = (Activity) (this.c);

			((TextView) contentView.findViewById(R.id.tvSPNote)).setVisibility(View.GONE);
			((TextView) contentView.findViewById(R.id.tvSPNote2)).setVisibility(View.GONE);
			((LinearLayout) contentView.findViewById(R.id.tvSP)).setVisibility(View.VISIBLE);

			int iTime = iSP_PBTimemin;
			INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(c);
			if (cData23a.bAdd15)
				iTime -= 15;
			else if (cData23a.bAdd30)
				iTime -= 30;
			formattedTimeFrom4pm2(iTime, R.id.tSPBedtime, R.id.tSPBedtimeAM);
			formattedTimeFrom4pm2(iSP_PWTimemin, R.id.tSPWaketime, R.id.tSPWaketimeAM);
			
			if ((iSP_SleepEfficiency == -1) || (iSP_SleepEfficiency < 0) || (iSP_SleepEfficiency > 100))
			{
				efficiency = c.getResources().getString(R.string.s_NoData);
				((TextView) contentView.findViewById(R.id.tSPEfficiency)).setText(R.string.s_NoData);
			}
			else
			{
				efficiency = String.format("%d", iSP_SleepEfficiency) + "%";
				((TextView) contentView.findViewById(R.id.tSPEfficiency)).setText(efficiency);
			}

		}
		else
		{
			((TextView) contentView.findViewById(R.id.tvSPNote)).setVisibility(View.VISIBLE);
			((TextView) contentView.findViewById(R.id.tvSPNote2)).setVisibility(View.GONE);
			((LinearLayout) contentView.findViewById(R.id.tvSP)).setVisibility(View.GONE);
		}
		RelativeLayout llbar = (RelativeLayout)contentView.findViewById(R.id.rlpb);
		String bedtime = ((TextView)contentView.findViewById(R.id.tSPBedtime)).getText().toString();
		String bedtimeAM = ((TextView)contentView.findViewById(R.id.tSPBedtimeAM)).getText().toString();
		String waketime = ((TextView)contentView.findViewById(R.id.tSPWaketime)).getText().toString();
		String waketimeAM = ((TextView)contentView.findViewById(R.id.tSPWaketimeAM)).getText().toString();
		llbar.setContentDescription("Sleep Prescription Bedtime: " + bedtime + " " + bedtimeAM +
													" Waketime: " + waketime + " " + waketimeAM +
													" Sleep Efficiency " + efficiency);
	}

	public int timeTo4pm(int iTime)
	{ // we store the times as based off 4pm 24 hour clock
		int iHour = iTime / 60 - 16; // so we can compare them
		if (iHour < 0)
			iHour += 24;
		return (iHour * 60) + (iTime % 60);
	}

	public int timeFrom4pm(int iTime)
	{ // this will translate them for display
		int iHour = (iTime / 60) + 16;
		if (iHour > 24)
			iHour -= 24;
		return (iHour * 60) + (iTime % 60);
	}

	public String formattedTimeFrom4pm(int iTime)
	{
		iTime = timeFrom4pm(iTime);

		String sAMPM = "AM";
		int iHour = iTime / 60;
		if (iHour > 12)
		{
			sAMPM = "PM";
			iHour -= 12;
		}
		return (String.format("%d:%02d %s", iHour, iTime % 60, sAMPM));
	}

	public void formattedTimeFrom4pm2(int iTime, int iRid1, int iRid2)
	{
		iTime = timeFrom4pm(iTime);

		String sAMPM = "AM";
		int iHour = iTime / 60;
		if (iHour > 12)
		{
			sAMPM = "PM";
			iHour -= 12;
		}
		Activity c = (Activity) (this.c);
		((TextView) c.findViewById(iRid1)).setText((String.format("%d:%02d", iHour, iTime % 60)));
		((TextView) c.findViewById(iRid2)).setText(sAMPM);
	}
}
