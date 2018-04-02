package com.retrofitaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.arch.persistence.room.Room;

public class MainActivity extends AppCompatActivity
{
    public static final String DATABASE = "users_database";

    private CoordinatorLayout mainLayout;
    private final int REGISTER_ACTIVITY = 101;
    private final int LOGIN_ACTIVITY = 102;
    private AppDatabase database;

	// private Toolbar toolbar;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        database = Room.databaseBuilder(getApplicationContext(),
            AppDatabase.class, DATABASE)
            .allowMainThreadQueries()
            .build();
    }

    // Click handler for floating action button
    public void onFloatingClick(View view){
    	Toast.makeText(MainActivity.this, "Floating Button" 
    		, Toast.LENGTH_SHORT).show();
    }

    // Handler for the register button (R.id.button_register)
    public void onRegister(View view){

    	startActivity(
    		new Intent(this, RegisterActivity.class));
    }


    // Handler for login button (R.id.button_login)
    public void onLogin(View view){

        // Request a user to login.
   		startActivityForResult(
   			new Intent(this, LoginActivity.class), LOGIN_ACTIVITY);	
    }

    // Handler for list accounts button (R.id.button_list_accounts)
    public void onListAccounts(View view){

    	startActivity(
    		new Intent(this, UsersActivity.class));
    }


    @Override
    protected void onActivityResult(
    	int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode == this.REGISTER_ACTIVITY){
    		if(resultCode == Activity.RESULT_OK){
    			// Registeration succeeded

    		}else{
    			// Either email or username already exists.

    		}
    	}else if(requestCode == this.LOGIN_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                // User login was successful.
                String username = data.getStringExtra("username");

                Snackbar.make(mainLayout, 
                    "Welcome back " + username, Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();

            }else if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.menu_main, menu);
    	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	int id = item.getItemId();

    	switch(id){
    		case R.id.action_settings:
    			Toast.makeText(MainActivity.this, 
    				"Menu Item selected" , Toast.LENGTH_SHORT).show();
    			break;

            // Clears all users in the database
            case R.id.action_clear_database:
                database.userDao().deleteAllUsers();
                Snackbar.make(mainLayout, "Cleared database" 
                    ,Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                break;
    	}

    	return true;
    }
}
