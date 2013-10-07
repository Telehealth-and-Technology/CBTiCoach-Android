package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;

public class SleepDairyData {
	
	int iPastWeek     = 0;
	int iTIBWeeklymin = -1;				// these are in minutes
	int iTSTWeeklymin = -1;				// these are in minutes
	int iSEWeekly     = -1;	
	 
	ArrayList<SleepDairyEntryData> alSleepDiary;
		
	Activity c;
	
	public SleepDairyData( Activity c) {
		this.c = c;  
		loadData();
	}
	
	
	
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_21a";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
				
			reorderSleepDiaries();
			
			int iSize = alSleepDiary.size();
			out.writeInt( iSize );
			
			for( int i=0 ; i<iSize ; i++ ) {
				SleepDairyEntryData cObj = alSleepDiary.get(i); 		// grab the next object and serialize it
				cObj.writeData( out );
			}
									
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	
	void loadData() {
		alSleepDiary= new ArrayList<SleepDairyEntryData>();
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			
			//iPastWeek = in.readInt();
			
			int iNumEntry = in.readInt();
			while( iNumEntry-- > 0 ) {
				alSleepDiary.add(new SleepDairyEntryData( c, in ));
			}
			
			updatePastWeek();
			
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	private void updatePastWeek() {
		Calendar cc = Calendar.getInstance();
		int iJulianDay = cc.get(Calendar.DAY_OF_YEAR);	// Julian today
		int iMinDay = iJulianDay-6;						// Julian 7 days ago (Base)
		Boolean[] bWeek = { false, false, false, false, false, false, false };
		// 1 for each of last 7 days
		for( int ii=0 ; ii<7 ; ii++ ) {					// one week is the max
			if( ii < alSleepDiary.size() ) {
				cc.setTimeInMillis((alSleepDiary.get(ii)).lSDETime);
				if( cc.get(Calendar.DAY_OF_YEAR) >= iMinDay ) {	// if entry part of current week
					bWeek[cc.get(Calendar.DAY_OF_WEEK)-1] = true;
					iTIBWeeklymin += alSleepDiary.get(ii).iTIBDailymin;
					iTSTWeeklymin += alSleepDiary.get(ii).iTSTDailymin;
					iSEWeekly  += alSleepDiary.get(ii).iSEDaily;
				}
			}
			else
				break;
		}
		iPastWeek = 0;									// update the counter
		for( int ii=0 ; ii<7 ; ii++ )
			if( bWeek[ii])
				iPastWeek++;

		if( iPastWeek > 0 ) {
			iTIBWeeklymin /= iPastWeek;
			iTSTWeeklymin /= iPastWeek;
			iSEWeekly /= iPastWeek;
			if( iSEWeekly<0 || iSEWeekly>100 )
				iSEWeekly = -1;
		}
	}

	
	private void reorderSleepDiaries() {
		ArrayList<SleepDairyEntryData> alSleepDiaryNew= new ArrayList<SleepDairyEntryData>();
		int iIndexOfNewest;

		int iLen = alSleepDiary.size();
		for( int ii=0 ; ii<iLen ; ii++ ) {
			iIndexOfNewest = 0;
			for( int i=1 ; i<alSleepDiary.size() ; i++ ) {		// go through the rest looking for newest
				if( alSleepDiary.get(i).lSDETime > alSleepDiary.get(iIndexOfNewest).lSDETime) {
					iIndexOfNewest = i;
				}
			}
			alSleepDiaryNew.add(alSleepDiary.get(iIndexOfNewest));
			alSleepDiary.remove(iIndexOfNewest);
		}
		alSleepDiary = alSleepDiaryNew;
	}
	

	public Boolean alreadyExists( long lDateTime) {
		for( int i=0 ; i<alSleepDiary.size() ; i++ )
			if( (alSleepDiary.get(i)).lSDETime == lDateTime )
				return true;
		return false;
	}
	
	

}
