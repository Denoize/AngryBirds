package main.java.model;

public class Velocity {
	
	private double x;
	private double y;
	
	
	public Velocity() {
		super();
		setX(0);
		setY(0);
	}
	
	
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @param x add x to x
	 */
	public void addX(double x) {
		this.x += x;
	}
	/**
	 * @param y add y to y
	 */
	public void addY(double y) {
		this.y += y;
	}
	
	
	

}
