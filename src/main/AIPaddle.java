package main;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle extends PaddleModel{
	
	
	private int x;
	private double y;
	private final double GRAVITY =  0.94;
	private double yVel;

	private boolean isUp, isDown;
	
	public AIPaddle() {
		x = Panel.WIDTH-20;
		y = 520 / 2 - 40;
	}

	@Override
	void move() {
		
		
	}

	@Override
	void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x,(int) y, 20, 80);
		move();
		
	}

	@Override
	int getY() {
		return 0;
	}

	@Override
	void setUp(boolean input) {
		this.isUp = input;
		
	}

	@Override
	void setDown(boolean input) {
		this.isDown = input;
		
	}

}
