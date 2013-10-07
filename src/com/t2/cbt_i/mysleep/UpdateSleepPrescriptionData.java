package com.t2.cbt_i.mysleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;


public class UpdateSleepPrescriptionData  {
	
	public int iSP_PBTimemin = -1;
	public int ii_PBTime  = 0;							// set to 1 any time this is set to keep count
	public int iSP_PWTimemin = -1;
	public int iSP_SleepEfficiency = -1;
	public Boolean bManUpdate = true;
	public int iBedtimemin  = 0;
	public int iWaketimemin = 0;
	public int iAutoWaketimemin = 0;
	public int iUSPDayofWeek = 0;
		
	private Context c;
	
	
	public UpdateSleepPrescriptionData( Context c ) {					// build an object from disk if possible
		this.c = c;
		loadData();
	}
	
	
	public UpdateSleepPrescriptionData( Context c, DataInputStream dis ) {
		this.c = c;
		try {
			readData( dis );
		} catch( Exception e ) {
		}
	}
	
	
	
	private void readData( DataInputStream dis ) throws IOException {
		iSP_PBTimemin  = dis.readInt();
		ii_PBTime   = dis.readInt();
		iSP_PWTimemin = dis.readInt();
		iSP_SleepEfficiency = dis.readInt();
		bManUpdate = dis.readBoolean();
		iBedtimemin = dis.readInt();
		iWaketimemin = dis.readInt();
		iAutoWaketimemin = dis.readInt();
		iUSPDayofWeek = dis.readInt();
	}
	
	public void writeData( DataOutputStream dos ) throws IOException {
		
		dos.writeInt( iSP_PBTimemin );
		dos.writeInt( ii_PBTime );
		dos.writeInt( iSP_PWTimemin );
		dos.writeInt( iSP_SleepEfficiency );
		dos.writeBoolean(bManUpdate);
		dos.writeInt(iBedtimemin);
		dos.writeInt(iWaketimemin);
		dos.writeInt(iAutoWaketimemin);
		dos.writeInt(iUSPDayofWeek);
	}
	
	private String sSubDir = "/CBTi_Data/";
	private String sFilename = "CBTi_Data_22a"; 
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
	
	public void displaySleepPrescription() {
		Activity c = (Activity)(this.c);
		if( iSP_PBTimemin == -2 ) {
			((TextView)c.findViewById(R.id.tvSPNote)).setVisibility(View.GONE);
			((TextView)c.findViewById(R.id.tvSPNote2)).setVisibility(View.VISIBLE);
			((LinearLayout)c.findViewById(R.id.tvSP)).setVisibility(View.GONE);
		}
		else if( iSP_PBTimemin != -1 ) {
			
			((TextView)c.findViewById(R.id.tvSPNote)).setVisibility(View.GONE);
			((TextView)c.findViewById(R.id.tvSPNote2)).setVisibility(View.GONE);
			((LinearLayout)c.findViewById(R.id.tvSP)).setVisibility(View.VISIBLE);
			
			int iTime = iSP_PBTimemin;
			INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(c);
			if( cData23a.bAdd15 )
				iTime -= 15;
			else if( cData23a.bAdd30 )
				iTime -= 30;
			formattedTimeFrom4pm2( iTime, R.id.tSPBedtime, R.id.tSPBedtimeAM );
			formattedTimeFrom4pm2( iSP_PWTimemin, R.id.tSPWaketime, R.id.tSPWaketimeAM );
			
			if( (iSP_SleepEfficiency==-1) || (iSP_SleepEfficiency<0) || (iSP_SleepEfficiency>100) )
				((TextView)c.findViewById(R.id.tSPEfficiency)).setText(R.string.s_NoData);
			else
				((TextView)c.findViewById(R.id.tSPEfficiency)).setText((String.format("%d", iSP_SleepEfficiency)));
			
		}
		else {
			((TextView)c.findViewById(R.id.tvSPNote)).setVisibility(View.VISIBLE);
			((TextView)c.findViewById(R.id.tvSPNote2)).setVisibility(View.GONE);
			((LinearLayout)c.findViewById(R.id.tvSP)).setVisibility(View.GONE);
		}
	}
	
	public int timeTo4pm( int iTime ) {				// we store the times as based off 4pm 24 hour clock
		int iHour = iTime/60 - 16;					// so we can compare them
		if( iHour < 0 )
			iHour += 24;
		return (iHour*60) + (iTime%60);
	}
	
	
	public int timeFrom4pm( int iTime ) {			// this will translate them for display
		int iHour = (iTime/60) + 16;
		if( iHour > 24 )
			iHour -= 24;
		return (iHour*60) + (iTime%60);
	}
	
	public String formattedTimeFrom4pm( int iTime ) {
		iTime = timeFrom4pm( iTime );
		
		String sAMPM = "AM";
		int iHour = iTime/60;
		if(  iHour>12 ) {
			sAMPM = "PM";
			iHour -= 12;
		}
		return (String.format("%d:%02d %s", iHour, iTime%60, sAMPM));
	}
	
	public void formattedTimeFrom4pm2( int iTime, int iRid1, int iRid2 ) {
		iTime = timeFrom4pm( iTime );
		
		String sAMPM = "AM";
		int iHour = iTime/60;
		if(  iHour>12 ) {
			sAMPM = "PM";
			iHour -= 12;
		}
		Activity c = (Activity)(this.c);
		((TextView)c.findViewById(iRid1)).setText((String.format("%d:%02d", iHour, iTime%60)));
		((TextView)c.findViewById(iRid2)).setText(sAMPM);
	}
}
