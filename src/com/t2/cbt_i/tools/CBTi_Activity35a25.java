package com.t2.cbt_i.tools;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;

public class CBTi_Activity35a25 extends CBTi_BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		Bundle b = getIntent().getExtras();
		int iRid = b.getInt("RID");
		if( iRid == R.id.bSelfGuided ) {
			setContentView(R.layout.cbti_35a25);
			((ImageButton)findViewById(R.id.ibTopLeft)).setVisibility(View.INVISIBLE);
			((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
			((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_SelfGuided);
			((TextView)findViewById(R.id.tvSelf)).setMovementMethod(new ScrollingMovementMethod());
		} else {
			setContentView(R.layout.cbti_35a252);
			((ImageButton)findViewById(R.id.ibTopLeft)).setVisibility(View.INVISIBLE);
			((ImageButton)findViewById(R.id.ibTopRight)).setVisibility(View.INVISIBLE);
			((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_AudioGuided);
			
			Uri uUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.mp4_clouds );
			((VideoView) findViewById( R.id.video )).setVideoURI(uUri);
			if( iVideoPos > 0 ) 
				((VideoView) findViewById( R.id.video )).seekTo(iVideoPos);
			((VideoView) findViewById( R.id.video )).start();
		}
	}	
	
	
	



	private static int iVideoPos;
	@Override
	protected void onPause() {
		if(((VideoView) findViewById( R.id.video ))!= null) {
			((VideoView) findViewById( R.id.video )).pause();
			iVideoPos = ((VideoView) findViewById( R.id.video )).getCurrentPosition();
		}
		super.onPause();
	}
	
	private void videoPlay() {
		if( iVideoPos > 0 ) 
			((VideoView) findViewById( R.id.video )).seekTo(iVideoPos);
		((VideoView) findViewById( R.id.video )).start();
		
	}
	
	
	@Override
	protected void onResume() {
		if( ((VideoView) findViewById( R.id.video )) != null ) {
			videoPlay();
		}
		super.onResume();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if(((VideoView) findViewById( R.id.video ))!= null) {
			((VideoView) findViewById( R.id.video )).stopPlayback();
			iVideoPos = 0;
		}
		CBTi_Activity35a25.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}

}
