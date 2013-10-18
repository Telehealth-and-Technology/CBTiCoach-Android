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

public class QuiteMindObserveSensationsFragment extends CBTi_BaseFragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_quitemindobservesensations, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_bodyscan));
		setHasOptionsMenu(true);

		// middle buttons
		((Button) getView().findViewById(R.id.bAudioGuided)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				QuiteMindObserveSensationsContentFragment content = new QuiteMindObserveSensationsContentFragment();
				content.iRid = R.id.bAudioGuided;
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    //ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, content);
			    ft.commit();
			}
		});

		// middle buttons
		((Button) getView().findViewById(R.id.bSelfGuided)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				QuiteMindObserveSensationsContentFragment content = new QuiteMindObserveSensationsContentFragment();
				content.iRid = R.id.bSelfGuided;
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();
			    ft.addToBackStack(null);
			    //ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.quitemindfragment, content);
			    ft.commit();
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsobservesensationsbodyscan);
		i.putExtra("RID_Text", R.string.s_35a16help);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
