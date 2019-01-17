import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
public class View extends JPanel{
	final int frameWidth = 500;
	 final int frameHeight = 300;
	 int imgWidth = 165;
	 int imgHeight = 165;
	 BufferedImage img;
	 JFrame frame;
	public int getHeight() {
		// TODO Auto-generated method stub
		return frameHeight;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return frameWidth;
	}

	public int getImageWidth() {
		// TODO Auto-generated method stub
		return imgWidth;
	}

	public int getImageHeight() {
		// TODO Auto-generated method stub
		return imgHeight;
	}

	public void update(int x, int y, Direction direct) {
		// TODO Auto-generated method stub
		try {
			img=ImageIO.read(new File("orc_animation/orc_forward_"+direct.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//g.drawImage(pics[picNum], x, y, Color.gray, this);//I don't know how to put this into view since there is not parameter g

		  frame.setBackground(Color.gray);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(frameWidth, frameHeight);
		  frame.setVisible(true);
		  for (int i = 0; i < 1000; i++) {
		   frame.repaint();
		   try {
		    Thread.sleep(100);
		   } catch (InterruptedException e) {
		    e.printStackTrace();
		   }
		  }
		 }
	}