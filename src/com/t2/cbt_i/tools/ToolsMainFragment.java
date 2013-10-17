package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class ToolsMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_main, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        
		// Middle New Sleep Habits
		((Button) getView().findViewById(R.id.bCreateNewSleepHabits)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(getSherlockActivity(), SleepHabitsMainActivity.class);
				startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// Middle Quiet Your Mind
		((Button) getView().findViewById(R.id.bQuietYourMind)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(getSherlockActivity(), QuiteMindMainActivity.class);
				startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// Middle Prevent Insomnia in the Future
		((Button) getView().findViewById(R.id.bPreventInsomniaintheFuture)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent(getSherlockActivity(), PreventInsomniaActivity.class);
				startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolshelp);
		i.putExtra("RID_Text", R.string.s_30b);
		startActivity(i);
		getSherlockActivity().overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}