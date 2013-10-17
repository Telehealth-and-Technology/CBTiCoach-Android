package com.t2.cbt_i.dashboard;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_BaseActivity;
import com.t2.cbt_i.learn.LearnMainFragment;
import com.t2.cbt_i.mysleep.MySleepMainFragment;
import com.t2.cbt_i.reminders.RemindersMainFragment;
import com.t2.cbt_i.tools.ToolsMainFragment;
import com.t2.cbt_i.utils.ActionBarUtils;

public class DashboardActivity extends CBTi_BaseActivity
{

	private ViewPager mPager;

	private TabsAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("Home");
		setContentView(R.layout.dashboard);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		mPager = (ViewPager) findViewById(R.id.tabpages);
		mAdapter = new TabsAdapter(this, mPager);
		mAdapter.addTab(getSupportActionBar().newTab().setText(getResources().getString(R.string.s_Home)).setTag(0).setIcon(R.drawable.ic_menu_home),
						DashboardFragment.class, null);
		mAdapter.addTab(getSupportActionBar().newTab().setText(getResources().getString(R.string.s_MySleep)).setTag(1).setIcon(R.drawable.ic_menu_edit),
	 					MySleepMainFragment.class, null);
		mAdapter.addTab(getSupportActionBar().newTab().setText(getResources().getString(R.string.s_Tools)).setTag(2).setIcon(R.drawable.ic_menu_manage), 
						ToolsMainFragment.class, null);
		mAdapter.addTab(getSupportActionBar().newTab().setText(getResources().getString(R.string.s_Learn)).setTag(3).setIcon(R.drawable.ic_menu_copy),
		 				LearnMainFragment.class, null);
		mAdapter.addTab(getSupportActionBar().newTab().setText(getResources().getString(R.string.s_Reminders)).setTag(4).setIcon(R.drawable.ic_menu_today),
		 				RemindersMainFragment.class, null);
	}

	@Override
	public void onBackPressed()
	{
		if (mPager.getCurrentItem() > 0)
		{
			setPage(0);
		}
		else
		{
			super.onBackPressed();
		}
	}

	public void setPage(int page)
	{
		mPager.setCurrentItem(page);
	}

	public static class TabsAdapter extends FragmentPagerAdapter implements ActionBar.TabListener, ViewPager.OnPageChangeListener
	{
		private final Context mContext;

		private final ActionBar mActionBar;

		private final ViewPager mViewPager;

		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager)
		{
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mActionBar = activity.getSupportActionBar();
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args)
		{
			final TabInfo info = new TabInfo(clss, args);
			tab.setTag(info);
			tab.setTabListener(this);
			mTabs.add(info);
			mActionBar.addTab(tab);
			notifyDataSetChanged();
		}

		@Override
		public int getCount()
		{
			return mTabs.size();
		}

		@Override
		public Fragment getItem(int position)
		{
			final TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clss.getName(), info.args);
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
		{
		}

		@Override
		public void onPageScrollStateChanged(int state)
		{
		}

		@Override
		public void onPageSelected(int position)
		{
			mActionBar.setSelectedNavigationItem(position);
			selectInSpinnerIfPresent(position, false);
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft)
		{
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft)
		{
			final Object tag = tab.getTag();
			for (int i = 0; i < mTabs.size(); i++)
			{

				if (mTabs.get(i) == tag)
				{
					mViewPager.setCurrentItem(i);
					String title = "Home";
					switch (i)
					{
					case 1:
						title = "My Sleep";
						break;
					case 2:
						title = "Tools";
						break;
					case 3:
						title = "Learn";
						break;
					case 4:
						title = "Reminders";
						break;
					}
					mActionBar.setTitle(title);
				}
			}

		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft)
		{
		}

		private void selectInSpinnerIfPresent(int position, boolean animate)
		{
			ActionBarUtils.selectSpinnerIfPresent((Activity) mContext, position, animate);
		}

		static final class TabInfo
		{
			private final Class<?> clss;

			private final Bundle args;

			TabInfo(Class<?> _class, Bundle _args)
			{
				clss = _class;
				args = _args;
			}
		}
	}
}
