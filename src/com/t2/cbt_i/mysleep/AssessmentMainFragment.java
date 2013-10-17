package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentMainFragment extends CBTi_BaseFragment
{
	public static boolean goingBacktoMain = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentmain_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Assessment));
		setHasOptionsMenu(true);

		// middle buttons
		((Button) getView().findViewById(R.id.bTakeAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentStartFragment());
				ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bResultsHistory)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentHistoryGraphFragment());
				ft.commit();
			}
		});

		((Button) getView().findViewById(R.id.bScheduleAssessments)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (AssessmentMainFragment.goingBacktoMain)
					AssessmentMainFragment.goingBacktoMain = false;
				
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentScheduleReminderFragment());
				ft.commit();
			}
		});
	}
	
	@Override
	public void getHelp()
	{
		final FragmentManager fm = getFragmentManager();
		CBTi_BaseFragment current = (CBTi_BaseFragment) fm.findFragmentById(R.id.assessmentfragment);
		if (!(current instanceof AssessmentMainFragment))
		{
			this.goingToHelp = true;
			current.getHelp();
		}
		this.goingToHelp = true;
	}

}
