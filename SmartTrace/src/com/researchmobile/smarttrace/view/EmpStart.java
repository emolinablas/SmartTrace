package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.researchmobile.smarttrace.entity.Barrel;
import com.researchmobile.smarttrace.entity.BarrelList;
import com.researchmobile.smarttrace.utility.MyDate;
import com.researchmobile.smarttrace.utility.MyDialog;

public class EmpStart extends Activity implements OnClickListener{
	
	private EditText userCodeEditText, barrelCodeEditText;
	private Button startButton;
	private MyDialog myDialog;
	private BarrelList list;
	private MyDate myDate;
	
	private int controlScan;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emp_start);
		
		ComponentPrepare();
		//CapturarUsuario();
	}
	
	private void ComponentPrepare() {
		setMyDialog(new MyDialog());
		setMyDate(new MyDate());
		setList(new BarrelList());
		
		setUserCodeEditText((EditText)findViewById(R.id.emp_start_username_edittext));
		getUserCodeEditText().setOnClickListener(this);
		setBarrelCodeEditText((EditText)findViewById(R.id.emp_start_barrel_edittext));
		getBarrelCodeEditText().setOnClickListener(this);
		setStartButton((Button)findViewById(R.id.emp_start_enter_button));
		getStartButton().setOnClickListener(this);
	}

	public void onClick(View view){
		if (view == getStartButton()){
			if (getUserCodeEditText().getText().toString().equalsIgnoreCase("") || getBarrelCodeEditText().getText().toString().equalsIgnoreCase("")){
				getMyDialog().showAlert(this, "Datos Requeridos", "Falta dato de usuario o barril");
			}else{
				getMyDialog().showAlert(this, "Nuevo Proceso", "Proceso Iniciado");
				Barrel barrel = new Barrel();
				barrel.setCapture(1);
				
				barrel.setCode(getBarrelCodeEditText().getText().toString());
				barrel.setUser(getUserCodeEditText().getText().toString());
				barrel.setState("en proceso");
				barrel.setHour1(getMyDate().Hora());
				barrel.setDate1(getMyDate().FechaHoy());
				barrel.setHour2(" ");
				barrel.setDate2(" ");
				
				getList().getBarrelList().add(barrel);
				getUserCodeEditText().setText("");
				getBarrelCodeEditText().setText("");
			}
			
			
		}else if (view == getUserCodeEditText()){
			CapturarUsuario();
			//setControlScan(1);
			//System.out.println(getControlScan());
			//IntentIntegrator integrator = new IntentIntegrator(this);
			//integrator.initiateScan();
		}else if (view == getBarrelCodeEditText()){
			CapturarUsuario();
			//setControlScan(0);
			//IntentIntegrator integrator = new IntentIntegrator(this);
			//integrator.initiateScan();
		}
	}
	
	public void CapturarUsuario(){
		setControlScan(0);
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}
	
	public void CapturarBarril(){
		setControlScan(1);
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null) {
			String barcode;
			barcode = scanResult.getContents();
			if (getControlScan() == 0){
				System.out.println("valor control == 0 , " + getControlScan());
				getUserCodeEditText().setText(barcode);
				CapturarBarril();
			}else{
				System.out.println("valor control == 1 , " + getControlScan());
				getBarrelCodeEditText().setText(barcode);
				
			}
			
			
		}
	}
	/*
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    */


	public EditText getUserCodeEditText() {
		return userCodeEditText;
	}

	public void setUserCodeEditText(EditText userCodeEditText) {
		this.userCodeEditText = userCodeEditText;
	}

	public EditText getBarrelCodeEditText() {
		return barrelCodeEditText;
	}

	public void setBarrelCodeEditText(EditText barrelCodeEditText) {
		this.barrelCodeEditText = barrelCodeEditText;
	}

	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public int getControlScan() {
		return controlScan;
	}

	public void setControlScan(int controlScan) {
		this.controlScan = controlScan;
	}

	public MyDialog getMyDialog() {
		return myDialog;
	}

	public void setMyDialog(MyDialog myDialog) {
		this.myDialog = myDialog;
	}

	public BarrelList getList() {
		return list;
	}

	public void setList(BarrelList list) {
		this.list = list;
	}

	public MyDate getMyDate() {
		return myDate;
	}

	public void setMyDate(MyDate myDate) {
		this.myDate = myDate;
	}

}
