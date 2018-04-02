package com.retrofitaccount;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Ignore;


@Entity(
	tableName="users"
)
public class User{

	@PrimaryKey(autoGenerate = true)
	private int id;

	@ColumnInfo(name="username")
	private String username;

	@ColumnInfo(name= "email")
	private String email;

	@ColumnInfo(name = "password")
	private String password;

	public User(String username, String email, String password){
		this.username = username;
		this.email    = email;
		this.password = password;
	}

	@Ignore
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() { return this.username; }
	public void setUsername(String username) { this.username = username; }
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	public int getId(){return this.id;}
	public void setId(int id){this.id = id;} 
}