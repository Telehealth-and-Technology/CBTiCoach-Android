package com.t2.cbt_i.mysleep;

import android.app.AlertDialog;
import android.app.Dialog;
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

public class AssessmentStartFragment extends CBTi_BaseFragment
{
	AssessmentStartData cData31b;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentstart, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Assessment));
		setHasOptionsMenu(true);
		
		// ProviderToggle Button
		((ToggleButton) getView().findViewById(R.id.bProvider)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
			}
		});

		// Take Assessment Button
		((Button) getView().findViewById(R.id.bTakeNow)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the button
				
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
	
	static final int DIALOG_ISIERROR = 1;

	public Dialog showDialog(int id)
	{
		switch (id)
		{
		case DIALOG_ISIERROR:
			new AlertDialog.Builder(getSherlockActivity()).setMessage(getString(R.string.s_ISIError)).setPositiveButton("OK", null).create().show();
			break;
		}
		return null;
	}

	@Override
	public void onPause()
	{
		cData31b.bProvider = ((ToggleButton) getView().findViewById(R.id.bProvider)).isChecked();
		cData31b.saveData(); // save data to file
		super.onPause();
	}

	@Override
	public void onResume()
	{
		cData31b = new AssessmentStartData(getSherlockActivity());

		if (cData31b.withinAWeek() && !AssessmentMainFragment.goingBacktoMain)
		{
			final FragmentManager fm = getFragmentManager();
			//Pop the back stack to prevent a infinite loop of going to the start fragment and then back to the takentoosonn one and so on
			fm.popBackStack();
		    final FragmentTransaction ft = fm.beginTransaction();					    
		    ft.addToBackStack(null);
		    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
	        ft.replace(R.id.assessmentfragment, new AssessmentTakenTooSoonFragment());
		    ft.commit();
		}
		else
		{
			((ToggleButton) getView().findViewById(R.id.bProvider)).setChecked(cData31b.bProvider);
		}

		super.onResume();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_assessmenthelp);
		i.putExtra("RID_Text", R.string.s_31bhelp);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}