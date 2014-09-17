/*
* QuiteMindBeachImageryFragment.java
* Fragment that serves as gateway into the beach imagery video but also plays the beach imagery and manages the captions
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright © 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright © 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
package com.t2.cbt_i.tools;

import android.annotation.SuppressLint;
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

public class QuiteMindBeachImageryFragment extends CBTi_BaseFragment
{
	private int[] iCaptionId = { R.string.s_Beach01, R.string.s_Beach02, R.string.s_Beach03, R.string.s_Beach04, R.string.s_Beach05, R.string.s_Beach06,
			R.string.s_Beach07, R.string.s_Beach08, R.string.s_Beach09, R.string.s_Beach10, R.string.s_Beach11, R.string.s_Beach12, R.string.s_Beach13,
			R.string.s_Beach14, R.string.s_Beach15, R.string.s_Beach16, R.string.s_Beach17, R.string.s_Beach18, R.string.s_Beach19, R.string.s_Beach20,
			R.string.s_Beach21, R.string.s_Beach22, R.string.s_Beach23, R.string.s_Beach24, R.string.s_Beach25, R.string.s_Beach26, R.string.s_Beach27,
			R.string.s_Beach28, R.string.s_Beach29, R.string.s_Beach30, R.string.s_Beach31, R.string.s_Beach32, R.string.s_Beach33 };
	private int[] iCaptionStart = { 1, 9, 14, 20, 24, 30, 41, 43, 46, 51, 62, 66, 74, 90, 96, 106, 117, 126, 132, 140, 150, 162, 173, 178, 188, 200, 207, 218,
			236, 252, 261, 273, 289 };
	private Handler sHandler;
	private boolean isPlaying = false;

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindbeachimagery, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_GuidedImageryBeach));
		setHasOptionsMenu(true);
		
		// PLAY
		((Button) getView().findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				isPlaying = true;
				videoPlay();
			}
		});
		
		// PAUSE
		((Button) getView().findViewById(R.id.bPauseMe)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				isPlaying = false;
				((VideoView) getView().findViewById(R.id.video)).pause();
				iVideoPos = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition();
				sHandler.removeCallbacks(rSequencer);				
			}
		});

		Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp3_imagerybeach);
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
		if (goingToHelp || isPlaying)
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

	/**
	 * Starts the video from the beginning
	 */
	private void videoPlay()
	{
//		((Button) getView().findViewById(R.id.bPlayMe)).setVisibility(View.GONE);
		((VideoView) getView().findViewById(R.id.video)).start();
		iVideoPos = 0;
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
			// ((VideoView) getView().findViewById( R.id.video )).setVisibility(View.INVISIBLE);
		}
	};
	
	private static int iResLast;
	
	/**
	 * Calculates the caption index using the video position
	 */
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

	/**
	 * Gets the closest caption index given the list of caption markers and the video position
	 * @param iList
	 * @param iVideoPos
	 * @return
	 */
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
		i.putExtra("RID_Img", R.drawable.guidedimagerybeach);
		i.putExtra("RID_Text", R.string.s_35a12help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
