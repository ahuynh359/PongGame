package main;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle extends PaddleModel {

	private int x, y;

	private Ball ball;

	public AIPaddle(Ball ball) {
		x = Panel.WIDTH - 20;
		y = 520 / 2 - 40;
		this.ball = ball;

	}

	@Override
	void move() {

		y = ball.getY() - 40;

		if (y <= 0)
			y = 0;
		if (y >= 420)
			y = 420;

	}

	@Override
	void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 20, 80);
		move();

	}

	@Override

	int getY() {
		return y;
	}

	@Override
	void setUp(boolean input) {

	}

	@Override
	void setDown(boolean input) {

	}

	@Override
	int getX() {
		return x;
	}

}
