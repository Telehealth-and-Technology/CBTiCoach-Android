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

public class CBTi_Data35a1 {
	
	Boolean bWind[] = { false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false, false, false,
                        false, false }; 
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
	int iID[]  = { R.string.s_Wind01, R.string.s_Wind02, R.string.s_Wind03, R.string.s_Wind04, R.string.s_Wind05,
			       R.string.s_Wind06, R.string.s_Wind07, R.string.s_Wind08, R.string.s_Wind09, R.string.s_Wind10,
			       R.string.s_Wind11, R.string.s_Wind12, R.string.s_Wind13, R.string.s_Wind14, R.string.s_Wind15,
			       R.string.s_Wind16, R.string.s_Wind17, R.string.s_Wind18, R.string.s_Wind19, R.string.s_Wind20,
			       R.string.s_Wind21, R.string.s_Wind22 };
	
	Activity c;
	
	public CBTi_Data35a1(Activity c) {
		this.c = c;
		loadData();
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_35a1";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			
			for( int i=0 ; i<20 ; i++ )
				out.writeBoolean(bWind[i]);
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
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			
			for( int i=0 ; i<20 ; i++ )
				bWind[i] = in.readBoolean();
			for( int i=0 ; i<20 ; i++ )
				iMap[i] = in.readInt();
						
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	public void renderData() {
		reOrderMap();
		
		((ImageButton)c.findViewById(R.id.bWind01)).setSelected( bWind[iMap[0]] );
		((ImageButton)c.findViewById(R.id.bWind02)).setSelected( bWind[iMap[1]] );
		((ImageButton)c.findViewById(R.id.bWind03)).setSelected( bWind[iMap[2]] );
		((ImageButton)c.findViewById(R.id.bWind04)).setSelected( bWind[iMap[3]] );
		((ImageButton)c.findViewById(R.id.bWind05)).setSelected( bWind[iMap[4]] );
		((ImageButton)c.findViewById(R.id.bWind06)).setSelected( bWind[iMap[5]] );
		((ImageButton)c.findViewById(R.id.bWind07)).setSelected( bWind[iMap[6]] );
		((ImageButton)c.findViewById(R.id.bWind08)).setSelected( bWind[iMap[7]] );
		((ImageButton)c.findViewById(R.id.bWind09)).setSelected( bWind[iMap[8]] );
		((ImageButton)c.findViewById(R.id.bWind10)).setSelected( bWind[iMap[9]] );
		((ImageButton)c.findViewById(R.id.bWind11)).setSelected( bWind[iMap[10]] );
		((ImageButton)c.findViewById(R.id.bWind12)).setSelected( bWind[iMap[11]] );
		((ImageButton)c.findViewById(R.id.bWind13)).setSelected( bWind[iMap[12]] );
		((ImageButton)c.findViewById(R.id.bWind14)).setSelected( bWind[iMap[13]] );
		((ImageButton)c.findViewById(R.id.bWind15)).setSelected( bWind[iMap[14]] );
		((ImageButton)c.findViewById(R.id.bWind16)).setSelected( bWind[iMap[15]] );
		((ImageButton)c.findViewById(R.id.bWind17)).setSelected( bWind[iMap[16]] );
		((ImageButton)c.findViewById(R.id.bWind18)).setSelected( bWind[iMap[17]] );
		((ImageButton)c.findViewById(R.id.bWind19)).setSelected( bWind[iMap[18]] );
		((ImageButton)c.findViewById(R.id.bWind20)).setSelected( bWind[iMap[19]] );
		((ImageButton)c.findViewById(R.id.bWind21)).setSelected( bWind[iMap[20]] );
		((ImageButton)c.findViewById(R.id.bWind22)).setSelected( bWind[iMap[21]] );
				
		((TextView)c.findViewById(R.id.tWind01)).setText( iID[iMap[0]] );
		((TextView)c.findViewById(R.id.tWind02)).setText( iID[iMap[1]] );
		((TextView)c.findViewById(R.id.tWind03)).setText( iID[iMap[2]] );
		((TextView)c.findViewById(R.id.tWind04)).setText( iID[iMap[3]] );
		((TextView)c.findViewById(R.id.tWind05)).setText( iID[iMap[4]] );
		((TextView)c.findViewById(R.id.tWind06)).setText( iID[iMap[5]] );
		((TextView)c.findViewById(R.id.tWind07)).setText( iID[iMap[6]] );
		((TextView)c.findViewById(R.id.tWind08)).setText( iID[iMap[7]] );
		((TextView)c.findViewById(R.id.tWind09)).setText( iID[iMap[8]] );
		((TextView)c.findViewById(R.id.tWind10)).setText( iID[iMap[9]] );
		((TextView)c.findViewById(R.id.tWind11)).setText( iID[iMap[10]] );
		((TextView)c.findViewById(R.id.tWind12)).setText( iID[iMap[11]] );
		((TextView)c.findViewById(R.id.tWind13)).setText( iID[iMap[12]] );
		((TextView)c.findViewById(R.id.tWind14)).setText( iID[iMap[13]] );
		((TextView)c.findViewById(R.id.tWind15)).setText( iID[iMap[14]] );
		((TextView)c.findViewById(R.id.tWind16)).setText( iID[iMap[15]] );
		((TextView)c.findViewById(R.id.tWind17)).setText( iID[iMap[16]] );
		((TextView)c.findViewById(R.id.tWind18)).setText( iID[iMap[17]] );
		((TextView)c.findViewById(R.id.tWind19)).setText( iID[iMap[18]] );
		((TextView)c.findViewById(R.id.tWind20)).setText( iID[iMap[19]] );
		((TextView)c.findViewById(R.id.tWind21)).setText( iID[iMap[20]] );
		((TextView)c.findViewById(R.id.tWind22)).setText( iID[iMap[21]] );
		
	}
	
	private void reOrderMap() {					// move checked items to top of list
		int i, j;
		for( i=0 ; i<19 ; i++ ) {
			if( bWind[iMap[i]] == false ) {		// when you find an unchecked item
				for( j=i+1 ; j<20 ; j++ ) { 	// look for another checked item
					if( bWind[iMap[j]] ) {		// found one
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
