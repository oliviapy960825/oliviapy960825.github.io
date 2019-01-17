import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	int xloc = 0;
	 int yloc = 0;
	 final int xIncr = 8;
	 final int yIncr = 2;
	 Direction d=Direction.EAST;
	int frameWidth = 500;
	 int frameHeight = 300;
	 int imgWidth = 165;
	 int imgHeight = 165;
	 BufferedImage img;
	 JFrame frame;
	public int getWidth() {
		// TODO Auto-generated method stub
		return frameWidth;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return frameHeight;
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
		this.xloc=x;
		this.yloc=y;
		this.d=direct;
		/*try {
			img=ImageIO.read(new File("orc_animation/orc_forward_"+d.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
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
		  }*/
	}
	}
