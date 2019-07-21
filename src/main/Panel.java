package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;

	private Paddle player1, player2;

	private Thread thread;
	private boolean running;
	
	private Collided isCollided;



	private Ball ball;

	private int scorePly1, scorePly2;
	

	public Panel() {

		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addKeyListener(this);

		player1 = new Paddle(0, (HEIGHT - Paddle.P_HEIGHT) / 2);
		player2 = new Paddle(WIDTH - Paddle.P_WIDTH, (HEIGHT - Paddle.P_HEIGHT) / 2);

		ball = new Ball(WIDTH / 2 - 12, HEIGHT / 2);

		startThread();
		
		this.isCollided = ball;

	}

	
	
	private void onUpdate(boolean isCollidedForPlayer1, boolean  isCollidedForPlayer2) {
		isCollided.isCollided(isCollidedForPlayer1,isCollidedForPlayer2);
	}
	
	
	
	
	
	private void startThread() {
		running = true;
		if (thread == null) {
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
	
	private void isCollided() {
		if (player1.getX() + Paddle.P_WIDTH >= ball.getX()) {
			onUpdate(true, false);
		}
		if (player2.getX() <= ball.getX() + 25) {
			onUpdate(false, true);
		}
	}



	
	

	private void score() {
		
		
		
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		// draw background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.white);

		if (!ball.isGameOver1() && !ball.isGameOver2()) {

			// drawline
			g.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

			// drawplayer1
			g.fillRect(player1.getX(), player1.getY(), Paddle.P_WIDTH, Paddle.P_HEIGHT);
			// drawplayer2
			g.fillRect(player2.getX(), player2.getY(), Paddle.P_WIDTH, Paddle.P_HEIGHT);
			// draw the ball
			g.fillOval(ball.getX(), ball.getY(), 25, 25);

			// draw score
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Player One: " + scorePly1, 20, 30);

			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Player Two: " + scorePly2, 550, 30);}
		else {
		if (ball.isGameOver1()) {
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("Player1 is a loser", 213, 50);
			} else {
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawString("Player2 is a loser", 213, 50);
			}

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			player1.setyDistance(-5);

		}

		if (key == KeyEvent.VK_DOWN) {
			player1.setyDistance(5);
		}

		if (key == KeyEvent.VK_W) {
			player2.setyDistance(-5);
		}

		if (key == KeyEvent.VK_S) {
			player2.setyDistance(5);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		player1.setyDistance(0);
		player2.setyDistance(0);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void run() {
		while (running) {

			try {
				isCollided();
				score();
				player1.move();
				player2.move();
				ball.move();
				repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	
}
