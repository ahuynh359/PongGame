package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int x, y;
	private int xVel, yVel;

	public Ball() {
		x = Panel.WIDTH / 2 - 10;
		y = Panel.HEIGHT / 2 - 10;

		xVel = 2;
		yVel = 3;
	}

	private void move() {
		x += xVel;
		y += yVel;
		
		if(x <= 0 || x >=Panel.WIDTH - 20)
			xVel =- xVel;
		
		if(y <= 0 || y >= Panel.HEIGHT - 20) 
			yVel =-yVel;
			
		

	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 20, 20);
		
		move();
	}

}
