package com.t2.cbt_i.learn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class LearnMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.learn_main_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);

		// Middle Sleep101
		((Button) getView().findViewById(R.id.bSleep101)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent();
				i.setClass(getSherlockActivity(), LearnSleep101Activity.class);
				getSherlockActivity().startActivity(i);
			}
		});

		// Middle Healthy Sleep Habits  
		((Button) getView().findViewById(R.id.bHealthySleepHabits)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent();
				i.setClass(getSherlockActivity(), LearnHealthySleepHabitsActivity.class);
				getSherlockActivity().startActivity(i);
			}
		});

		// Middle CBT-i Glossary
		((Button) getView().findViewById(R.id.bCBTiGlossary)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				Intent i = new Intent();
				i.setClass(getSherlockActivity(), LearnCBTiGlossaryActivity.class);
				getSherlockActivity().startActivity(i);
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_homelearn);
		i.putExtra("RID_Text", R.string.s_40b);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}

}
