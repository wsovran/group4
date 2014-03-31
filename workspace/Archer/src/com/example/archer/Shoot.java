package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Shoot {

	 private Bitmap bitmap; // the actual bitmap
	 private int x;   // the X coordinate
	 private int y;   // the Y coordinate
	 private boolean touched;//state
	 private int power;
	 private boolean increment = true;
	
	 public Shoot(Bitmap bitmap, int x, int y) {
	  this.bitmap = bitmap;
	  this.x = x;
	  this.y = y;
	  power = 1;
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
	  this.x = x;
	 }
	 public int getY() {
	  return y;
	 }
	 
	 public void setY(int y) {
	  this.y = y;
	 }
	 public boolean isTouched() {
		  return touched;
	 }
	 public void setTouched(boolean touched) {
		 this.touched = touched;
	 }
	 public void adjustPower(boolean inc)
	 {
		 if(power < 100 && inc)
		 {
			 power+=2;
			 
		 }
		 else if(power > 0 && !inc)
		 {
			 power-=2;

		 }
	 }
	 public int getPower()
	 {
		 return power;
	 }
	 public void setPower(int power)
	 {
		 if(power > 0 && power<100)
		 {
			 this.power=power;
		 }
	 }
	 public void draw(Canvas canvas) {
		 Paint paint = new Paint();
		 paint.setAlpha(100);
		 canvas.drawBitmap(bitmap, x, y, paint);
	 }
	 public void handleActionDown()
	 {
		 if(power >= 100)
		 {
			 increment = false;
		 }
		 else if(power <= 1)
		 {
			 increment = true;
		 }
		 adjustPower(increment);
	 }
	 public void handleActionUp(Arrow arrow, int angle)
	 {
		 //TO - do create arrow with power and angle
		 arrow.setAngle(angle);
		 arrow.setVelocity(power);
		 power = 1;
		 increment = true;
		 
	 }
	 public void checkBounds(int x, int y)
	 {
		 if(x >= this.x && x<= bitmap.getWidth()+this.x && y >= this.y && y <= bitmap.getHeight()+this.y)
			 setTouched(true);
	 }
}
	 