package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Archer {

	 private Bitmap bitmaps[]; // the actual bitmap
	 private int x;   // the X coordinate
	 private int y;   // the Y coordinate
	 private int angle; //shot angle
	 private boolean touched;//state
	 private int currentBitmap;
	 private boolean moving;
	
	 public Archer(Bitmap bitmaps[], int x, int y) {
	  this.bitmaps = bitmaps;
	  this.x = x;
	  this.y = y;
	  this.angle = 0;
	  currentBitmap = 0;
	  moving= false;
	 }
	
	 public Bitmap getBitmap(int index) {
	  return bitmaps[index];
	 }
	 public void setBitmap(Bitmap bitmap, int index) {
	  this.bitmaps[index] = bitmap;
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
	 public void setY(int y) {
	  this.y = y;
	 }
	 public int getWidth()
	 {
		 return getBitmap(currentBitmap % bitmaps.length).getWidth();
	 }
	 public int getHeight()
	 {
		 return getBitmap(currentBitmap % bitmaps.length).getHeight();
	 }
	 public void setAngle(int angle){
	 	if (angle < 91 && angle >=0)
		 	this.angle = angle;
	 }
	 public int getAngle(){
		 return angle;
	 }
	 public boolean isTouched() {
		  return touched;
		 }
	 public boolean isMoving()
	 {
		 return moving;
	 }
	 public void setMoving(boolean value)
	 {
		 moving = value;
	 }

	 public void setTouched(boolean touched) {
	  this.touched = touched;
	 }

	 public void draw(Canvas canvas) {
	  canvas.drawBitmap(getBitmap((currentBitmap % 16)/4), x - (getWidth() / 2), y - (getHeight() / 2), null);
	  currentBitmap++;
	  setMoving(false);
	 }
	 public void drawStill(Canvas canvas)
	 {
		 canvas.drawBitmap(getBitmap(0), x - (getWidth() / 2), y - (getHeight() / 2), null);
	 }

	 public void handleActionDown(int quad) {
		 switch(quad)
		 {
		 	case 1:
		 		//if (x>20)
		 		setX(x-5);
		 		setAngle(angle+1);
		 		setMoving(true);
		 		break;
		 	case 2:
		 		setAngle(angle+1);
		 		setMoving(false);
		 		break;
		 	case 3:
		 		//if (x<1900)
		 		setX(x+5);
		 		setAngle(angle+1);
		 		setMoving(true);
		 		break;
		 	case 4:
		 		//if (x>20)
		 		setX(x-5);
		 		setMoving(true);
		 		break;
		 	case 5:
		 		setMoving(false);
		 		break;
		 	case 6:
		 		//if (x<1900)
		 		setX(x+5);
		 		setMoving(true);
		 		break;
		 	case 7:
		 		//if (x>20)
		 		setX(x-5);
		 		setAngle(angle-1);
		 		setMoving(true);
		 		break;
		 	case 8:
		 		setMoving(false);
		 		setAngle(angle-1);
		 		break;
		 	case 9:
		 		//if (x<1900)
		 		setX(x+5);
		 		setMoving(true);
		 		setAngle(angle-1);
		 		break;
	 		default:
	 			break;
		 }

	 }
}