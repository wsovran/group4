package com.example.archer;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class DPad {
	private Bitmap bitmap; // the actual bitmap
	 private int x;   // the X coordinate
	 private int y;   // the Y coordinate
	 private boolean touched;//state
	 private int prevQuad;

	 public DPad(Bitmap bitmap, int x, int y) {
	  this.bitmap = bitmap;
	  this.x = x;
	  this.y = y;
	  prevQuad = -1;
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
	 public void setPrevQuad (int quad)
	 {
		 prevQuad = quad;
	 }

	 public void draw(Canvas canvas) {
	  canvas.drawBitmap(bitmap, x, y, null);
	 }
	 public int handleActionDown(int eventX, int eventY)
	 {
		 return calcQuad(eventX, eventY);
	 }
	 public int calcQuad(int eventX, int eventY)
	 {
		 setTouched(true);
		 int width = bitmap.getWidth();
		 int height = bitmap.getHeight() ;
		 if(eventX >= x && eventX < (width/3)+x && eventY >= y && eventY < (height/3)+y)
		 {
			 setPrevQuad(1);
			 return 1;
		 }
		 if(eventX >= (width/3)+x && eventX < ((2*width)/3)+x && eventY >= y && eventY < ((height)/3)+y)
		 {
			 setPrevQuad(2);
			 return 2;
		 }
		 if(eventX >= ((2*width)/3)+x && eventX < width+x && eventY >= y && eventY < ((height)/3)+y)
		 {
			 setPrevQuad(3);
			 return 3;
		 }
		 if(eventX >= x && eventX < (width/3)+x && eventY >= (height/3)+y && eventY < (2*height/3)+y)
		 {
			 setPrevQuad(4);
			 return 4;
		 }
		 if(eventX >= (width/3)+x && eventX < ((2*width)/3)+x && eventY >= (height/3)+y && eventY < ((2*height)/3)+y)
		 {
			 setPrevQuad(5);
			 return 5;
		 }
		 if(eventX >= ((2*width)/3)+x && eventX < width+x && eventY >= (height/3)+y && eventY < ((2*height)/3)+y)
		 {
			 setPrevQuad(6);
			 return 6;
		 }
		 if(eventX >= x && eventX < (width/3)+x && eventY >= (2*height/3)+y && eventY < height+y)
		 {
			 setPrevQuad(7);
			 return 7;
		 }
		 if(eventX >= (width/3)+x && eventX < ((2*width)/3)+x && eventY >= (2*height/3)+y && eventY < height+y)
		 {
			 setPrevQuad(8);
			 return 8;
		 }
		 if(eventX >= (2*width/3)+x && eventX < width+x && eventY >= (2*height/3)+y && eventY < height+y)
		 {
			 setPrevQuad(9);
			 return 9;
		 }
		 
		 
		 setTouched(false);
		 return -1;
	 }

	public int getPrevQuad() {
		
		return prevQuad;
	}

}
