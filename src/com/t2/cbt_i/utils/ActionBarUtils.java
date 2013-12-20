/*
* ActionBarUtils.java
* Provides utility functions for the action bar
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
package com.t2.cbt_i.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.t2.cbt_i.R;

import android.app.Activity;
import android.view.View;

public class ActionBarUtils 
{
	public static final void selectSpinnerIfPresent(Activity activity, int position, boolean animate) 
	{
		try 
		{
			View actionBarView = activity.findViewById(R.id.abs__action_bar);
			if (actionBarView == null) 
			{
				final int id = activity.getResources().getIdentifier(
						"action_bar", "id", "android");
				actionBarView = activity.findViewById(id);
			}

			final Class<?> actionBarViewClass = actionBarView.getClass();
			final Field mTabScrollViewField = actionBarViewClass
					.getDeclaredField("mTabScrollView");
			mTabScrollViewField.setAccessible(true);

			final Object mTabScrollView = mTabScrollViewField
					.get(actionBarView);
			if (mTabScrollView == null) 
			{
				return;
			}

			final Field mTabSpinnerField = mTabScrollView.getClass()
					.getDeclaredField("mTabSpinner");
			mTabSpinnerField.setAccessible(true);

			final Object mTabSpinner = mTabSpinnerField.get(mTabScrollView);
			if (mTabSpinner == null) 
			{
				return;
			}

			final Method setSelectionMethod = mTabSpinner
					.getClass()
					.getSuperclass()
					.getDeclaredMethod("setSelection", Integer.TYPE,
							Boolean.TYPE);
			setSelectionMethod.invoke(mTabSpinner, position, animate);

		} 
		catch (final Exception e) 
		{
			e.printStackTrace();
		}
	}

	private ActionBarUtils() {
	}
}
