package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Soldier {
	private int health;
	private int moveSpeed;
	private int damage;
	private int x;
	private int attackSpeed;
	private Bitmap bitmap;
	private int y;
	
	public Soldier(Bitmap bitmap, int health, int moveSpeed, int damage, int x, int attackspeed)
	{
		y = 50; 
		this.bitmap=bitmap;
		this.health=health;
		this.moveSpeed=moveSpeed;
		this.damage=damage;
		this.x=x;
		this.attackSpeed = attackspeed;
	}
	
	
	public int getHealth()
	{
		return this.health;
	}
	public void setHealth(int value)
	{
		this.health = value;
	}
	public int getMoveSpeed()
	{
		return this.moveSpeed;
	}
	public void setMoveSpeed(int value)
	{
		this.moveSpeed = value;
	}
	public int getDamage()
	{
		return this.damage;
	}
	public void setDamage(int value)
	{
		this.health = value;
	}
	public int getX()
	{
		return this.x;
	}
	public void setX(int value)
	{
		this.x = value;
	}
	public int getY()
	{
		return this.y;
	}
	public int getWidth()
	 {
		 return bitmap.getWidth();
	 }
	 public int getHeight()
	 {
		 return bitmap.getHeight();
	 }
	public void setY(int value)
	{
		this.y = value;
	}
	public Bitmap getBitmap()
	{
		  return bitmap;
	 }
	 public void setBitmap(Bitmap bitmap)
	 {
		  this.bitmap = bitmap;
	 }
	public void draw(Canvas canvas)
	{
		x+=this.moveSpeed;
		canvas.drawBitmap(bitmap,x,y, null);
	}
	public void drawStill(Canvas canvas)
	{
		canvas.drawBitmap(bitmap,x,y, null);
	}
	public boolean winCon (boolean direction)
	{
		return direction && this.x < 0 ? true : !direction && this.x > 1920 ? true : false;
	}
	
	public boolean checkCollision(int x, int xMax, int y, int yMax)
	{
		if(x>= this.x && x<=bitmap.getWidth()+this.x)
			return true;
		if((xMax+x)>= this.x && (xMax+x)<=bitmap.getWidth()+this.x)
			return true;
		return false;
	}
	public boolean attack(int speed, Soldier enemy)
	{
		if(speed % this.attackSpeed ==0)
		{
			enemy.wound(this.damage);
			return true;
		}
		return false;
		
	}
	public void wound(int damage)
	{
		health -= damage;	
	}
	public boolean isDead()
	{
		return this.health<=0;
	}

}
