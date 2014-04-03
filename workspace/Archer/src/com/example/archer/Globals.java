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
	private int archerDamageLevel;
	private int allySpawnRateLevel;
	private int allyDamageLevel;
	private int allyHealthLevel;
	
	
	public Globals()
	{
		money = 0;
		score = 0;
		level = 0;
		archerDamage = 10;
		allyDamage = 25;
		allySpawnRate = 450;
		allyHealth = 100;
		doubleShot = false;
		pierceShot = false;
		archerDamageLevel = 1;
		allyDamageLevel = 1;
		allySpawnRateLevel = 1;
		allyHealthLevel =1;
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
	public int getArcherDamage()
	{
		return (archerDamageLevel *25) + archerDamage;
	}
	public void incArcherDamgeLevel()
	{
		archerDamageLevel++;
	}
	public void setArcherDamageLevel(int value)
	{
		archerDamageLevel = value;
	}
	
	public int getCost(int button)
	{
		switch(button)
		{
			case 1:
				return (archerDamageLevel * 25) + 25;
			case 2:
				return 2000;
			case 3:
				return 5000;
			case 4:
				return (allyDamageLevel * 25);
			case 5:
				return (allySpawnRateLevel * 50);
			case 6:
				return (allyHealthLevel * 100);
			default:
				return -1;
				
		}
	}
	public void setDoubleShot(boolean value)
	{
		doubleShot = value;
	}
	public void activateDoubleShot()
	{
		doubleShot = true;
	}
	public boolean isDoubleShot()
	{
		return doubleShot;
	}
	public void activatePiercingShot()
	{
		pierceShot = true;
	}
	public boolean isPiercingShot()
	{
		return pierceShot;
	}
	public void incSoldierDamageLevel() {
		allyDamageLevel++;
		
	}
	public void setSoldierDamageLevel(int value)
	{
		allyDamageLevel = value;
	}
	public int getSoldierDamageLevel()
	{
		return allyDamageLevel;
	}
	public int getSoldierDamage()
	{
		return (allyDamageLevel *10) + allyDamage;
	}
	public void setSoldierSpawnRateLevel(int value){
		allySpawnRateLevel = value;
	}
	public int getSoldierSpawnRateLevel()
	{
		return allySpawnRateLevel;
	}
	public void incSoldierSpawnRateLevel()
	{
		allySpawnRateLevel++;
	}
	public int getSoldierHealth()
	{
		return (allyHealthLevel *20)+100;
	}
	public int getSoldierHealthLevel()
	{
		return allyHealthLevel;
	}
	public void setSoldierHealthLevel(int value)
	{
		allyHealthLevel = value;
	}
	public void incSoldierHealthLevel()
	{
		allyHealthLevel++;
	}
	public int getEnemyHealth() {
		
		return (level * 5) +100;
	}
	public int getEnemyDamage() {
		// TODO Auto-generated method stub
		return (level * 4) + 26;
	}

}
