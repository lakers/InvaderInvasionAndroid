package com.lsparks.invader.invasion.android;

import org.andengine.entity.primitive.Line;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class PlayerShip extends GameObject {
	public PlayerShip() {
		System.out.println("Setting up Player Ship");
		setupDraw();
	}
	
	public void setupDraw() {
		VertexBufferObjectManager vertexBufferObjectManager = new
				VertexBufferObjectManager();
		//Line l0 = new Line(mX, mY, mX, mY+10, vertexBufferObjectManager);
		Line line0 = new Line(-20, 20, 0, -20, vertexBufferObjectManager);
		Line line1 = new Line(0, -20, 20, 20, vertexBufferObjectManager);
		Line line2 = new Line(20, 20, -20, 20, vertexBufferObjectManager);
		attachChild(line0);
		attachChild(line1);
		attachChild(line2);
		//l0.setParent(this);
	}
}
