package com.example.archer;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas;
import android.view.Menu;

public class GameActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_game);
		setContentView(new MainGamePanel(this));//set the content view to the Game Controller

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
