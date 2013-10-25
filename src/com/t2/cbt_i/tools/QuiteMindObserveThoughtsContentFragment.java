package com.t2.cbt_i.tools;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class QuiteMindObserveThoughtsContentFragment extends CBTi_BaseFragment
{
	private boolean isPlaying = false;
	private static int iVideoPos;
	public static int iRid = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (iRid == R.id.bSelfGuided)
		{
			return inflater.inflate(R.layout.tools_quitemindobservethoughts_selfguided, null);

		}
		else
		{
			return inflater.inflate(R.layout.tools_quitemindobservethoughts_audioguided, null);
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_cloudsinthesky));

		if (iRid == R.id.bSelfGuided)
		{
			((TextView) getView().findViewById(R.id.tvSelf)).setMovementMethod(new ScrollingMovementMethod());
		}
		else
		{
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
				}
			});

			Uri uUri = Uri.parse("android.resource://" + getSherlockActivity().getPackageName() + "/" + R.raw.mp4_clouds);
			((VideoView) getView().findViewById(R.id.video)).setVideoURI(uUri);
			videoPlay();
		}
	}

	@Override
	public void onResume()
	{
		if (iVideoPos > 0 && ((VideoView) getView().findViewById(R.id.video)) != null)
		{
			((VideoView) getView().findViewById(R.id.video)).seekTo(iVideoPos);
			videoPlay();
		}
		super.onResume();
	}

	@Override
	public void onPause()
	{
		if (goingToHelp || isPlaying && ((VideoView) getView().findViewById(R.id.video)) != null)
		{
			((VideoView) getView().findViewById(R.id.video)).pause();
			iVideoPos = ((VideoView) getView().findViewById(R.id.video)).getCurrentPosition();
		}
		else if (((VideoView) getView().findViewById(R.id.video)) != null)
		{
			((VideoView) getView().findViewById(R.id.video)).stopPlayback();
			iVideoPos = 0;
		}
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}

	private void videoPlay()
	{
		((VideoView) getView().findViewById(R.id.video)).start();
	}

}
