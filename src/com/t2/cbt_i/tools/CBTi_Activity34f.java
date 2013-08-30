package com.t2.cbt_i.tools;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity34f extends CBTi_BaseActivity {
	
	CBTi_Data34f cData34f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_34f);
		
		cData34f = new CBTi_Data34f(this);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);
		((TextView)findViewById(R.id.tvTopTitle)).setText(R.string.s_SleepEnvironment);
		
		// Top Left HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				finish();		// make sure we close the splash screen so the user won't come back when it presses back key
				Intent i = new Intent(getApplicationContext(), DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				CBTi_Activity34f.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		}); 

		// Top Right HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_toolssetupyoursleepenvironment);
				i.putExtra("RID_Text", R.string.s_34h);
				startActivity(i);
				CBTi_Activity34f.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		}); 
		
		
		((Button)findViewById(R.id.bLownoiselevel)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if( !((ToggleButton)findViewById(R.id.bLownoiselevel)).isChecked() )
					showDialog(DIALOG_LNL);
			}
		}); 
		
		((Button)findViewById(R.id.bRoomisdark)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if( !((ToggleButton)findViewById(R.id.bRoomisdark)).isChecked() )
					showDialog(DIALOG_RID);
			}
		}); 
		
		((Button)findViewById(R.id.bTemperatureiscomfortable)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if( !((ToggleButton)findViewById(R.id.bTemperatureiscomfortable)).isChecked() )
					showDialog(DIALOG_TIC);
			}
		}); 
		
		((Button)findViewById(R.id.bSleepisundisturbedbyothers)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if( !((ToggleButton)findViewById(R.id.bSleepisundisturbedbyothers)).isChecked() )
					showDialog(DIALOG_SIU);
			}
		}); 
		
		((Button)findViewById(R.id.bReservemybedforsleepsex)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if( !((ToggleButton)findViewById(R.id.bReservemybedforsleepsex)).isChecked() )
					showDialog(DIALOG_RSS);
			}
		}); 

		
	}




	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		CBTi_Activity34f.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	@Override
	protected void onPause() {
		cData34f.bLownoiselevel              = ((ToggleButton)findViewById(R.id.bLownoiselevel)).isChecked();
		cData34f.bRoomisdark                 = ((ToggleButton)findViewById(R.id.bRoomisdark)).isChecked();
		cData34f.bTemperatureiscomfortable   = ((ToggleButton)findViewById(R.id.bTemperatureiscomfortable)).isChecked();
		cData34f.bSleepisundisturbedbyothers = ((ToggleButton)findViewById(R.id.bSleepisundisturbedbyothers)).isChecked();
		cData34f.bReervermybeddforsleepsex   = ((ToggleButton)findViewById(R.id.bReservemybedforsleepsex)).isChecked();
		cData34f.saveData();
		
		super.onPause();
	}



	@Override
	protected void onResume() {
		cData34f = new CBTi_Data34f( this );
		((ToggleButton)findViewById(R.id.bLownoiselevel)).setChecked( cData34f.bLownoiselevel );
		((ToggleButton)findViewById(R.id.bRoomisdark)).setChecked( cData34f.bRoomisdark );
		((ToggleButton)findViewById(R.id.bTemperatureiscomfortable)).setChecked( cData34f.bTemperatureiscomfortable );
		((ToggleButton)findViewById(R.id.bSleepisundisturbedbyothers)).setChecked( cData34f.bSleepisundisturbedbyothers );
		((ToggleButton)findViewById(R.id.bReservemybedforsleepsex)).setChecked( cData34f.bReervermybeddforsleepsex );
		
		super.onResume();
	}
	
	private static final int DIALOG_LNL      = 41;
	private static final int DIALOG_RID      = 42;
	private static final int DIALOG_TIC      = 43;
	private static final int DIALOG_SIU      = 44;
	private static final int DIALOG_RSS      = 45;
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Builder builder = new AlertDialog.Builder(this);
		switch (id) {
		case DIALOG_LNL:
			builder.setMessage(getString(R.string.s_Lownoiseleveltext));
			break;
			
		case DIALOG_RID:
			builder.setMessage(getString(R.string.s_Roomisdarktext));
			break;
			
		case DIALOG_TIC:
			builder.setMessage(getString(R.string.s_Temperatureiscomfortabletext));
			break;
			
		case DIALOG_SIU:
			builder.setMessage(getString(R.string.s_Sleepisundisturbedbyotherstext));
			break;
			
		case DIALOG_RSS:
			builder.setMessage(getString(R.string.s_Reservemybedforsleepsextext));
			break;
		}
		builder.setPositiveButton("OK", new OkOnClickListener());
		builder.create().show();
		return null;
	}
	
	private final class OkOnClickListener implements DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which) {
		}
	}
}