package com.retrofitaccount;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.arch.persistence.room.Room;

import java.util.List;
import java.util.ArrayList;


public class UsersActivity extends AppCompatActivity{

	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private List<User> users;
	private AppDatabase database;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_users);

		database = Room.databaseBuilder(getApplicationContext(), 
			AppDatabase.class, MainActivity.DATABASE)
			.allowMainThreadQueries()
			.build();

		List<User> mockUsers = new ArrayList<>();
		mockUsers.add(new User("Omar", "omar@email.com", "29iuaskj"));
		mockUsers.add(new User("Hassan", "hassan@email.com", "kasj2"));
		mockUsers.add(new User("Ahmad", "ahmad@email.com", "sak29"));

		database.userDao().insertAll(mockUsers.get(1));
		database.userDao().insertAll(mockUsers.get(0));
		database.userDao().insertAll(mockUsers.get(2));
		users = database.userDao().getAllUsers();	

		adapter = new UserAdapter(users);

		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
	}
}