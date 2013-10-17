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
