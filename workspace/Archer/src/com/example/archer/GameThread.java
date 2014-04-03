package com.example.archer;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

 private static final String TAG = GameThread.class.getSimpleName();

 private SurfaceHolder surfaceHolder;
 private MainGamePanel gamePanel;
 private boolean running;
 private boolean shouldContinue;
 private Globals global;
 private Bitmap background;
 
 public void setRunning(boolean running) {
  this.running = running;
 }

 public GameThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
  super();
  this.surfaceHolder = surfaceHolder;
  this.gamePanel = gamePanel;
  this.shouldContinue = true;
  this.global = (Globals)gamePanel.context.getApplication();
 background = BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.background3);
 }

 public void setShouldContinue(boolean value)
 {
	 shouldContinue = value;
 }
 
 @SuppressLint("NewApi")
@Override
 	public void run()
 	{
	// TODO Auto-generated method stub
	 	global.setLevel(global.getLevel()+1);
		Canvas canvas;
		//Canvas back;
		canvas = this.surfaceHolder.lockCanvas();
		canvas.drawBitmap(this.background, 0, 0, null);
		surfaceHolder.unlockCanvasAndPost(canvas);
		
		int count = 0;
		int enemyTicks = 0;
		int allyTicks = 0;
		int randomEnemy = (int)(Math.random() * 100);
		int randomAlly = (int)(Math.random() * 100);
		while(shouldContinue)
		{
			canvas = null;
			//back = null;
			try
			{
				canvas = this.surfaceHolder.lockCanvas();
				//back = this.surfaceHolder.lockCanvas();
				//background.setHeight(canvas.getHeight());
				//background.setWidth(canvas.getWidth());
				//canvas.drawBitmap(background,0,0,null);
				synchronized (surfaceHolder) {
				     // update game state
				     // draws the canvas on the panel
					if(enemyTicks %((475-(global.getLevel() *25)) + randomEnemy  ) == 0)
					{
						this.gamePanel.updateEnemy();
						enemyTicks = 0;
						randomEnemy = (int)(Math.random() * 50);
					}
					if(allyTicks %(global.getSpawnRate() + randomAlly  ) == 0)
					{
						this.gamePanel.updateAlly();
						allyTicks = 0;
						randomAlly = (int)(Math.random() * 50);
					}
					//back.drawBitmap(this.background, 0, 0, null);
					this.gamePanel.updateArcher();
					this.gamePanel.updateShoot();
					this.gamePanel.onDraw(canvas, count);
			    }
			}
			finally {
			    // in case of an exception the surface is not left in
			    // an inconsistent state
				//if (back != null)
				//	surfaceHolder.unlockCanvasAndPost(back);
			    if (canvas != null) 
			    {
			     surfaceHolder.unlockCanvasAndPost(canvas);
			     
			    }
			    count++;
			    enemyTicks++;
			    allyTicks++;
			} // end finally
		}
 	}
}