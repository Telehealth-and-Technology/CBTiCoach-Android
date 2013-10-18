package com.t2.cbt_i.tools;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class SleepHabitsSleepEnvironmentSetupFragment extends CBTi_BaseFragment
{
	SleepHabitsSleepEnvironmentData cData34f;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.tools_sleephabitssleepenvironmentsetup, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);		
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Environment));
		setHasOptionsMenu(true);

		cData34f = new SleepHabitsSleepEnvironmentData(getSherlockActivity());

		((Button) getView().findViewById(R.id.bLownoiselevel)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!((ToggleButton) v).isChecked())
					showDialog(DIALOG_LNL);
			}
		});

		((Button) getView().findViewById(R.id.bRoomisdark)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!((ToggleButton) v).isChecked())
					showDialog(DIALOG_RID);
			}
		});

		((Button) getView().findViewById(R.id.bTemperatureiscomfortable)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!((ToggleButton) v).isChecked())
					showDialog(DIALOG_TIC);
			}
		});

		((Button) getView().findViewById(R.id.bSleepisundisturbedbyothers)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!((ToggleButton) v).isChecked())
					showDialog(DIALOG_SIU);
			}
		});

		((Button) getView().findViewById(R.id.bReservemybedforsleepsex)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!((ToggleButton) v).isChecked())
					showDialog(DIALOG_RSS);
			}
		});

	}

	@Override
	public void onResume()
	{
		cData34f = new SleepHabitsSleepEnvironmentData(getSherlockActivity());
		((ToggleButton) getView().findViewById(R.id.bLownoiselevel)).setChecked(cData34f.bLownoiselevel);
		((ToggleButton) getView().findViewById(R.id.bRoomisdark)).setChecked(cData34f.bRoomisdark);
		((ToggleButton) getView().findViewById(R.id.bTemperatureiscomfortable)).setChecked(cData34f.bTemperatureiscomfortable);
		((ToggleButton) getView().findViewById(R.id.bSleepisundisturbedbyothers)).setChecked(cData34f.bSleepisundisturbedbyothers);
		((ToggleButton) getView().findViewById(R.id.bReservemybedforsleepsex)).setChecked(cData34f.bReervermybeddforsleepsex);

		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData34f.bLownoiselevel = ((ToggleButton) getView().findViewById(R.id.bLownoiselevel)).isChecked();
		cData34f.bRoomisdark = ((ToggleButton) getView().findViewById(R.id.bRoomisdark)).isChecked();
		cData34f.bTemperatureiscomfortable = ((ToggleButton) getView().findViewById(R.id.bTemperatureiscomfortable)).isChecked();
		cData34f.bSleepisundisturbedbyothers = ((ToggleButton) getView().findViewById(R.id.bSleepisundisturbedbyothers)).isChecked();
		cData34f.bReervermybeddforsleepsex = ((ToggleButton) getView().findViewById(R.id.bReservemybedforsleepsex)).isChecked();
		cData34f.saveData();

		super.onPause();
	}

	private static final int DIALOG_LNL = 41;
	private static final int DIALOG_RID = 42;
	private static final int DIALOG_TIC = 43;
	private static final int DIALOG_SIU = 44;
	private static final int DIALOG_RSS = 45;

	
	private Dialog showDialog(int id)
	{
		Builder builder = new AlertDialog.Builder(getSherlockActivity());
		switch (id)
		{
		case DIALOG_LNL:
			builder.setMessage(getString(R.string.s_Lownoiseleveltext));
			break;

		case DIALOG_RID:
			builder.setMessage(getString(R.string.s_Roomisdarktext));
			break;

		case DIALOG_TIC:
			builder.setMessage(getString(R.string.s_Temperatureiscomfortabletext));
			break;

		case DIALOG_SIU:
			builder.setMessage(getString(R.string.s_Sleepisundisturbedbyotherstext));
			break;

		case DIALOG_RSS:
			builder.setMessage(getString(R.string.s_Reservemybedforsleepsextext));
			break;
		}
		builder.setPositiveButton("OK", null).create().show();
		return null;
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_homelearn);
		i.putExtra("RID_Text", R.string.s_40b);
		startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}
}