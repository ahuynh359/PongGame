package main;

import javax.swing.JFrame;

public class Main {

	private Panel panel;

	public Main() {

		JFrame frame = new JFrame("Pong Game");
		panel = new Panel();

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);

		frame.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		Main main = new Main();

	}

}
