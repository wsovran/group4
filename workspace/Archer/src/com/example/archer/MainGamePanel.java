package com.example.archer;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback
{
	private GameThread thread;
	private Archer archer;
	private DPad dpad;
	private Shoot shoot;
	private static final String TAG = MainGamePanel.class.getSimpleName();

 public MainGamePanel(Context context) {
	 super(context);
	 getHolder().addCallback(this);
	 
	 //init actors
	 archer = new Archer(BitmapFactory.decodeResource(getResources(), R.drawable.droid_1), 50, 50);
	 
	 //init dpad
	 dpad = new DPad(BitmapFactory.decodeResource(getResources(), R.drawable.d_pad), 0, 500);
	 
	 //init shoot
	 shoot = new Shoot(BitmapFactory.decodeResource(getResources(), R.drawable.button), 1400, 500);
	 
	 thread = new GameThread(getHolder(), this);//create thread
	 setFocusable(true);
 }

 @Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
 }

 @Override
 public void surfaceCreated(SurfaceHolder holder) {
	 thread.setRunning(true);
	 thread.start();
 }

 @Override
 public void surfaceDestroyed(SurfaceHolder holder) {
 }

 @Override
	 public boolean onTouchEvent(MotionEvent event) {
	 
	 	int quad = 0;
	 	boolean touchedQuad = false;
	 	quad = dpad.handleActionDown((int)event.getX(), (int)event.getY());
		 if (event.getAction() == MotionEvent.ACTION_DOWN)
		 {
			 Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
			 //quad = dpad.handleActionDown((int)event.getX(), (int)event.getY());
			 if (quad > 0)
				 dpad.setTouched(true);
			 //archer.handleActionDown(quad);
		 }
		 if (event.getAction() == MotionEvent.ACTION_UP) {
			   // touch was released
			 if (dpad.isTouched())
			 {
				 dpad.setTouched(false);
			 }
		 }
		 
		  return true;
	 }
 public void updateArcher()
 {
	 if (dpad.isTouched())
		 archer.handleActionDown(dpad.getPrevQuad());
 }

 @Override
 protected void onDraw(Canvas canvas) {
	 canvas.drawColor(Color.BLACK);
	 archer.draw(canvas);
	 dpad.draw(canvas);
	 shoot.draw(canvas);
 }
}
