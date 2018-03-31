package com.retrofitaccount;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.arch.persistence.room.Room;


public class LoginActivity extends AppCompatActivity{

	private AppDatabase database;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		
	}
}