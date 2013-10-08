package com.t2.cbt_i.settings;


import java.io.File;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class SettingsActivity extends BaseABSNHActivity {
	SettingsData cData50b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_main);

		// middle buttons
		((Button)findViewById(R.id.bResetData)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button
				new AlertDialog.Builder( SettingsActivity.this )
				.setTitle(R.string.app_name)
				.setIcon(R.drawable.cbti_icon)
				.setMessage(R.string.s_ResetAllUserData)
				.setCancelable(false)
				.setPositiveButton(R.string.s_Continue,new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,int id) {
						resetAllUserData();
					}
				})
				.setNegativeButton(R.string.s_Cancel,null)
				.create()
				.show();
			}
		});
	}

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		SettingsActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	private String sSubDir = "/CBTi_Data/";
	private void resetAllUserData() {
			
		try {
			File dir = new File(getFilesDir(), sSubDir );								// open the subdirectory
						
			if( dir.isDirectory()) {													// delete each file in the directory
				String[] children = dir.list();
		        for (int i = 0; i < children.length; i++) {
		            new File(dir, children[i]).delete();
		        }
		        Toast.makeText(SettingsActivity.this, "User Data Reset", Toast.LENGTH_SHORT).show();
			}
		} catch(Exception e ) {
			Toast.makeText(SettingsActivity.this, "User Data Reset Error", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	@Override
	protected void onPause() {
		cData50b.bProvideUsageData = ((CheckBox)findViewById(R.id.bHelpImprove)).isChecked();
		cData50b.saveData();			// save data to file
		super.onPause();
	}

	@Override
	protected void onResume() {
		cData50b = new SettingsData( this );
		((CheckBox)findViewById(R.id.bHelpImprove)).setChecked( cData50b.bProvideUsageData );
		super.onResume();
	}
	
	
		
}