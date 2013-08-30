package com.t2.cbt_i.classes;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;


public class CBTi_Help extends CBTi_BaseActivity {

	private int iTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_help);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setVisibility( View.INVISIBLE );
		((ImageButton)findViewById(R.id.ibTopRight)).setVisibility( View.INVISIBLE );
		
		Bundle b = getIntent().getExtras();
		iTitle = b.getInt("RID_Title");
		if(  iTitle == 0 )
			iTitle = R.string.s_Help;
		((TextView)findViewById(R.id.tvTopTitle)).setText( iTitle );
		
		int iText, iImg;
		if( (iText = b.getInt("RID_Text")) != 0) {
			((TextView)findViewById(R.id.tvHelp)).setText( iText );
			((TextView)findViewById(R.id.tvHelp)).setMovementMethod(new ScrollingMovementMethod());
		}
		
		if( (iImg = b.getInt("RID_Img")) != 0)
			((ImageView)findViewById(R.id.ivHelp)).setImageResource( iImg );
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if(  iTitle == 0 )
			CBTi_Help.this.overridePendingTransition( R.anim.slide_down, R.anim.slide_down2);
		else
			CBTi_Help.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}