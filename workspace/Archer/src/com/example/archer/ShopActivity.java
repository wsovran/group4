package com.example.archer;

import android.os.Bundle;
import android.app.Activity;
import android.util.MonthDisplayHelper;
import android.view.Menu;
import android.widget.TextView;

public class ShopActivity extends Activity {

	private Globals global;
	private int money;
	private TextView moneyView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		
		global = ((Globals)this.getApplication());
		money = global.getMoney();
		
		moneyView = (TextView)findViewById(R.id.moneyDisplay);
		moneyView.setText(money+"");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}
	public void updateFunds(int value)
	{
		
	}

}
