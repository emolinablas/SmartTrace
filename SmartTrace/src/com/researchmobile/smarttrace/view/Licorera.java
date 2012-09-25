package com.researchmobile.smarttrace.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Licorera extends Activity implements OnClickListener{
	
	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button enterButton;
	
	private String username;
	private String password;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setUsernameEditText((EditText)findViewById(R.id.login_username_edittext));
        setPasswordEditText((EditText)findViewById(R.id.login_password_edittext));
        setEnterButton((Button)findViewById(R.id.login_enter_button));
        getEnterButton().setOnClickListener(this);
        
    }
    
    @Override
	public void onClick(View view) {
		if (view == getEnterButton()){
			setUsername(getUsernameEditText().getText().toString());
			setPassword(getPasswordEditText().getText().toString());
			Intent intent = new Intent(Licorera.this, ScanControl.class);
			startActivity(intent);
		}
		
	}
	public EditText getUsernameEditText() {
		return usernameEditText;
	}
	public void setUsernameEditText(EditText usernameEditText) {
		this.usernameEditText = usernameEditText;
	}
	public EditText getPasswordEditText() {
		return passwordEditText;
	}
	public void setPasswordEditText(EditText passwordEditText) {
		this.passwordEditText = passwordEditText;
	}
	public Button getEnterButton() {
		return enterButton;
	}
	public void setEnterButton(Button enterButton) {
		this.enterButton = enterButton;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}