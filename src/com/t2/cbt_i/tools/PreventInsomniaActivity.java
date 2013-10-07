package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class PreventInsomniaActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_preventinsomnia);
	
		// SUBMIT
		((Button)findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				
				Intent i = new Intent(PreventInsomniaActivity.this, PreventInsomniaResultActivity.class );
				i.putExtra("PREVENT01", (Boolean)((ToggleButton)findViewById(R.id.bPrevent01)).isChecked());
				i.putExtra("PREVENT02", (Boolean)((ToggleButton)findViewById(R.id.bPrevent02)).isChecked());
				i.putExtra("PREVENT03", (Boolean)((ToggleButton)findViewById(R.id.bPrevent03)).isChecked());
				i.putExtra("PREVENT04", (Boolean)((ToggleButton)findViewById(R.id.bPrevent04)).isChecked());
				i.putExtra("PREVENT05", (Boolean)((ToggleButton)findViewById(R.id.bPrevent05)).isChecked());
				i.putExtra("PREVENT06", (Boolean)((ToggleButton)findViewById(R.id.bPrevent06)).isChecked());
				i.putExtra("PREVENT07", (Boolean)((ToggleButton)findViewById(R.id.bPrevent07)).isChecked());
				i.putExtra("PREVENT08", (Boolean)((ToggleButton)findViewById(R.id.bPrevent08)).isChecked());
				PreventInsomniaActivity.this.startActivity(i);
				PreventInsomniaActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}	
	
	

	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		PreventInsomniaActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(PreventInsomniaActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolspreventinsomniainthefuture);
		i.putExtra("RID_Text", R.string.s_36b);
		PreventInsomniaActivity.this.startActivity(i);
		PreventInsomniaActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
