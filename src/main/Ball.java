package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int x, y;
	private int xVel, yVel;

	private boolean isCollided;

	public Ball() {
		x = Panel.WIDTH / 2 - 10;
		y = Panel.HEIGHT / 2 - 10;

		xVel = -4;
		yVel = 1;
	}

	private void move() {
		
		x += xVel;
		y += yVel;

		if (x <= 0 || x >= Panel.WIDTH - 20)
			xVel = -xVel;

		if (y <= 0 || y >= Panel.HEIGHT - 20)
			yVel = -yVel;

		if (isCollided) {
			xVel = -xVel;
			isCollided = false;

		}
		
		System.out.println("Ball"+ getY());

	}

	public void checkCollision(Paddle paddle1, AIPaddle paddle2) {
		if (x <= 20) {
			if (y >= paddle1.getY() && y <= paddle1.getY() + 80)
				xVel = -xVel;
		} else if (x >= 720) {
			if (y >= paddle2.getY() && y <= paddle2.getY() + 80)
				xVel = -xVel;
		}

	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 20, 20);

		move();
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}
