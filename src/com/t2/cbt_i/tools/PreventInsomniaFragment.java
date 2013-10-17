package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class PreventInsomniaFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_preventinsomnia_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_PreventInsomnia));
		setHasOptionsMenu(true);
		
		// SUBMIT
		((Button) getView().findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				Bundle i = new Bundle();
				i.putBoolean("PREVENT01", ((ToggleButton) getView().findViewById(R.id.bPrevent01)).isChecked());
				i.putBoolean("PREVENT02", ((ToggleButton) getView().findViewById(R.id.bPrevent02)).isChecked());
				i.putBoolean("PREVENT03", ((ToggleButton) getView().findViewById(R.id.bPrevent03)).isChecked());
				i.putBoolean("PREVENT04", ((ToggleButton) getView().findViewById(R.id.bPrevent04)).isChecked());
				i.putBoolean("PREVENT05", ((ToggleButton) getView().findViewById(R.id.bPrevent05)).isChecked());
				i.putBoolean("PREVENT06", ((ToggleButton) getView().findViewById(R.id.bPrevent06)).isChecked());
				i.putBoolean("PREVENT07", ((ToggleButton) getView().findViewById(R.id.bPrevent07)).isChecked());
				i.putBoolean("PREVENT08", ((ToggleButton) getView().findViewById(R.id.bPrevent08)).isChecked());

				PreventInsomniaResultFragment content = new PreventInsomniaResultFragment();
				content.setArguments(i);

				final FragmentManager fm = getFragmentManager();
				final FragmentTransaction ft = fm.beginTransaction();
				ft.addToBackStack(null);
				ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				ft.replace(R.id.preventinsomniafragment, content);
				ft.commit();
			}
		});

	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolspreventinsomniainthefuture);
		i.putExtra("RID_Text", R.string.s_36b);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}

}
