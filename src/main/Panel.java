package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener,Runnable{
	
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	private Paddle player1,player2;
	
	private boolean up1, up2;
	private boolean isStart;
	
	private Thread thread;
	private boolean running;
	
	private int x,y;
	
	public Panel() {
		isStart = false;
		setFocusable(true); //This function makes addKeyListener run
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addKeyListener(this);
	
		
		player1 = new Paddle(0, (HEIGHT-Paddle.P_HEIGHT)/2);
		player2 = new Paddle(WIDTH-Paddle.P_WIDTH, (HEIGHT-Paddle.P_HEIGHT)/2);
		
		startThread();
		
		
		
		x =0;
		
		
	}
	
	private void startThread() {
		running = true;
		if(thread==null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	private void stopThread() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void gameUpdate() {
		if(x +100 == HEIGHT && up1== true) {
			x -=5;
		} else if(x ==0 &&  up1== false) {
		x+=5;
		}
	
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//draw background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		g.setColor(Color.white);
	
		if(isStart) {
		//drawplayer1
		g.fillRect(player1.getX(), x, Paddle.P_WIDTH,Paddle.P_HEIGHT);
		//drawplayer2
		g.fillRect(player2.getX(), player2.getY(), Paddle.P_WIDTH, Paddle.P_HEIGHT);} else {
			g.setFont(new Font("Arial",Font.BOLD,50));
			g.drawString("Press Space To Start", WIDTH/2-250, HEIGHT/2);
		
			
		}
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_UP) {
			up1= false;
				
			}
			
			if(key == KeyEvent.VK_DOWN) {
				System.out.println("Down");
				up1=true;
			}
			
			if(key == KeyEvent.VK_W) {
				player2.setUp(true);
			}
			
			if(key == KeyEvent.VK_S) {
				player2.setUp(false);
			}
			
			
			if(key == KeyEvent.VK_SPACE) {
				isStart=true;
			}
			
	}


	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Out");
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void run() {
		while(running) {
			
			try {
				gameUpdate();
				repaint();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	

}
