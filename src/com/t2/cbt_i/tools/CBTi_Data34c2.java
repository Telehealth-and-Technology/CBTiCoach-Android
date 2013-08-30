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

public class CBTi_Data34c2 {
	
	Boolean bGetOut[] = { false, false, false, false, false, false, false, false, false, false, 
			              false, false, false, false, false, false, false, false, false, false 	};
	int iMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	int iID[]  = { R.string.s_GetOut01, R.string.s_GetOut02, R.string.s_GetOut03, R.string.s_GetOut04, R.string.s_GetOut05,
			       R.string.s_GetOut06, R.string.s_GetOut07, R.string.s_GetOut08, R.string.s_GetOut09, R.string.s_GetOut10,
			       R.string.s_GetOut11, R.string.s_GetOut12, R.string.s_GetOut13, R.string.s_GetOut14, R.string.s_GetOut15,
			       R.string.s_GetOut16, R.string.s_GetOut17, R.string.s_GetOut18, R.string.s_GetOut19, R.string.s_GetOut20 };

	Activity c;
	
	
	public CBTi_Data34c2(Activity c) { 
		this.c = c;
		loadData();
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34c2";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			
			for( int i=0 ; i<20 ; i++ )
				out.writeBoolean(bGetOut[i]);
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
				bGetOut[i] = in.readBoolean();
			for( int i=0 ; i<20 ; i++ )
				iMap[i] = in.readInt();
								
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}
	
	public void renderData() {
		reOrderMap();
		
		((ImageButton)c.findViewById(R.id.bGetOut01)).setSelected( bGetOut[iMap[0]] );
		((ImageButton)c.findViewById(R.id.bGetOut02)).setSelected( bGetOut[iMap[1]] );
		((ImageButton)c.findViewById(R.id.bGetOut03)).setSelected( bGetOut[iMap[2]] );
		((ImageButton)c.findViewById(R.id.bGetOut04)).setSelected( bGetOut[iMap[3]] );
		((ImageButton)c.findViewById(R.id.bGetOut05)).setSelected( bGetOut[iMap[4]] );
		((ImageButton)c.findViewById(R.id.bGetOut06)).setSelected( bGetOut[iMap[5]] );
		((ImageButton)c.findViewById(R.id.bGetOut07)).setSelected( bGetOut[iMap[6]] );
		((ImageButton)c.findViewById(R.id.bGetOut08)).setSelected( bGetOut[iMap[7]] );
		((ImageButton)c.findViewById(R.id.bGetOut09)).setSelected( bGetOut[iMap[8]] );
		((ImageButton)c.findViewById(R.id.bGetOut10)).setSelected( bGetOut[iMap[9]] );
		((ImageButton)c.findViewById(R.id.bGetOut11)).setSelected( bGetOut[iMap[10]] );
		((ImageButton)c.findViewById(R.id.bGetOut12)).setSelected( bGetOut[iMap[11]] );
		((ImageButton)c.findViewById(R.id.bGetOut13)).setSelected( bGetOut[iMap[12]] );
		((ImageButton)c.findViewById(R.id.bGetOut14)).setSelected( bGetOut[iMap[13]] );
		((ImageButton)c.findViewById(R.id.bGetOut15)).setSelected( bGetOut[iMap[14]] );
		((ImageButton)c.findViewById(R.id.bGetOut16)).setSelected( bGetOut[iMap[15]] );
		((ImageButton)c.findViewById(R.id.bGetOut17)).setSelected( bGetOut[iMap[16]] );
		((ImageButton)c.findViewById(R.id.bGetOut18)).setSelected( bGetOut[iMap[17]] );
		((ImageButton)c.findViewById(R.id.bGetOut19)).setSelected( bGetOut[iMap[18]] );
		((ImageButton)c.findViewById(R.id.bGetOut20)).setSelected( bGetOut[iMap[19]] );
		
		
		((TextView)c.findViewById(R.id.tGetOut01)).setText( iID[iMap[0]] );
		((TextView)c.findViewById(R.id.tGetOut02)).setText( iID[iMap[1]] );
		((TextView)c.findViewById(R.id.tGetOut03)).setText( iID[iMap[2]] );
		((TextView)c.findViewById(R.id.tGetOut04)).setText( iID[iMap[3]] );
		((TextView)c.findViewById(R.id.tGetOut05)).setText( iID[iMap[4]] );
		((TextView)c.findViewById(R.id.tGetOut06)).setText( iID[iMap[5]] );
		((TextView)c.findViewById(R.id.tGetOut07)).setText( iID[iMap[6]] );
		((TextView)c.findViewById(R.id.tGetOut08)).setText( iID[iMap[7]] );
		((TextView)c.findViewById(R.id.tGetOut09)).setText( iID[iMap[8]] );
		((TextView)c.findViewById(R.id.tGetOut10)).setText( iID[iMap[9]] );
		((TextView)c.findViewById(R.id.tGetOut11)).setText( iID[iMap[10]] );
		((TextView)c.findViewById(R.id.tGetOut12)).setText( iID[iMap[11]] );
		((TextView)c.findViewById(R.id.tGetOut13)).setText( iID[iMap[12]] );
		((TextView)c.findViewById(R.id.tGetOut14)).setText( iID[iMap[13]] );
		((TextView)c.findViewById(R.id.tGetOut15)).setText( iID[iMap[14]] );
		((TextView)c.findViewById(R.id.tGetOut16)).setText( iID[iMap[15]] );
		((TextView)c.findViewById(R.id.tGetOut17)).setText( iID[iMap[16]] );
		((TextView)c.findViewById(R.id.tGetOut18)).setText( iID[iMap[17]] );
		((TextView)c.findViewById(R.id.tGetOut19)).setText( iID[iMap[18]] );
		((TextView)c.findViewById(R.id.tGetOut20)).setText( iID[iMap[19]] );
	}
	
	private void reOrderMap() {					// move checked items to top of list
		int i, j;
		for( i=0 ; i<19 ; i++ ) {
			if( bGetOut[iMap[i]] == false ) {	// when you find an unchecked item
				for( j=i+1 ; j<20 ; j++ ) { 	// look for another checked item
					if( bGetOut[iMap[j]] ) {		// found one
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
