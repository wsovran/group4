package com.example.archer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class NewGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_game, menu);
		return true;
	}
	public void sendMain(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),MainActivity.class);
    	startActivity(nextScreen);
    }
	public void sendGame(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),GameActivity.class);
    	startActivity(nextScreen);
    }

}
