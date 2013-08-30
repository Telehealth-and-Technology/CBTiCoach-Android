package com.t2.cbt_i.tools;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;

public class CBTi_Data34c {
	
	Boolean bAwake[] = { false, false, false, false, false, false, false, false, false, false,
			             false, false, false, false, false, false, false, false, false, false }; 
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[]  = { R.string.s_awake01, R.string.s_awake02, R.string.s_awake03, R.string.s_awake04, R.string.s_awake05,
			       R.string.s_awake06, R.string.s_awake07, R.string.s_awake08, R.string.s_awake09, R.string.s_awake10,
			       R.string.s_awake11, R.string.s_awake12, R.string.s_awake13, R.string.s_awake14, R.string.s_awake15,
			       R.string.s_awake16, R.string.s_awake17, R.string.s_awake18, R.string.s_awake19, R.string.s_awake20 };

	Activity c;
	
	public CBTi_Data34c(Activity c) {
		this.c = c;
		loadData();
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();													
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);	// open the file in the subdirectory
			DataOutputStream out = new DataOutputStream(fos);
			
			for( int i=0 ; i<20 ; i++ )
				out.writeBoolean(bAwake[i]);
			for( int i=0 ; i<20 ; i++ )
				out.writeInt(iMap[i]);
				
			out.flush();
			out.close();
		}
		catch( Exception e ) {
			Log.d("DEBUG", "Exception= "+e);
		}
	}
	
	void loadData() {
		try {
			File dir  = new File(c.getFilesDir() + sSubDir);
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			
			for( int i=0 ; i<20 ; i++ )
				bAwake[i] = in.readBoolean();
			for( int i=0 ; i<20 ; i++ )
				iMap[i] = in.readInt();
			
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	public void renderData() {
		reOrderMap();
		
		((ImageButton)c.findViewById(R.id.bAwake01)).setSelected( bAwake[iMap[0]] );
		((ImageButton)c.findViewById(R.id.bAwake02)).setSelected( bAwake[iMap[1]] );
		((ImageButton)c.findViewById(R.id.bAwake03)).setSelected( bAwake[iMap[2]] );
		((ImageButton)c.findViewById(R.id.bAwake04)).setSelected( bAwake[iMap[3]] );
		((ImageButton)c.findViewById(R.id.bAwake05)).setSelected( bAwake[iMap[4]] );
		((ImageButton)c.findViewById(R.id.bAwake06)).setSelected( bAwake[iMap[5]] );
		((ImageButton)c.findViewById(R.id.bAwake07)).setSelected( bAwake[iMap[6]] );
		((ImageButton)c.findViewById(R.id.bAwake08)).setSelected( bAwake[iMap[7]] );
		((ImageButton)c.findViewById(R.id.bAwake09)).setSelected( bAwake[iMap[8]] );
		((ImageButton)c.findViewById(R.id.bAwake10)).setSelected( bAwake[iMap[9]] );
		((ImageButton)c.findViewById(R.id.bAwake11)).setSelected( bAwake[iMap[10]] );
		((ImageButton)c.findViewById(R.id.bAwake12)).setSelected( bAwake[iMap[11]] );
		((ImageButton)c.findViewById(R.id.bAwake13)).setSelected( bAwake[iMap[12]] );
		((ImageButton)c.findViewById(R.id.bAwake14)).setSelected( bAwake[iMap[13]] );
		((ImageButton)c.findViewById(R.id.bAwake15)).setSelected( bAwake[iMap[14]] );
		((ImageButton)c.findViewById(R.id.bAwake16)).setSelected( bAwake[iMap[15]] );
		((ImageButton)c.findViewById(R.id.bAwake17)).setSelected( bAwake[iMap[16]] );
		((ImageButton)c.findViewById(R.id.bAwake18)).setSelected( bAwake[iMap[17]] );
		((ImageButton)c.findViewById(R.id.bAwake19)).setSelected( bAwake[iMap[18]] );
		((ImageButton)c.findViewById(R.id.bAwake20)).setSelected( bAwake[iMap[19]] );
		
		
		((TextView)c.findViewById(R.id.tAwake01)).setText( iID[iMap[0]] );
		((TextView)c.findViewById(R.id.tAwake02)).setText( iID[iMap[1]] );
		((TextView)c.findViewById(R.id.tAwake03)).setText( iID[iMap[2]] );
		((TextView)c.findViewById(R.id.tAwake04)).setText( iID[iMap[3]] );
		((TextView)c.findViewById(R.id.tAwake05)).setText( iID[iMap[4]] );
		((TextView)c.findViewById(R.id.tAwake06)).setText( iID[iMap[5]] );
		((TextView)c.findViewById(R.id.tAwake07)).setText( iID[iMap[6]] );
		((TextView)c.findViewById(R.id.tAwake08)).setText( iID[iMap[7]] );
		((TextView)c.findViewById(R.id.tAwake09)).setText( iID[iMap[8]] );
		((TextView)c.findViewById(R.id.tAwake10)).setText( iID[iMap[9]] );
		((TextView)c.findViewById(R.id.tAwake11)).setText( iID[iMap[10]] );
		((TextView)c.findViewById(R.id.tAwake12)).setText( iID[iMap[11]] );
		((TextView)c.findViewById(R.id.tAwake13)).setText( iID[iMap[12]] );
		((TextView)c.findViewById(R.id.tAwake14)).setText( iID[iMap[13]] );
		((TextView)c.findViewById(R.id.tAwake15)).setText( iID[iMap[14]] );
		((TextView)c.findViewById(R.id.tAwake16)).setText( iID[iMap[15]] );
		((TextView)c.findViewById(R.id.tAwake17)).setText( iID[iMap[16]] );
		((TextView)c.findViewById(R.id.tAwake18)).setText( iID[iMap[17]] );
		((TextView)c.findViewById(R.id.tAwake19)).setText( iID[iMap[18]] );
		((TextView)c.findViewById(R.id.tAwake20)).setText( iID[iMap[19]] );
	}
	
	private void reOrderMap() {					// move checked items to top of list
		int i, j;
		for( i=0 ; i<19 ; i++ ) {
			if( bAwake[iMap[i]] == false ) {	// when you find an unchecked item
				for( j=i+1 ; j<20 ; j++ ) { 	// look for another checked item
					if( bAwake[iMap[j]] ) {		// found one
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
