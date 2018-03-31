package com.retrofitaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
	private CoordinatorLayout mainLayout;
	private final int REGISTER_ACTIVITY = 101;
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


    }

    // Click handler for floating action button
    public void onFloatingClick(View view){
    	Toast.makeText(MainActivity.this, "Floating Button" 
    		, Toast.LENGTH_SHORT).show();
    }

    // Handler for the register button (R.id.button_register)
    public void onRegister(View view){
    	Toast.makeText(MainActivity.this, "Register a new account"
    		, Toast.LENGTH_SHORT).show();

    	startActivity(
    		new Intent(MainActivity.this, RegisterActivity.class));
    }


    // Handler for login button (R.id.button_login)
    public void onLogin(View view){
    	Toast.makeText(MainActivity.this, "Login clicked" 
    		, Toast.LENGTH_SHORT).show();

   		startActivity(
   			new Intent(MainActivity.this, LoginActivity.class));	
    }

    // Handler for list accounts button (R.id.button_list_accounts)
    public void onListAccounts(View view){
    	Toast.makeText(MainActivity.this, "Listing accounts"
    		, Toast.LENGTH_SHORT).show();

    	startActivity(
    		new Intent(MainActivity.this, AccountsActivity.class));
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
    	}

    	return true;
    }
}
