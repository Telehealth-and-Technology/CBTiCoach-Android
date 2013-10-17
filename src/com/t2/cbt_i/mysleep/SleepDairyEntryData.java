package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.t2.cbt_i.R;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class SleepDairyEntryData
{

	long lSDETime = 0;
	Boolean bTNT = false;
	int iTNTmin = 0;
	int iBTmin = -1;
	int iSIATmin = -1;
	int iTTSmin = 0;
	int iTimesAwake = 0;
	int iTAmin = 0;
	int iWUTmin = -1;
	Boolean bEarlier = false;
	int iEarliermin = 0;
	int iWTmin = -1;
	int iSleepQ = 2;
	String sComment = "";

	int iTIBDailymin = 0; // these are in minutes
	int iTSTDailymin = 0; // these are in minutes
	int iSEDaily = 0;

	Activity c;

	public SleepDairyEntryData(Activity c)
	{ // build an object from disk if possible
		this.c = c;
		loadData();
	}

	public SleepDairyEntryData(Activity c, DataInputStream dis)
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
		lSDETime = dis.readLong();
		bTNT = dis.readBoolean();
		iTNTmin = dis.readInt();
		iBTmin = dis.readInt();
		iSIATmin = dis.readInt();
		iTTSmin = dis.readInt();
		iTimesAwake = dis.readInt();
		iTAmin = dis.readInt();
		iWUTmin = dis.readInt();
		bEarlier = dis.readBoolean();
		iEarliermin = dis.readInt();
		iWTmin = dis.readInt();
		iSleepQ = dis.readInt();
		sComment = dis.readUTF();

		iTIBDailymin = dis.readInt();
		iTSTDailymin = dis.readInt();
		iSEDaily = dis.readInt();
	}

	public void writeData(DataOutputStream dos) throws IOException
	{
		dos.writeLong(lSDETime);
		dos.writeBoolean(bTNT);
		dos.writeInt(iTNTmin);
		dos.writeInt(iBTmin);
		dos.writeInt(iSIATmin);
		dos.writeInt(iTTSmin);
		dos.writeInt(iTimesAwake);
		dos.writeInt(iTAmin);
		dos.writeInt(iWUTmin);
		dos.writeBoolean(bEarlier);
		dos.writeInt(iEarliermin);
		dos.writeInt(iWTmin);
		dos.writeInt(iSleepQ);
		dos.writeUTF(sComment);
		dos.writeInt(iTIBDailymin);
		dos.writeInt(iTSTDailymin);
		dos.writeInt(iSEDaily);
	}

	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_21c";

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
		if (lSDETime == 0)
		{
			Calendar cc = Calendar.getInstance();
			cc.set(Calendar.HOUR_OF_DAY, 0);
			cc.set(Calendar.MINUTE, 0);
			cc.set(Calendar.SECOND, 0);
			cc.set(Calendar.MILLISECOND, 0);
			lSDETime = cc.getTimeInMillis();
		}

		UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData(c);
		iBTmin = cData22a.iSP_PBTimemin;
		iSIATmin = cData22a.iSP_PBTimemin;
		iWUTmin = cData22a.iSP_PWTimemin;
		iWTmin = cData22a.iSP_PWTimemin;
	}

	void deleteData()
	{
		try
		{
			File dir = new File(c.getFilesDir(), sSubDir); // open the
															// subdirectory if
															// it exists
			if (!dir.exists()) // create if necessary
				dir.mkdir();
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
		cc.setTimeInMillis(lSDETime);
		SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy, EEEE");
		return (format.format(cc.getTime()));
	}

	public void scrapeData()
	{

		bTNT = ((ToggleButton) c.findViewById(R.id.bTNT)).isChecked();

		iTimesAwake = ((Spinner) c.findViewById(R.id.sTimesAwake)).getSelectedItemPosition();

		bEarlier = ((ToggleButton) c.findViewById(R.id.bEarlier)).isChecked();
		iSleepQ = ((Spinner) c.findViewById(R.id.sSleepQuality)).getSelectedItemPosition();
		// String s =
		// ((EditText)findViewById(R.id.tComment)).getText().toString();
		sComment = new String(((EditText) c.findViewById(R.id.tComment)).getText().toString());
	}
}
