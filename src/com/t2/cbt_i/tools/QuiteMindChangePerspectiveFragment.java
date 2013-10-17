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
import com.t2.cbt_i.dashboard.ThoughtActivity;

public class QuiteMindChangePerspectiveFragment extends CBTi_BaseFragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindchangeperspective, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle("Change Your Perspective");
		// Middle Worried About Sleep
		((Button) getView().findViewById(R.id.bWorriedAboutSleep)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				QuiteMindChangePerspectiveFragment.this.goingToHelp = true;
				Intent i = new Intent(getSherlockActivity().getApplicationContext(), ThoughtActivity.class);
				i.putExtra("THINKABOUT", true);
				startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});

		// Middle Worried About Trauma
		((Button) getView().findViewById(R.id.bWorriedAboutTrauma)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// Perform action on click
				QuiteMindChangePerspectiveFragment.this.goingToHelp = true;
				Intent i = new Intent(getSherlockActivity().getApplicationContext(), ThoughtActivity.class);
				i.putExtra("THINKABOUT", false);
				startActivity(i);
				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity().getApplicationContext(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsperspective);
		i.putExtra("RID_Text", R.string.s_35e2);
		startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}