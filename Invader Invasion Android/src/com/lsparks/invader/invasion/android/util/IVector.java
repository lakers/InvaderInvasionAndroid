package com.lsparks.invader.invasion.android.util;

public class IVector {
	public float x, y;
	
	public IVector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(IVector other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public static IVector add(IVector first, IVector second) {
		return (new IVector(first.x + second.x, 
				first.y + second.y));
	}
	
	public void sub(IVector other) {
		this.x -= other.x;
		this.y -= other.y;
	}
	
	public static IVector sub(IVector first, IVector second) {
		return (new IVector(first.x - second.x,
				first.y - second.y));
	}
	
	public void normalize() {
		float length = (float)Math.sqrt(x*x + y*y);
		x /= length;
		y /= length;
	}
	
	public void mult(float num) {
		this.x *= num;
		this.y *= num;
	}
	
	public float dot(IVector other) {
		return(this.x * other.x + this.y * other.y);
	}
}