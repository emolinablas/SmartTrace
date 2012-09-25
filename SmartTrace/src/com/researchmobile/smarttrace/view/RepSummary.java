package com.researchmobile.smarttrace.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.researchmobile.smarttrace.entity.Barrel;
import com.researchmobile.smarttrace.entity.BarrelList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class RepSummary extends Activity{
	private EditText userEditText;
	private TextView totalTextView;
	private BarrelList list;
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> arrayList;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rep_summary);
		
		ComponentPrepare();
		ObtenerDatos();
	}

	private void ObtenerDatos() {
		
		int cant = list.getBarrelList().size();
		
		if (cant > 0){
			ListView listView = (ListView)findViewById(R.id.rep_summary_listview);
			
			setArrayList(convertArray(list.getBarrelList(), this));
			
			setSimpleAdapter(new SimpleAdapter(this, getArrayList(), R.layout.row_rep_summary,
	                new String[] {"code", "state", "date1", "date2"}, 
	                new int[] {R.id.row_rep_summary_code, R.id.row_rep_summary_state, R.id.row_rep_summary_date1, R.id.row_rep_summary_date2}));
	        
			listView.setAdapter(getSimpleAdapter());
			registerForContextMenu(listView);
			     
		}
		else{
			Toast.makeText(getBaseContext(), "Aún no hay datos", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	private ArrayList<HashMap<String, Object>> convertArray(List<Barrel> barrelList, Context context) {
		ArrayList<HashMap<String, Object>> myList = new ArrayList<HashMap<String, Object>>();
		int stateOff = context.getResources().getIdentifier("logo_lg", "drawable", context.getPackageName());

		for (int i = 0; i < barrelList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("code", barrelList.get(i).getCode());
			map.put("state", barrelList.get(i).getState());
			map.put("date1", barrelList.get(i).getDate1() + " " + " " + barrelList.get(i).getHour1());
			map.put("date2", barrelList.get(i).getDate2() + " " + " " + barrelList.get(i).getHour2());

			// Selected state image
			if (barrelList.get(i).getCapture() != 1) {
				map.put("image", stateOff);
			} else {
				map.put("image", barrelList.get(i).getPath());
			}
			myList.add(map);
		}
		System.out.println(myList.size());
		return myList;
	}

	private void ComponentPrepare() {
		setTotalTextView((TextView)findViewById(R.id.rep_summary_total_textview));
		getTotalTextView().setText(String.valueOf(getList().getBarrelList().size()));
		
	}

	public EditText getUserEditText() {
		return userEditText;
	}

	public void setUserEditText(EditText userEditText) {
		this.userEditText = userEditText;
	}

	public TextView getTotalTextView() {
		return totalTextView;
	}

	public void setTotalTextView(TextView totalTextView) {
		this.totalTextView = totalTextView;
	}

	public BarrelList getList() {
		return list;
	}

	public void setList(BarrelList list) {
		this.list = list;
	}

	public SimpleAdapter getSimpleAdapter() {
		return simpleAdapter;
	}

	public void setSimpleAdapter(SimpleAdapter simpleAdapter) {
		this.simpleAdapter = simpleAdapter;
	}

	public ArrayList<HashMap<String, Object>> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<HashMap<String, Object>> arrayList) {
		this.arrayList = arrayList;
	}

}
