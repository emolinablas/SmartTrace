package com.researchmobile.smarttrace.view;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.researchmobile.smarttrace.entity.Barrel;
import com.researchmobile.smarttrace.entity.BarrelList;

public class Scan extends Activity implements OnClickListener{
	
	private Button scanButton;
	private TextView resultTextView;
	int i = 0;
	private BarrelList barrelList;
	private Barrel barrel;
	
	private ToggleButton luzButton;
	private Spinner tempSpinner;
	private Button fotoButton;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);
        
        setBarrelList(new BarrelList());
        setScanButton((Button)findViewById(R.id.scan_capture_button));
        getScanButton().setOnClickListener(this);
        setResultTextView((TextView)findViewById(R.id.scan_result_textview));
    }

	@SuppressWarnings("static-access")
	@Override
	public void onClick(View view) {
		if (view == getScanButton()){
			
			IntentIntegrator integrator = new IntentIntegrator(this);
			integrator.initiateScan();
		}
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null) {
			setBarrel(new Barrel());

			String barcode;

			barcode = scanResult.getContents();
			getBarrel().setCode(barcode);
			getResultTextView().setText(barcode);
			
			MyDialog();
		}

		// else continue with any other code you need in the method

	}
	
	
	
	private void MyDialog() {
		LayoutInflater factory = LayoutInflater.from(this);
		final View textEntryView = factory.inflate(R.layout.scan_state_dialog, null);
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		
		setLuzButton((ToggleButton)textEntryView.findViewById(R.id.estadoLuzButton));
        setTempSpinner((Spinner)textEntryView.findViewById(R.id.tempSpinner));
        PrepateSpinner();
        setFotoButton((Button)textEntryView.findViewById(R.id.fotoButton));
        getFotoButton().setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				activeCamera();
				
			}

			private void activeCamera() {
				//Activar la camara
			  	Intent cIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				//asignar nombre y direccion a la imagen
				String path = "/" + getResultTextView().getText() +".jpg";
				//crear nuevo archivo (imagen)
				getBarrel().setPath("sdcard/" + path);
				getBarrel().setCapture(1);
				File f = new File(Environment.getExternalStorageDirectory() + path);
				Uri uri = Uri.fromFile(f);
				cIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivityForResult(cIntent, 0);
			}
		});
		        
		alert.setTitle(getBarrel().getCode());
		alert.setView(textEntryView);

		alert.setPositiveButton("   OK   ", new DialogInterface.OnClickListener()
		{
		     public void onClick(DialogInterface dialog, int whichButton)
		     {
		    	 
		    	 getBarrel().setLuz(getLuzButton().getText().toString());
		    	 getBarrel().setTemperatura(getTempSpinner().getSelectedItem().toString());
		    	 getBarrelList().getBarrelList().add(getBarrel());
		     }
		});
		 

		alert.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener()
		{
		     public void onClick(DialogInterface dialog, int whichButton)
		     {
		          // Canceled.
		     }
		});

		alert.show();
	}

	private void PrepateSpinner() {
		
		ArrayAdapter<String> adaptador =
	        new ArrayAdapter<String>(this, R.layout.row_spinner, R.id.row_spinner_dialog, new String[]{"Bien", "Regular", "Mal"});
		getTempSpinner().setAdapter(adaptador);
	}

	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


	public Button getScanButton() {
		return scanButton;
	}

	public void setScanButton(Button scanButton) {
		this.scanButton = scanButton;
	}

	public TextView getResultTextView() {
		return resultTextView;
	}

	public void setResultTextView(TextView resultTextView) {
		this.resultTextView = resultTextView;
	}

	public BarrelList getBarrelList() {
		return barrelList;
	}

	public void setBarrelList(BarrelList barrelList) {
		this.barrelList = barrelList;
	}

	public ToggleButton getLuzButton() {
		return luzButton;
	}

	public void setLuzButton(ToggleButton luzButton) {
		this.luzButton = luzButton;
	}

	public Spinner getTempSpinner() {
		return tempSpinner;
	}

	public void setTempSpinner(Spinner tempSpinner) {
		this.tempSpinner = tempSpinner;
	}

	public Button getFotoButton() {
		return fotoButton;
	}

	public void setFotoButton(Button fotoButton) {
		this.fotoButton = fotoButton;
	}

	public Barrel getBarrel() {
		return barrel;
	}

	public void setBarrel(Barrel barrel) {
		this.barrel = barrel;
	}
}
