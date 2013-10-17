package com.t2.cbt_i.mysleep;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class SleepDairyEntryFragment extends CBTi_BaseFragment
{
	SleepDairyEntryData cData21c;
	SleepDairyData cData21a;
	Boolean bNew;
	int iPos;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_sleepdairyentry, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		bNew = getArguments().getBoolean("NEW");
		iPos = getArguments().getInt("POS");
		
		if(bNew)
			getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_NewEntry));
		else
			getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_SleepDairyEntry));

		((Button) getView().findViewById(R.id.bSleepDiaryEntryTime)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				bProcessed = false;
				showDialog(DATE_DIALOG_ID);
			}
		});

		((ImageButton) getView().findViewById(R.id.bSleepDiaryEntryTimeInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_SDETimeInfo);

			}
		});

		((Button) getView().findViewById(R.id.bTNT)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (((ToggleButton) getView().findViewById(R.id.bTNT)).isChecked())
				{
					((LinearLayout) getView().findViewById(R.id.llTNT)).setVisibility(View.VISIBLE);
					((TextView) (getView().findViewById(R.id.tTNT))).setText(String.format("%d hours: %d minutes", cData21c.iTNTmin / 60, cData21c.iTNTmin % 60));
				}
				else
					((LinearLayout) getView().findViewById(R.id.llTNT)).setVisibility(View.GONE);
			}
		});

		((TextView) getView().findViewById(R.id.tTNT)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				showDialog(DIALOG_TNTTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bTNTInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_TNTInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tBT)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				showDialog(DIALOG_BTTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bBTInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_BTInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tSIAT)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				bProcessed = false;
				showDialog(DIALOG_SIATTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bSIATInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_SIATInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tTTS)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				showDialog(DIALOG_TTSTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bTTSInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_TTSInfo);
			}
		});

		((ImageButton) getView().findViewById(R.id.bTimesAwakeInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_TimesAwakeInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tTA)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				showDialog(DIALOG_TATime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bTAInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_TAInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tWUT)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_WUTTime);
			}
		});

		((ImageButton) getView().findViewById(R.id.bWUTInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_WUTInfo);
			}
		});

		((Button) getView().findViewById(R.id.bEarlier)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (((ToggleButton) getView().findViewById(R.id.bEarlier)).isChecked())
				{
					((LinearLayout) getView().findViewById(R.id.llEarlier)).setVisibility(View.VISIBLE);
					((TextView) (getView().findViewById(R.id.tEarlier))).setText(String.format("%d hours: %2d minutes", cData21c.iEarliermin / 60,
							cData21c.iEarliermin % 60));
				}
				else
					((LinearLayout) getView().findViewById(R.id.llEarlier)).setVisibility(View.GONE);
			}
		});

		((TextView) getView().findViewById(R.id.tEarlier)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				showDialog(DIALOG_EarlierTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bEarlierInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_EarlierInfo);
			}
		});

		((TextView) getView().findViewById(R.id.tWT)).setOnTouchListener(new OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				bProcessed = false;
				showDialog(DIALOG_WTTime);
				return false;
			}
		});

		((ImageButton) getView().findViewById(R.id.bWTInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_WTInfo);
			}
		});

		((ImageButton) getView().findViewById(R.id.bSleepQualityInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_SQInfo);
			}
		});

		((ImageButton) getView().findViewById(R.id.bCommentInfo)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				showDialog(DIALOG_CommentInfo);
			}
		});

		((Button) getView().findViewById(R.id.bSaveEntry)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if ((bNew == true) && cData21a.alreadyExists(cData21c.lSDETime))
					showDialog(DIALOG_SDETimeError2);
				else
				{
					int iWTmin = cData21c.iWTmin;
					int iSIATmin = cData21c.iSIATmin;
					cData21c.iTIBDailymin = (iWTmin - iSIATmin); // calculate
																	// dailies
					int iWUTmin = cData21c.iWUTmin;
					int iTTSmin = cData21c.iTTSmin;
					int iTAmin = cData21c.iTAmin;
					cData21c.iTSTDailymin = (iWUTmin - iSIATmin) - iTTSmin - iTAmin;
					if (cData21c.iTIBDailymin != 0)
					{
						cData21c.iSEDaily = ((cData21c.iTSTDailymin * 100) + 50) / cData21c.iTIBDailymin;
					}
					if (cData21c.iTSTDailymin < 0)
						showDialog(DIALOG_TSTERROR);
					else if (cData21c.iTIBDailymin < 0)
						showDialog(DIALOG_TIBERROR);
					else if (cData21c.iTSTDailymin > 600)
						showDialog(DIALOG_TSTWARN);
					else if (cData21c.iTIBDailymin > 600)
						showDialog(DIALOG_TIBWARN);
					else if (cData21c.iTSTDailymin < 300)
						showDialog(DIALOG_TSTWARN2);
					else if ((cData21c.iTTSmin + cData21c.iTAmin) > 180)
						showDialog(DIALOG_TTSWARN);
					else
					{
						cData21c.scrapeData();

						if (bNew)
							cData21a.alSleepDiary.add(cData21c);
						else
						{
							cData21a.alSleepDiary.set(iPos, cData21c);
						}
						cData21a.saveData();
						cData21c.saveData();
						
						final FragmentManager fm = getFragmentManager();
					    final FragmentTransaction ft = fm.beginTransaction();					    
					    ft.addToBackStack(null);
					    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
				        ft.replace(R.id.sleepdairyfragment, new SleepDairyEntryResultsFragment());
					    ft.commit();
					}
				}
			}
		});
	}

	private void enableTimesAwakePicker()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sTimesAwake);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.NUMPICKER, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData21c.iTimesAwake, true);
		OnItemSelectedListener spinnerListener = new myOnItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	private void enableSleepQualityPicker()
	{
		Spinner sSpin = (Spinner) getView().findViewById(R.id.sSleepQuality);
		sSpin.setVisibility(View.VISIBLE);
		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getSherlockActivity(), R.array.SQPICKER, android.R.layout.simple_spinner_dropdown_item);
		sSpin.setAdapter(aa);
		sSpin.setSelection(cData21c.iSleepQ, true);
		OnItemSelectedListener spinnerListener = new myOnSQItemSelectedListener();
		sSpin.setOnItemSelectedListener(spinnerListener);
	}

	/**
	 * A callback listener that implements the
	 * {@link android.widget.AdapterView.OnItemSelectedListener} interface For
	 * views based on adapters, this interface defines the methods available
	 * when the user selects an item from the View.
	 * 
	 */
	public class myOnItemSelectedListener implements OnItemSelectedListener
	{

		public myOnItemSelectedListener()
		{
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row)
		{
			if (pos > 0)
			{
				((LinearLayout) getView().findViewById(R.id.llTA)).setVisibility(View.VISIBLE);
				((TextView) (getView().findViewById(R.id.tTA))).setText((String.format("%d hours: %d minutes", cData21c.iTAmin / 60, cData21c.iTAmin % 60)));
			}
			else
				((LinearLayout) getView().findViewById(R.id.llTA)).setVisibility(View.GONE);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
		}
	}

	/**
	 * A callback listener that implements the
	 * {@link android.widget.AdapterView.OnItemSelectedListener} interface For
	 * views based on adapters, this interface defines the methods available
	 * when the user selects an item from the View.
	 * 
	 */
	public class myOnSQItemSelectedListener implements OnItemSelectedListener
	{

		public myOnSQItemSelectedListener()
		{
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int pos, long row)
		{
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
		}
	}

	@Override
	public void onPause()
	{
		cData21c.scrapeData();

		cData21c.saveData();
		cData21a.saveData();
		super.onPause();
	}

	@Override
	public void onResume()
	{

		cData21a = new SleepDairyData(getSherlockActivity());

		if (bNew == true)
		{
			cData21c = new SleepDairyEntryData(getSherlockActivity()); // this will get a brand
														// new object or one
														// with in progress data
														// in in progress
		}
		else
		{
			cData21c = cData21a.alSleepDiary.get(iPos);
		}

		SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Calendar cc = Calendar.getInstance();
		cc.setTimeInMillis(cData21c.lSDETime);
		((Button) getView().findViewById(R.id.bSleepDiaryEntryTime)).setText(format.format(cc.getTime()));

		((ToggleButton) getView().findViewById(R.id.bTNT)).setChecked(cData21c.bTNT);

		if (((ToggleButton) getView().findViewById(R.id.bTNT)).isChecked())
		{
			((LinearLayout) getView().findViewById(R.id.llTNT)).setVisibility(View.VISIBLE);
			((TextView) (getView().findViewById(R.id.tTNT))).setText(String.format("%d hours: %d minutes", cData21c.iTNTmin / 60, cData21c.iTNTmin % 60));
		}
		else
			((LinearLayout) getView().findViewById(R.id.llTNT)).setVisibility(View.GONE);

		((TextView) (getView().findViewById(R.id.tBT))).setText(formattedTimeFrom4pm(cData21c.iBTmin));
		((TextView) (getView().findViewById(R.id.tSIAT))).setText(formattedTimeFrom4pm(cData21c.iSIATmin));
		((TextView) (getView().findViewById(R.id.tTTS))).setText((String.format("%d hours: %2d minutes", cData21c.iTTSmin / 60, cData21c.iTTSmin % 60)));

		enableTimesAwakePicker();

		if (cData21c.iTimesAwake > 0)
		{
			((LinearLayout) getView().findViewById(R.id.llTA)).setVisibility(View.VISIBLE);
			((TextView) (getView().findViewById(R.id.tTA))).setText((String.format("%d hours: %2d minutes", cData21c.iTAmin / 60, cData21c.iTAmin % 60)));
		}
		else
			((LinearLayout) getView().findViewById(R.id.llTA)).setVisibility(View.GONE);

		((TextView) (getView().findViewById(R.id.tWUT))).setText(formattedTimeFrom4pm(cData21c.iWUTmin));
		((ToggleButton) getView().findViewById(R.id.bEarlier)).setChecked(cData21c.bEarlier);

		if (((ToggleButton) getView().findViewById(R.id.bEarlier)).isChecked())
		{
			((LinearLayout) getView().findViewById(R.id.llEarlier)).setVisibility(View.VISIBLE);
			((TextView) (getView().findViewById(R.id.tEarlier))).setText(String.format("%d hours: %d minutes", cData21c.iEarliermin / 60, cData21c.iEarliermin % 60));
		}
		else
			((LinearLayout) getView().findViewById(R.id.llEarlier)).setVisibility(View.GONE);

		((TextView) (getView().findViewById(R.id.tWT))).setText(formattedTimeFrom4pm(cData21c.iWTmin));

		enableSleepQualityPicker();

		((EditText) getView().findViewById(R.id.tComment)).setText(cData21c.sComment);

		super.onResume();
	}

	private static final int DATE_DIALOG_ID = 1;
	private static final int DIALOG_SDETimeInfo = 10;
	private static final int DIALOG_SDETimeWarn = 11;
	private static final int DIALOG_SDETimeError = 12;
	private static final int DIALOG_TNTInfo = 13;
	private static final int DIALOG_TNTTime = 14;
	private static final int DIALOG_BTTime = 15;
	private static final int DIALOG_BTInfo = 16;
	private static final int DIALOG_SIATTime = 17;
	private static final int DIALOG_SIATInfo = 18;
	private static final int DIALOG_TTSTime = 19;
	private static final int DIALOG_TTSInfo = 20;
	private static final int DIALOG_TATime = 21;
	private static final int DIALOG_TAInfo = 22;
	private static final int DIALOG_TimesAwakeInfo = 23;
	private static final int DIALOG_WUTInfo = 24;
	private static final int DIALOG_EarlierInfo = 25;
	private static final int DIALOG_WTInfo = 26;
	private static final int DIALOG_CommentInfo = 28;
	private static final int DIALOG_SQInfo = 29;
	private static final int DIALOG_WUTTime = 30;
	private static final int DIALOG_EarlierTime = 31;
	private static final int DIALOG_WTTime = 32;
	private static final int DIALOG_SDETimeError2 = 33;
	private static final int DIALOG_SIATERROR = 34;
	private static final int DIALOG_WUTERROR = 35;
	private static final int DIALOG_TSTERROR = 36;
	private static final int DIALOG_TIBERROR = 37;
	private static final int DIALOG_TSTWARN = 38;
	private static final int DIALOG_TIBWARN = 39;
	private static final int DIALOG_TTSWARN = 40;
	private static final int DIALOG_TSTWARN2 = 41;

	/*
	 * @Override protected void onPrepareDialog(int id, Dialog dialog) {
	 * super.onPrepareDialog(id, dialog);
	 * 
	 * switch(id) { case DATE_DIALOG_ID: Calendar c = Calendar.getInstance();
	 * if( cData21c.lSDETime != 0 ) c.setTimeInMillis(cData21c.lSDETime);
	 * ((DatePickerDialog) dialog).updateDate(c.get(Calendar.YEAR),
	 * c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)); break; } }
	 */

	protected Dialog showDialog(int id)
	{
		Builder builder;
		switch (id)
		{
		case DATE_DIALOG_ID:
			Calendar cc = Calendar.getInstance();
			if (cData21c.lSDETime != 0)
				cc.setTimeInMillis(cData21c.lSDETime);
			return new DatePickerDialog(getSherlockActivity(), mDatePickerListener, cc.get(Calendar.YEAR), cc.get(Calendar.MONTH), cc.get(Calendar.DAY_OF_MONTH));

		case DIALOG_SDETimeInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SDEDateHint).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SDETimeWarn:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SDEDateWarn).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SDETimeError:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SDEDateError).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SDETimeError2:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SDEDateError2).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TNTInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TNTInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_BTInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_BTInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SIATInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SIATInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TTSInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TTSInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TimesAwakeInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TimesAwakeInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TAInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TAInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_WUTInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_WUT_Info).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_EarlierInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_EarlierInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_WTInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_WT_Info).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SQInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SQInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_CommentInfo:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_CommentInfo).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_SIATERROR:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_SIATError).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_WUTERROR:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_WUTError).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TSTERROR:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TSTError).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TIBERROR:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TIBError).setPositiveButton(R.string.s_OK, null).create().show();
			break;

		case DIALOG_TSTWARN:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TSTWarn);
			builder.setPositiveButton(R.string.s_OK, new OkOnClickListener2());
			builder.create().show();
			break;

		case DIALOG_TTSWARN:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TTSWarn);
			builder.setPositiveButton(R.string.s_OK, new OkOnClickListener2());
			builder.create().show();
			break;

		case DIALOG_TSTWARN2:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TSTWarn2);
			builder.setPositiveButton(R.string.s_OK, new OkOnClickListener2());
			builder.create().show();
			break;

		case DIALOG_TIBWARN:
			builder = new AlertDialog.Builder(getSherlockActivity());
			builder.setMessage(R.string.s_TIBWarn);
			builder.setPositiveButton(R.string.s_OK, new OkOnClickListener2());
			builder.create().show();
			break;

		case DIALOG_BTTime:
			int iTime = timeFrom4pm(cData21c.iBTmin);
			return new TimePickerDialog(getSherlockActivity(), mBTTimePickerListener, iTime / 60, iTime % 60, false);

		case DIALOG_SIATTime:
			iTime = timeFrom4pm(cData21c.iSIATmin);
			return new TimePickerDialog(getSherlockActivity(), mSIATTimePickerListener, iTime / 60, iTime % 60, false);

		case DIALOG_TNTTime:
			TimePickerDialog tp = new TimePickerDialog(getSherlockActivity(), mTNTTimePickerListener, cData21c.iTNTmin / 60, cData21c.iTNTmin % 60, true);
			tp.setTitle(R.string.s_TNTQuestion);
			return tp;

		case DIALOG_TTSTime:
			tp = new TimePickerDialog(getSherlockActivity(), mTTSTimePickerListener, cData21c.iTTSmin / 60, cData21c.iTTSmin % 60, true);
			tp.setTitle(R.string.s_TTSQuestion);
			return tp;

		case DIALOG_TATime:
			tp = new TimePickerDialog(getSherlockActivity(), mTATimePickerListener, cData21c.iTAmin / 60, cData21c.iTAmin % 60, true);
			tp.setTitle(R.string.s_TAQuestion);
			return tp;

		case DIALOG_WUTTime:
			iTime = timeFrom4pm(cData21c.iWUTmin);
			return new TimePickerDialog(getSherlockActivity(), mWUTTimePickerListener, iTime / 60, iTime % 60, false);

		case DIALOG_EarlierTime:
			tp = new TimePickerDialog(getSherlockActivity(), mEarlierTimePickerListener, cData21c.iEarliermin / 60, cData21c.iEarliermin % 60, true);
			tp.setTitle(R.string.s_EarlierQuestion);
			return tp;

		case DIALOG_WTTime:
			iTime = timeFrom4pm(cData21c.iWTmin);
			return new TimePickerDialog(getSherlockActivity(), mWTTimePickerListener, iTime / 60, iTime % 60, false);
		}
		return null;
	}

	private Boolean bProcessed; // if true the button has been handled
	private DatePickerDialog.OnDateSetListener mDatePickerListener = new DatePickerDialog.OnDateSetListener()
	{
		@Override
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay)
		{
			if (!bProcessed)
			{
				bProcessed = true;

				Calendar cc = Calendar.getInstance();
				cc.set(Calendar.HOUR_OF_DAY, 0);
				cc.set(Calendar.MINUTE, 0);
				cc.set(Calendar.SECOND, 0);
				cc.set(Calendar.MILLISECOND, 0);
				long lToday = cc.getTimeInMillis();

				cc.set(Calendar.YEAR, selectedYear); // try the newly selected
														// date
				cc.set(Calendar.DAY_OF_MONTH, selectedDay);
				cc.set(Calendar.MONTH, selectedMonth);
				if (cData21a.alreadyExists(cc.getTimeInMillis()))
					showDialog(DIALOG_SDETimeError2);
				else if (cc.getTimeInMillis() > lToday)
					showDialog(DIALOG_SDETimeError);
				else
				{
					cData21c.lSDETime = cc.getTimeInMillis();
					SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy");
					((Button) getView().findViewById(R.id.bSleepDiaryEntryTime)).setText(format.format(cc.getTime()));
					if (cc.getTimeInMillis() < lToday)
						showDialog(DIALOG_SDETimeWarn);
				}
			}
		}
	};

	private TimePickerDialog.OnTimeSetListener mTNTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData21c.iTNTmin = (hourOfDay * 60) + minute;
			((TextView) (getView().findViewById(R.id.tTNT))).setText(String.format("%d hours: %d minutes", hourOfDay, minute));
		}
	};

	private TimePickerDialog.OnTimeSetListener mBTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData21c.iBTmin = timeTo4pm((hourOfDay * 60) + minute);
			((TextView) (getView().findViewById(R.id.tBT))).setText(formattedTimeFrom4pm(cData21c.iBTmin));
		}
	};

	private TimePickerDialog.OnTimeSetListener mSIATTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			if (!bProcessed)
			{
				bProcessed = true;
				if (timeTo4pm((hourOfDay * 60) + minute) < cData21c.iBTmin)
					showDialog(DIALOG_SIATERROR);
				else
				{
					cData21c.iSIATmin = timeTo4pm((hourOfDay * 60) + minute);
					((TextView) (getView().findViewById(R.id.tSIAT))).setText(formattedTimeFrom4pm(cData21c.iSIATmin));
				}
			}
		}
	};

	private TimePickerDialog.OnTimeSetListener mTTSTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData21c.iTTSmin = (hourOfDay * 60) + minute;
			((TextView) (getView().findViewById(R.id.tTTS))).setText((String.format("%d hours: %d minutes", hourOfDay, minute)));
		}
	};

	private TimePickerDialog.OnTimeSetListener mTATimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData21c.iTAmin = hourOfDay * 60 + minute;
			((TextView) (getView().findViewById(R.id.tTA))).setText((String.format("%d hours: %d minutes", hourOfDay, minute)));
		}
	};

	private TimePickerDialog.OnTimeSetListener mWUTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			int iTime = timeTo4pm((hourOfDay * 60) + minute);
			// if( iTime < cData21c.iWT )
			// showDialog(DIALOG_WUTERROR);
			// else {
			cData21c.iWUTmin = iTime;
			((TextView) (getView().findViewById(R.id.tWUT))).setText(formattedTimeFrom4pm(cData21c.iWUTmin));
			// }
		}
	};

	private TimePickerDialog.OnTimeSetListener mEarlierTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			cData21c.iEarliermin = (hourOfDay * 60) + minute;
			((TextView) (getView().findViewById(R.id.tEarlier))).setText((String.format("%d hours: %d minutes", hourOfDay, minute)));
		}
	};

	private TimePickerDialog.OnTimeSetListener mWTTimePickerListener = new TimePickerDialog.OnTimeSetListener()
	{
		@Override
		public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute)
		{
			if (!bProcessed)
			{
				bProcessed = true;

				int iTime = timeTo4pm((hourOfDay * 60) + minute);
				if (iTime < cData21c.iWUTmin)
				{
					showDialog(DIALOG_WUTERROR);
				}
				else
				{
					cData21c.iWTmin = iTime;
					((TextView) (getView().findViewById(R.id.tWT))).setText(formattedTimeFrom4pm(cData21c.iWTmin));
				}
			}
		}
	};

	private final class OkOnClickListener2 implements DialogInterface.OnClickListener
	{
		@Override
		public void onClick(DialogInterface dialog, int which)
		{
			cData21c.scrapeData();

			if (bNew)
				cData21a.alSleepDiary.add(cData21c);
			else
			{
				cData21a.alSleepDiary.set(iPos, cData21c);
			}
			cData21a.saveData();

			final FragmentManager fm = getFragmentManager();
		    final FragmentTransaction ft = fm.beginTransaction();					    
		    ft.addToBackStack(null);
		    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
	        ft.replace(R.id.sleepdairyfragment, new SleepDairyEntryResultsFragment());
		    ft.commit();
		}
	}

	public int timeTo4pm(int iTime)
	{ // we store the times as based off 4pm 24 hour clock
		int iHour = iTime / 60 - 16; // so we can compare them
		if (iHour < 0)
			iHour += 24;
		return (iHour * 60) + (iTime % 60);
	}

	public int timeFrom4pm(int iTime)
	{ // this will translate them for display
		int iHour = (iTime / 60) + 16;
		if (iHour >= 24)
			iHour -= 24;
		return (iHour * 60) + (iTime % 60);
	}

	public String formattedTimeFrom4pm(int iTime)
	{
		if (iTime == -1)
			return "no data";

		iTime = timeFrom4pm(iTime);

		String sAMPM = "AM";
		int iHour = iTime / 60;
		if (iHour >= 12)
		{
			sAMPM = "PM";
		}
		if (iHour > 12)
		{
			iHour -= 12;
		}
		if (iHour == 0)
			iHour = 12;

		return (String.format("%d:%02d %s", iHour, iTime % 60, sAMPM));
	}

	@Override
	public void getHelp() 
	{
		this.goingToHelp = true;
	}

}