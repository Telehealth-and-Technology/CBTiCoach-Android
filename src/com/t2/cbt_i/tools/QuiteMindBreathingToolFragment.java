/*
* QuiteMindBreathingToolFragment
* Fragment that serves as the breathing tool, playing the guiding audio, managing the captions and display the breathing red, yellow and green visual aids
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

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class QuiteMindBreathingToolFragment extends CBTi_BaseFragment
{

	private int[] iCaptionId = { R.string.s_btool01, R.string.s_btool02, R.string.s_btool03, R.string.s_btool04, R.string.s_btool05, R.string.s_btool06,
			R.string.s_btool07, R.string.s_btool08, R.string.s_btool09, R.string.s_btool10, R.string.s_btool11, R.string.s_btool12, R.string.s_btool13,
			R.string.s_btool14, R.string.s_btool15, R.string.s_btool16, R.string.s_btool17, R.string.s_btool18, R.string.s_btool19, R.string.s_btool20,
			R.string.s_btool21, R.string.s_btool22, R.string.s_btool23, R.string.s_btool24, R.string.s_btool25, R.string.s_btool26, R.string.s_btool27,
			R.string.s_btool28, R.string.s_btool29, R.string.s_btool30, R.string.s_btool31, R.string.s_btool32, R.string.s_btool33, R.string.s_btool34,
			R.string.s_btool35, R.string.s_btool36, R.string.s_btool37, R.string.s_btool38, R.string.s_btool39, R.string.s_btool40, R.string.s_btool41,
			R.string.s_btool42, R.string.s_btool43, R.string.s_btool44, R.string.s_btool45, R.string.s_btool46, R.string.s_btool47, R.string.s_btool48,
			R.string.s_btool49, R.string.s_btool50, R.string.s_btool51, R.string.s_btool52, R.string.s_btool53, R.string.s_btool54, R.string.s_btool55,
			R.string.s_btool56, R.string.s_btool57, R.string.s_btool58, R.string.s_btool59, R.string.s_btool60, R.string.s_btool61, R.string.s_btool62,
			R.string.s_btool63, R.string.s_btool64, R.string.s_btool65, R.string.s_btool66, R.string.s_btool67 };
	private int[] iCaptionStart = { 1, 10, 18, 32, 38, 43, 51, 57, 59, 66, 72, 75, 77, 84, 92, 98, 105, 113, 117, 120, 127, 132, 135, 138, 141, 145, 148, 151,
			155, 160, 162, 166, 170, 173, 176, 180, 182, 187, 190, 194, 197, 202, 204, 208, 211, 216, 218, 223, 225, 230, 233, 236, 239, 244, 246, 250, 253,
			261, 266, 272, 275, 278, 281, 287, 292, 295, 296 };

	private int[] iCaptionId2 = { R.string.s_One, R.string.s_Relax, R.string.s_Two, R.string.s_Relax, R.string.s_Three, R.string.s_Relax, R.string.s_Four,
			R.string.s_Relax, R.string.s_Five, R.string.s_Relax, R.string.s_Six, R.string.s_Relax, R.string.s_Seven, R.string.s_Relax, R.string.s_Eight,
			R.string.s_Relax, R.string.s_Eight, R.string.s_Relax, R.string.s_Seven, R.string.s_Relax, R.string.s_Six, R.string.s_Relax, R.string.s_Five,
			R.string.s_Relax, R.string.s_Four, R.string.s_Relax, R.string.s_Three, R.string.s_Relax, R.string.s_Two, R.string.s_Relax };
	private int[] iCaptionStart2 = { 73, 77, 87, 93, 100, 106, 115, 121, 130, 135, 144, 148, 157, 163, 172, 177, 186, 192, 199, 206, 215, 220, 229, 234, 242,
			250, 255, 259, 272, 278 };

	private int[] iResId = { R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred,
			R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen,
			R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow,
			R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred,
			R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen,
			R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow,
			R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred,
			R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen,
			R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow,
			R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred,
			R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen,
			R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow,
			R.drawable.breathingtoolballred, R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred,
			R.drawable.breathingtooltalltreen, R.drawable.breathingtoolballyellow, R.drawable.breathingtoolballred };
	private int[] iResIdStart = { 43, 49, 51, 59, 64, 66, 71, 75, 77, 84, 90, 92, 97, 103, 105, 112, 116, 120, 127, 133, 135, 141, 146, 148, 155, 160, 162,
			170, 174, 176, 183, 188, 190, 197, 202, 204, 210, 216, 218, 225, 231, 233, 239, 244, 246, 253, 259, 261, 266, 273, 275, 281, 285, 287 };

	int iAnimInDuration = 3500;
	int iAnimOutDuration = 4000;
	private Handler sHandler;

	ImageView iImageOverlay, iImage;
	RelativeLayout rSelf;
	TextView tCaption, tCaption2;
	Button bPlayMe;
	VideoView vVideo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindbreathingtool, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_BreathingTool));
		setHasOptionsMenu(true);

		iImageOverlay = (ImageView) getView().findViewById(R.id.iImageOverlay);
		iImage = (ImageView) getView().findViewById(R.id.iImage);
		tCaption = (TextView) getView().findViewById(R.id.caption);
		tCaption2 = (TextView) getView().findViewById(R.id.caption2);
		bPlayMe = (Button) getView().findViewById(R.id.bPlayMe);
		vVideo = (VideoView) getView().findViewById(R.id.video);
		rSelf = (RelativeLayout) getView().findViewById(R.id.rlSelf);

		// PLAY
		bPlayMe.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});

		Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp3_deepbreathing);
		vVideo.setVideoURI(uUri);
		vVideo.setOnCompletionListener(onComplete);

		sHandler = new Handler();
	}

	private void videoPlay()
	{
		bPlayMe.setVisibility(View.GONE);
		iImage.setVisibility(View.INVISIBLE);
		tCaption.setTextColor(Color.WHITE);
		rSelf.setBackgroundColor(Color.BLACK);

		ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) tCaption.getLayoutParams();
		mlp.setMargins(0, 0, 0, 0);
		iResLast = iResLast2 = iResLast3 = -1;
		rSequencer.run();

		vVideo.setVisibility(View.VISIBLE);
		vVideo.seekTo(iVideoPos);
		vVideo.start();
	}

	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener()
	{
		@Override
		public void onCompletion(MediaPlayer arg0)
		{
			iImage.setVisibility(View.VISIBLE);
			iImageOverlay.setVisibility(View.INVISIBLE);
			ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) tCaption.getLayoutParams();
			double dMarg = 70.0 * getResources().getDisplayMetrics().density;
			mlp.setMargins(0, 0, 0, (int) dMarg);
			tCaption.setText(R.string.s_35a10);
			bPlayMe.setVisibility(View.VISIBLE);
			tCaption.setTextColor(Color.BLACK);
			rSelf.setBackgroundResource(R.drawable.bg_bggraystriped);
		}
	};

	private int iVideoPos;

	@Override
	public void onResume()
	{
		if (iVideoPos > 0)
		{
			videoPlay();
		}
		super.onResume();
	}
	
	@Override
	public void onPause()
	{
		if (goingToHelp && vVideo != null)
		{
			vVideo.pause();
			iVideoPos = vVideo.getCurrentPosition();
			sHandler.removeCallbacks(rSequencer);
			iImageOverlay.clearAnimation();
			tCaption2.clearAnimation();
		}
		else if (vVideo != null)
		{
			vVideo.stopPlayback();
			sHandler.removeCallbacks(rSequencer);
		}
		super.onPause();
	}

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

	private static int iResLast, iResLast2, iResLast3;
	private Runnable rSequencer = new Runnable()
	{ // Do something to the UI thread here
		@Override
		public void run()
		{ // This method runs in the same thread as the UI.
			int iVideoCur = vVideo.getCurrentPosition() / 1000;
			if (iVideoCur > 0)
			{
				int iCur = getCurrentCaptionIndex(iCaptionStart, iVideoCur);
				if ((iCur != -1) && (iResLast != iCur))
				{
					tCaption.setText(iCaptionId[iCur]);
					iResLast = iCur;
				}

				int iCur2 = getCurrentCaptionIndex(iCaptionStart2, iVideoCur);
				if ((iCur2 != -1) && (iResLast2 != iCur2))
				{
					tCaption.setText(iCaptionId[iCur]);
					tCaption2.clearAnimation();
					Animation fadeOutt = new AlphaAnimation(1, 0);
					fadeOutt.setInterpolator(new AccelerateInterpolator()); // and
																			// this
					fadeOutt.setDuration(iAnimOutDuration);
					Animation scaleOutt = new ScaleAnimation(1.0f, .1f, 1.0f, .1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
					scaleOutt.setDuration(iAnimOutDuration);
					AnimationSet asetOutt = new AnimationSet(true);
					asetOutt.addAnimation(scaleOutt);
					asetOutt.addAnimation(fadeOutt);
					asetOutt.setAnimationListener(new AnimationListener()
					{
						@Override
						public void onAnimationEnd(Animation animation)
						{
							tCaption2.setText(""); // blank it out
							tCaption2.clearAnimation();
						}

						@Override
						public void onAnimationRepeat(Animation animation) { }

						@Override
						public void onAnimationStart(Animation animation) { }
					});
					tCaption2.setText(iCaptionId2[iCur2]);
					tCaption2.setAnimation(asetOutt);
					iResLast2 = iCur2;
				}

				int iCur3 = getCurrentCaptionIndex(iResIdStart, iVideoCur);
				if ((iCur3 != -1) && (iResLast3 != iCur3))
				{
					iImageOverlay.clearAnimation();
					AnimationSet asetAnim = null;
					switch (iResId[iCur3])
					{
					case R.drawable.breathingtooltalltreen:
						Animation fadeIn = new AlphaAnimation(0, 1);
						fadeIn.setInterpolator(new DecelerateInterpolator());
						fadeIn.setDuration(iAnimInDuration);
						Animation scaleIn = new ScaleAnimation(.1f, 1.0f, .1f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
						scaleIn.setDuration(iAnimInDuration);
						AnimationSet asetIn = new AnimationSet(true);
						asetIn.addAnimation(scaleIn);
						asetIn.addAnimation(fadeIn);
						asetAnim = asetIn;
						asetIn.setAnimationListener(new AnimationListener()
						{
							@Override
							public void onAnimationEnd(Animation animation)
							{
								iImageOverlay.clearAnimation();
							}

							@Override
							public void onAnimationRepeat(Animation animation) { }

							@Override
							public void onAnimationStart(Animation animation) { }
						});
						break;

					case R.drawable.breathingtoolballyellow:
						iImageOverlay.clearAnimation();
						tCaption2.clearAnimation();
						break;

					case R.drawable.breathingtoolballred:
						Animation fadeOut = new AlphaAnimation(1, 0);
						fadeOut.setInterpolator(new AccelerateInterpolator());
						fadeOut.setDuration(iAnimOutDuration);
						Animation scaleOut = new ScaleAnimation(1.0f, .1f, 1.0f, .1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
						scaleOut.setDuration(iAnimOutDuration);
						AnimationSet asetOut = new AnimationSet(true);
						asetOut.addAnimation(scaleOut);
						asetOut.addAnimation(fadeOut);
						asetAnim = asetOut;
						asetOut.setAnimationListener(new AnimationListener()
						{
							@Override
							public void onAnimationEnd(Animation animation)
							{
								iImageOverlay.clearAnimation();
								iImageOverlay.setVisibility(View.INVISIBLE);
							}

							@Override
							public void onAnimationRepeat(Animation animation) { }

							@Override
							public void onAnimationStart(Animation animation) { }
						});
						break;
					}
					iImageOverlay.setImageResource(iResId[iCur3]);
					if (asetAnim != null)
						iImageOverlay.setAnimation(asetAnim);
					iImageOverlay.setVisibility(View.VISIBLE);
					iResLast3 = iCur3;
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
		i.putExtra("RID_Img", R.drawable.buddy_toolsbreathingtool);
		i.putExtra("RID_Text", R.string.s_35a10help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
