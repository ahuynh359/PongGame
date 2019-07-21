package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private double x, y;
	double xVel;
	private double yVel;

	private boolean isCollided;
	
	private int score;

	public Ball() {
		x = Panel.WIDTH / 2 - 10;
		y = Panel.HEIGHT / 2 - 10;

		xVel = Math.random()*3+2;
		yVel = Math.random()*3+2;
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


	}

	public void checkCollision(Paddle paddle1, AIPaddle paddle2) {
		if (x <= 20) {
			if (y >= paddle1.getY() && y <= paddle1.getY() + 80) {
				xVel = -xVel;
				score++;
			}
		} else if (x >= 760) {
			if (y >= paddle2.getY() && y <= paddle2.getY() + 80)
				xVel = -xVel;
		}

	}
	
	
	public boolean isGameOver(Paddle paddle) {
		if(x <= 0)
			return true;
		return false;
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x,(int) y, 20, 20);

		move();
	}

	public int getY() {
		return (int)y;
	}

	public int getX() {
		return (int)x;
	}
	public int getScore() {
		return score;
	}

}
