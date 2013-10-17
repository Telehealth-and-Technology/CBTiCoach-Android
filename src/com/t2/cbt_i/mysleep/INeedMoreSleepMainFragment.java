package com.t2.cbt_i.mysleep;

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

public class INeedMoreSleepMainFragment extends CBTi_BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_ineedmoresleepmain_fragment, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getSherlockActivity().getResources().getString(R.string.s_NeedSleep));
		setHasOptionsMenu(true);
		
		// Start Questionnaire Button
		((Button) getView().findViewById(R.id.bStartQuestionaire)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				INeedMoreSleepQuestionnaireAnswersData cData23c = new INeedMoreSleepQuestionnaireAnswersData(getSherlockActivity());
				cData23c.deleteData();


				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();					    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.ineedmoresleepfragment, new INeedMoreSleepQuestionnaireFragment());
			    ft.commit();
			    
//				Intent i = new Intent(getSherlockActivity(), INeedMoreSleepQuestionnaireFragment.class);
//				getSherlockActivity().startActivity(i);
//				getSherlockActivity().overridePendingTransition(R.anim.slide_left, R.anim.slide_left2);
			}
		});
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_mysleepineedmoresleep);
		i.putExtra("RID_Text", R.string.s_23b);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}

}
