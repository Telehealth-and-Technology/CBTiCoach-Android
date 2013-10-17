package com.t2.cbt_i.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.settings.SettingsActivity;

public class AboutMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.about_main_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_About));

		// mid Button CBTi Coach
		((Button) getView().findViewById(R.id.bCBTi)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				Intent i = new Intent(getSherlockActivity(), AboutCBTiActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Project Team
		((Button) getView().findViewById(R.id.bPTS)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				Intent i = new Intent(getSherlockActivity(), AboutProjectTeamActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Project Partners
		((Button) getView().findViewById(R.id.bPP)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{

				Intent i = new Intent(getSherlockActivity(), AboutProjectPartnersActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// mid Button Settings
		((Button) getView().findViewById(R.id.bSettings)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button

				Intent i = new Intent(getSherlockActivity(), SettingsActivity.class);
				getSherlockActivity().startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}

	@Override
	public void getHelp() { }

}
