package com.t2.cbt_i.about;


import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity51a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_51a);
	
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
		((TextView)findViewById(R.id.tvTopTitle)).setText(R.string.app_name);
		
		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {		// handle the about button       
		       	Intent i = new Intent(CBTi_Activity51a.this, DashActivity.class );
		       	i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		       	CBTi_Activity51a.this.startActivity(i);
		       	CBTi_Activity51a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
		    }
		});
		
		((TextView)findViewById(R.id.tvCBTi)).setMovementMethod(new ScrollingMovementMethod());
						
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity51a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}