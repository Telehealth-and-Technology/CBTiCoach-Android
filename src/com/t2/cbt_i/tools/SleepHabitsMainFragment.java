package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class SleepHabitsMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitsmain_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_CreateNewSleepHabits));
		
		// middle buttons
		((Button) getView().findViewById(R.id.bSetCaffeineGoals)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the button
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleephabitsfragment, new SleepHabitsCaffeineFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bSetUpYourSleepEnvironment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the button

				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleephabitsfragment, new SleepHabitsSleepEnvironmentSetupFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGotoBedOnlyWhenSleepy)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the button

				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleephabitsfragment, new SleepHabitsGoToBedOnlyWhenSleepyFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGetoutofBedWhenyoucantSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the button

				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleephabitsfragment, new SleepHabitsGetOutOfBedWhenCantSleepFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGetoutofBedatyourPrescribedTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.sleephabitsfragment, new SleepHabitsGetOutOfBedOnTimeFragment());
			    ft.commit();
			}
		});
	}

	@Override
	public void getHelp()
	{
		final FragmentManager fm = getFragmentManager();
		CBTi_BaseFragment current = (CBTi_BaseFragment) fm.findFragmentById(R.id.sleephabitsfragment);
		if(!(current instanceof SleepHabitsMainFragment))
		{
			this.goingToHelp = true;
			current.getHelp();
		}
		else
		{
			this.goingToHelp = true;
			Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
			i.putExtra("RID_Img", R.drawable.buddy_toolscreatenewsleephabits);
			i.putExtra("RID_Text", R.string.s_34b);
			getSherlockActivity().startActivity(i);
			getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
		}
	}
}
