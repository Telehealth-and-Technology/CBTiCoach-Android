/*
* AssessmentQuestionnaireFragment.java
* Fragment used to display the assessment questionnaire and store the question values and result data
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright © 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright © 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
package com.t2.cbt_i.mysleep;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseFragment;

public class AssessmentQuestionnaireFragment extends CBTi_BaseFragment
{
	AssessmentQuestionnaireData cData31c;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.mysleep_assessmentquestionnaire, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		getSherlockActivity().getSupportActionBar().setTitle(getString(R.string.s_ISITitle));
		
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
					if (cData31c.iQuestion == 5)
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
					if (cData31c.iQuestion == 5)
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
					if (cData31c.iQuestion == 5)
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
					if (cData31c.iQuestion == 5)
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
					if (cData31c.iQuestion == 5)
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

		// Next Question Button
		((Button) getView().findViewById(R.id.bNextQuestion)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the next button
				cData31c.iScore[cData31c.iQuestion + 1] = getScore();
				cData31c.iQuestion++;
				cData31c.b0 = cData31c.b1 = cData31c.b2 = cData31c.b3 = cData31c.b4 = false;
				fetchScreen();
				((Button) getView().findViewById(R.id.bNextQuestion)).setVisibility(View.GONE);

			}
		});

		// Submit Button
		((Button) getView().findViewById(R.id.bSubmit)).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{ // handle the submit button
				cData31c.iScore[cData31c.iQuestion + 1] = getScore();
				cData31c.iCumScore = cData31c.iScore[0] + cData31c.iScore[1] + cData31c.iScore[2] + cData31c.iScore[3] + cData31c.iScore[4]
						+ cData31c.iScore[5] + cData31c.iScore[6];
				AssessmentStartData cData31b = new AssessmentStartData(getSherlockActivity());
				cData31b.addEntry(cData31c);
				cData31b.saveData();
				
				final FragmentManager fm = getFragmentManager();
			    final FragmentTransaction ft = fm.beginTransaction();					    
			    ft.addToBackStack(null);
			    ft.setCustomAnimations(R.anim.slide_left, R.anim.slide_left2, R.anim.slide_right, R.anim.slide_right2);
		        ft.replace(R.id.assessmentfragment, new AssessmentResultsFragment());
			    ft.commit();
			}
		});
	}

	@Override
	public void onResume()
	{
		cData31c = new AssessmentQuestionnaireData(getSherlockActivity());

		fetchScreen();
		if (anyChecked())
		{
			if (cData31c.iQuestion == 5)
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
		cData31c.b0 = ((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked();
		cData31c.b1 = ((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked();
		cData31c.b2 = ((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked();
		cData31c.b3 = ((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked();
		cData31c.b4 = ((CheckBox) getView().findViewById(R.id.cbISIQ4)).isChecked();
		cData31c.saveData(); // save data to file
		super.onPause();
	}

	@Override
	public void getHelp()
	{
		this.goingToHelp = true;
	}

	/**
	 * Returns whether any of the checkboxes are checked
	 * @return True if any are checked
	 */
	private Boolean anyChecked()
	{
		return (((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked() | ((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked()
				| ((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked() | ((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked() | ((CheckBox) getView()
				.findViewById(R.id.cbISIQ4)).isChecked());
	}

	/**
	 * Gets the score based off of what checkbox was checked
	 * @return 0-4 score
	 */
	private int getScore()
	{
		int iScore;
		if (((CheckBox) getView().findViewById(R.id.cbISIQ0)).isChecked())
			iScore = 0;
		else if (((CheckBox) getView().findViewById(R.id.cbISIQ1)).isChecked())
			iScore = 1;
		else if (((CheckBox) getView().findViewById(R.id.cbISIQ2)).isChecked())
			iScore = 2;
		else if (((CheckBox) getView().findViewById(R.id.cbISIQ3)).isChecked())
			iScore = 3;
		else
			iScore = 4;

		return iScore;
	}

	/**
	 * Depending on what question stage, loads the next question
	 */
	private void fetchScreen()
	{
		// 1 screen for state -1 is ready to go
		if (cData31c.iQuestion == 0)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ2);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ10);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ11);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ12);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ13);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ14);
		}
		else if (cData31c.iQuestion == 1)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ3);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ10);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ11);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ12);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ13);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ14);
		}
		else if (cData31c.iQuestion == 2)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ4);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ40);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ41);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ42);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ43);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ44);
		}
		else if (cData31c.iQuestion == 3)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ5);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ50);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ51);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ52);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ53);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ54);
		}
		else if (cData31c.iQuestion == 4)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ6);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ60);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ61);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ62);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ63);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ64);
		}
		else if (cData31c.iQuestion == 5)
		{
			((TextView) getView().findViewById(R.id.tISIQ)).setText(R.string.s_ISIQ7);
			((TextView) getView().findViewById(R.id.cbISIQ0)).setText(R.string.s_ISIQ70);
			((TextView) getView().findViewById(R.id.cbISIQ1)).setText(R.string.s_ISIQ71);
			((TextView) getView().findViewById(R.id.cbISIQ2)).setText(R.string.s_ISIQ72);
			((TextView) getView().findViewById(R.id.cbISIQ3)).setText(R.string.s_ISIQ73);
			((TextView) getView().findViewById(R.id.cbISIQ4)).setText(R.string.s_ISIQ74);
		}

		getSherlockActivity().getSupportActionBar().setTitle(String.format(getString(R.string.s_ISITitle), cData31c.iQuestion + 2));
		((CheckBox) getView().findViewById(R.id.cbISIQ0)).setChecked(cData31c.b0);
		((CheckBox) getView().findViewById(R.id.cbISIQ1)).setChecked(cData31c.b1);
		((CheckBox) getView().findViewById(R.id.cbISIQ2)).setChecked(cData31c.b2);
		((CheckBox) getView().findViewById(R.id.cbISIQ3)).setChecked(cData31c.b3);
		((CheckBox) getView().findViewById(R.id.cbISIQ4)).setChecked(cData31c.b4);

	}
}