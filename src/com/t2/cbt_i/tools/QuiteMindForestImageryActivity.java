package com.t2.cbt_i.tools;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindForestImageryActivity extends BaseABSActivity {

	private int[] iCaptionId ={ R.string.s_Forest01, R.string.s_Forest02, R.string.s_Forest03, R.string.s_Forest04, R.string.s_Forest05,
			R.string.s_Forest06, R.string.s_Forest07, R.string.s_Forest08, R.string.s_Forest09, R.string.s_Forest10,
			R.string.s_Forest11, R.string.s_Forest12, R.string.s_Forest13, R.string.s_Forest14, R.string.s_Forest15,
			R.string.s_Forest16, R.string.s_Forest17, R.string.s_Forest18, R.string.s_Forest19, R.string.s_Forest20,
			R.string.s_Forest21, R.string.s_Forest22, R.string.s_Forest23, R.string.s_Forest24, R.string.s_Forest25,
			R.string.s_Forest26, R.string.s_Forest27, R.string.s_Forest28, R.string.s_Forest29, R.string.s_Forest30,
			R.string.s_Forest31 };
	private int[] iCaptionStart = 	{ 
			1, 8, 14, 20, 24, 
			32, 44, 46, 52, 57, 
			64, 75, 86, 98, 110,
			120, 136, 147, 151, 158, 
			163, 177, 187, 197, 203, 
			211, 226, 242, 256, 266, 
			278 };
	private Handler sHandler;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_quitemindforestimagery);

		// PLAY
		((Button)findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});


		Uri uUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.mp3_imageryforest );
		((VideoView) findViewById( R.id.video )).setVideoURI(uUri);
		((VideoView) findViewById( R.id.video )).setOnCompletionListener(onComplete);
		
		sHandler = new Handler();
	}	

	private void videoPlay() {
		((Button)findViewById(R.id.bPlayMe)).setVisibility(View.GONE);
		((VideoView) findViewById( R.id.video )).start();
		rSequencer.run();
		iResLast = -1;
	}


	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener() {
		public void onCompletion(MediaPlayer arg0) {
			((TextView)findViewById( R.id.caption )).setText(R.string.s_RoadText);
			((Button)findViewById(R.id.bPlayMe)).setVisibility(View.VISIBLE);
			//((VideoView) findViewById( R.id.video )).setVisibility(View.INVISIBLE);
		}
	};






	@Override
	public void onBackPressed() {
		super.onBackPressed();
		((VideoView) findViewById( R.id.video )).stopPlayback();
		sHandler.removeCallbacks(rSequencer);
		iVideoPos = 0;
		QuiteMindForestImageryActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}


	private static int iVideoPos;
	@Override
	protected void onPause() {
		((VideoView) findViewById( R.id.video )).pause();
		iVideoPos = ((VideoView) findViewById( R.id.video )).getCurrentPosition();
		sHandler.removeCallbacks(rSequencer);
		super.onPause();
	}



	@Override
	protected void onResume() {
		if( iVideoPos > 0 ) {
			((VideoView) findViewById( R.id.video )).seekTo(iVideoPos);
			videoPlay();
		}
		super.onResume();
	}

	private static int iResLast;
	private Runnable rSequencer = new Runnable() {	//Do something to the UI thread here
		@Override public void run() {		//This method runs in the same thread as the UI. 
			int iVideoCur = ((VideoView)findViewById(R.id.video)).getCurrentPosition() / 1000;
			if( iVideoCur > 0 ) {
				int iCur = getCurrentCaptionIndex(iCaptionStart,iVideoCur);
				if( (iCur!=-1) && (iResLast!=iCur) ) {
					((TextView)findViewById( R.id.caption )).setText(iCaptionId[iCur]);
					iResLast = iCur;
				}
			}
			sHandler.postDelayed(rSequencer, 1000);
		}
	};
	
	private int getCurrentCaptionIndex( int[] iList, int iVideoPos ) {
		int i=0;
		while(i<iList.length) {
			if( iList[i] > iVideoPos)
				return ((i<=iList.length)? i-1 : i);
			i++;
		}
		return ((iList[i-1]<=iVideoPos)? i-1 : -1);
	}

	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(QuiteMindForestImageryActivity.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.guidedimageryforest);
		i.putExtra("RID_Text", R.string.s_35a12help);
		QuiteMindForestImageryActivity.this.startActivity(i);
		QuiteMindForestImageryActivity.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}
