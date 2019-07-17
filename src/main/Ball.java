package main;

public class Ball {

	private int x, y;
	private int xDrect, yDirect;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setxDrect(int xDrect) {
		this.xDrect = xDrect;
	}

	public void setyDirect(int yDirect) {
		this.yDirect = yDirect;
	}

	public void move() {
		x += xDrect;
		y += yDirect;
		
		
	}

}
