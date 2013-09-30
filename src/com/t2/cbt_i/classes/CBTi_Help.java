package com.t2.cbt_i.classes;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.t2.cbt_i.R;


public class CBTi_Help extends BaseABSNHActivity {
	int iText, iImg, iTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_help);

		Bundle b = getIntent().getExtras();
		
		if( (iText = b.getInt("RID_Text")) != 0) {
			((TextView)findViewById(R.id.tvHelp)).setText( iText );
		}
		
		if( (iImg = b.getInt("RID_Img")) != 0)
			((ImageView)findViewById(R.id.ivHelp)).setImageResource( iImg );
		
		if( (iTitle = b.getInt("RID_Title")) != 0)
			getSupportActionBar().setTitle(iTitle);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if( iTitle != 0 )
			CBTi_Help.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
		else
			CBTi_Help.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
	}
}