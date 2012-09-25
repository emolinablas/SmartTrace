package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class ScanControl extends TabActivity implements OnTabChangeListener{
	private TabHost mTabHost;
	private String lastTabID;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
		
		super.onCreate(savedInstanceState);

		setmTabHost(getTabHost());
		
		getmTabHost().addTab(
				getmTabHost().newTabSpec("sample2").setIndicator("ESCANEAR")
						.setContent(new Intent(this, Scan.class)));

		getmTabHost().addTab(
				getmTabHost().newTabSpec("sample3").setIndicator("AVANCE")
						.setContent(new Intent(this, Result.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));

		// 01234
		
		getmTabHost().setCurrentTabByTag("wifiMenu");
		getmTabHost().setOnTabChangedListener(this);
		lastTabID = getmTabHost().getCurrentTabTag();
	}
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

	public TabHost getmTabHost() {
		return mTabHost;
	}

	public void setmTabHost(TabHost mTabHost) {
		this.mTabHost = mTabHost;
	}

	public String getLastTabID() {
		return lastTabID;
	}

	public void setLastTabID(String lastTabID) {
		this.lastTabID = lastTabID;
	}

	@Override
	public void onTabChanged(String arg0) {
		// TODO Auto-generated method stub
		
	}
}
