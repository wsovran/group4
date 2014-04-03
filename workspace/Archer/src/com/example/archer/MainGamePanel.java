package com.example.archer;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
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
	private ArrayList<Arrow> arrows = new ArrayList<Arrow>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Ally> allies = new ArrayList<Ally>();
	public GameActivity context;
	private Globals global;
	private int score;
	private int money;
	private Bitmap allySprites[];
	private Bitmap archerSprites[];
	private Bitmap enemySprites[];
	private Bitmap background;

 @SuppressLint("NewApi")
public MainGamePanel(Context context) {
	 super(context);
		setBackground(getResources().getDrawable(R.drawable.background3));
		setZOrderOnTop(true);
		
	 allySprites = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.ally_right1),BitmapFactory.decodeResource(getResources(), R.drawable.ally_right2),BitmapFactory.decodeResource(getResources(), R.drawable.ally_right3),BitmapFactory.decodeResource(getResources(), R.drawable.ally_right2)};
	 archerSprites = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.archer_right1),BitmapFactory.decodeResource(getResources(), R.drawable.archer_right2),BitmapFactory.decodeResource(getResources(), R.drawable.archer_right3),BitmapFactory.decodeResource(getResources(), R.drawable.archer_right2)};
	 enemySprites = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.enemy_left1),BitmapFactory.decodeResource(getResources(), R.drawable.enemy_left2),BitmapFactory.decodeResource(getResources(), R.drawable.enemy_left3),BitmapFactory.decodeResource(getResources(), R.drawable.enemy_left2)};
	 this.context = (GameActivity) context;
	 getHolder().addCallback(this);
	 
	 

	 //init actors
	 archer = new Archer(archerSprites, 50, 300);
	 
	 //init dpad
	 dpad = new DPad(BitmapFactory.decodeResource(getResources(), R.drawable.d_pad), 0, 500);
	 
	 //init shoot
	 shoot = new Shoot(BitmapFactory.decodeResource(getResources(), R.drawable.button), 1400, 500);
	 
	 thread = new GameThread(getHolder(), this);//create thread
	 //setFocusable(true);
	 global = (Globals)((GameActivity)context).getApplication();
	 money = global.getMoney();

	 
	 
 }

 @Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
 }

 @Override
 public void surfaceCreated(SurfaceHolder holder) {
	 //this.setBackgroundColor(Color.RED);
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
			 //Log.d(TAG, "Coords: x=" + event.getX(0) + ",y=" + event.getY(0));
			 //quad = dpad.handleActionDown((int)event.getX(), (int)event.getY());
			 if (quad > 0)
				 dpad.setTouched(true);
			 shoot.checkBounds((int)event.getX(), (int)event.getY());
			 //archer.handleActionDown(quad);
		 }
		 if (event.getAction() == MotionEvent.ACTION_UP) {
			   // touch was released
			 if (dpad.isTouched())
			 {
				 dpad.setTouched(false);
			 }
			 if(shoot.isTouched() && arrows.size()<5)
			 {
				 Arrow arrow = new Arrow(BitmapFactory.decodeResource(getResources(), R.drawable.arrow2), archer.getX(), archer.getY(),archer.getAngle(),global.getArcherDamage());
				 shoot.handleActionUp(arrow, archer.getAngle());
				 shoot.setTouched(false);
				 arrows.add(arrow);
			 }
		 }
		 
		  return true;
	 }
 public void updateArcher()
 {
	 if (dpad.isTouched())
		 archer.handleActionDown(dpad.getPrevQuad());
 }
 public void updateShoot()
 {
	 if(shoot.isTouched())
	 {
		 shoot.handleActionDown();
	 }
 }
 public void updateEnemy()
 {
	 enemies.add(new Enemy(enemySprites, global.getEnemyHealth(), ((int)(Math.random()*-4))-1, global.getEnemyDamage(), 1900, 10));
 }
 public void updateAlly()
 {
	 allies.add(new Ally(allySprites, global.getSoldierHealth(), ((int)(Math.random()*4))+1, global.getSoldierDamage(), 20, 10));
 }
 public void scoreDeath(Soldier enemy)
 {
	 global.addMoney(5);
	 global.addScore(100);
 }

 protected void onDraw(Canvas canvas, int tick) {
	 canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
	 Paint paint = new Paint();
	 paint.setColor(Color.WHITE);
	 paint.setTextSize(36);
	 canvas.drawText(""+archer.getAngle(), 50, 50, paint);
	 canvas.drawText(""+shoot.getPower(), 150, 50, paint);
	 if(archer.isMoving())
		 archer.draw(canvas);
	 else
		 archer.drawStill(canvas);
	 dpad.draw(canvas);
	 shoot.draw(canvas);
	 for(int i=0;i< enemies.size(); i++)
	 {
		 boolean collide = false;
		 if(enemies.get(i).isDead())
		 {
			 scoreDeath(enemies.get(i));
			 enemies.remove(i--);
			 continue;
		 }
		 for(int j=0;j< allies.size(); j++)
		 {
			 if(enemies.get(i).checkCollision(allies.get(j).getX(),allies.get(j).getWidth(),allies.get(j).getY(),allies.get(j).getHeight()))
			 {
				 enemies.get(i).attack(tick, allies.get(j));
				 collide = true;
				 break;
			 }
		 }
		 if(!collide)
		 {
			 enemies.get(i).draw(canvas);
		 }
		 else
		 {
			 enemies.get(i).drawStill(canvas);
		 }
		 if(enemies.get(i).winCon(true)){
			 //TO-DO go to shop
			 context.sendMain(this);
			 System.out.println("this worked");
			 thread.setShouldContinue(false);
			 return;
		 }
	 }
	 for(int i=0;i< allies.size(); i++)
	 {
		 boolean collide = false;
		 if(allies.get(i).isDead())
		 {
			 allies.remove(i--);
			 continue;
		 }
		 for(int j=0;j< enemies.size(); j++)
		 {
			 if(allies.get(i).checkCollision(enemies.get(j).getX(),enemies.get(j).getWidth(), enemies.get(j).getY(), enemies.get(j).getHeight()))
			 {
				 
				 collide = true;
				 allies.get(i).attack(tick, enemies.get(j));
				 //System.out.println("Collide");
				 break;
			 }
		 }
		 if(!collide)
		 {
			 allies.get(i).draw(canvas);
		 }
		 else
			 allies.get(i).drawStill(canvas);
		 if(allies.get(i).winCon(false)){
			 //TO-DO go to shop
			 context.sendShop(this);
			 System.out.println("this worked");
			 thread.setShouldContinue(false);
			 return;
		 }
	 }
	 for(int i=0;i< arrows.size(); i++)
	 {
		 if(!arrows.get(i).draw(canvas))
		 {
			 arrows.remove(i--);
			 continue;
		 }
		 for(int j=0;j< enemies.size(); j++)
		 {
			 if(arrows.get(i).checkCollision(enemies.get(j).getX(),enemies.get(j).getWidth(), enemies.get(j).getY(), enemies.get(j).getHeight()))
			 {
				 //enemies.get(j).setHealth(value);
				 arrows.get(i).attack(enemies.get(j));
				 if(enemies.get(j).isDead())
				 {
					 scoreDeath(enemies.get(j));
					 enemies.remove(j--);
				 }
					 
				 arrows.remove(i--);
				 break;
				 
			 }
		 }
	 }
	 
 }
 
}
