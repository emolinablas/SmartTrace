package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Actions extends Activity implements OnClickListener{
	private ImageButton procesosButton, asociarButton, enviarButton, reportesButton, variosButton, mezclasButton;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.st_actions);
        
        ComponentPrepare();
	}

	private void ComponentPrepare() {
		setProcesosButton((ImageButton)findViewById(R.id.actions_procesos_button));
		setAsociarButton((ImageButton)findViewById(R.id.acctions_asociar_button));
		setEnviarButton((ImageButton)findViewById(R.id.actions_enviar_button));
		setReportesButton((ImageButton)findViewById(R.id.actions_reportes_button));
		setVariosButton((ImageButton)findViewById(R.id.actions_procesosvarior_button));
		setMezclasButton((ImageButton)findViewById(R.id.actions_mezclas));
		getProcesosButton().setOnClickListener(this);
		getAsociarButton().setOnClickListener(this);
		getEnviarButton().setOnClickListener(this);
		getReportesButton().setOnClickListener(this);
		getVariosButton().setOnClickListener(this);
		getMezclasButton().setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if (view == getProcesosButton()){
			ProcessActivity();
		}else if (view == getAsociarButton()){
			Toast.makeText(getBaseContext(), "2", Toast.LENGTH_SHORT).show();
		}else if (view == getEnviarButton()){
			Toast.makeText(getBaseContext(), "3", Toast.LENGTH_SHORT).show();
		}else if (view == getReportesButton()){
			Toast.makeText(getBaseContext(), "4", Toast.LENGTH_SHORT).show();
		}else if (view == getVariosButton()){
			Toast.makeText(getBaseContext(), "5", Toast.LENGTH_SHORT).show();
		}else if (view == getMezclasButton()){
			Toast.makeText(getBaseContext(), "6", Toast.LENGTH_SHORT).show();
		}
		
	}

	private void ProcessActivity() {
		Intent intent = new Intent(Actions.this, Process.class);
		startActivity(intent);
		
	}

	public ImageButton getProcesosButton() {
		return procesosButton;
	}

	public void setProcesosButton(ImageButton procesosButton) {
		this.procesosButton = procesosButton;
	}

	public ImageButton getAsociarButton() {
		return asociarButton;
	}

	public void setAsociarButton(ImageButton asociarButton) {
		this.asociarButton = asociarButton;
	}

	public ImageButton getEnviarButton() {
		return enviarButton;
	}

	public void setEnviarButton(ImageButton enviarButton) {
		this.enviarButton = enviarButton;
	}

	public ImageButton getReportesButton() {
		return reportesButton;
	}

	public void setReportesButton(ImageButton reportesButton) {
		this.reportesButton = reportesButton;
	}

	public ImageButton getVariosButton() {
		return variosButton;
	}

	public void setVariosButton(ImageButton variosButton) {
		this.variosButton = variosButton;
	}

	public ImageButton getMezclasButton() {
		return mezclasButton;
	}

	public void setMezclasButton(ImageButton mezclasButton) {
		this.mezclasButton = mezclasButton;
	}
}
