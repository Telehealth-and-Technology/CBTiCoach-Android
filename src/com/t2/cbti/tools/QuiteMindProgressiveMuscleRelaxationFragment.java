/*
* QuiteMindProgressiveMuscleRelaxationFragment.java
* Fragment used to display and guide the user through the progressive muscle relaxation exercise
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright � 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright � 2009-2014 Contributors. All Rights Reserved.
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
package com.t2.cbti.tools;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbti.R;
import com.t2.cbti.classes.CBTi_BaseFragment;
import com.t2.cbti.classes.CBTi_Help;

public class QuiteMindProgressiveMuscleRelaxationFragment extends CBTi_BaseFragment
{

	private int[] iCaptionId = { R.string.s_muscle01, R.string.s_muscle02, R.string.s_muscle03, R.string.s_muscle04, R.string.s_muscle05, R.string.s_muscle06,
			R.string.s_muscle07, R.string.s_muscle08, R.string.s_muscle09, R.string.s_muscle10, R.string.s_muscle11, R.string.s_muscle12, R.string.s_muscle13,
			R.string.s_muscle14, R.string.s_muscle15, R.string.s_muscle16, R.string.s_muscle17, R.string.s_muscle18, R.string.s_muscle19, R.string.s_muscle20,
			R.string.s_muscle21, R.string.s_muscle22, R.string.s_muscle23, R.string.s_muscle24, R.string.s_muscle25, R.string.s_muscle26, R.string.s_muscle27,
			R.string.s_muscle28, R.string.s_muscle29, R.string.s_muscle30, R.string.s_muscle31, R.string.s_muscle32, R.string.s_muscle33, R.string.s_muscle34,
			R.string.s_muscle35, R.string.s_muscle36, R.string.s_muscle37, R.string.s_muscle38, R.string.s_muscle39, R.string.s_muscle40, R.string.s_muscle41,
			R.string.s_muscle42, R.string.s_muscle43, R.string.s_muscle44, R.string.s_muscle45, R.string.s_muscle46, R.string.s_muscle47, R.string.s_muscle48,
			R.string.s_muscle49, R.string.s_muscle50, R.string.s_muscle51, R.string.s_muscle52, R.string.s_muscle53 };
	private int[] iCaptionStart = { 0, 10, 14, 17, 27, 35, 43, 52, 59, 69, 77, 86, 93, 103, 107, 115, 129, 135, 139, 150, 165, 177, 186, 194, 211, 218, 224,
			236, 242, 245, 252, 254, 264, 276, 293, 311, 320, 329, 336, 353, 360, 364, 380, 399, 416, 422, 429, 459, 466, 475, 493, 502, 528 };

	private int[] iResId = { R.drawable.toolsmusclerelaxation_bodyarms, R.drawable.toolsmusclerelaxation_bodyhead,
			R.drawable.toolsmusclerelaxation_bodyshoulders, R.drawable.toolsmusclerelaxation_bodystomach, R.drawable.toolsmusclerelaxation_bodybutt,
			R.drawable.toolsmusclerelaxation_bodyfeet, R.drawable.toolsmusclerelaxation_bodyall };
	private int[] iResIdStart = { 59, 115, 186, 242, 293, 353, 429 };
	private Handler sHandler;
	private boolean isPlaying;

	/**
	 * Initializes the VideoView and the caption handler
	 * @param initial
	 */
	private void setup(boolean initial)
	{
		if (!initial)
		{
			Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp3_progressivemr);
			((VideoView) getView().findViewById(R.id.video)).setVideoURI(uUri);
			((VideoView) getView().findViewById(R.id.video)).setOnCompletionListener(onComplete);

			sHandler = new Handler();
		}
	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindprogressivemusclerelaxation, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_ProgressiveMuscleRelaxation));
		setHasOptionsMenu(true);

		setup(true);
		((TextView) getView().findViewById(R.id.caption)).setText(R.string.s_35a11);

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
	}

	/**
	 * Switches layout to the video playing layout, setups the views and then starts the video
	 */
	private void videoPlay()
	{
		RelativeLayout main = (RelativeLayout) getView().findViewById(R.id.progressivemusclemainlayout);
		main.removeAllViews();
		main.addView(View.inflate(getSherlockActivity(), R.layout.tools_quitemindprogressivemusclerelaxationvideoplaying, null));
		setup(false);

		((ImageView) getView().findViewById(R.id.iImage)).setImageResource(R.drawable.toolsmusclerelaxation_body);
		((ImageView) getView().findViewById(R.id.iImageOverlay)).setVisibility(View.VISIBLE);
		((RelativeLayout) getView().findViewById(R.id.rlPMR)).setBackgroundColor(Color.BLACK);
		((RelativeLayout) getView().findViewById(R.id.rlPMRC)).setBackgroundColor(Color.BLACK);

		TextView mTextView = (TextView) getView().findViewById(R.id.caption);
		ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) mTextView.getLayoutParams();
		mlp.setMargins(0, 0, 0, 0);

		// PAUSE setup here because it only occurs in tools_quitemindprogressivemusclerelaxationvideoplaying
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
		
		// PLAY setup again here because its functionality changes once the video starts
		((Button) getView().findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				isPlaying = true;
				((VideoView) getView().findViewById(R.id.video)).start();
				((VideoView) getView().findViewById(R.id.video)).seekTo(iVideoPos);
				rSequencer.run();
			}
		});
		
		//Start the video and seek to location
		((VideoView) getView().findViewById(R.id.video)).start();

		iResLast = iResLast2 = -1;
		rSequencer.run();
	}

	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener()
	{

		@Override
		public void onCompletion(MediaPlayer arg0)
		{
			RelativeLayout main = (RelativeLayout) getView().findViewById(R.id.progressivemusclemainlayout);
			main.removeAllViews();
			main.addView(View.inflate(getSherlockActivity(), R.layout.tools_quitemindprogressivemusclerelaxation, null));

			iVideoPos = 0;
			setup(false);
			((TextView) getView().findViewById(R.id.caption)).setText(R.string.s_35a11);
		}
	};

	/**
	 * Calculates the current caption index given the caption position list and the video position
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

	private static int iVideoPos = 0;

	@Override
	public void onResume()
	{
		if (iVideoPos > 0 && (VideoView) getView().findViewById(R.id.video) != null)
		{
			videoPlay();
		}
		super.onResume();
	}

	@Override
	public void onPause()
	{
		if (goingToHelp || isPlaying && (VideoView) getView().findViewById(R.id.video) != null)
		{
			((VideoView) getView().findViewById(R.id.video)).pause();
			iVideoPos = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition();
			sHandler.removeCallbacks(rSequencer);
		}
		else if ((VideoView) getView().findViewById(R.id.video) != null)
		{
			((VideoView) getView().findViewById(R.id.video)).stopPlayback();
			sHandler.removeCallbacks(rSequencer);
			iVideoPos = 0;
		}
		super.onPause();
	}

	private static int iResLast, iResLast2;
	/**
	 * Synchronizes the captions with the video
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
				iCur = getCurrentCaptionIndex(iResIdStart, iVideoCur);
				if ((iCur != -1) && (iResLast2 != iCur))
				{
					((ImageView) getView().findViewById(R.id.iImageOverlay)).setImageResource(iResId[iCur]);
					iResLast2 = iCur;
				}
			}
			sHandler.postDelayed(rSequencer, 1000);
		}
	};

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsprogressivemusclerelaxation);
		i.putExtra("RID_Text", R.string.s_35a11help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
