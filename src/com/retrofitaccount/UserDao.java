package com.retrofitaccount;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Insert;

import java.util.List;

@Dao
public interface UserDao{

	@Query("select * from users")
	List<User> getAllUsers();

	@Insert
	void insertAll(User... user);

	@Query("select * from users where username = :username")
	User getUser(String username);

	@Query("delete from users")
	void deleteAllUsers();
}