package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity34c1 extends CBTi_BaseActivity {
	
	CBTi_Data34c1 cData34c1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_34c1);
		
		cData34c1 = new CBTi_Data34c1( this );
		
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_GetoutofBed);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity34c1.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity34c1.this.startActivity(i);
				CBTi_Activity34c1.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity34c1.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolsgetoutofbedwhenyoucantsleep);
				i.putExtra("RID_Text", R.string.s_34e1);
				CBTi_Activity34c1.this.startActivity(i);
				CBTi_Activity34c1.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		((LinearLayout)findViewById(R.id.llCantSleep01)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep02)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep03)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep04)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep05)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep06)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep07)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep08)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep09)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep10)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep11)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep12)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep13)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep14)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep15)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep16)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep17)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep18)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep19)).setOnClickListener( CantSleepOCL );
		((LinearLayout)findViewById(R.id.llCantSleep20)).setOnClickListener( CantSleepOCL );
		
		((ImageButton)findViewById(R.id.bCantSleep01)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep02)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep03)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep04)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep05)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep06)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep07)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep08)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep09)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep10)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep11)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep12)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep13)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep14)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep15)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep16)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep17)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep18)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep19)).setOnClickListener( CantSleepOCL );
		((ImageButton)findViewById(R.id.bCantSleep20)).setOnClickListener( CantSleepOCL );
		
	}	
	
	//On click listener for button1
    final OnClickListener CantSleepOCL = new OnClickListener() {
        public void onClick(final View v) {
        	
        	Boolean bState = false;
        	int id = v.getId();
        	int iButton = 0;
        	
        	int iStart=0;
        	if( id==R.id.llCantSleep01 || id==R.id.bCantSleep01 ) {
        		iStart = 0;
        		iButton = R.id.bCantSleep01;
        	}
        	else if( id==R.id.llCantSleep02 || id==R.id.bCantSleep02 ) {
        		iStart = 1;
        		iButton = R.id.bCantSleep02;
        	}
        	else if( id == R.id.llCantSleep03 || id==R.id.bCantSleep03 ) {
        		iStart = 2;
        		iButton = R.id.bCantSleep03;
        	}
        	else if( id == R.id.llCantSleep04 || id==R.id.bCantSleep04 ) {
        		iStart = 3;
        		iButton = R.id.bCantSleep04;
        	}
        	else if( id == R.id.llCantSleep05 || id==R.id.bCantSleep05 ) {
        		iStart = 4;
        		iButton = R.id.bCantSleep05;
        	}
        	else if( id == R.id.llCantSleep06 || id==R.id.bCantSleep06 ) {
        		iStart = 5;
        		iButton = R.id.bCantSleep06;
        	}
        	else if( id == R.id.llCantSleep07 || id==R.id.bCantSleep07 ) {
        		iStart = 6;
        		iButton = R.id.bCantSleep07;
        	}
        	else if( id == R.id.llCantSleep08 || id==R.id.bCantSleep08 ) {
        		iStart = 7;
        		iButton = R.id.bCantSleep08;
        	}
        	else if( id == R.id.llCantSleep09 || id==R.id.bCantSleep09 ) {
        		iStart = 8;
        		iButton = R.id.bCantSleep09;
        	}
        	else if( id == R.id.llCantSleep10 || id==R.id.bCantSleep10 ) {
        		iStart = 9;
        		iButton = R.id.bCantSleep10;
        	}
        	else if( id == R.id.llCantSleep11 || id==R.id.bCantSleep11 ) {
        		iStart = 10;
        		iButton = R.id.bCantSleep11;
        	}
        	else if( id == R.id.llCantSleep12 || id==R.id.bCantSleep12 ) {
        		iStart = 11;
        		iButton = R.id.bCantSleep12;
        	}
        	else if( id == R.id.llCantSleep13 || id==R.id.bCantSleep13 ) {
        		iStart = 12;
        		iButton = R.id.bCantSleep13;
        	}
        	else if( id == R.id.llCantSleep14 || id==R.id.bCantSleep14 ) {
        		iStart = 13;
        		iButton = R.id.bCantSleep14;
        	}
        	else if( id == R.id.llCantSleep15 || id==R.id.bCantSleep15 ) {
        		iStart = 14;
        		iButton = R.id.bCantSleep15;
        	}
        	else if( id == R.id.llCantSleep16 || id==R.id.bCantSleep16 ) {
        		iStart = 15;
        		iButton = R.id.bCantSleep16;
        	}
        	else if( id == R.id.llCantSleep17 || id==R.id.bCantSleep17 ) {
        		iStart = 16;
        		iButton = R.id.bCantSleep17;
        	}
        	else if( id == R.id.llCantSleep18 || id==R.id.bCantSleep18 ) {
        		iStart = 17;
        		iButton = R.id.bCantSleep18;
        	}
        	else if( id == R.id.llCantSleep19 || id==R.id.bCantSleep19 ) {
        		iStart = 18;
        		iButton = R.id.bCantSleep19;
        	}
        	else if( id == R.id.llCantSleep20 || id==R.id.bCantSleep20 ) {
        		iStart = 19;
        		iButton = R.id.bCantSleep20;
        	}
        	
        	if( v.getClass().getSimpleName().equalsIgnoreCase("LinearLayout") ) {
        	   	bState = !((ImageButton)findViewById(iButton)).isSelected();
        	   	((ImageButton)findViewById(iButton)).setSelected(bState);
        	}
        	else {
        		if (v.isSelected())
        			v.setSelected(false);
        		else 
        			v.setSelected(true);
        		bState = ((ImageButton)findViewById(iButton)).isSelected();
        	}
        	cData34c1.bCantSleep[cData34c1.iMap[iStart]] = bState;		// scrape new state to data store

        	if( bState ) {		// if checked then re order display
        		if( iStart > 0 ) {
        			int iHold = cData34c1.iMap[iStart];
        			for( ; iStart>0 ; iStart-- ) 
        				cData34c1.iMap[iStart] = cData34c1.iMap[iStart-1];
        			cData34c1.iMap[0] = iHold;
        		}
        	}
        	cData34c1.renderData();
        }
    };
	
	
	


    

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity34c1.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}



	@Override
	protected void onPause() {
		cData34c1.saveData();
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData34c1 = new CBTi_Data34c1( this );
		cData34c1.renderData();
		super.onResume();
	}
}
