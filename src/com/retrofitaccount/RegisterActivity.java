package com.retrofitaccount;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity{

	private EditText inputUsername;
	private EditText inputEmail;
	private EditText inputPassword;
	private EditText inputPasswordConfirm;
	private User user;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		inputUsername = (EditText) findViewById(R.id.input_username);
		inputEmail    = (EditText) findViewById(R.id.input_email);
		inputPassword = (EditText) findViewById(R.id.input_password);
		inputPasswordConfirm = 
			(EditText) findViewById(R.id.input_password_confirm);

	}

	public void onRegister(View view){

		String password        = inputPassword.getText().toString();
		String passwordConfirm = inputPasswordConfirm.getText().toString();

		user = new User(
			inputUsername.getText().toString(),
			inputEmail.getText().toString(),
			password
		);

		// If the password two fields don't match.
		if(!password.equals(passwordConfirm)){
			Toast.makeText(this, 
				"Password mismatch - please type the password again", 
				Toast.LENGTH_LONG).show();
			return;
		}
		Toast.makeText(this, "Registering a new user: " + user.getUsername() 
			, Toast.LENGTH_SHORT).show();
	} 
}