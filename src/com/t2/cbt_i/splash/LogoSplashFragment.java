package com.t2.cbt_i.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.t2.cbt_i.R;

public class LogoSplashFragment extends SherlockFragment 
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	{
		return inflater.inflate(R.layout.splash_logo, null);
	}
}