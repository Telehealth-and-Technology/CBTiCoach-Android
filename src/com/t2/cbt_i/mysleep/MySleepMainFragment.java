package com.t2.cbt_i.mysleep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class MySleepMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_main, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);

		// middle buttons
		((Button) getView().findViewById(R.id.bSleepDiary)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				Intent i = new Intent(getSherlockActivity(), SleepDairyMainActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button) getView().findViewById(R.id.bUpdateSleepPrescription)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				Intent i = new Intent(getSherlockActivity(), UpdateSleepPrescriptionActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button) getView().findViewById(R.id.bINeedMoreSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button 23a

				Intent i = new Intent(getSherlockActivity(), INeedMoreSleepMainActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button) getView().findViewById(R.id.bAssessment)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button 23a

				Intent i = new Intent(getSherlockActivity(), AssessmentMainActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}

	@Override
	public void getHelp()
	{
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_learnusingbedroom);
		i.putExtra("RID_Text", R.string.s_20b);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}