package com.lsparks.invader.invasion.android;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Line;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.lsparks.invader.invasion.android.util.IVector;

public class HexShooter extends Entity {
	private float r;
	public Entity target;
	private Line turret;
	
	public HexShooter() {
		r = 20.0f;
		target = null;
		setupShape();
	}
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	public IVector toTarget() {
		IVector toTarg = new IVector(0, 1);
		if(target != null) {
			toTarg.x = target.getX();
			toTarg.y = target.getY();
			IVector pos = new IVector(mX, mY);
			toTarg = IVector.sub(toTarg, pos);
		}
		return toTarg;
	}
	
	public void setupShape() {
		float b = (float) (r * Math.cos(Math.PI/6.0));
		float a = (float) (r * Math.sin(Math.PI/6.0));
		
		VertexBufferObjectManager vbom = new VertexBufferObjectManager();
		Line l0 = new Line(r, 0, a, b, vbom);
		Line l1 = new Line(a, b, -a, b, vbom);
		Line l2 = new Line(-a, b, -r, 0, vbom);
		Line l3 = new Line(-r, 0, -a, -b, vbom);
		Line l4 = new Line(-a, -b, a, -b, vbom);
		Line l5 = new Line(a, -b, r, 0, vbom);
		
		attachChild(l0);
		attachChild(l1);
		attachChild(l2);
		attachChild(l3);
		attachChild(l4);
		attachChild(l5);
		
		IVector toTarget = new IVector(0, 1);
		if(target != null) {
			toTarget = toTarget();
		}
		toTarget.normalize();
		toTarget.mult(13);
		
		turret = new Line(0, 0, toTarget.x, toTarget.y, vbom);
		attachChild(turret);
	}
	
	public void setupTurret() {
		IVector toTarget = new IVector(0, 1);
		if(target != null) {
			toTarget = toTarget();
		}
		toTarget.normalize();
		toTarget.mult(13);
		
		//turret.setRotation(90);
		turret.setPosition(0, 0, toTarget.x, toTarget.y);
	}
	
	public void step() {
		setupTurret();
	}
}
