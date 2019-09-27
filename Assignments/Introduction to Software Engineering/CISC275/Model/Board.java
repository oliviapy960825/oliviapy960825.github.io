package Model;

import java.awt.Color;

import javax.swing.JFrame;

public class Board {
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final int frameCount = 10; // picture frame number

	// Button location (model), view retrieve the locations
	// Action listener (model) (usually in the controller--> Main)
	// OrcList (controller)
	/*
	 * tick() --> update the orc position & collision detection (doesn't run off the screen)
	 * tick --> draw
	 * 	while true:
	 * 		tick()
	 * 		iterate the array, do the update (iterate, update)
	 */
	// make model be able to modify things in the view
	// framecount --> model
	// shared enumerate type: directions --> enumeration
	// actions --> enumeration
	// 
		
	public Board(){
		JFrame frame = new JFrame();
		//frame.getContentPane().add(new Animation());
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		for(int i = 0; i < 1000; i++){
			frame.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// board(width, height)


}
