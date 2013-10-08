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

public class SleepHabitsGetOutOfBedWhenCantSleepData {
	
	Boolean bCantSleep[] = { false, false, false, false, false, false, false, false, false, false,
			                 false, false, false, false, false, false, false, false, false, false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[]  = { R.string.s_CantSleep01, R.string.s_CantSleep02, R.string.s_CantSleep03, R.string.s_CantSleep04, R.string.s_CantSleep05,
			       R.string.s_CantSleep06, R.string.s_CantSleep07, R.string.s_CantSleep08, R.string.s_CantSleep09, R.string.s_CantSleep10,
			       R.string.s_CantSleep11, R.string.s_CantSleep12, R.string.s_CantSleep13, R.string.s_CantSleep14, R.string.s_CantSleep15,
			       R.string.s_CantSleep16, R.string.s_CantSleep17, R.string.s_CantSleep18, R.string.s_CantSleep19, R.string.s_CantSleep20 };
	
	
	Activity c;
	
	
	public SleepHabitsGetOutOfBedWhenCantSleepData( Activity c) {
		this.c = c;
		loadData();
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c1";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			
			for( int i=0 ; i<20 ; i++ )
				out.writeBoolean( bCantSleep[i] );
			for( int i=0 ; i<20 ; i++ )
				out.writeInt(iMap[i]);
			 
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	void loadData() {
		try {
			File dir  = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists									
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			
			for( int i=0 ; i<20 ; i++ )
				bCantSleep[i] = in.readBoolean();
			for( int i=0 ; i<20 ; i++ )
				iMap[i] = in.readInt();
						
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	public void renderData() {
		reOrderMap();
		
		((CheckBox)c.findViewById(R.id.cbCantSleep01)).setChecked( bCantSleep[iMap[0]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep02)).setChecked( bCantSleep[iMap[1]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep03)).setChecked( bCantSleep[iMap[2]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep04)).setChecked( bCantSleep[iMap[3]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep05)).setChecked( bCantSleep[iMap[4]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep06)).setChecked( bCantSleep[iMap[5]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep07)).setChecked( bCantSleep[iMap[6]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep08)).setChecked( bCantSleep[iMap[7]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep09)).setChecked( bCantSleep[iMap[8]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep10)).setChecked( bCantSleep[iMap[9]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep11)).setChecked( bCantSleep[iMap[10]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep12)).setChecked( bCantSleep[iMap[11]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep13)).setChecked( bCantSleep[iMap[12]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep14)).setChecked( bCantSleep[iMap[13]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep15)).setChecked( bCantSleep[iMap[14]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep16)).setChecked( bCantSleep[iMap[15]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep17)).setChecked( bCantSleep[iMap[16]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep18)).setChecked( bCantSleep[iMap[17]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep19)).setChecked( bCantSleep[iMap[18]] );
		((CheckBox)c.findViewById(R.id.cbCantSleep20)).setChecked( bCantSleep[iMap[19]] );
		
		
		((TextView)c.findViewById(R.id.tCantSleep01)).setText( iID[iMap[0]] );
		((TextView)c.findViewById(R.id.tCantSleep02)).setText( iID[iMap[1]] );
		((TextView)c.findViewById(R.id.tCantSleep03)).setText( iID[iMap[2]] );
		((TextView)c.findViewById(R.id.tCantSleep04)).setText( iID[iMap[3]] );
		((TextView)c.findViewById(R.id.tCantSleep05)).setText( iID[iMap[4]] );
		((TextView)c.findViewById(R.id.tCantSleep06)).setText( iID[iMap[5]] );
		((TextView)c.findViewById(R.id.tCantSleep07)).setText( iID[iMap[6]] );
		((TextView)c.findViewById(R.id.tCantSleep08)).setText( iID[iMap[7]] );
		((TextView)c.findViewById(R.id.tCantSleep09)).setText( iID[iMap[8]] );
		((TextView)c.findViewById(R.id.tCantSleep10)).setText( iID[iMap[9]] );
		((TextView)c.findViewById(R.id.tCantSleep11)).setText( iID[iMap[10]] );
		((TextView)c.findViewById(R.id.tCantSleep12)).setText( iID[iMap[11]] );
		((TextView)c.findViewById(R.id.tCantSleep13)).setText( iID[iMap[12]] );
		((TextView)c.findViewById(R.id.tCantSleep14)).setText( iID[iMap[13]] );
		((TextView)c.findViewById(R.id.tCantSleep15)).setText( iID[iMap[14]] );
		((TextView)c.findViewById(R.id.tCantSleep16)).setText( iID[iMap[15]] );
		((TextView)c.findViewById(R.id.tCantSleep17)).setText( iID[iMap[16]] );
		((TextView)c.findViewById(R.id.tCantSleep18)).setText( iID[iMap[17]] );
		((TextView)c.findViewById(R.id.tCantSleep19)).setText( iID[iMap[18]] );
		((TextView)c.findViewById(R.id.tCantSleep20)).setText( iID[iMap[19]] );
		
		((CheckBox)c.findViewById(R.id.cbCantSleep01)).setContentDescription( c.getString(iID[iMap[0]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep02)).setContentDescription( c.getString(iID[iMap[1]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep03)).setContentDescription( c.getString(iID[iMap[2]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep04)).setContentDescription( c.getString(iID[iMap[3]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep05)).setContentDescription( c.getString(iID[iMap[4]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep06)).setContentDescription( c.getString(iID[iMap[5]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep07)).setContentDescription( c.getString(iID[iMap[6]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep08)).setContentDescription( c.getString(iID[iMap[7]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep09)).setContentDescription( c.getString(iID[iMap[8]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep10)).setContentDescription( c.getString(iID[iMap[9]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep11)).setContentDescription( c.getString(iID[iMap[10]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep12)).setContentDescription( c.getString(iID[iMap[11]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep13)).setContentDescription( c.getString(iID[iMap[12]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep14)).setContentDescription( c.getString(iID[iMap[13]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep15)).setContentDescription( c.getString(iID[iMap[14]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep16)).setContentDescription( c.getString(iID[iMap[15]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep17)).setContentDescription( c.getString(iID[iMap[16]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep18)).setContentDescription( c.getString(iID[iMap[17]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep19)).setContentDescription( c.getString(iID[iMap[18]])+" checkbox)" );
		((CheckBox)c.findViewById(R.id.cbCantSleep20)).setContentDescription( c.getString(iID[iMap[19]])+" checkbox)" );
	}
	
	private void reOrderMap() {						// move checked items to top of list
		int i, j;
		for( i=0 ; i<19 ; i++ ) {
			if( bCantSleep[iMap[i]] == false ) {	// when you find an unchecked item
				for( j=i+1 ; j<20 ; j++ ) { 	    // look for another checked item
					if( bCantSleep[iMap[j]] ) {		// found one
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
