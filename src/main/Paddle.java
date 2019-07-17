package main;

public class Paddle {

	private int x, y;
	public static final int P_WIDTH = 20;
	public static final int P_HEIGHT = 100;
	private boolean up;
	private int yDistance;

	public Paddle(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void move() {

		if (y <= 0) {
			y = 0;
		}

		if (y + P_HEIGHT >= Panel.HEIGHT) {
			y = Panel.HEIGHT - P_HEIGHT;
		}

		y += yDistance;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean getUp() {
		return up;
	}

	public void setyDistance(int yDistance) {
		this.yDistance = yDistance;
	}

	public int getyDistance() {
		return yDistance;
	}

}
