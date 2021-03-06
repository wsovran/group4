package com.example.archer;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.View;

public class GameActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_game);
		setContentView(new MainGamePanel(this));//set the content view to the Game Controller
	
	}
	
	public void sendMain(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),MainActivity.class);
    	startActivity(nextScreen);
    }
	public void sendShop(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),ShopActivity.class);
    	startActivity(nextScreen);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
