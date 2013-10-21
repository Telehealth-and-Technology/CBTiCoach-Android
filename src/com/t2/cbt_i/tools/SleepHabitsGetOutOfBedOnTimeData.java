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

public class SleepHabitsGetOutOfBedOnTimeData
{

	Boolean bGetOut[] = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[] = { R.string.s_GetOut01, R.string.s_GetOut02, R.string.s_GetOut03, R.string.s_GetOut04, R.string.s_GetOut05, R.string.s_GetOut06,
			R.string.s_GetOut07, R.string.s_GetOut08, R.string.s_GetOut09, R.string.s_GetOut10, R.string.s_GetOut11, R.string.s_GetOut12, R.string.s_GetOut13,
			R.string.s_GetOut14, R.string.s_GetOut15, R.string.s_GetOut16, R.string.s_GetOut17, R.string.s_GetOut18, R.string.s_GetOut19, R.string.s_GetOut20 };

	Activity c;

	public SleepHabitsGetOutOfBedOnTimeData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c2";

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

			for (int i = 0; i < bGetOut.length; i++)
				out.writeBoolean(bGetOut[i]);
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

			for (int i = 0; i < bGetOut.length; i++)
				bGetOut[i] = in.readBoolean();
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

		((CheckBox) c.findViewById(R.id.cbGetOut01)).setChecked(bGetOut[iMap[0]]);
		((CheckBox) c.findViewById(R.id.cbGetOut02)).setChecked(bGetOut[iMap[1]]);
		((CheckBox) c.findViewById(R.id.cbGetOut03)).setChecked(bGetOut[iMap[2]]);
		((CheckBox) c.findViewById(R.id.cbGetOut04)).setChecked(bGetOut[iMap[3]]);
		((CheckBox) c.findViewById(R.id.cbGetOut05)).setChecked(bGetOut[iMap[4]]);
		((CheckBox) c.findViewById(R.id.cbGetOut06)).setChecked(bGetOut[iMap[5]]);
		((CheckBox) c.findViewById(R.id.cbGetOut07)).setChecked(bGetOut[iMap[6]]);
		((CheckBox) c.findViewById(R.id.cbGetOut08)).setChecked(bGetOut[iMap[7]]);
		((CheckBox) c.findViewById(R.id.cbGetOut09)).setChecked(bGetOut[iMap[8]]);
		((CheckBox) c.findViewById(R.id.cbGetOut10)).setChecked(bGetOut[iMap[9]]);
		((CheckBox) c.findViewById(R.id.cbGetOut11)).setChecked(bGetOut[iMap[10]]);
		((CheckBox) c.findViewById(R.id.cbGetOut12)).setChecked(bGetOut[iMap[11]]);
		((CheckBox) c.findViewById(R.id.cbGetOut13)).setChecked(bGetOut[iMap[12]]);
		((CheckBox) c.findViewById(R.id.cbGetOut14)).setChecked(bGetOut[iMap[13]]);
		((CheckBox) c.findViewById(R.id.cbGetOut15)).setChecked(bGetOut[iMap[14]]);
		((CheckBox) c.findViewById(R.id.cbGetOut16)).setChecked(bGetOut[iMap[15]]);
		((CheckBox) c.findViewById(R.id.cbGetOut17)).setChecked(bGetOut[iMap[16]]);
		((CheckBox) c.findViewById(R.id.cbGetOut18)).setChecked(bGetOut[iMap[17]]);
		((CheckBox) c.findViewById(R.id.cbGetOut19)).setChecked(bGetOut[iMap[18]]);
		((CheckBox) c.findViewById(R.id.cbGetOut20)).setChecked(bGetOut[iMap[19]]);

		((TextView) c.findViewById(R.id.tGetOut01)).setText(iID[iMap[0]]);
		((TextView) c.findViewById(R.id.tGetOut02)).setText(iID[iMap[1]]);
		((TextView) c.findViewById(R.id.tGetOut03)).setText(iID[iMap[2]]);
		((TextView) c.findViewById(R.id.tGetOut04)).setText(iID[iMap[3]]);
		((TextView) c.findViewById(R.id.tGetOut05)).setText(iID[iMap[4]]);
		((TextView) c.findViewById(R.id.tGetOut06)).setText(iID[iMap[5]]);
		((TextView) c.findViewById(R.id.tGetOut07)).setText(iID[iMap[6]]);
		((TextView) c.findViewById(R.id.tGetOut08)).setText(iID[iMap[7]]);
		((TextView) c.findViewById(R.id.tGetOut09)).setText(iID[iMap[8]]);
		((TextView) c.findViewById(R.id.tGetOut10)).setText(iID[iMap[9]]);
		((TextView) c.findViewById(R.id.tGetOut11)).setText(iID[iMap[10]]);
		((TextView) c.findViewById(R.id.tGetOut12)).setText(iID[iMap[11]]);
		((TextView) c.findViewById(R.id.tGetOut13)).setText(iID[iMap[12]]);
		((TextView) c.findViewById(R.id.tGetOut14)).setText(iID[iMap[13]]);
		((TextView) c.findViewById(R.id.tGetOut15)).setText(iID[iMap[14]]);
		((TextView) c.findViewById(R.id.tGetOut16)).setText(iID[iMap[15]]);
		((TextView) c.findViewById(R.id.tGetOut17)).setText(iID[iMap[16]]);
		((TextView) c.findViewById(R.id.tGetOut18)).setText(iID[iMap[17]]);
		((TextView) c.findViewById(R.id.tGetOut19)).setText(iID[iMap[18]]);
		((TextView) c.findViewById(R.id.tGetOut20)).setText(iID[iMap[19]]);

		((CheckBox) c.findViewById(R.id.cbGetOut01)).setContentDescription(c.getString(iID[iMap[0]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut02)).setContentDescription(c.getString(iID[iMap[1]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut03)).setContentDescription(c.getString(iID[iMap[2]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut04)).setContentDescription(c.getString(iID[iMap[3]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut05)).setContentDescription(c.getString(iID[iMap[4]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut06)).setContentDescription(c.getString(iID[iMap[5]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut07)).setContentDescription(c.getString(iID[iMap[6]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut08)).setContentDescription(c.getString(iID[iMap[7]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut09)).setContentDescription(c.getString(iID[iMap[8]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut10)).setContentDescription(c.getString(iID[iMap[9]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut11)).setContentDescription(c.getString(iID[iMap[10]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut12)).setContentDescription(c.getString(iID[iMap[11]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut13)).setContentDescription(c.getString(iID[iMap[12]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut14)).setContentDescription(c.getString(iID[iMap[13]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut15)).setContentDescription(c.getString(iID[iMap[14]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut16)).setContentDescription(c.getString(iID[iMap[15]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut17)).setContentDescription(c.getString(iID[iMap[16]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut18)).setContentDescription(c.getString(iID[iMap[17]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut19)).setContentDescription(c.getString(iID[iMap[18]]) + " checkbox)");
		((CheckBox) c.findViewById(R.id.cbGetOut20)).setContentDescription(c.getString(iID[iMap[19]]) + " checkbox)");
	}

	private void reOrderMap()
	{ // move checked items to top of list
		int i, j;
		for (i = 0; i < bGetOut.length; i++)
		{
			if (bGetOut[iMap[i]] == false)
			{ // when you find an unchecked item
				for (j = i + 1; j < bGetOut.length; j++)
				{ // look for another checked item
					if (bGetOut[iMap[j]])
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
