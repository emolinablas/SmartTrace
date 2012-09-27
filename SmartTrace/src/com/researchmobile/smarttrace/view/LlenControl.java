package com.researchmobile.smarttrace.view;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class LlenControl extends TabActivity implements OnTabChangeListener{
	private TabHost mTabHost;
	private String lastTabID;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Drawable drawClock = getResources().getDrawable(R.drawable.selector_clock);
        Drawable drawStop = getResources().getDrawable(R.drawable.selector_stop);
        Drawable drawNote = getResources().getDrawable(R.drawable.selector_note);

		setmTabHost(getTabHost());
		getmTabHost().addTab(getmTabHost().newTabSpec("sample2").setIndicator("INICIAR", drawClock).setContent(new Intent(this, LlenStart.class)));
		getmTabHost().addTab(getmTabHost().newTabSpec("sample3").setIndicator("FINALIZAR", drawStop).setContent(new Intent(this, LlenStop.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		getmTabHost().addTab(getmTabHost().newTabSpec("sample4").setIndicator("RESUMEN", drawNote).setContent(new Intent(this, LlenSummary.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
		//Hola, mi nombre es Wuilder Alvarado

		getmTabHost().setCurrentTabByTag("wifiMenu");
		getmTabHost().setOnTabChangedListener(this);
		lastTabID = getmTabHost().getCurrentTabTag();
	}
	
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
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

}
