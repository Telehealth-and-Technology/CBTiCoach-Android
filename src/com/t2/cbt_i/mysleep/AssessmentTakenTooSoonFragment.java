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

public class AssessmentTakenTooSoonFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmenttakentoosoon, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_TooEarly));
		// schedule Button
		((Button) getView().findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentScheduleReminderFragment());
				ft.commit();
			}
		});

		// take now Button
		((Button) getView().findViewById(R.id.bTakeAssessmentNow)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				AssessmentQuestionnaireData cData31c = new AssessmentQuestionnaireData(getSherlockActivity());
				cData31c.deleteData(); // start with a clean slate

				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.assessmentfragment, new AssessmentQuestionnaireFragment());
				ft.commit();
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}
}