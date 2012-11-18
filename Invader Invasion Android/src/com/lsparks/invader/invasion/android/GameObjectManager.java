package com.lsparks.invader.invasion.android;

import java.util.ArrayList;

import org.andengine.entity.Entity;

import android.util.Log;

public class GameObjectManager extends Entity {
	private ArrayList<HexShooter> hordeObjects;
	
	public GameObjectManager() {
		hordeObjects = new ArrayList<HexShooter>();
	}
	
	public void addHordeObject(HexShooter hordeObject) {
		Log.d("GameObjectManager","Adding hordeObject");
		hordeObjects.add(hordeObject);
		attachChild(hordeObject);
	}
	
	public void step() {
		Log.d("GameObjectManager", "stepping");
		for(int index = 0; index < hordeObjects.size(); index++) {
			HexShooter entity = (HexShooter)hordeObjects.get(index);
			entity.step();
		}
	}
}
