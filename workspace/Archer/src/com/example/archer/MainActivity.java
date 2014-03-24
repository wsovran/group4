package com.example.archer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void sendTutorial(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),TutorialActivity.class);
    	startActivity(nextScreen);
    }
    public void sendOptions(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),OptionsActivity.class);
    	startActivity(nextScreen);
    }
    public void sendHighScores(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),HighScoreActivity.class);
    	startActivity(nextScreen);
    }
    public void sendNewGame(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),NewGameActivity.class);
    	startActivity(nextScreen);
    }
    public void sendGame(View view)
    {
    	Intent nextScreen = new Intent(getApplicationContext(),GameActivity.class);
    	startActivity(nextScreen);
    }
}
