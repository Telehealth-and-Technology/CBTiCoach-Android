package com.t2.cbt_i.classes;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.t2.cbt_i.R;
import com.t2.cbt_i.about.AboutMainActivity;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashboardActivity;
import com.t2.cbt_i.learn.LearnMainActivity;
import com.t2.cbt_i.mysleep.MySleepMainActivity;
import com.t2.cbt_i.reminders.RemindersMainActivity;
import com.t2.cbt_i.settings.SettingsActivity;
import com.t2.cbt_i.tools.ToolsMainActivity;


public class BaseABSNHActivity extends CBTi_BaseActivity {

	com.actionbarsherlock.app.ActionBar bar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int iSelected = -1;
		Bundle b = getIntent().getExtras();
		if( b!=null )
			iSelected = b.getInt("RID_Selected");
		bPrimed = iSelected==-1;		// forces skip of ontabselected processing
		
		bar = getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayHomeAsUpEnabled(false);
		bar.setLogo(R.drawable.cbti_icon);
		bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_topbar));
		
		bar.addTab(bar.newTab().setText(R.string.action_home).setIcon(R.drawable.ic_menu_home)  .setTabListener(new MyTabListener()),0,iSelected==0);
		bar.addTab(bar.newTab().setText(R.string.s_MySleep)  .setIcon(R.drawable.ic_menu_edit)  .setTabListener(new MyTabListener()),1,iSelected==1);
		bar.addTab(bar.newTab().setText(R.string.s_Tools)    .setIcon(R.drawable.ic_menu_manage).setTabListener(new MyTabListener()),2,iSelected==2);
		bar.addTab(bar.newTab().setText(R.string.s_Learn)    .setIcon(R.drawable.ic_menu_copy)  .setTabListener(new MyTabListener()),3,iSelected==3);
		bar.addTab(bar.newTab().setText(R.string.s_Reminders).setIcon(R.drawable.ic_menu_today) .setTabListener(new MyTabListener()),4,iSelected==4);
	}

	
	private Boolean bPrimed = false;
	private class MyTabListener implements TabListener {

		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		}

		@Override
		public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
			if( bPrimed ) {
				Intent i=null;
				int iSelected=-1;
				if( arg0.getText().toString().equalsIgnoreCase(getString(R.string.action_home)) ) {
					i = new Intent(getApplicationContext(), DashboardActivity.class ); 
					iSelected = 0;
				}
				else if ( arg0.getText().toString().equalsIgnoreCase(getString(R.string.s_MySleep)) ) {
					i = new Intent(getApplicationContext(), MySleepMainActivity.class );
					iSelected = 1;
				}
				else if ( arg0.getText().toString().equalsIgnoreCase(getString(R.string.s_Tools)) ) {
					i = new Intent(getApplicationContext(), ToolsMainActivity.class );
					iSelected = 2;
				}
				else if ( arg0.getText().toString().equalsIgnoreCase(getString(R.string.s_Learn)) ) {
					i = new Intent(getApplicationContext(), LearnMainActivity.class );
					iSelected = 3;
				}
				else if ( arg0.getText().toString().equalsIgnoreCase(getString(R.string.s_Reminders)) ) {
					i = new Intent(getApplicationContext(), RemindersMainActivity.class );
					iSelected = 4;
				}
				// dont replicate yourself
				if( i!= null && !BaseABSNHActivity.this.getIntent().toString().equalsIgnoreCase(i.toString()) ) {
					i.putExtra("RID_Selected", iSelected);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(i);
					overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
				}
			}
			bPrimed = true;
		}

		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {	
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("settings").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add("about").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i=null;
		if( item.getTitle().toString().equalsIgnoreCase(getString(R.string.s_Settings)) ) {
			i = new Intent(getApplicationContext(), SettingsActivity.class );       	
		}
		else if( item.getTitle().toString().equalsIgnoreCase(getString(R.string.s_About)) ) {
			i = new Intent(getApplicationContext(), AboutMainActivity.class );   
		}
		if( i!= null ) {
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
		}
		return super.onOptionsItemSelected(item);
	}

}
