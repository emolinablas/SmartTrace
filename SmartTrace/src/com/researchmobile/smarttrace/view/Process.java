package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Process extends Activity implements OnClickListener{
	
	private ImageButton armarButton, repararButton, rasparButton, quemarButton, empanzarButton, llenarButton;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.st_process);
		ComponentPrepare();
	}
	
	private void ComponentPrepare() {
		setArmarButton((ImageButton)findViewById(R.id.process_armar_button));
		setRepararButton((ImageButton)findViewById(R.id.process_reparar_button));
		setRasparButton((ImageButton)findViewById(R.id.process_raspar_button));
		setQuemarButton((ImageButton)findViewById(R.id.process_quemar_empanzar));
		setEmpanzarButton((ImageButton)findViewById(R.id.process_empanzar_button));
		setLlenarButton((ImageButton)findViewById(R.id.process_llenar_button));
		
		getArmarButton().setOnClickListener(this);
		getRepararButton().setOnClickListener(this);
		getRasparButton().setOnClickListener(this);
		getQuemarButton().setOnClickListener(this);
		getEmpanzarButton().setOnClickListener(this);
		getLlenarButton().setOnClickListener(this);
	}

	public void onClick(View view){
		if (view == getArmarButton()){
			ActivityArm();
		}else if (view == getRepararButton()){
			ActivityRep();
		}else if (view == getRasparButton()){
			ActivityRas();
		}else if (view == getQuemarButton()){
			ActivityQuemar();
		}else if (view == getEmpanzarButton()){
			ActivityEmpanzar();
		}else if (view == getLlenarButton()){
			ActivityLlenar();
		}
		
	}

	private void ActivityArm() {
		Intent intent = new Intent(Process.this, ArmControl.class);
		startActivity(intent);
		
	}
	private void ActivityRep(){
		Intent intent = new Intent (Process.this,RepControl.class);
		startActivity(intent);
	}
	private void ActivityRas(){
		Intent intent = new Intent (Process.this,RasControl.class);
		startActivity(intent);
	}
	private void ActivityQuemar(){
		Intent intent = new Intent (Process.this,QuemarControl.class);
		startActivity(intent);
	}
	private void ActivityEmpanzar(){
		Intent intent = new Intent (Process.this,EmpanzarControl.class);
		startActivity(intent);
	}
	private void ActivityLlenar(){
		Intent intent = new Intent (Process.this,LlenControl.class);
		startActivity(intent);
	}

	public ImageButton getArmarButton() {
		return armarButton;
	}

	public void setArmarButton(ImageButton armarButton) {
		this.armarButton = armarButton;
	}

	public ImageButton getRepararButton() {
		return repararButton;
	}

	public void setRepararButton(ImageButton repararButton) {
		this.repararButton = repararButton;
	}

	public ImageButton getRasparButton() {
		return rasparButton;
	}

	public void setRasparButton(ImageButton rasparButton) {
		this.rasparButton = rasparButton;
	}

	public ImageButton getQuemarButton() {
		return quemarButton;
	}

	public void setQuemarButton(ImageButton quemarButton) {
		this.quemarButton = quemarButton;
	}

	public ImageButton getEmpanzarButton() {
		return empanzarButton;
	}

	public void setEmpanzarButton(ImageButton empanzarButton) {
		this.empanzarButton = empanzarButton;
	}

	public ImageButton getLlenarButton() {
		return llenarButton;
	}

	public void setLlenarButton(ImageButton llenarButton) {
		this.llenarButton = llenarButton;
	}

}
