package com.t2.cbt_i.tools;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;

public class CBTi_Activity35a11 extends BaseABSActivity {

	private int[] iCaptionId = { 
			R.string.s_muscle01, R.string.s_muscle02, R.string.s_muscle03, R.string.s_muscle04, R.string.s_muscle05,
			R.string.s_muscle06, R.string.s_muscle07, R.string.s_muscle08, R.string.s_muscle09, R.string.s_muscle10,
			R.string.s_muscle11, R.string.s_muscle12, R.string.s_muscle13, R.string.s_muscle14, R.string.s_muscle15,
			R.string.s_muscle16, R.string.s_muscle17, R.string.s_muscle18, R.string.s_muscle19, R.string.s_muscle20,
			R.string.s_muscle21, R.string.s_muscle22, R.string.s_muscle23, R.string.s_muscle24, R.string.s_muscle25,
			R.string.s_muscle26, R.string.s_muscle27, R.string.s_muscle28, R.string.s_muscle29, R.string.s_muscle30,
			R.string.s_muscle31, R.string.s_muscle32, R.string.s_muscle33, R.string.s_muscle34, R.string.s_muscle35,
			R.string.s_muscle36, R.string.s_muscle37, R.string.s_muscle38, R.string.s_muscle39, R.string.s_muscle40,
			R.string.s_muscle41, R.string.s_muscle42, R.string.s_muscle43, R.string.s_muscle44, R.string.s_muscle45,
			R.string.s_muscle46, R.string.s_muscle47, R.string.s_muscle48, R.string.s_muscle49, R.string.s_muscle50,
			R.string.s_muscle51, R.string.s_muscle52, R.string.s_muscle53  };
	private int[] iCaptionStart = 	{ 0, 10, 14, 17, 27, 35, 43, 52, 59, 69, 
			77, 86, 93, 103, 107, 115, 129, 135, 139, 150, 
			165, 177, 186, 194, 211, 218, 224, 236, 242, 245, 
			252, 254, 264, 276, 293, 311, 320, 329, 336, 353, 
			360, 364, 380, 399, 416, 422, 429, 459, 466, 475, 
			493, 502, 528 };

	private int[] iResId = {	R.drawable.toolsmusclerelaxation_bodyarms, R.drawable.toolsmusclerelaxation_bodyhead, 
			R.drawable.toolsmusclerelaxation_bodyshoulders, R.drawable.toolsmusclerelaxation_bodystomach,
			R.drawable.toolsmusclerelaxation_bodybutt, R.drawable.toolsmusclerelaxation_bodyfeet,
			R.drawable.toolsmusclerelaxation_bodyall
	};
	private int[] iResIdStart =	{ 59, 115, 186, 242, 293, 353, 429 };
	private Handler sHandler;

	private void setup() {

		// PLAY
		((Button)findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});


		Uri uUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.mp3_progressivemr );
		((VideoView)findViewById(R.id.video)).setVideoURI(uUri);
		((VideoView)findViewById(R.id.video)).setOnCompletionListener(onComplete);

		sHandler = new Handler();
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35a11);

		setup();
		((TextView)findViewById(R.id.caption)).setText( R.string.s_35a11 );

		// PLAY
		((Button)findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});


	}	

	private void videoPlay() {
		setContentView(R.layout.cbti_35a112);
		setup();

		((Button)findViewById(R.id.bPlayMe)).setVisibility(View.GONE);
		((ImageView)findViewById( R.id.iImage )).setImageResource(R.drawable.toolsmusclerelaxation_body);
		((ImageView)findViewById( R.id.iImageOverlay )).setVisibility(View.VISIBLE);
		((RelativeLayout)findViewById(R.id.rlPMR)).setBackgroundColor(Color.BLACK);
		((RelativeLayout)findViewById(R.id.rlPMRC)).setBackgroundColor(Color.BLACK);

		TextView mTextView = (TextView)findViewById(R.id.caption);
		ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) mTextView.getLayoutParams();
		mlp.setMargins(0, 0, 0, 0);
		((VideoView)findViewById(R.id.video)).start();

		iResLast = iResLast2 = -1;
		rSequencer.run();
	}


	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener() {

		public void onCompletion(MediaPlayer arg0) {
			setContentView(R.layout.cbti_35a11);
			setup();
			((TextView)findViewById(R.id.caption)).setText( R.string.s_35a11 );
			// PLAY
			((Button)findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {		// handle the about button
					iVideoPos = 0;
					videoPlay();
				}
			});
		}
	};





	@Override
	public void onBackPressed() {
		super.onBackPressed();
		((VideoView)findViewById(R.id.video)).stopPlayback();
		sHandler.removeCallbacks(rSequencer);
		iVideoPos = 0;
		CBTi_Activity35a11.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}


	private int getCurrentCaptionIndex( int[] iList, int iVideoPos ) {
		int i=0;
		while(i<iList.length) {
			if( iList[i] > iVideoPos)
				return ((i<=iList.length)? i-1 : i);
			i++;
		}
		return ((iList[i-1]<=iVideoPos)? i-1 : -1);
	}

	private static int iVideoPos;
	@Override
	protected void onPause() {
		((VideoView)findViewById(R.id.video)).pause();
		iVideoPos = ((VideoView)findViewById(R.id.video)).getCurrentPosition();
		sHandler.removeCallbacks(rSequencer);
		super.onPause();
	}



	@Override
	protected void onResume() {
		if( iVideoPos > 0 ) {
			((VideoView)findViewById(R.id.video)).seekTo(iVideoPos);
			videoPlay();
		}
		super.onResume();
	}


	private static int iResLast, iResLast2;
	private Runnable rSequencer = new Runnable() {	//Do something to the UI thread here
		@Override public void run() {		//This method runs in the same thread as the UI. 
			int iVideoCur = ((VideoView)findViewById(R.id.video)).getCurrentPosition() / 1000;
			if( iVideoCur > 0 ) {
				int iCur = getCurrentCaptionIndex(iCaptionStart,iVideoCur);
				if( (iCur!=-1) && (iResLast!=iCur) ) {
					((TextView)findViewById( R.id.caption )).setText(iCaptionId[iCur]);
					iResLast = iCur;
				}
				iCur = getCurrentCaptionIndex(iResIdStart,iVideoCur);
				if( (iCur!=-1) && (iResLast2!=iCur) ) {
					((ImageView)findViewById( R.id.iImageOverlay )).setImageResource(iResId[iCur]);
					iResLast2 = iCur;
				}
			}
			sHandler.postDelayed(rSequencer, 1000);
		}
	};

	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(CBTi_Activity35a11.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolsprogressivemusclerelaxation);
		i.putExtra("RID_Text", R.string.s_35a11help);
		CBTi_Activity35a11.this.startActivity(i);
		CBTi_Activity35a11.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}


