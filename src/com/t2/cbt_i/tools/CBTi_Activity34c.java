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


public class CBTi_Activity34c extends CBTi_BaseActivity {
	
	CBTi_Data34c cData34c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_34c);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_GotoBed);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity34c.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity34c.this.startActivity(i);
				CBTi_Activity34c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity34c.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolsgotobedonlywhensleepy);
				i.putExtra("RID_Text", R.string.s_34e);
				CBTi_Activity34c.this.startActivity(i);
				CBTi_Activity34c.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});
		
		((LinearLayout)findViewById(R.id.llAwake01)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake02)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake03)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake04)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake05)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake06)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake07)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake08)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake09)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake10)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake11)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake12)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake13)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake14)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake15)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake16)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake17)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake18)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake19)).setOnClickListener( awakeOCL );
		((LinearLayout)findViewById(R.id.llAwake20)).setOnClickListener( awakeOCL );
		
		((ImageButton)findViewById(R.id.bAwake01)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake02)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake03)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake04)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake05)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake06)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake07)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake08)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake09)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake10)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake11)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake12)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake13)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake14)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake15)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake16)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake17)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake18)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake19)).setOnClickListener( awakeOCL );
		((ImageButton)findViewById(R.id.bAwake20)).setOnClickListener( awakeOCL );
		
		
		
	}	
	
	//On click listener for button1
    final OnClickListener awakeOCL = new OnClickListener() {
        public void onClick(final View v) {
        	
        	Boolean bState = false;
        	int id = v.getId();
        	int iButton = 0;
        	
        	int iStart=0;
        	if( id==R.id.llAwake01 || id==R.id.bAwake01 ) {
        		iStart = 0;
        		iButton = R.id.bAwake01;
        	}
        	else if( id==R.id.llAwake02 || id==R.id.bAwake02 ) {
        		iStart = 1;
        		iButton = R.id.bAwake02;
        	}
        	else if( id == R.id.llAwake03 || id==R.id.bAwake03 ) {
        		iStart = 2;
        		iButton = R.id.bAwake03;
        	}
        	else if( id == R.id.llAwake04 || id==R.id.bAwake04 ) {
        		iStart = 3;
        		iButton = R.id.bAwake04;
        	}
        	else if( id == R.id.llAwake05 || id==R.id.bAwake05 ) {
        		iStart = 4;
        		iButton = R.id.bAwake05;
        	}
        	else if( id == R.id.llAwake06 || id==R.id.bAwake06 ) {
        		iStart = 5;
        		iButton = R.id.bAwake06;
        	}
        	else if( id == R.id.llAwake07 || id==R.id.bAwake07 ) {
        		iStart = 6;
        		iButton = R.id.bAwake07;
        	}
        	else if( id == R.id.llAwake08 || id==R.id.bAwake08 ) {
        		iStart = 7;
        		iButton = R.id.bAwake08;
        	}
        	else if( id == R.id.llAwake09 || id==R.id.bAwake09 ) {
        		iStart = 8;
        		iButton = R.id.bAwake09;
        	}
        	else if( id == R.id.llAwake10 || id==R.id.bAwake10 ) {
        		iStart = 9;
        		iButton = R.id.bAwake10;
        	}
        	else if( id == R.id.llAwake11 || id==R.id.bAwake11 ) {
        		iStart = 10;
        		iButton = R.id.bAwake11;
        	}
        	else if( id == R.id.llAwake12 || id==R.id.bAwake12 ) {
        		iStart = 11;
        		iButton = R.id.bAwake12;
        	}
        	else if( id == R.id.llAwake13 || id==R.id.bAwake13 ) {
        		iStart = 12;
        		iButton = R.id.bAwake13;
        	}
        	else if( id == R.id.llAwake14 || id==R.id.bAwake14 ) {
        		iStart = 13;
        		iButton = R.id.bAwake14;
        	}
        	else if( id == R.id.llAwake15 || id==R.id.bAwake15 ) {
        		iStart = 14;
        		iButton = R.id.bAwake15;
        	}
        	else if( id == R.id.llAwake16 || id==R.id.bAwake16 ) {
        		iStart = 15;
        		iButton = R.id.bAwake16;
        	}
        	else if( id == R.id.llAwake17 || id==R.id.bAwake17 ) {
        		iStart = 16;
        		iButton = R.id.bAwake17;
        	}
        	else if( id == R.id.llAwake18 || id==R.id.bAwake18 ) {
        		iStart = 17;
        		iButton = R.id.bAwake18;
        	}
        	else if( id == R.id.llAwake19 || id==R.id.bAwake19 ) {
        		iStart = 18;
        		iButton = R.id.bAwake19;
        	}
        	else if( id == R.id.llAwake20 || id==R.id.bAwake20 ) {
        		iStart = 19;
        		iButton = R.id.bAwake20;
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

        	cData34c.bAwake[cData34c.iMap[iStart]] = bState;		// scrape new state to data store

        	if( bState ) {		// if checked then re order display
        		if( iStart > 0 ) {
        			int iHold = cData34c.iMap[iStart];
        			for( ; iStart>0 ; iStart-- ) 
        				cData34c.iMap[iStart] = cData34c.iMap[iStart-1];
        			cData34c.iMap[0] = iHold;
        		}
        	}
        	cData34c.renderData();
        }
    };
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity34c.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}



	@Override
	protected void onPause() {
		cData34c.saveData();
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData34c = new CBTi_Data34c( this );
		cData34c.renderData();
		super.onResume();
	}
}
