package com.t2.cbt_i.tools;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class CBTi_Data34c1 {
	
	Boolean bCantSleep[] = { false, false, false, false, false, false, false, false, false, false,
			                 false, false, false, false, false, false, false, false, false, false };
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[]  = { R.string.s_CantSleep01, R.string.s_CantSleep02, R.string.s_CantSleep03, R.string.s_CantSleep04, R.string.s_CantSleep05,
			       R.string.s_CantSleep06, R.string.s_CantSleep07, R.string.s_CantSleep08, R.string.s_CantSleep09, R.string.s_CantSleep10,
			       R.string.s_CantSleep11, R.string.s_CantSleep12, R.string.s_CantSleep13, R.string.s_CantSleep14, R.string.s_CantSleep15,
			       R.string.s_CantSleep16, R.string.s_CantSleep17, R.string.s_CantSleep18, R.string.s_CantSleep19, R.string.s_CantSleep20 };
	
	
	Activity c;
	
	
	public CBTi_Data34c1( Activity c) {
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
		
		((ImageButton)c.findViewById(R.id.bCantSleep01)).setSelected( bCantSleep[iMap[0]] );
		((ImageButton)c.findViewById(R.id.bCantSleep02)).setSelected( bCantSleep[iMap[1]] );
		((ImageButton)c.findViewById(R.id.bCantSleep03)).setSelected( bCantSleep[iMap[2]] );
		((ImageButton)c.findViewById(R.id.bCantSleep04)).setSelected( bCantSleep[iMap[3]] );
		((ImageButton)c.findViewById(R.id.bCantSleep05)).setSelected( bCantSleep[iMap[4]] );
		((ImageButton)c.findViewById(R.id.bCantSleep06)).setSelected( bCantSleep[iMap[5]] );
		((ImageButton)c.findViewById(R.id.bCantSleep07)).setSelected( bCantSleep[iMap[6]] );
		((ImageButton)c.findViewById(R.id.bCantSleep08)).setSelected( bCantSleep[iMap[7]] );
		((ImageButton)c.findViewById(R.id.bCantSleep09)).setSelected( bCantSleep[iMap[8]] );
		((ImageButton)c.findViewById(R.id.bCantSleep10)).setSelected( bCantSleep[iMap[9]] );
		((ImageButton)c.findViewById(R.id.bCantSleep11)).setSelected( bCantSleep[iMap[10]] );
		((ImageButton)c.findViewById(R.id.bCantSleep12)).setSelected( bCantSleep[iMap[11]] );
		((ImageButton)c.findViewById(R.id.bCantSleep13)).setSelected( bCantSleep[iMap[12]] );
		((ImageButton)c.findViewById(R.id.bCantSleep14)).setSelected( bCantSleep[iMap[13]] );
		((ImageButton)c.findViewById(R.id.bCantSleep15)).setSelected( bCantSleep[iMap[14]] );
		((ImageButton)c.findViewById(R.id.bCantSleep16)).setSelected( bCantSleep[iMap[15]] );
		((ImageButton)c.findViewById(R.id.bCantSleep17)).setSelected( bCantSleep[iMap[16]] );
		((ImageButton)c.findViewById(R.id.bCantSleep18)).setSelected( bCantSleep[iMap[17]] );
		((ImageButton)c.findViewById(R.id.bCantSleep19)).setSelected( bCantSleep[iMap[18]] );
		((ImageButton)c.findViewById(R.id.bCantSleep20)).setSelected( bCantSleep[iMap[19]] );
		
		
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
	}
	
	private void reOrderMap() {					// move checked items to top of list
		int i, j;
		for( i=0 ; i<19 ; i++ ) {
			if( bCantSleep[iMap[i]] == false ) {	// when you find an unchecked item
				for( j=i+1 ; j<20 ; j++ ) { 	// look for another checked item
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
