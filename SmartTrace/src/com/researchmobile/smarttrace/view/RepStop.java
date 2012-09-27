package com.researchmobile.smarttrace.view;

import com.researchmobile.smarttrace.entity.BarrelList;
import com.researchmobile.smarttrace.utility.MyDate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RepStop extends Activity implements OnClickListener{
	
	private EditText userCodeEditText, barrilCodeEditText, inservibleTapaderaEditText, inservibleBarrilEditText, duelasEditText;
	private Spinner origenSpinner;
	private RadioButton allFinishRadioButton, parcialFinishRadioButton;
	private Button finishButton;
	private BarrelList list;
	
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		setContentView(R.layout.rep_stop);
		
		ComponentPrepare();
	}

	
	private void ComponentPrepare() {
		setList(new BarrelList());
		setUserCodeEditText((EditText)findViewById(R.id.rep_stop_user_edittext));
		getUserCodeEditText().setOnClickListener(this);
		setBarrilCodeEditText((EditText)findViewById(R.id.rep_start_barrel_edittext));
		setInservibleTapaderaEditText((EditText)findViewById(R.id.rep_stop_inservible_tapadera_edittext));
		setInservibleBarrilEditText((EditText)findViewById(R.id.rep_stop_inservible_barril_edittext));
		
		setOrigenSpinner((Spinner)findViewById(R.id.rep_stop_origen_spinner));
		
		setAllFinishRadioButton((RadioButton)findViewById(R.id.rep_stop_allend_radiobutton));
		setParcialFinishRadioButton((RadioButton)findViewById(R.id.rep_stop_parcialend_radiobutton));
		
		setFinishButton((Button)findViewById(R.id.rep_stop_finish_button));
		getFinishButton().setOnClickListener(this);
		
	}


	public void onClick(View view){
		if (view == getFinishButton()){
			finalizarProceso();
		}
		
		//Control EditText
		if (view == getUserCodeEditText()){
			activeScanUser();
		}
		
	}


	private void finalizarProceso() {
		if (getUserCodeEditText().getText().toString().equalsIgnoreCase("")){
			
		}else{
			MyDate mDate = new MyDate();
			BarrelList list = new BarrelList();
			String usuario = getUserCodeEditText().getText().toString();
			int tamano = list.getBarrelList().size();
			for (int i = 0; i < tamano; i++){
				if (list.getBarrelList().get(i).getUser().equalsIgnoreCase(usuario)){
					list.getBarrelList().get(i).setDate2(mDate.FechaHoy() + " " + mDate.Hora());
					list.getBarrelList().get(i).setState("Finalizado");
					clearComponent();
				}
			}
		}
		
	}
	
	private void clearComponent() {
		getUserCodeEditText().setText("");
		getBarrilCodeEditText().setText("");
		getInservibleBarrilEditText().setText("");
		getInservibleTapaderaEditText().setText("");
		getDuelasEditText().setText("");
	}
	
	private void activeScanUser() {
		IntentIntegrator integrator = new IntentIntegrator(this);
		integrator.initiateScan();
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null) {
			String barcode;
			barcode = scanResult.getContents();
			getUserCodeEditText().setText(barcode);
			
			int tamano = getList().getBarrelList().size();
			int cont = 0;
			for (int i = 0; i < tamano; i++){
				if (getList().getBarrelList().get(i).getUser().equalsIgnoreCase(barcode)){
					getBarrilCodeEditText().setText(getList().getBarrelList().get(i).getCode());
					cont++;
				}
			}
			if (cont==0){
				getUserCodeEditText().setText("");
				Toast.makeText(getBaseContext(), "No ha iniciado procesos", Toast.LENGTH_SHORT).show();
			}
			
		}
	}


	public EditText getUserCodeEditText() {
		return userCodeEditText;
	}


	public void setUserCodeEditText(EditText userCodeEditText) {
		this.userCodeEditText = userCodeEditText;
	}


	public EditText getBarrilCodeEditText() {
		return barrilCodeEditText;
	}


	public void setBarrilCodeEditText(EditText barrilCodeEditText) {
		this.barrilCodeEditText = barrilCodeEditText;
	}


	public EditText getInservibleTapaderaEditText() {
		return inservibleTapaderaEditText;
	}


	public void setInservibleTapaderaEditText(EditText inservibleTapaderaEditText) {
		this.inservibleTapaderaEditText = inservibleTapaderaEditText;
	}


	public EditText getInservibleBarrilEditText() {
		return inservibleBarrilEditText;
	}


	public void setInservibleBarrilEditText(EditText inservibleBarrilEditText) {
		this.inservibleBarrilEditText = inservibleBarrilEditText;
	}


	public EditText getDuelasEditText() {
		return duelasEditText;
	}


	public void setDuelasEditText(EditText duelasEditText) {
		this.duelasEditText = duelasEditText;
	}


	public Spinner getOrigenSpinner() {
		return origenSpinner;
	}


	public void setOrigenSpinner(Spinner origenSpinner) {
		this.origenSpinner = origenSpinner;
	}


	public RadioButton getAllFinishRadioButton() {
		return allFinishRadioButton;
	}


	public void setAllFinishRadioButton(RadioButton allFinishRadioButton) {
		this.allFinishRadioButton = allFinishRadioButton;
	}


	public RadioButton getParcialFinishRadioButton() {
		return parcialFinishRadioButton;
	}


	public void setParcialFinishRadioButton(RadioButton parcialFinishRadioButton) {
		this.parcialFinishRadioButton = parcialFinishRadioButton;
	}


	public Button getFinishButton() {
		return finishButton;
	}


	public void setFinishButton(Button finishButton) {
		this.finishButton = finishButton;
	}


	public BarrelList getList() {
		return list;
	}


	public void setList(BarrelList list) {
		this.list = list;
	}
	
}


