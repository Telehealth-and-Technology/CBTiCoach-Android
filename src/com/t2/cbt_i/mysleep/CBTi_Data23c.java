package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;

public class CBTi_Data23c {
	
	public int iQuestion = -1;
	public Boolean b0 = false;
	public Boolean b1 = false;
	public Boolean b2 = false;
	public Boolean b3 = false;
	public Boolean b4 = false;
	
	public long lDate = -1;
	public int iScore[] = { -1, -1, -1, -1 };
	public int iCumScore = -1;
	
	Activity c;
	
	
	public CBTi_Data23c(Activity c) {
		this.c = c;  
		loadData();
	}
	
	
	
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_23c";
	public void saveData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream out = new DataOutputStream(fos);
			writeData(out);
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	public void writeData(DataOutputStream out) {
		try {
			out.writeInt( iQuestion );
			out.writeBoolean( b0 );
			out.writeBoolean( b1 );
			out.writeBoolean( b2 );
			out.writeBoolean( b3 );
			out.writeBoolean( b4 );
			out.writeLong(lDate);
			for( int i=0 ; i<4 ; i++ )
				out.writeInt( iScore[i] );
			out.writeInt(iCumScore);						
			out.flush();
			out.close();
		}
		catch( Exception e ) {
		}
	}
	
	
	public void loadData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			if(!dir.exists()) 									// create if necessary
	            dir.mkdir();	
			File file = new File(dir, sFilename);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fis);
			readData(in);
			in.close();
		}
		catch( Exception e ) {
		}	
	}
	
	public void readData(DataInputStream in) {
		try {
			iQuestion = in.readInt();
			b0 = in.readBoolean();
			b1 = in.readBoolean();
			b2 = in.readBoolean();
			b3 = in.readBoolean();
			b4 = in.readBoolean();
			lDate = in.readLong();
			
			for( int i=0 ; i<4 ; i++ )
				iScore[i] = in.readInt();
			iCumScore=in.readInt();
		}
		catch( Exception e ) {
		}	
	}
	
	
	
	public void deleteData() {
		try {
			File dir = new File(c.getFilesDir(), sSubDir );		// open the subdirectory if it exists
			File file = new File(dir, sFilename);
			file.delete();
		}
		catch( Exception e ) {
		
		}	
	}
	
	

}
