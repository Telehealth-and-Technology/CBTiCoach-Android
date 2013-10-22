package com.t2.cbt_i.settings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class SettingsData
{

	public Boolean bProvideUsageData = true;
	Context c;

	public SettingsData(Activity c)
	{
		this.c = c;
		loadData();
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_50b";

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

			out.writeBoolean(bProvideUsageData);

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

			bProvideUsageData = in.readBoolean();

			in.close();
		}
		catch (Exception e)
		{

		}
	}

}
