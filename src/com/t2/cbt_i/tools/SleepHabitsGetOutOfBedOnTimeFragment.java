package com.t2.cbt_i.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class SleepHabitsGetOutOfBedOnTimeFragment extends CBTi_BaseFragment
{

	SleepHabitsGetOutOfBedOnTimeData cData34c2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitsgetoutofbedontime, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		getSherlockActivity().getSupportActionBar().setTitle(getSherlockActivity().getResources().getString(R.string.s_GetoutofBedatyourPrescribedTime));

		((CheckBox) getView().findViewById(R.id.cbGetOut01)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut02)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut03)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut04)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut05)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut06)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut07)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut08)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut09)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut10)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut11)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut12)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut13)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut14)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut15)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut16)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut17)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut18)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut19)).setOnClickListener(GetOutOCL);
		((CheckBox) getView().findViewById(R.id.cbGetOut20)).setOnClickListener(GetOutOCL);
	}

	// On click listener for button1
	final OnClickListener GetOutOCL = new OnClickListener()
	{
		@Override
		public void onClick(final View v)
		{

			Boolean bState = false;
			int id = v.getId();
			int iButton = 0;

			int iStart = 0;
			if (id == R.id.llGetOut01 || id == R.id.cbGetOut01)
			{
				iStart = 0;
				iButton = R.id.cbGetOut01;
			}
			else if (id == R.id.llGetOut02 || id == R.id.cbGetOut02)
			{
				iStart = 1;
				iButton = R.id.cbGetOut02;
			}
			else if (id == R.id.llGetOut03 || id == R.id.cbGetOut03)
			{
				iStart = 2;
				iButton = R.id.cbGetOut03;
			}
			else if (id == R.id.llGetOut04 || id == R.id.cbGetOut04)
			{
				iStart = 3;
				iButton = R.id.cbGetOut04;
			}
			else if (id == R.id.llGetOut05 || id == R.id.cbGetOut05)
			{
				iStart = 4;
				iButton = R.id.cbGetOut05;
			}
			else if (id == R.id.llGetOut06 || id == R.id.cbGetOut06)
			{
				iStart = 5;
				iButton = R.id.cbGetOut06;
			}
			else if (id == R.id.llGetOut07 || id == R.id.cbGetOut07)
			{
				iStart = 6;
				iButton = R.id.cbGetOut07;
			}
			else if (id == R.id.llGetOut08 || id == R.id.cbGetOut08)
			{
				iStart = 7;
				iButton = R.id.cbGetOut08;
			}
			else if (id == R.id.llGetOut09 || id == R.id.cbGetOut09)
			{
				iStart = 8;
				iButton = R.id.cbGetOut09;
			}
			else if (id == R.id.llGetOut10 || id == R.id.cbGetOut10)
			{
				iStart = 9;
				iButton = R.id.cbGetOut10;
			}
			else if (id == R.id.llGetOut11 || id == R.id.cbGetOut11)
			{
				iStart = 10;
				iButton = R.id.cbGetOut11;
			}
			else if (id == R.id.llGetOut12 || id == R.id.cbGetOut12)
			{
				iStart = 11;
				iButton = R.id.cbGetOut12;
			}
			else if (id == R.id.llGetOut13 || id == R.id.cbGetOut13)
			{
				iStart = 12;
				iButton = R.id.cbGetOut13;
			}
			else if (id == R.id.llGetOut14 || id == R.id.cbGetOut14)
			{
				iStart = 13;
				iButton = R.id.cbGetOut14;
			}
			else if (id == R.id.llGetOut15 || id == R.id.cbGetOut15)
			{
				iStart = 14;
				iButton = R.id.cbGetOut15;
			}
			else if (id == R.id.llGetOut16 || id == R.id.cbGetOut16)
			{
				iStart = 15;
				iButton = R.id.cbGetOut16;
			}
			else if (id == R.id.llGetOut17 || id == R.id.cbGetOut17)
			{
				iStart = 16;
				iButton = R.id.cbGetOut17;
			}
			else if (id == R.id.llGetOut18 || id == R.id.cbGetOut18)
			{
				iStart = 17;
				iButton = R.id.cbGetOut18;
			}
			else if (id == R.id.llGetOut19 || id == R.id.cbGetOut19)
			{
				iStart = 18;
				iButton = R.id.cbGetOut19;
			}
			else if (id == R.id.llGetOut20 || id == R.id.cbGetOut20)
			{
				iStart = 19;
				iButton = R.id.cbGetOut20;
			}

			if (v.getClass().getSimpleName().equalsIgnoreCase("LinearLayout"))
			{
				bState = !((CheckBox) getView().findViewById(iButton)).isChecked();
				((CheckBox) getView().findViewById(iButton)).setChecked(bState);
			}
			else
			{
				if (v.isSelected())
					v.setSelected(false);
				else
					v.setSelected(true);
				bState = ((CheckBox) getView().findViewById(iButton)).isChecked();
			}
			//save new state to data store
			cData34c2.bGetOut[cData34c2.iMap[iStart]] = bState;

			// if( bState ) { // if checked place at top
			// if( iStart > 0 ) {
			// int iHold = cData34c2.iMap[iStart];
			// for( ; iStart>0 ; iStart-- )
			// cData34c2.iMap[iStart] = cData34c2.iMap[iStart-1];
			// cData34c2.iMap[0] = iHold;
			// }
			// }
			// cData34c2.renderData();
		}
	};

	@Override
	public void onResume()
	{
		cData34c2 = new SleepHabitsGetOutOfBedOnTimeData(getSherlockActivity());
		cData34c2.renderData();
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData34c2.saveData();
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_toolsgetoutofbedatyourprescribedbedtime);
		i.putExtra("RID_Text", R.string.s_34e2);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}
