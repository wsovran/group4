package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Arrow {

	 private Bitmap bitmap; // the actual bitmap
	 private int x;   // the X coordinate
	 private int y;   // the Y coordinate
	 private int angle; //shot angle
	 private boolean touched;//state
	 
	 private double xVelocity;
	 private double yVelocity;
	 private int gravity;
	 private float rotate;
	 private int power;
	private int damage;
	
	 public Arrow(Bitmap bitmap, int x, int y,int angle, int damage) {
	  this.bitmap = bitmap;
	  this.x = x;
	  this.y = y;
	  this.angle = angle;
	  this.gravity = 1;
	  rotate = angle;
	  this.damage = damage;
	 }
	
	 public Bitmap getBitmap() {
	  return bitmap;
	 }
	 public void setBitmap(Bitmap bitmap) {
	  this.bitmap = bitmap;
	 }
	 public int getX() {
	  return x;
	 }
	 public void setX(int x) {
		 if (x > 20 && x < 1900)
			 this.x = x;
	 }
	 public int getY() {
	  return y;
	 }
	 public int getWidth()
	 {
		 return bitmap.getWidth();
	 }
	 public int getHeight()
	 {
		 return bitmap.getHeight();
	 }
	 public void setY(int y) {
	  this.y = y;
	 }
	 public void setAngle(int angle){
	 	if (angle < 91 && angle >=0)
		 	this.angle = angle;
	 }
	 public void setDamage(int value)
	 {
		 this.damage = value;
	 }
	 public int getAngle(){
		 return angle;
	 }
	 public boolean isTouched() {
		  return touched;
		 }

	 public void setTouched(boolean touched) {
	  this.touched = touched;
	 }

	 public boolean draw(Canvas canvas) {
		 
		// Matrix matrix = new Matrix();
		// matrix.setRotate(rotate*-1, x, y);
		 x += xVelocity;
		 y -= yVelocity;
		 setYVelocity(yVelocity - gravity);
		 //System.out.println(xVelocity+ " "+yVelocity + " "+ x + " " +x);
		 if((x <0 || x >1920) || (y > 500))
			 return false;
		 
		 
	  canvas.drawBitmap(bitmap,x,y, null);
	  return true;
	  
	}

	public void setVelocity(int power) {
		setXVelocity((power/2.5)*Math.cos(Math.toRadians(angle)));
		setYVelocity((power/2.5)*Math.sin(Math.toRadians(angle)));
		this.power = power;
	}
	public void setXVelocity(double value)
	{
		xVelocity = value;
	}
	public void setYVelocity(double value)
	{
		yVelocity = value;
	}
	public boolean checkCollision(int x, int xMax, int y, int yMax)
	{
		if((this.getWidth()+this.x) >= x && (this.getWidth()+this.x) <= xMax+x && (this.getHeight()+this.y) >= y && (this.getHeight()+this.y) <= yMax+y)
		{
				return true;
		}
		return false;
	}
	public boolean attack(Soldier enemy)
	{
		enemy.wound(damage);
		return true;
	}

	 
}