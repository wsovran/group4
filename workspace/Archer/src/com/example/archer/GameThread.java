package com.example.archer;
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
 
 public void setRunning(boolean running) {
  this.running = running;
 }

 public GameThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
  super();
  this.surfaceHolder = surfaceHolder;
  this.gamePanel = gamePanel;
  this.shouldContinue = true;
  this.global = (Globals)gamePanel.context.getApplication();
 }

 public void setShouldContinue(boolean value)
 {
	 shouldContinue = value;
 }
 
 @Override
 	public void run()
 	{
	// TODO Auto-generated method stub
		Canvas canvas;
		int count = 0;
		int enemyTicks = 0;
		int allyTicks = 0;
		int randomEnemy = (int)(Math.random() * 50);
		int randomAlly = (int)(Math.random() * 50);
		while(shouldContinue)
		{
			canvas = null;
			try
			{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
				     // update game state
				     // draws the canvas on the panel
					if(enemyTicks %((500-(global.getLevel() *50)) + randomEnemy  ) == 0)
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
					this.gamePanel.updateArcher();
					this.gamePanel.updateShoot();
					this.gamePanel.onDraw(canvas, count);
			    }
			}
			finally {
			    // in case of an exception the surface is not left in
			    // an inconsistent state
			    if (canvas != null) {
			     surfaceHolder.unlockCanvasAndPost(canvas);
			    }
			    count++;
			    enemyTicks++;
			    allyTicks++;
			} // end finally
		}
 	}
}