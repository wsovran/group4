package com.example.archer;
import android.app.Application;


public class Globals extends Application {
	private int money;
	private int score;
	private int level;
	private int archerDamage;
	private int allySpawnRate;
	private int allyDamage;
	private int allyHealth;
	private boolean doubleShot;
	private boolean pierceShot;
	
	public Globals()
	{
		money = 0;
		score = 0;
		level = 1;
		archerDamage = 50;
		allyDamage = 25;
		allySpawnRate = 500;
		allyHealth = 100;
		doubleShot = false;
		pierceShot = false;
	}
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int value)
	{
		money = value;
	}
	public boolean addMoney(int value)
	{
			money += value;
			return true;
	}
	public boolean subMoney(int value)
	{
		if(money-value < 0 )
			return false;
		money -= value;
		return true;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int value)
	{
		score = value;
	}
	public boolean addScore(int value)
	{
		score+=value;
		return true;
	}
	public boolean subScore(int value)
	{
		if(score-value < 0 )
			return false;
		score -= value;
		return true;
	} 
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int value)
	{
		level = value;
	}
	public boolean nextLevel()
	{
		level++;
		return true;
	}
	public int getSpawnRate() {
		
		return allySpawnRate;
	}

}
