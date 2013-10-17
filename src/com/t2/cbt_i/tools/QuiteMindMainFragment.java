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

public class QuiteMindMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindmain_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);  
		getSherlockActivity().getSupportActionBar().setTitle(getSherlockActivity().getResources().getString(R.string.s_ToolR08));

		((Button) getView().findViewById(R.id.bWindingDown)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindWindingDownFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bScheduleWorryTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindScheduleWorryTimeFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bChangeYourPerspective)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindChangePerspectiveFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bObserveThoughtsCloudsintheSky)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindObserveThoughtsFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bObserveSensationsBodyScan)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindObserveSensationsFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGuidedImageryForest)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindForestImageryFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGuidedImageryCountryRoad)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindCountryRoadImageryFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bGuidedImageryBeach)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindBeachImageryFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bProgressiveMuscleRelaxation)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindProgressiveMuscleRelaxationFragment());
			    ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bBreathingTool)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, new QuiteMindBreathingToolFragment());
			    ft.commit();
			}
		});

	}

	@Override
	public void getHelp()
	{
		final FragmentManager fm = getFragmentManager();
		CBTi_BaseFragment current = (CBTi_BaseFragment) fm.findFragmentById(R.id.quitemindfragment);
		if(!(current instanceof QuiteMindMainFragment))
		{
			this.goingToHelp = true;
			current.getHelp();
		}
		else
		{
			Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
			i.putExtra("RID_Img", R.drawable.buddy_toolsquietyourmind);
			i.putExtra("RID_Text", R.string.s_35b);
			getSherlockActivity().startActivity(i);
			getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
		}
	}
}
