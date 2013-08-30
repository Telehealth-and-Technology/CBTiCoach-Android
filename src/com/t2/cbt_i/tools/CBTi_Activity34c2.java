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


public class CBTi_Activity34c2 extends CBTi_BaseActivity {
	
	CBTi_Data34c2 cData34c2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_34c2);
		
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_GetoutofBed);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity34c2.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity34c2.this.startActivity(i);
				CBTi_Activity34c2.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity34c2.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolsgetoutofbedatyourprescribedbedtime);
				i.putExtra("RID_Text", R.string.s_34e2);
				CBTi_Activity34c2.this.startActivity(i);
				CBTi_Activity34c2.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		((LinearLayout)findViewById(R.id.llGetOut01)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut02)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut03)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut04)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut05)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut06)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut07)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut08)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut09)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut10)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut11)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut12)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut13)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut14)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut15)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut16)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut17)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut18)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut19)).setOnClickListener( GetOutOCL );
		((LinearLayout)findViewById(R.id.llGetOut20)).setOnClickListener( GetOutOCL );
		
		((ImageButton)findViewById(R.id.bGetOut01)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut02)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut03)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut04)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut05)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut06)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut07)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut08)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut09)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut10)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut11)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut12)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut13)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut14)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut15)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut16)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut17)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut18)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut19)).setOnClickListener( GetOutOCL );
		((ImageButton)findViewById(R.id.bGetOut20)).setOnClickListener( GetOutOCL );
		
	}	
	
	//On click listener for button1
    final OnClickListener GetOutOCL = new OnClickListener() {
        public void onClick(final View v) {
        	
        	Boolean bState = false;
        	int id = v.getId();
        	int iButton = 0;
        	
        	int iStart=0;
        	if( id==R.id.llGetOut01 || id==R.id.bGetOut01 ) {
        		iStart = 0;
        		iButton = R.id.bGetOut01;
        	}
        	else if( id==R.id.llGetOut02 || id==R.id.bGetOut02 ) {
        		iStart = 1;
        		iButton = R.id.bGetOut02;
        	}
        	else if( id == R.id.llGetOut03 || id==R.id.bGetOut03 ) {
        		iStart = 2;
        		iButton = R.id.bGetOut03;
        	}
        	else if( id == R.id.llGetOut04 || id==R.id.bGetOut04 ) {
        		iStart = 3;
        		iButton = R.id.bGetOut04;
        	}
        	else if( id == R.id.llGetOut05 || id==R.id.bGetOut05 ) {
        		iStart = 4;
        		iButton = R.id.bGetOut05;
        	}
        	else if( id == R.id.llGetOut06 || id==R.id.bGetOut06 ) {
        		iStart = 5;
        		iButton = R.id.bGetOut06;
        	}
        	else if( id == R.id.llGetOut07 || id==R.id.bGetOut07 ) {
        		iStart = 6;
        		iButton = R.id.bGetOut07;
        	}
        	else if( id == R.id.llGetOut08 || id==R.id.bGetOut08 ) {
        		iStart = 7;
        		iButton = R.id.bGetOut08;
        	}
        	else if( id == R.id.llGetOut09 || id==R.id.bGetOut09 ) {
        		iStart = 8;
        		iButton = R.id.bGetOut09;
        	}
        	else if( id == R.id.llGetOut10 || id==R.id.bGetOut10 ) {
        		iStart = 9;
        		iButton = R.id.bGetOut10;
        	}
        	else if( id == R.id.llGetOut11 || id==R.id.bGetOut11 ) {
        		iStart = 10;
        		iButton = R.id.bGetOut11;
        	}
        	else if( id == R.id.llGetOut12 || id==R.id.bGetOut12 ) {
        		iStart = 11;
        		iButton = R.id.bGetOut12;
        	}
        	else if( id == R.id.llGetOut13 || id==R.id.bGetOut13 ) {
        		iStart = 12;
        		iButton = R.id.bGetOut13;
        	}
        	else if( id == R.id.llGetOut14 || id==R.id.bGetOut14 ) {
        		iStart = 13;
        		iButton = R.id.bGetOut14;
        	}
        	else if( id == R.id.llGetOut15 || id==R.id.bGetOut15 ) {
        		iStart = 14;
        		iButton = R.id.bGetOut15;
        	}
        	else if( id == R.id.llGetOut16 || id==R.id.bGetOut16 ) {
        		iStart = 15;
        		iButton = R.id.bGetOut16;
        	}
        	else if( id == R.id.llGetOut17 || id==R.id.bGetOut17 ) {
        		iStart = 16;
        		iButton = R.id.bGetOut17;
        	}
        	else if( id == R.id.llGetOut18 || id==R.id.bGetOut18 ) {
        		iStart = 17;
        		iButton = R.id.bGetOut18;
        	}
        	else if( id == R.id.llGetOut19 || id==R.id.bGetOut19 ) {
        		iStart = 18;
        		iButton = R.id.bGetOut19;
        	}
        	else if( id == R.id.llGetOut20 || id==R.id.bGetOut20 ) {
        		iStart = 19;
        		iButton = R.id.bGetOut20;
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
        	cData34c2.bGetOut[cData34c2.iMap[iStart]] = bState;		// scrape new state to data store

        	if( bState ) {		// if checked then re order display
        		if( iStart > 0 ) {
        			int iHold = cData34c2.iMap[iStart];
        			for( ; iStart>0 ; iStart-- ) 
        				cData34c2.iMap[iStart] = cData34c2.iMap[iStart-1];
        			cData34c2.iMap[0] = iHold;
        		}
        	}
        	cData34c2.renderData();
        }
    };
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity34c2.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}



	@Override
	protected void onPause() {
		cData34c2.saveData();
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData34c2 = new CBTi_Data34c2(this);
		cData34c2.renderData();
		super.onResume();
	}
}
