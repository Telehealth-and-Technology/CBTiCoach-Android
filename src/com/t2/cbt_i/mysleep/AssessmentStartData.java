package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;


import android.app.Activity;

public class AssessmentStartData {
	
	public Boolean 					bProvider = true;
	public ArrayList<AssessmentQuestionnaireData> 	alISIData;
		 
	Activity c;
	
	public AssessmentStartData( Activity c) {
		this.c = c;  
		loadData();
	}
	
	
	
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_31b";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			
			out.writeBoolean( bProvider );
			int iSize = alISIData.size();
			out.writeInt( iSize );
			for( int i=0 ; i<iSize ; i++ ) {
				alISIData.get(i).writeData( out );
			}
												
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	
	void loadData() {
		alISIData = new ArrayList<AssessmentQuestionnaireData>();
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			
			bProvider = in.readBoolean();
			int iNumEntry = in.readInt();
			while( iNumEntry-- > 0 ) {
				AssessmentQuestionnaireData cData31c = new AssessmentQuestionnaireData(c);
				cData31c.readData(in);
				if( cData31c.iCumScore != -1 )
					alISIData.add(cData31c);
			}
						
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	

	public Boolean alreadyExists() {
		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY, 0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return alreadyExists( cc.getTimeInMillis() );
	}
	
	public Boolean alreadyExists( long lDateTime) {
		if( alISIData.isEmpty() )
			return false;
		long lLastISI = alISIData.get(alISIData.size()-1).lDate;
		return lLastISI != lDateTime;
	}
	
	public void addEntry( AssessmentQuestionnaireData cData31c ) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		cData31c.lDate = c.getTimeInMillis();
		alISIData.add(cData31c);
	}

	public Boolean withinAWeek() {
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
		for(int i=0 ; i<alISIData.size() ; i++) {
			if( alISIData.get(i).lDate > lWeekAgo ) {
				bRetval = true;
				break;
			}
		}
		
		return bRetval;
	}
	
}
