package com.t2.cbt_i.classes;

import android.os.Bundle;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.t2.cbt_i.R;


public class BaseABSActivity extends BaseABSNHActivity {

	com.actionbarsherlock.app.ActionBar bar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(R.string.s_Help).setIcon(R.drawable.ic_menu_help).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		if( item.getTitle().toString().equalsIgnoreCase(getString(R.string.s_Help)) ) {
			getHelp();
		}
		return super.onOptionsItemSelected(item);
	}


	public void getHelp() {
	}	
}
