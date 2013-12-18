package com.t2.cbt_i.tools;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.app.Activity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class SleepHabitsGoToBedOnlyWhenSleepyData
{

	Boolean bAwake[] = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
			false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[] = { R.string.s_awake01, R.string.s_awake02, R.string.s_awake03, R.string.s_awake04, R.string.s_awake05, R.string.s_awake06, R.string.s_awake07,
			R.string.s_awake08, R.string.s_awake09, R.string.s_awake10, R.string.s_awake11, R.string.s_awake12, R.string.s_awake13, R.string.s_awake14,
			R.string.s_awake15, R.string.s_awake16, R.string.s_awake17, R.string.s_awake18, R.string.s_awake19, R.string.s_awake20 };

	Activity c;

	public SleepHabitsGoToBedOnlyWhenSleepyData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c";

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
			FileOutputStream fos = new FileOutputStream(file); // open the file
																// in the
																// subdirectory
			DataOutputStream out = new DataOutputStream(fos);

			for (int i = 0; i < bAwake.length; i++)
				out.writeBoolean(bAwake[i]);
			for (int i = 0; i < iMap.length; i++)
				out.writeInt(iMap[i]);

			out.flush();
			out.close();
		}
		catch (Exception e)
		{
			Log.d("DEBUG", "Exception= " + e);
		}
	}

	void loadData()
	{
		try
		{
			File dir = new File(c.getFilesDir() + sSubDir);
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);

			for (int i = 0; i < bAwake.length; i++)
				bAwake[i] = in.readBoolean();
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

		((CheckBox) c.findViewById(R.id.cbAwake01)).setChecked(bAwake[iMap[0]]);
		((CheckBox) c.findViewById(R.id.cbAwake02)).setChecked(bAwake[iMap[1]]);
		((CheckBox) c.findViewById(R.id.cbAwake03)).setChecked(bAwake[iMap[2]]);
		((CheckBox) c.findViewById(R.id.cbAwake04)).setChecked(bAwake[iMap[3]]);
		((CheckBox) c.findViewById(R.id.cbAwake05)).setChecked(bAwake[iMap[4]]);
		((CheckBox) c.findViewById(R.id.cbAwake06)).setChecked(bAwake[iMap[5]]);
		((CheckBox) c.findViewById(R.id.cbAwake07)).setChecked(bAwake[iMap[6]]);
		((CheckBox) c.findViewById(R.id.cbAwake08)).setChecked(bAwake[iMap[7]]);
		((CheckBox) c.findViewById(R.id.cbAwake09)).setChecked(bAwake[iMap[8]]);
		((CheckBox) c.findViewById(R.id.cbAwake10)).setChecked(bAwake[iMap[9]]);
		((CheckBox) c.findViewById(R.id.cbAwake11)).setChecked(bAwake[iMap[10]]);
		((CheckBox) c.findViewById(R.id.cbAwake12)).setChecked(bAwake[iMap[11]]);
		((CheckBox) c.findViewById(R.id.cbAwake13)).setChecked(bAwake[iMap[12]]);
		((CheckBox) c.findViewById(R.id.cbAwake14)).setChecked(bAwake[iMap[13]]);
		((CheckBox) c.findViewById(R.id.cbAwake15)).setChecked(bAwake[iMap[14]]);
		((CheckBox) c.findViewById(R.id.cbAwake16)).setChecked(bAwake[iMap[15]]);
		((CheckBox) c.findViewById(R.id.cbAwake17)).setChecked(bAwake[iMap[16]]);
		((CheckBox) c.findViewById(R.id.cbAwake18)).setChecked(bAwake[iMap[17]]);
		((CheckBox) c.findViewById(R.id.cbAwake19)).setChecked(bAwake[iMap[18]]);
		((CheckBox) c.findViewById(R.id.cbAwake20)).setChecked(bAwake[iMap[19]]);

		((TextView) c.findViewById(R.id.tAwake01)).setText(iID[iMap[0]]);
		((TextView) c.findViewById(R.id.tAwake02)).setText(iID[iMap[1]]);
		((TextView) c.findViewById(R.id.tAwake03)).setText(iID[iMap[2]]);
		((TextView) c.findViewById(R.id.tAwake04)).setText(iID[iMap[3]]);
		((TextView) c.findViewById(R.id.tAwake05)).setText(iID[iMap[4]]);
		((TextView) c.findViewById(R.id.tAwake06)).setText(iID[iMap[5]]);
		((TextView) c.findViewById(R.id.tAwake07)).setText(iID[iMap[6]]);
		((TextView) c.findViewById(R.id.tAwake08)).setText(iID[iMap[7]]);
		((TextView) c.findViewById(R.id.tAwake09)).setText(iID[iMap[8]]);
		((TextView) c.findViewById(R.id.tAwake10)).setText(iID[iMap[9]]);
		((TextView) c.findViewById(R.id.tAwake11)).setText(iID[iMap[10]]);
		((TextView) c.findViewById(R.id.tAwake12)).setText(iID[iMap[11]]);
		((TextView) c.findViewById(R.id.tAwake13)).setText(iID[iMap[12]]);
		((TextView) c.findViewById(R.id.tAwake14)).setText(iID[iMap[13]]);
		((TextView) c.findViewById(R.id.tAwake15)).setText(iID[iMap[14]]);
		((TextView) c.findViewById(R.id.tAwake16)).setText(iID[iMap[15]]);
		((TextView) c.findViewById(R.id.tAwake17)).setText(iID[iMap[16]]);
		((TextView) c.findViewById(R.id.tAwake18)).setText(iID[iMap[17]]);
		((TextView) c.findViewById(R.id.tAwake19)).setText(iID[iMap[18]]);
		((TextView) c.findViewById(R.id.tAwake20)).setText(iID[iMap[19]]);
	}

	private void reOrderMap()
	{ // move checked items to top of list
		int i, j;
		for (i = 0; i < bAwake.length; i++)
		{
			if (bAwake[iMap[i]] == false)
			{ // when you find an unchecked item
				for (j = i + 1; j < bAwake.length; j++)
				{ // look for another checked item
					if (bAwake[iMap[j]])
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
