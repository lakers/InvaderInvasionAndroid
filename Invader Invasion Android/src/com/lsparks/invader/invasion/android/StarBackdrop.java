package com.lsparks.invader.invasion.android;

import java.util.ArrayList;
import java.util.Random;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class StarBackdrop extends Entity{
	private float w, h, rate;
	private ArrayList<Rectangle> stars;
	
	public StarBackdrop(float width, float height, int rate) {
		this.w = width;
		this.h = height;
		this.rate = rate;
		
		stars = new ArrayList<Rectangle>();
		
		Random random = new Random();
		for(int index = 0; index < 200; index++) {
			Rectangle star = new Rectangle(random.nextFloat()*w, random.nextFloat()*h,
					1, 1, new VertexBufferObjectManager());
			stars.add(star);
			this.attachChild(star);
		}
	}
	
	public void step() {
		for(int index = 0; index < 200; index++) {
			Rectangle star = (Rectangle)stars.get(index);
			float x = star.getX();
			float y = star.getY();
			
			y += rate;
			
			if(y > h) {
				y -= h;
			}
			
			star.setPosition(x, y);
		}
	}
	
}
