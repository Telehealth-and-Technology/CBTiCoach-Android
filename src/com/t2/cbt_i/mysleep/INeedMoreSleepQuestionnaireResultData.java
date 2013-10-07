package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;



public class INeedMoreSleepQuestionnaireResultData  {
	
	public long lQuestionaireDate = 0;
	public Boolean bAdd15 = false;
	public Boolean bAdd30 = false;
	public int iScore = -1;
		
	Activity c;
	
	
	public INeedMoreSleepQuestionnaireResultData( Activity c ) {					// build an object from disk if possible
		this.c = c;
		loadData();
	}
	
	
	public INeedMoreSleepQuestionnaireResultData( Activity c, DataInputStream dis ) {
		this.c = c;
		try {
			readData( dis );
		} catch( Exception e ) {
		}
	}
	
	
	
	private void readData( DataInputStream dis ) throws IOException {
		lQuestionaireDate = dis.readLong();
		bAdd15 = dis.readBoolean();
		bAdd30 = dis.readBoolean();
		iScore = dis.readInt();
		
	}
	
	public void writeData( DataOutputStream dos ) throws IOException {
		
		dos.writeLong( lQuestionaireDate );
		dos.writeBoolean(bAdd15);
		dos.writeBoolean(bAdd30);
		dos.writeInt(iScore);
		
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_23a"; 
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			writeData( out );
						
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	void loadData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			readData( in );
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	public Boolean inLastWeek() {								// see if entry made in last 7 days
		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY,  0);
		cc.set(Calendar.MINUTE,       0);
		cc.set(Calendar.SECOND,       0);
		cc.set(Calendar.MILLISECOND,  0);
		int iJulianDay = cc.get(Calendar.DAY_OF_YEAR);	// Julian today
		cc.set(Calendar.DAY_OF_YEAR, iJulianDay-6);		// Julian 7 days ago (Base)
		long lMinDate = cc.getTimeInMillis();			// if before this older tna a week
		
		if( lQuestionaireDate == 0 )
			return false;
		return lQuestionaireDate >= lMinDate;
	}
}
