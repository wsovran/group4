package com.example.archer;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

 private static final String TAG = GameThread.class.getSimpleName();

 private SurfaceHolder surfaceHolder;
 private MainGamePanel gamePanel;
 private boolean running;
 
 public void setRunning(boolean running) {
  this.running = running;
 }

 public GameThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
  super();
  this.surfaceHolder = surfaceHolder;
  this.gamePanel = gamePanel;
 }

 @Override
 	public void run()
 	{
	// TODO Auto-generated method stub
		Canvas canvas;
		while(true)
		{
			canvas = null;
			//repaint();
			try
			{
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
				     // update game state
				     // draws the canvas on the panel
					this.gamePanel.updateArcher();
					this.gamePanel.onDraw(canvas);
			    }
			}
			finally {
			    // in case of an exception the surface is not left in
			    // an inconsistent state
			    if (canvas != null) {
			     surfaceHolder.unlockCanvasAndPost(canvas);
			    }
			} // end finally
		}
 	}
}