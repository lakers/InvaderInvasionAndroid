package com.lsparks.invader.invasion.android;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSCounter;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

import android.util.Log;


public class MainActivity extends SimpleBaseGameActivity {

	final int mCameraWidth = 480;  
    final int mCameraHeight = 800;
    
    private int x1;
    private int y1;
    
    StarBackdrop b0;
    
    //private Line line;
    PlayerShip ship;
    
    private GameObjectManager gameObjectManager;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
        Camera mCamera = new Camera(0, 0, mCameraWidth, mCameraHeight);
        final EngineOptions engineOptions = new EngineOptions(true, 
        		ScreenOrientation.PORTRAIT_FIXED , 
        		new RatioResolutionPolicy(mCameraWidth, mCameraHeight), mCamera);
        x1 = 50;
        y1 = 600;
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Scene onCreateScene() {
		Log.d("MainActivity","Starting scene");
		Scene scene = new Scene();
		scene.setBackground(new Background(0.0f,0.0f,0.0f));
		//VertexBufferObjectManager vertexBufferObjectManager = new
		//		VertexBufferObjectManager();
		//Line line = new Line(x1, 100, x1+10, 100, vertexBufferObjectManager);
		ship = new PlayerShip();
		ship.setPosition(x1, y1);
		
		b0 = new StarBackdrop(mCameraWidth, mCameraHeight, 4);
		
		gameObjectManager = new GameObjectManager();
		HexShooter testShooter = new HexShooter();
		testShooter.setPosition(200, 100);
		testShooter.setTarget(ship);
		gameObjectManager.addHordeObject(testShooter);
		
		scene.attachChild(b0);
		scene.attachChild(gameObjectManager);
		
		
		scene.attachChild(ship);
		//scene.attachChild(line);
		scene.registerUpdateHandler(new TimerHandler(
				1.0f/30.0f, true, new IIUpdateHandler()));
		return scene;
	}
	
	private class IIUpdateHandler implements ITimerCallback {
		public IIUpdateHandler() {
		}
		
		public void onTimePassed(TimerHandler pTimerHandler) {
			// TODO Auto-generated method stub
			//System.out.println(pTimerHandler.getTimerSecondsElapsed());
			//Log.d("INVADER INVASION","TIMER: "+pTimerHandler.getTimerSecondsElapsed());
			y1--;
			ship.setPosition(x1, y1);
			b0.step();
			gameObjectManager.step();
		}

		
	
	}

}
