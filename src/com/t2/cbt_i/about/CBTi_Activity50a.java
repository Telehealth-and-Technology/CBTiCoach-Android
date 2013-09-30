package com.t2.cbt_i.about;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;


public class CBTi_Activity50a extends BaseABSNHActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_50a);
	
		// mid Button CBTi Coach
		((Button)findViewById(R.id.bCBTi)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity51a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
		// mid Button Project Team
		((Button)findViewById(R.id.bPTS)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity52a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Project Partners
		((Button)findViewById(R.id.bPP)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity53a.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Settings
		((Button)findViewById(R.id.bSettings)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity50a.this, CBTi_Activity50b.class );
				CBTi_Activity50a.this.startActivity(i);
				CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity50a.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
}