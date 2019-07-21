package main;

import java.awt.Graphics;

public abstract class PaddleModel {

	abstract void move();

	abstract void paint(Graphics g);

	abstract int getY();

	abstract int getX();

	abstract void setUp(boolean input);

	abstract void setDown(boolean input);

}
