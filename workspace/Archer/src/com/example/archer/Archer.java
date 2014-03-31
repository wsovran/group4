package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Archer {

	 private Bitmap bitmap; // the actual bitmap
	 private int x;   // the X coordinate
	 private int y;   // the Y coordinate
	 private int angle; //shot angle
	 private boolean touched;//state
	
	 public Archer(Bitmap bitmap, int x, int y) {
	  this.bitmap = bitmap;
	  this.x = x;
	  this.y = y;
	  this.angle = 0;
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
	 public void setY(int y) {
	  this.y = y;
	 }
	 public int getWidth()
	 {
		 return bitmap.getWidth();
	 }
	 public int getHeight()
	 {
		 return bitmap.getHeight();
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

	 public void setTouched(boolean touched) {
	  this.touched = touched;
	 }

	 public void draw(Canvas canvas) {
	  canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
	 }

	 public void handleActionDown(int quad) {
		 switch(quad)
		 {
		 	case 1:
		 		//if (x>20)
		 		setX(x-5);
		 		setAngle(angle+1);
		 		break;
		 	case 2:
		 		setAngle(angle+1);
		 		break;
		 	case 3:
		 		//if (x<1900)
		 		setX(x+5);
		 		setAngle(angle+1);
		 		break;
		 	case 4:
		 		//if (x>20)
		 		setX(x-5);
		 		break;
		 	case 5:
		 		break;
		 	case 6:
		 		//if (x<1900)
		 		setX(x+5);
		 		break;
		 	case 7:
		 		//if (x>20)
		 		setX(x-5);
		 		setAngle(angle-1);
		 		break;
		 	case 8:
		 		setAngle(angle-1);
		 		break;
		 	case 9:
		 		//if (x<1900)
		 		setX(x+5);
		 		setAngle(angle-1);
		 		break;
	 		default:
	 			break;
		 }

	 }
}