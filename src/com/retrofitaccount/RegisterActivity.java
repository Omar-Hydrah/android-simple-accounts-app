package com.retrofitaccount;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.arch.persistence.room.Room;


public class RegisterActivity extends AppCompatActivity{

	private EditText inputUsername;
	private EditText inputEmail;
	private EditText inputPassword;
	private EditText inputPasswordConfirm;
	private User user;
	private AppDatabase database;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		inputUsername = (EditText) findViewById(R.id.input_username);
		inputEmail    = (EditText) findViewById(R.id.input_email);
		inputPassword = (EditText) findViewById(R.id.input_password);
		inputPasswordConfirm = 
			(EditText) findViewById(R.id.input_password_confirm);

		database = Room.databaseBuilder(getApplicationContext(),
			AppDatabase.class, MainActivity.DATABASE)
			.allowMainThreadQueries()
			.build();
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

		// To check if a user already exists with the same username.

		User existingUser = database.userDao().getUser(user.getUsername());

		if(existingUser != null){

			Toast.makeText(this
				,"Username "+user.getUsername() +
						" already exists - Choose another one." 
				,Toast.LENGTH_LONG).show();
			return; 

		}else{
			database.userDao().insertAll(user);
			existingUser = null;

			// A user has been inserted successfully.
			Toast.makeText(this, "Registering a new user: " + user.getUsername() 
				, Toast.LENGTH_SHORT).show();

			// Navigate to UsersActivity to display the new user.
			startActivity(new Intent(this, UsersActivity.class));
		}
	} 
}