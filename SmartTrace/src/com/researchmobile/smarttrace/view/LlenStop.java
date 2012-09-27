package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class LlenStop extends Activity implements OnClickListener{
	
	private EditText userCodeEditText, barrilCodeEditText, inservibleTapaderaEditText, inservibleBarrilEditText, duelasEditText;
	private Spinner origenSpinner;
	private RadioButton allFinishRadioButton, parcialFinishRadioButton;
	private Button finishButton;
	
	public void onCreate(Bundle saveInstanceState){
		super.onCreate(saveInstanceState);
		setContentView(R.layout.llen_stop);
		
		ComponentPrepare();
	}

	
	private void ComponentPrepare() {
		setUserCodeEditText((EditText)findViewById(R.id.llen_stop_user_edittext));
		setBarrilCodeEditText((EditText)findViewById(R.id.llen_start_barrel_edittext));
		
		setFinishButton((Button)findViewById(R.id.llen_stop_finish_button));
		getFinishButton().setOnClickListener(this);
		
	}


	public void onClick(View view){
		if (view == getFinishButton()){
			
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
	
}


