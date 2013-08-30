package com.t2.cbt_i.tools;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;

public class CBTi_Data34f {
	
	public Boolean bRoomisdark = true;
	public Boolean bTemperatureiscomfortable = true;
	public Boolean bSleepisundisturbedbyothers = true;
	public Boolean bReervermybeddforsleepsex = true;
	public Boolean bLownoiselevel = true;
	
	private Context c;
	
	public CBTi_Data34f(Context c) {
		this.c = c;
		loadData();
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_34f";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
				
			out.writeBoolean( bRoomisdark );
			out.writeBoolean( bTemperatureiscomfortable );
			out.writeBoolean( bSleepisundisturbedbyothers );
			out.writeBoolean( bReervermybeddforsleepsex );
			out.writeBoolean( bLownoiselevel );
			
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
			
			bRoomisdark = in.readBoolean();
			bTemperatureiscomfortable = in.readBoolean();
			bSleepisundisturbedbyothers = in.readBoolean();
			bReervermybeddforsleepsex = in.readBoolean();
			bLownoiselevel = in.readBoolean();
									
			in.close();
		}
		catch( Exception e ) {
		
		}	
	}

}
