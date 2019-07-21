package main;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends PaddleModel {

	private int x;
	private double y;
	private final double GRAVITY = 0.94;
	private double yVel;

	private boolean isUp, isDown;

	public Paddle() {
		x = 0;
		y = 520 / 2 - 40;

	}

	@Override
	void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, (int) y, 20, 80);
		move();

	}

	@Override
	void move() {

		if (isUp) {
			yVel -= 1.25;
		} else if (isDown) {
			yVel += 1.25;
		} else if (!isUp && !isDown) {
			yVel *= GRAVITY;
		}

		y += yVel;

		if (y <= 0)
			y = 0;
		if (y >= 420)
			y = 420;
	}

	@Override
	int getY() {
		return (int) y;
	}

	@Override
	void setUp(boolean input) {
		this.isUp = input;
	}

	@Override
	void setDown(boolean input) {
		this.isDown = input;
	}

	@Override
	int getX() {
		return x;
	}

}
