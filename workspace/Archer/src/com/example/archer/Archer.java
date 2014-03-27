package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Archer {

 private Bitmap bitmap; // the actual bitmap
 private int x;   // the X coordinate
 private int y;   // the Y coordinate
 private boolean touched;//state

 public Archer(Bitmap bitmap, int x, int y) {
  this.bitmap = bitmap;
  this.x = x;
  this.y = y;
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

	 public void draw(Canvas canvas) {
	  canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2), null);
	 }

	 public void handleActionDown(int quad) {
		 System.out.println(quad);
		 switch(quad)
		 {
		 	case 1:
		 		setX(x-100);
		 		setY(y-100);
		 		break;
		 	case 2:
		 		setY(y-100);
		 		break;
		 	case 3:
		 		setX(x+100);
		 		setY(y-100);
		 		break;
		 	case 4:
		 		setX(x-100);
		 		break;
		 	case 5:
		 		break;
		 	case 6:
		 		setX(x+100);
		 		break;
		 	case 7:
		 		setX(x-100);
		 		setY(y+100);
		 		break;
		 	case 8:
		 		setY(y+100);
		 		break;
		 	case 9:
		 		setX(x+100);
		 		setY(y+100);
		 		break;
	 		default:
	 			break;
		 }

	 }
}