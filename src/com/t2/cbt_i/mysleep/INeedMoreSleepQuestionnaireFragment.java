package com.t2.cbt_i.mysleep;

import java.util.Calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class INeedMoreSleepQuestionnaireFragment extends CBTi_BaseFragment
{
	INeedMoreSleepQuestionnaireAnswersData cData23c;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_ineedmoresleepquestionnaire, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_ISITitle));

		// Next Question Button
		((Button) getView().findViewById(R.id.bNextQuestion)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the next button
				cData23c.iScore[cData23c.iQuestion + 1] = getScore();
				cData23c.iQuestion++;
				cData23c.b0 = cData23c.b1 = cData23c.b2 = cData23c.b3 = cData23c.b4 = false;
				fetchScreen();
				((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);

			}
		});

		// CheckBox1
		((CheckBox) getView().findViewById(R.id.cbISIQ0)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				if (anyChecked())
				{
					((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(false);
					if (cData23c.iQuestion == 2)
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else
				{
					((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox2
		((CheckBox) getView().findViewById(R.id.cbISIQ1)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				if (anyChecked())
				{
					((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(false);
					if (cData23c.iQuestion == 2)
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else
				{
					((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox3
		((CheckBox) getView().findViewById(R.id.cbISIQ2)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				if (anyChecked())
				{
					((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(false);
					if (cData23c.iQuestion == 2)
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else
				{
					((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox4
		((CheckBox) getView().findViewById(R.id.cbISIQ3)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				if (anyChecked())
				{
					((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(false);
					if (cData23c.iQuestion == 2)
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else
				{
					((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// CheckBox5
		((CheckBox) getView().findViewById(R.id.cbISIQ4)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the about button
				if (anyChecked())
				{
					((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(false);
					((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(false);
					if (cData23c.iQuestion == 2)
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
					}
					else
					{
						((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
						((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
					}
				}
				else
				{
					((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
					((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
				}
			}
		});

		// Submit Button
		((Button) getView().findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the submit button
				getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Feedback));
				((LinearLayout) getView().findViewById(R.id.llISI)).setVisibility(View.GONE);
				cData23c.iScore[cData23c.iQuestion + 1] = getScore();
				cData23c.iQuestion++;
				cData23c.iCumScore = cData23c.iScore[0] + cData23c.iScore[1] + cData23c.iScore[2] + cData23c.iScore[3];

				((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
				((Button) getView().findViewById(R.id.bDone)).setVisibility(View.VISIBLE);
				((TextView) getView().findViewById(R.id.tSNQResult)).setVisibility(View.VISIBLE);
				if (!inLast6Days())
				{
					if (cData23c.iCumScore < 10)
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq09a);
					else if (cData23c.iCumScore < 13)
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq1012a);
					else
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq13ga);
					((Button) getView().findViewById(R.id.bAdd15)).setVisibility(View.VISIBLE);
					((Button) getView().findViewById(R.id.bAdd30)).setVisibility(View.VISIBLE);
				}
				else
				{
					if (cData23c.iCumScore < 10)
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq09b);
					else if (cData23c.iCumScore < 13)
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq1012b);
					else
						((TextView) getView().findViewById(R.id.tSNQResult)).setText(R.string.s_snq13gb);
				}
				Calendar cc = Calendar.getInstance();
				cc.set(Calendar.HOUR_OF_DAY, 0);
				cc.set(Calendar.MINUTE, 0);
				cc.set(Calendar.SECOND, 0);
				cc.set(Calendar.MILLISECOND, 0);
				cData23c.lDate = cc.getTimeInMillis();
				cData23c.saveData();
			}
		});

		// Done Button
		((Button) getView().findViewById(R.id.bDone)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the submit button
				INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(getSherlockActivity());
				cData23a.bAdd15 = false;
				cData23a.bAdd30 = false;
				cData23a.saveData();
				getSherlockActivity().finish();
			}
		});

		// Add15 Button
		((Button) getView().findViewById(R.id.bAdd15)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the submit button
				INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(getSherlockActivity());
				cData23a.bAdd15 = true;
				cData23a.bAdd30 = false;
				cData23a.saveData();
				getSherlockActivity().finish();
			}
		});

		// Add30 Button
		((Button) getView().findViewById(R.id.bAdd30)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the submit button
				INeedMoreSleepQuestionnaireResultData cData23a = new INeedMoreSleepQuestionnaireResultData(getSherlockActivity());
				cData23a.bAdd30 = true;
				cData23a.bAdd15 = false;
				cData23a.saveData();
				getSherlockActivity().finish();
			}
		});
	}

	@Override
	public void onResume()
	{
		cData23c = new INeedMoreSleepQuestionnaireAnswersData(getSherlockActivity());

		fetchScreen();
		if (anyChecked())
		{
			if(cData23c.iQuestion > 2)
			{
				((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
				((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);				
			}
			else if (cData23c.iQuestion == 2)
			{
				((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.VISIBLE);
				((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);
			}
			else
			{
				((Button) getView().findViewById(R.id.bSubmit)).setVisibility(View.GONE);
				((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.VISIBLE);
			}
		}
		super.onResume();
	}

	@Override
	public void onPause()
	{
		cData23c.b0 = ((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked();
		cData23c.b1 = ((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked();
		cData23c.b2 = ((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked();
		cData23c.b3 = ((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked();
		cData23c.b4 = ((CheckBox) getView().findViewById(R.id.cbISIQ4)).isChecked();
		cData23c.saveData(); // save data to file
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}

	private Boolean anyChecked()
	{
		return (((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked() | ((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked()
				| ((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked() | ((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked() | ((CheckBox) getView()
				.findViewById(R.id.cbISIQ4)).isChecked());
	}

	private int getScore()
	{
		int iScore;
		if (cData23c.iQuestion == 2)
		{
			if (((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked())
				iScore = 5;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked())
				iScore = 4;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked())
				iScore = 3;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked())
				iScore = 2;
			else
				iScore = 1;
		}
		else
		{
			if (((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked())
				iScore = 1;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked())
				iScore = 2;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked())
				iScore = 3;
			else if (((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked())
				iScore = 4;
			else
				iScore = 5;
		}

		return iScore;
	}

	private void fetchScreen()
	{
		// 1 screen for state -1 is ready to go
		if (cData23c.iQuestion == 0)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_snq2);
		}
		else if (cData23c.iQuestion == 1)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_snq3);
		}
		else if (cData23c.iQuestion == 2)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_snq4);
		}
		
		if(cData23c.iQuestion <= 2)
			getSherlockActivity().getSupportActionBar().setTitle(String.format(getString(R.string.s_INMSQTitle), cData23c.iQuestion + 2));
		else
			getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_Feedback));
		
		((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(cData23c.b0);
		((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(cData23c.b1);
		((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(cData23c.b2);
		((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(cData23c.b3);
		((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(cData23c.b4);

	}

	private Boolean inLast6Days()
	{
		if (cData23c.lDate == -1)
			return false;
		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY, 0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		int iJulian = cc.get(Calendar.DAY_OF_YEAR);
		cc.set(Calendar.DAY_OF_YEAR, iJulian - 6);
		long l6Days = cc.getTimeInMillis(); // 6 days ago

		return cData23c.lDate >= l6Days;
	}
}