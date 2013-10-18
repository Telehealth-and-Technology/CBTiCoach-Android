package com.t2.cbt_i.tools;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindForestImageryFragment extends CBTi_BaseFragment
{

	private int[] iCaptionId = { R.string.s_Forest01, R.string.s_Forest02, R.string.s_Forest03, R.string.s_Forest04, R.string.s_Forest05, R.string.s_Forest06,
			R.string.s_Forest07, R.string.s_Forest08, R.string.s_Forest09, R.string.s_Forest10, R.string.s_Forest11, R.string.s_Forest12, R.string.s_Forest13,
			R.string.s_Forest14, R.string.s_Forest15, R.string.s_Forest16, R.string.s_Forest17, R.string.s_Forest18, R.string.s_Forest19, R.string.s_Forest20,
			R.string.s_Forest21, R.string.s_Forest22, R.string.s_Forest23, R.string.s_Forest24, R.string.s_Forest25, R.string.s_Forest26, R.string.s_Forest27,
			R.string.s_Forest28, R.string.s_Forest29, R.string.s_Forest30, R.string.s_Forest31 };
	private int[] iCaptionStart = { 1, 8, 14, 20, 24, 32, 44, 46, 52, 57, 64, 75, 86, 98, 110, 120, 136, 147, 151, 158, 163, 177, 187, 197, 203, 211, 226, 242,
			256, 266, 278 };
	private Handler sHandler;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindforestimagery, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_GuidedImageryForest));
		setHasOptionsMenu(true);
		
		// PLAY
		((Button) getView().findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});

		Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp3_imageryforest);
		((VideoView) getView().findViewById(R.id.video)).setVideoURI(uUri);
		((VideoView) getView().findViewById(R.id.video)).setOnCompletionListener(onComplete);

		sHandler = new Handler();
	}
	
	private static int iVideoPos;

	@Override
	public void onResume()
	{
		if (iVideoPos > 0)
		{
			((VideoView) getView().findViewById(R.id.video)).seekTo(iVideoPos);
			videoPlay();
		}
		super.onResume();
	}
	
	@Override
	public void onPause()
	{
		if(goingToHelp)
		{
			((VideoView) getView().findViewById(R.id.video)).pause();
			iVideoPos = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition();
			sHandler.removeCallbacks(rSequencer);
		}
		else
		{
			((VideoView) getView().findViewById( R.id.video )).stopPlayback();
			sHandler.removeCallbacks(rSequencer);
			iVideoPos = 0;	
		}
		super.onPause();
	}

	private void videoPlay()
	{
		((Button) getView().findViewById(R.id.bPlayMe)).setVisibility(View.GONE);
		((VideoView) getView().findViewById(R.id.video)).start();
		rSequencer.run();
		iResLast = -1;
	}

	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener()
	{
		@Override
		public void onCompletion(MediaPlayer arg0)
		{
			((TextView) getView().findViewById(R.id.caption)).setText(R.string.s_RoadText);
			((Button) getView().findViewById(R.id.bPlayMe)).setVisibility(View.VISIBLE);
			// ((VideoView) getView().findViewById( R.id.video
			// )).setVisibility(View.INVISIBLE);
		}
	};
	
	private static int iResLast;
	
	private Runnable rSequencer = new Runnable()
	{ // Do something to the UI thread here
		@Override
		public void run()
		{ // This method runs in the same thread as the UI.
			int iVideoCur = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition() / 1000;
			if (iVideoCur > 0)
			{
				int iCur = getCurrentCaptionIndex(iCaptionStart, iVideoCur);
				if ((iCur != -1) && (iResLast != iCur))
				{
					((TextView) getView().findViewById(R.id.caption)).setText(iCaptionId[iCur]);
					iResLast = iCur;
				}
			}
			sHandler.postDelayed(rSequencer, 1000);
		}
	};

	private int getCurrentCaptionIndex(int[] iList, int iVideoPos)
	{
		int i = 0;
		while (i < iList.length)
		{
			if (iList[i] > iVideoPos)
				return ((i <= iList.length) ? i - 1 : i);
			i++;
		}
		return ((iList[i - 1] <= iVideoPos) ? i - 1 : -1);
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.guidedimageryforest);
		i.putExtra("RID_Text", R.string.s_35a12help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
