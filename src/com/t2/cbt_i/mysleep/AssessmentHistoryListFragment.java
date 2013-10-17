package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentHistoryListFragment extends CBTi_BaseFragment
{
	AssessmentStartData cData31b;
	ArrayAdapter<AssessmentQuestionnaireData> aa;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmenthistorylist, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getSherlockActivity().getResources().getString(R.string.s_AllAssessments));
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}

	private ListView lv;

	@Override
	public void onResume()
	{
		cData31b = new AssessmentStartData(getSherlockActivity());

		// Find the ListView resource.
		lv = (ListView) getView().findViewById(R.id.lvISIData);
		aa = new ArrayAdapter<AssessmentQuestionnaireData>(getSherlockActivity(), R.layout.sleepdatarow, cData31b.alISIData);
		lv.setAdapter(aa);
		lv.setEmptyView(getView().findViewById(R.id.tSleepDataEmpty));
		lv.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				AssessmentViewScoresFragment frag = new AssessmentViewScoresFragment();
				Bundle bun = new Bundle();
				bun.putInt("POS", position);
				frag.setArguments(bun);
				
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();					    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.assessmentfragment, frag);
			    ft.commit();
			}
		});

		super.onResume();
	}

}