package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class SleepDairyEntryResultsFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_sleepdairyentryresults, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_SleepData));
		
		// DONE
		((Button) getView().findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				getFragmentManager().popBackStack();
				getFragmentManager().popBackStack();
//				Intent i = new Intent(getSherlockActivity(), SleepDairyMainActivity.class);
//				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				getSherlockActivity().startActivity(i);
//				getSherlockActivity().overridePendingTransition(R.anim.slide_right, R.anim.slide_right2);
			}
		});
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		SleepDairyEntryData cData21c = new SleepDairyEntryData(getSherlockActivity());

		String s = String.format(getString(R.string.s_TotalTimeInBed), cData21c.iTIBDailymin / 60, cData21c.iTIBDailymin % 60);
		((TextView) getView().findViewById(R.id.tTotalTimeInBed)).setText(s);

		s = String.format(getString(R.string.s_TotalTimeAsleep), cData21c.iTSTDailymin / 60, cData21c.iTSTDailymin % 60);
		((TextView) getView().findViewById(R.id.tTotalTimeAsleep)).setText(s);

		s = String.format(getString(R.string.s_SleepEfficiency), cData21c.iSEDaily);
		((TextView) getView().findViewById(R.id.tSleepEfficiency)).setText(s + "%");
	}

	@Override
	public void getHelp() 
	{
		this.goingToHelp = true;
	}
}
