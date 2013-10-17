package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentViewScoresFragment extends CBTi_BaseFragment
{
	AssessmentQuestionnaireData cData31c;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentviewscores, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Assessment));

		AssessmentStartData cData31b = new AssessmentStartData(getSherlockActivity());
		Bundle b = this.getArguments();
		int iEntry = b.getInt("POS");
		cData31c = cData31b.alISIData.get(iEntry);

		// done Button
		((Button) getView().findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				// handle the done button
				getFragmentManager().popBackStack();
			}
		});

		// schedule Button
		((Button) getView().findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ 
				// handle the schedule button
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
		this.goingToHelp = true;
	}

	@Override
	public void onResume()
	{
		super.onResume();

		((TextView) getView().findViewById(R.id.tISIScore)).setText(String.format(getString(R.string.s_ISI_Score), cData31c.iCumScore));
		((TextView) getView().findViewById(R.id.tISIScore01)).setText(String.format(getString(R.string.s_ISI_Score01), cData31c.iScore[0]));
		((TextView) getView().findViewById(R.id.tISIScore02)).setText(String.format(getString(R.string.s_ISI_Score02), cData31c.iScore[1]));
		((TextView) getView().findViewById(R.id.tISIScore03)).setText(String.format(getString(R.string.s_ISI_Score03), cData31c.iScore[2]));
		((TextView) getView().findViewById(R.id.tISIScore04)).setText(String.format(getString(R.string.s_ISI_Score04), cData31c.iScore[3]));
		((TextView) getView().findViewById(R.id.tISIScore05)).setText(String.format(getString(R.string.s_ISI_Score05), cData31c.iScore[4]));
		((TextView) getView().findViewById(R.id.tISIScore06)).setText(String.format(getString(R.string.s_ISI_Score06), cData31c.iScore[5]));
		((TextView) getView().findViewById(R.id.tISIScore07)).setText(String.format(getString(R.string.s_ISI_Score07), cData31c.iScore[6]));
	}

}