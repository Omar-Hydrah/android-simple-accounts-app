package com.retrofitaccount;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.arch.persistence.room.Room;

public class LoginActivity extends AppCompatActivity{

	private AppDatabase database;
	private EditText inputUsername;
	private EditText inputPassword;
	private final int CORRECT_PASSWORD = 1;
	private final int WRONG_USERNAME = 2;
	private final int WRONG_PASSWORD = 3;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
			
		inputUsername = (EditText) findViewById(R.id.input_username);
		inputPassword = (EditText) findViewById(R.id.input_password);

		database = Room.databaseBuilder(getApplicationContext(),
			AppDatabase.class, MainActivity.DATABASE)
			.allowMainThreadQueries()
			.build();
	}

	// Checks whether or not the user login is correct.
	private int validateForm(User user){
		// Returning an instance for the user, by its unique username field.
		User databaseUser = database.userDao().getUser(user.getUsername());

		if(databaseUser == null){
			// No user exists by this username.
			return WRONG_USERNAME;

		}

		if(databaseUser.getUsername().equals(user.getUsername())){
		// The username in databaseUser, matches the entered username.

			if(databaseUser.getPassword().equals(user.getPassword())){
				// The password is a match.
				// Successfull login. 
				return CORRECT_PASSWORD;
			}else{
				// Wrong password
				return WRONG_PASSWORD;
			}
		}
		
		// Unknown result
		return 0;
	}

	public void onLogin(View view){
		User user = new User(
			inputUsername.getText().toString(),
			inputPassword.getText().toString());

		int result = validateForm(user);

		if(result == CORRECT_PASSWORD){
			Toast.makeText(this, "Successful Login", Toast.LENGTH_SHORT).show();
			Intent resultIntent = new Intent();
			// Return the username to MainActivity
			resultIntent.putExtra("username", user.getUsername());

			// To return to MainActivity
			setResult(Activity.RESULT_OK, resultIntent);
			finish();

		}else if(result == WRONG_USERNAME ){
			Toast.makeText(this, "No user found", Toast.LENGTH_SHORT).show();

		}else if(result == WRONG_PASSWORD){
			Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Failed to process login" 
				, Toast.LENGTH_SHORT).show();
		}
	}

}