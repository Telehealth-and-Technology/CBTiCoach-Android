package com.t2.cbt_i.mysleep;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.AdapterView.OnItemSelectedListener;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTiDialogFragment;
import com.t2.cbt_i.classes.CBTi_BaseFragment;
import com.t2.cbt_i.classes.CBTi_Help;

public class UpdateSleepPrescriptionFragment extends CBTi_BaseFragment
{
	UpdateSleepPrescriptionData cData22a;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_updatesleepprescription_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_UpdateSleep));
		setHasOptionsMenu(true);
		
		// Manual Button
		((ToggleButton) getView().findViewById(R.id.bManMan)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				((ToggleButton) getView().findViewById(R.id.bManAut)).setChecked(false);
				((ToggleButton) getView().findViewById(R.id.bManMan)).setChecked(true);
				((LinearLayout) getView().findViewById(R.id.llManUpdate)).setVisibility(View.VISIBLE);
				((LinearLayout) getView().findViewById(R.id.llAutoUpdate)).setVisibility(View.GONE);
				cData22a.displaySleepPrescription();
			}
		});

		// Automatic Button
		((ToggleButton) getView().findViewById(R.id.bManAut)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				((ToggleButton) getView().findViewById(R.id.bManMan)).setChecked(false);
				((ToggleButton) getView().findViewById(R.id.bManAut)).setChecked(true);
				((LinearLayout) getView().findViewById(R.id.llManUpdate)).setVisibility(View.GONE);
				((LinearLayout) getView().findViewById(R.id.llAutoUpdate)).setVisibility(View.VISIBLE);
				enableUSPDayOfWeek();
				cData22a.iSP_PBTimemin = 480;
				cData22a.iSP_PWTimemin = 480;
				cData22a.displaySleepPrescription();
			}
		});

		((TextView) getView().findViewById(R.id.tManBedtime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_BEDTIME);
			}
		});

		((ImageButton) getView().findViewById(R.id.bManBedInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_MANBEDINFO);
			}
		});

		((TextView) getView().findViewById(R.id.tManWaketime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_WAKETIME);
			}
		});

		((ImageButton) getView().findViewById(R.id.bManWakeInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_MANWAKEINFO);
			}
		});

		((TextView) getView().findViewById(R.id.tAutoWaketime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_AUTOWAKETIME);
			}
		});

		((ImageButton) getView().findViewById(R.id.bAutoWakeInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_AUTOWAKETIMEINFO);
			}
		});

		// Update Button
		((Button) getView().findViewById(R.id.bUpdatePrescription)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the update button
				SleepDairyData cData21a = new SleepDairyData(getSherlockActivity());
				INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(getSherlockActivity());
				cData22a.iSP_SleepEfficiency = cData21a.iSEWeekly;
				if (cData21a.iPastWeek < 5 && cData22a.bManUpdate == false)
					showDialog(DIALOG_UPDATEERROR);
				else
				{
					if (cData22a.bManUpdate == true)
					{ // man update
						cData22a.iSP_PBTimemin = cData22a.iBedtimemin;
						cData22a.ii_PBTime = 1;
						cData22a.iSP_PWTimemin = cData22a.iWaketimemin;
					}
					else
					{ // auto update
						if (cData21a.iPastWeek < 5)
							showDialog(DIALOG_UPDATEERROR);
						else
						{
							cData22a.iSP_PWTimemin = cData22a.iAutoWaketimemin;
							if (cData22a.iSP_SleepEfficiency < 80)
							{ // test #1
								cData22a.iSP_PBTimemin = -2;
								cData22a.ii_PBTime = 1;
								showDialog(DIALOG_USP1);
							}
							else if (cData22a.iSP_SleepEfficiency <= 85 && ((cData23a.iScore < 13) || (cData23a.iScore == -1)))
							{ // test 6
								if (cData22a.ii_PBTime != 2)
								{ // 1st consecutive
									cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - cData21a.iTSTWeeklymin;
								}
								else
								{ // 2nd
									cData22a.iSP_PBTimemin = -2;
									showDialog(DIALOG_USP2); // same as 2
								}
								cData22a.ii_PBTime = 6;
							}
							else if (cData22a.iSP_SleepEfficiency <= 85)
							{ // test 7
								if (cData22a.iSP_PBTimemin != 7)
								{ // 1st consecutive
									cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - 300;
								}
								else
								{ // 2nd
									cData22a.iSP_PBTimemin = -2;
									showDialog(DIALOG_USP2);
								}
								cData22a.ii_PBTime = 7;
							}
							else if (cData22a.iSP_SleepEfficiency > 85 && ((cData23a.iScore < 10) || (cData23a.iScore == -1)))
							{ // test 5
								cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - cData21a.iTSTWeeklymin;
								cData22a.ii_PBTime = 5;
							}
							else if (cData22a.iSP_SleepEfficiency > 85 && (cData23a.iScore < 12))
							{ // test 3
								cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - cData21a.iTSTWeeklymin + 15;
								cData22a.ii_PBTime = 3;
							}
							else if (cData22a.iSP_SleepEfficiency > 85)
							{ // test 2
								cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - 500;
								cData22a.ii_PBTime = 3;
							}
							else if (cData22a.iSP_SleepEfficiency > 80 && (cData23a.iScore < 13))
							{ // test 4
								cData22a.iSP_PBTimemin = cData22a.iSP_PWTimemin - cData21a.iTSTWeeklymin + 30;
								cData22a.ii_PBTime = 4;
							}
						}
					}
					cData22a.saveData();
					cData22a.displaySleepPrescription();
					// Intent i = new Intent(CBTi_Activity22a.this,
					// CBTi_Activity20a.class );
					// i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					// CBTi_Activity22a.this.startActivity(i);
					// CBTi_Activity22a.this.overridePendingTransition(
					// R.anim.slide_right, R.anim.slide_right2);
				}
			}
		});
	}

	private void enableUSPDayOfWeek()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sAutoDay);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.Days, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData22a.iUSPDayofWeek, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	@Override
	public void onPause()
	{
		cData22a.bManUpdate = ((ToggleButton) getView().findViewById(R.id.bManMan)).isChecked();
		if ((Spinner) getView().findViewById(R.id.sAutoDay) != null)
			cData22a.iUSPDayofWeek = ((Spinner) getView().findViewById(R.id.sAutoDay)).getSelectedItemPosition();
		// cData22a.saveData();

		super.onPause();
	}

	@Override
	public void onResume()
	{
		SleepDairyData cData21a = new SleepDairyData(getSherlockActivity());

		// fetch the data and display either the sleep prescription or the msg
		cData22a = new UpdateSleepPrescriptionData(getSherlockActivity(), this.getView());
		cData22a.displaySleepPrescription();
		((ToggleButton) getView().findViewById(R.id.bManMan)).setChecked(cData22a.bManUpdate);
		((ToggleButton) getView().findViewById(R.id.bManAut)).setChecked(!cData22a.bManUpdate);

		((TextView) (getView().findViewById(R.id.tManBedtime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iBedtimemin));
		((TextView) (getView().findViewById(R.id.tManWaketime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iWaketimemin));
		((TextView) (getView().findViewById(R.id.tAutoWaketime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iAutoWaketimemin));
		if (cData22a.bManUpdate == true)
		{
			((LinearLayout) getView().findViewById(R.id.llManUpdate)).setVisibility(View.VISIBLE);
			((LinearLayout) getView().findViewById(R.id.llAutoUpdate)).setVisibility(View.GONE);
		}
		else
		{
			((LinearLayout) getView().findViewById(R.id.llManUpdate)).setVisibility(View.GONE);
			((LinearLayout) getView().findViewById(R.id.llAutoUpdate)).setVisibility(View.VISIBLE);
			enableUSPDayOfWeek();
			if (cData21a.iPastWeek < 5)
				showDialog(DIALOG_UPDATEERROR);
		}
		super.onResume();
	}

	private static final int DIALOG_UPDATEERROR = 41;
	private static final int DIALOG_UPDATEERROR2 = 42;
	private static final int DIALOG_UPDATEERROR3 = 43;
	private static final int DIALOG_MANBEDINFO = 44;
	private static final int DIALOG_MANWAKEINFO = 45;
	private static final int DIALOG_WAKETIME = 46;
	private static final int DIALOG_BEDTIME = 47;
	private static final int DIALOG_WTERROR = 48;
	private static final int DIALOG_AUTOWAKETIME = 49;
	private static final int DIALOG_AUTOWAKETIMEINFO = 50;
	private static final int DIALOG_USP1 = 51;
	private static final int DIALOG_USP2 = 52;

	private Dialog showDialog(int id)
	{
		Builder builder = new AlertDialog.Builder(getSherlockActivity());
		CBTiDialogFragment dia = new CBTiDialogFragment();
		switch (id)
		{

		case DIALOG_UPDATEERROR:
			builder.setMessage(getString(R.string.s_UpdateError));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_UPDATEERROR2:
			builder.setMessage(getString(R.string.s_UpdateError2));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_UPDATEERROR3:
			builder.setMessage(getString(R.string.s_UpdateError3));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_MANWAKEINFO:
			builder.setMessage(getString(R.string.s_ManWakeInfo));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_MANBEDINFO:
			builder.setMessage(getString(R.string.s_ManBedInfo));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_WTERROR:
			builder.setMessage(getString(R.string.s_WTError));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_AUTOWAKETIMEINFO:
			builder.setMessage(getString(R.string.s_AWTInfo));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_BEDTIME:
			int iTime = cData22a.timeFrom4pm(cData22a.iBedtimemin);
			dia.showTimeDialog(iTime, mBTTimePickerListener, getFragmentManager());
			break;

		case DIALOG_WAKETIME:
			iTime = cData22a.timeFrom4pm(cData22a.iWaketimemin);
			dia.showTimeDialog(iTime, mWTTimePickerListener, getFragmentManager());
			break;

		case DIALOG_AUTOWAKETIME:
			iTime = cData22a.timeFrom4pm(cData22a.iAutoWaketimemin);
			dia.showTimeDialog(iTime, mAWTTimePickerListener, getFragmentManager());
			break;

		case DIALOG_USP1:
			builder.setMessage(getString(R.string.s_USP1));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;

		case DIALOG_USP2:
			builder.setMessage(getString(R.string.s_USP2));
			builder.setPositiveButton("OK", null);
			builder.create().show();
			break;
		}

		return null;
	}

	private TimePickerDialog.OnTimeSetListener mBTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute)
		{
			cData22a.iBedtimemin = cData22a.timeTo4pm((hourOfDay * 60) + minute);
			((TextView) (getView().findViewById(R.id.tManBedtime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iBedtimemin));
		}
	};

	private TimePickerDialog.OnTimeSetListener mWTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute)
		{
			cData22a.iWaketimemin = cData22a.timeTo4pm((hourOfDay * 60) + minute);
			((TextView) (getView().findViewById(R.id.tManWaketime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iWaketimemin));
		}
	};

	private TimePickerDialog.OnTimeSetListener mAWTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute)
		{
			cData22a.iAutoWaketimemin = cData22a.timeTo4pm((hourOfDay * 60) + minute);
			((TextView) (getView().findViewById(R.id.tAutoWaketime))).setText(cData22a.formattedTimeFrom4pm(cData22a.iAutoWaketimemin));
		}
	};

	/**
	 * A callback listener that implements the
	 * {@link android.widget.AdapterView.OnItemSelectedListener} interface For
	 * views based on adapters, this interface defines the methods available
	 * when the user selects an item from the View.
	 * 
	 */
	public class myOnItemSelectedListener implements OnItemSelectedListener
	{

		/**
		 * Constructor
		 * 
		 * @param c
		 *            - The activity that displays the Spinner.
		 * @param ad
		 *            - The Adapter view that
		 * @param id
		 *            - where to put the result; controls the Spinner.
		 *            Instantiate a new listener object.
		 */
		public myOnItemSelectedListener()
		{
		}

		/**
		 * When the user selects an item in the spinner, this method is invoked
		 * by the callback chain. Android calls the item selected listener for
		 * the spinner, which invokes the onItemSelected method.
		 * 
		 * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android.widget.AdapterView,
		 *      android.view.View, int, long)
		 * @param parent
		 *            - the AdapterView for this listener
		 * @param v
		 *            - the View for this listener
		 * @param pos
		 *            - the 0-based position of the selection in the
		 *            mLocalAdapter
		 * @param row
		 *            - the 0-based row number of the selection in the View
		 */
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row)
		{
		}

		/**
		 * The definition of OnItemSelectedListener requires an override of
		 * onNothingSelected(), even though this implementation does not use it.
		 * 
		 * @param parent
		 *            - The View for this Listener
		 */
		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
		}
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
		Intent i = new Intent(getSherlockActivity(), CBTi_Help.class);
		i.putExtra("RID_Img", R.drawable.buddy_mysleepupdatesleepprescription);
		i.putExtra("RID_Text", R.string.s_22b);
		getSherlockActivity().startActivity(i);
		getSherlockActivity().overridePendingTransition(R.anim.slide_up, R.anim.slide_up2);
	}

}