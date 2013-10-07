package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class SleepHabitsGetOutOfBedWhenCantSleepActivity extends BaseABSActivity {
	
	SleepHabitsGetOutOfBedWhenCantSleepData cData34c1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_sleephabitsgetoutofbedwhencantsleep);
		
		cData34c1 = new SleepHabitsGetOutOfBedWhenCantSleepData( this );
		
		((CheckBox)findViewById(R.id.cbCantSleep01)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep02)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep03)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep04)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep05)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep06)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep07)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep08)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep09)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep10)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep11)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep12)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep13)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep14)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep15)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep16)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep17)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep18)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep19)).setOnClickListener( CantSleepOCL );
		((CheckBox)findViewById(R.id.cbCantSleep20)).setOnClickListener( CantSleepOCL );
		
	}	
	
	//On click listener for button1
    final OnClickListener CantSleepOCL = new OnClickListener() {
        public void onClick(final View v) {
        	
        	Boolean bState = false;
        	int id = v.getId();
        	int iButton = 0;
        	
        	int iStart=0;
        	if( id==R.id.llCantSleep01 || id==R.id.cbCantSleep01 ) {
        		iStart = 0;
        		iButton = R.id.cbCantSleep01;
        	}
        	else if( id==R.id.llCantSleep02 || id==R.id.cbCantSleep02 ) {
        		iStart = 1;
        		iButton = R.id.cbCantSleep02;
        	}
        	else if( id == R.id.llCantSleep03 || id==R.id.cbCantSleep03 ) {
        		iStart = 2;
        		iButton = R.id.cbCantSleep03;
        	}
        	else if( id == R.id.llCantSleep04 || id==R.id.cbCantSleep04 ) {
        		iStart = 3;
        		iButton = R.id.cbCantSleep04;
        	}
        	else if( id == R.id.llCantSleep05 || id==R.id.cbCantSleep05 ) {
        		iStart = 4;
        		iButton = R.id.cbCantSleep05;
        	}
        	else if( id == R.id.llCantSleep06 || id==R.id.cbCantSleep06 ) {
        		iStart = 5;
        		iButton = R.id.cbCantSleep06;
        	}
        	else if( id == R.id.llCantSleep07 || id==R.id.cbCantSleep07 ) {
        		iStart = 6;
        		iButton = R.id.cbCantSleep07;
        	}
        	else if( id == R.id.llCantSleep08 || id==R.id.cbCantSleep08 ) {
        		iStart = 7;
        		iButton = R.id.cbCantSleep08;
        	}
        	else if( id == R.id.llCantSleep09 || id==R.id.cbCantSleep09 ) {
        		iStart = 8;
        		iButton = R.id.cbCantSleep09;
        	}
        	else if( id == R.id.llCantSleep10 || id==R.id.cbCantSleep10 ) {
        		iStart = 9;
        		iButton = R.id.cbCantSleep10;
        	}
        	else if( id == R.id.llCantSleep11 || id==R.id.cbCantSleep11 ) {
        		iStart = 10;
        		iButton = R.id.cbCantSleep11;
        	}
        	else if( id == R.id.llCantSleep12 || id==R.id.cbCantSleep12 ) {
        		iStart = 11;
        		iButton = R.id.cbCantSleep12;
        	}
        	else if( id == R.id.llCantSleep13 || id==R.id.cbCantSleep13 ) {
        		iStart = 12;
        		iButton = R.id.cbCantSleep13;
        	}
        	else if( id == R.id.llCantSleep14 || id==R.id.cbCantSleep14 ) {
        		iStart = 13;
        		iButton = R.id.cbCantSleep14;
        	}
        	else if( id == R.id.llCantSleep15 || id==R.id.cbCantSleep15 ) {
        		iStart = 14;
        		iButton = R.id.cbCantSleep15;
        	}
        	else if( id == R.id.llCantSleep16 || id==R.id.cbCantSleep16 ) {
        		iStart = 15;
        		iButton = R.id.cbCantSleep16;
        	}
        	else if( id == R.id.llCantSleep17 || id==R.id.cbCantSleep17 ) {
        		iStart = 16;
        		iButton = R.id.cbCantSleep17;
        	}
        	else if( id == R.id.llCantSleep18 || id==R.id.cbCantSleep18 ) {
        		iStart = 17;
        		iButton = R.id.cbCantSleep18;
        	}
        	else if( id == R.id.llCantSleep19 || id==R.id.cbCantSleep19 ) {
        		iStart = 18;
        		iButton = R.id.cbCantSleep19;
        	}
        	else if( id == R.id.llCantSleep20 || id==R.id.cbCantSleep20 ) {
        		iStart = 19;
        		iButton = R.id.cbCantSleep20;
        	}
        	
        	if( v.getClass().getSimpleName().equalsIgnoreCase("LinearLayout") ) {
        	   	bState = !((CheckBox)findViewById(iButton)).isChecked();
        	   	((CheckBox)findViewById(iButton)).setChecked(bState);
        	}
        	else {
        		if (v.isSelected())
        			v.setSelected(false);
        		else 
        			v.setSelected(true);
        		bState = ((CheckBox)findViewById(iButton)).isChecked();
        	}
        	cData34c1.bCantSleep[cData34c1.iMap[iStart]] = bState;		// scrape new state to data store

        	//if( bState ) {				// if checked then place at top
        	//	if( iStart > 0 ) {
        	//		int iHold = cData34c1.iMap[iStart];
        	//		for( ; iStart>0 ; iStart-- ) 
        	//			cData34c1.iMap[iStart] = cData34c1.iMap[iStart-1];
        	//		cData34c1.iMap[0] = iHold;
        	//	}
        	//}cData34c1.renderData();
        }
    };
	
	
	


    

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		SleepHabitsGetOutOfBedWhenCantSleepActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}



	@Override
	protected void onPause() {
		cData34c1.saveData();
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData34c1 = new SleepHabitsGetOutOfBedWhenCantSleepData( this );
		cData34c1.renderData();
		super.onResume();
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(SleepHabitsGetOutOfBedWhenCantSleepActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsgetoutofbedwhenyoucantsleep);
		i.putExtra("RID_Text", R.string.s_34e1);
		SleepHabitsGetOutOfBedWhenCantSleepActivity.this.startActivity(i);
		SleepHabitsGetOutOfBedWhenCantSleepActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
