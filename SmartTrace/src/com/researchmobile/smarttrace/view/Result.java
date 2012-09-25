package com.researchmobile.smarttrace.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.researchmobile.smarttrace.entity.Barrel;
import com.researchmobile.smarttrace.entity.BarrelList;

public class Result extends Activity implements OnClickListener{
	
	private BarrelList list;
	private String[] listString;
	private SimpleAdapter simpleAdapter;
	private ArrayList<HashMap<String, Object>> arrayList;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        
        ObtenerDatos();
    }
	
	private void ObtenerDatos() {
		int cant = list.getBarrelList().size();
		
		if (cant > 0){
			ListView listView = (ListView)findViewById(R.id.result_list_listview);
			
			setArrayList(convertArray(list.getBarrelList(), this));
			setSimpleAdapter(new SimpleAdapter(this, getArrayList(), R.layout.row,
	                new String[] {"barrel", "luz", "tem", "image"}, 
	                new int[] {R.id.item_list_code_result, R.id.item_list_luz_result, R.id.item_list_temp_result, R.id.item_list_image_result}));
	        
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
			map.put("barrel", barrelList.get(i).getCode());
			map.put("luz", barrelList.get(i).getLuz());
			map.put("tem", barrelList.get(i).getTemperatura());

			// Selected state image
			if (barrelList.get(i).getCapture() != 1) {
				map.put("image", stateOff);
			} else {
				map.put("image", barrelList.get(i).getPath());
			}
			myList.add(map);
		}
		return myList;
	}

	@Override
	public void onClick(View view) {
		
		
	}


	public BarrelList getList() {
		return list;
	}

	public void setList(BarrelList list) {
		this.list = list;
	}

	public String[] getListString() {
		return listString;
	}

	public void setListString(String[] listString) {
		this.listString = listString;
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
