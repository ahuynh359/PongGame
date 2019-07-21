package main;

import java.util.Random;

public class Ball implements Collided {

	private int x, y;
	private int xDirect, yDirect;
	private boolean isGameOver1, isGameOver2;
	private boolean player1,player2;


	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		
		isGameOver1 = false;
		isGameOver2 =false;
		
		Random random =new Random();
		
		xDirect = random.nextInt(5+5)-5;
		yDirect =random.nextInt(3+3)-3;
		
		
	}
	
	public void move() {
		System.out.println(player1 +""+player2);
		x += xDirect;
		y += yDirect;
		
		if(y<=0 || y >=Panel.HEIGHT-25 )
			yDirect=-yDirect;
		//is GameOver
		if(x<=-25 )
			isGameOver1 = true;
		if(x >= Panel.WIDTH)
			isGameOver2 = true;
		
		//isCollided
		if(x <= Paddle.P_WIDTH && player1 || x >= Panel.HEIGHT-Paddle.P_WIDTH-25 && player2)
			xDirect =- xDirect;
		
//		
	
	}


	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	public void setyDirect(int yDirect) {
		this.yDirect = yDirect;
	}
	
	public boolean isGameOver1() {
		return isGameOver1;
	}
	
	public boolean isGameOver2() {
		return isGameOver2;
	}

	@Override
	public void isCollided(boolean player1, boolean player2) {
		// TODO Auto-generated method stub
		this.player1 = player1;
		this.player2 = player2;
		
		
		
	}


	

	

}
