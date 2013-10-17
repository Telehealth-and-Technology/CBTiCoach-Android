package com.t2.cbt_i.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.mysleep.UpdateSleepPrescriptionData;

public class DashboardFragment extends CBTi_BaseFragment
{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.dashboardfragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);
        
		// MySleep Button
		((Button)getView().findViewById(R.id.b10mysleep)).setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View v) 
		    {
		    	//MySleep
                ((DashboardActivity)getSherlockActivity()).setPage(1);
		    }  
		});
		
		// Learn Button
		((Button)getView().findViewById(R.id.b10learn)).setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View v) 
		    {
		    	//Learn
                ((DashboardActivity)getSherlockActivity()).setPage(3);
		    }
		});
		
		// Tools Button
		((Button)getView().findViewById(R.id.b10tools)).setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View v) 
		    {
		    	//Tools
                ((DashboardActivity)getSherlockActivity()).setPage(2);
			}
		});
		
		// Reminders Button
		((Button)getView().findViewById(R.id.b10reminders)).setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View v) 
		    {
		    	//Reminders
                ((DashboardActivity)getSherlockActivity()).setPage(4);
		    }
		});
	}

	@Override
	public void onResume() 
	{
		super.onResume();
		
		// fetch the data and display either the sleep prescription or the msg
		UpdateSleepPrescriptionData cData22a = new UpdateSleepPrescriptionData( getSherlockActivity() );
		cData22a.displaySleepPrescription();		
	}
	
//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) 
//	{
//		int ht = ((Button)getView().findViewById(R.id.b10mysleep)).getHeight();
//		int wi = ((Button)getView().findViewById(R.id.b10mysleep)).getWidth();
//		int sc = Math.min(ht,wi) / 18;
//		((TextView)getView().findViewById(R.id.t10mysleep)).setTextSize(sc);
//		((TextView)getView().findViewById(R.id.t10tools)).setTextSize(sc);
//		((TextView)getView().findViewById(R.id.t10learn)).setTextSize(sc);
//		((TextView)getView().findViewById(R.id.t10reminders)).setTextSize(sc);
//	    super.onWindowFocusChanged(hasFocus);
//	}

	
	//@Override
	@Override
	public void getHelp() 
	{
		this.goingToHelp = true;
		startActivity( new Intent(getSherlockActivity(), DashboardHelpActivity.class) ); 
		getSherlockActivity().overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
