package com.t2.cbt_i.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;
import com.t2.cbt_i.settings.SettingsActivity;


public class AboutMainActivity extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_main);
	
		// mid Button CBTi Coach
		((Button)findViewById(R.id.bCBTi)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(AboutMainActivity.this, AboutCBTiActivity.class );
				AboutMainActivity.this.startActivity(i);
				AboutMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// mid Button Project Team
		((Button)findViewById(R.id.bPTS)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(AboutMainActivity.this, AboutProjectTeamActivity.class );
				AboutMainActivity.this.startActivity(i);
				AboutMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Project Partners
		((Button)findViewById(R.id.bPP)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(AboutMainActivity.this, AboutProjectPartnersActivity.class );
				AboutMainActivity.this.startActivity(i);
				AboutMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Settings
		((Button)findViewById(R.id.bSettings)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(AboutMainActivity.this, SettingsActivity.class );
				AboutMainActivity.this.startActivity(i);
				AboutMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AboutMainActivity.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
}