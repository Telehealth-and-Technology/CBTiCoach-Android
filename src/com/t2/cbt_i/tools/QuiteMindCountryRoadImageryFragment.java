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

public class QuiteMindCountryRoadImageryFragment extends CBTi_BaseFragment
{
	VideoView vvVideo;

	private int[] iCaptionId = { R.string.s_Road01, R.string.s_Road02, R.string.s_Road03, R.string.s_Road04, R.string.s_Road05, R.string.s_Road06,
			R.string.s_Road07, R.string.s_Road08, R.string.s_Road09, R.string.s_Road10, R.string.s_Road11, R.string.s_Road12, R.string.s_Road13,
			R.string.s_Road14, R.string.s_Road15, R.string.s_Road16, R.string.s_Road17, R.string.s_Road18, R.string.s_Road19, R.string.s_Road20,
			R.string.s_Road21, R.string.s_Road22, R.string.s_Road23, R.string.s_Road24, R.string.s_Road25, R.string.s_Road26, R.string.s_Road27,
			R.string.s_Road28, R.string.s_Road29, R.string.s_Road30 };
	private int[] iCaptionStart = { 1, 8, 13, 22, 26, 36, 38, 44, 55, 59, 63, 75, 79, 81, 87, 97, 100, 104, 109, 121, 124, 133, 138, 146, 155, 167, 180, 184,
			206, 214 };
	private Handler sHandler;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindcountryroadimagery, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_GuidedImageryCountryRoad));
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

		Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp3_imagerycountryroad);
		((VideoView) getView().findViewById(R.id.video)).setVideoURI(uUri);
		((VideoView) getView().findViewById(R.id.video)).setOnCompletionListener(onComplete);

		sHandler = new Handler();
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
		if (goingToHelp)
		{
			((VideoView) getView().findViewById(R.id.video)).pause();
			iVideoPos = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition();
			sHandler.removeCallbacks(rSequencer);
		}
		else
		{
			((VideoView) getView().findViewById(R.id.video)).stopPlayback();
			sHandler.removeCallbacks(rSequencer);
			iVideoPos = 0;
		}
		super.onPause();
	}

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
		i.putExtra("RID_Img", R.drawable.guidedimageryroad);
		i.putExtra("RID_Text", R.string.s_35a12help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
