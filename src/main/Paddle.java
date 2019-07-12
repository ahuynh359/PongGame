package main;

public class Paddle   {
	
	private int x,y;
	private int xSpace = 10;
	public static final int P_WIDTH = 20;
	public static final int P_HEIGHT = 100;
	private boolean up;
	private static int SPACE = 5;
	
	public Paddle(int x, int y) {
		this.x = x;
		this.y= y;
	
	
		

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


	
	private void move() {
		
		if(y==0) {
			y=0;
		}
		
		if(y+P_HEIGHT==Panel.HEIGHT){
			y = Panel.HEIGHT-P_HEIGHT;
		}
		if(up) {
			for(int i = 3; i <10;i++)
			y-=i;
		} else {
			y+=10;
		}
	}
	

	
	
	

}
