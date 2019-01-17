
//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {
	 final int frameCount = 10;
	 int picNum = 0;
	 
	 final static int frameWidth = 500;
	 final static int frameHeight = 300;
	 final static int imgWidth = 165;
	 final static int imgHeight = 165;
	 int DirFlagOfX = 1;
	 int DirFlagOfY = 1;
	 BufferedImage[] pics;
	 BufferedImage[][] imgCollection;
	 Model m;

	 // Constructor: get image, segment and store in array
	 public Animation() {
		 m=new Model(frameWidth,frameHeight,imgWidth,imgHeight);
	  BufferedImage[] img = createImage();
	  imgCollection = new BufferedImage[8][10];
	  for (int i = 0; i < 8; i++) {
	   for (int j = 0; j < frameCount; j++) {
	    imgCollection[i][j] = img[i].getSubimage(imgWidth * j, 0, imgWidth, imgHeight);
	   }
	  }

	  // TODO: Change this constructor so that at least eight orc animation
	  // pngs are loaded
	 }

	 // Read image from file and return
	 private BufferedImage[] createImage() {
	  
	  BufferedImage allImgs[] = new BufferedImage[8];

	  try {// File dir=new File("orc_animation");
	    // for(File fl:dir.listFiles()){
	    // bufferedImage = ImageIO.read(fl);
	    // }

	   allImgs[0] = ImageIO.read(new File("orc_animation/orc_forward_east.png"));
	   allImgs[1] = ImageIO.read(new File("orc_animation/orc_forward_north.png"));
	   allImgs[2] = ImageIO.read(new File("orc_animation/orc_forward_south.png"));
	   allImgs[3] = ImageIO.read(new File("orc_animation/orc_forward_west.png"));
	   allImgs[4] = ImageIO.read(new File("orc_animation/orc_forward_southeast.png"));
	   allImgs[5] = ImageIO.read(new File("orc_animation/orc_forward_northeast.png"));
	   allImgs[6] = ImageIO.read(new File("orc_animation/orc_forward_southwest.png"));
	   allImgs[7] = ImageIO.read(new File("orc_animation/orc_forward_northwest.png"));
	   return allImgs;
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	  return null;

	  // TODO: Change this method so you can load other orc animation bitmaps
	 }

	 // Override this JPanel's paint method to cycle through picture array and
	 // draw images
	 public void paint(Graphics g) {
	  BufferedImage[] images = null;

	  picNum = (picNum + 1) % frameCount;
	  if (m.getX()<0) {
	   DirFlagOfX = DirFlagOfX * (-1);
	  } else if (m.getX() > frameWidth - imgWidth) {
	   DirFlagOfX = DirFlagOfX * (-1);
	  } else if (m.getY() < 0) {
	   DirFlagOfY = DirFlagOfY * (-1);
	  } else if (m.getY() > frameHeight - imgHeight) {
	   DirFlagOfY = DirFlagOfY * (-1);
	  }
	  if (DirFlagOfX == 1 && DirFlagOfY == 1) {
	   pics = imgCollection[4];
	  } else if (DirFlagOfX == -1 && DirFlagOfY == 1) {
	   pics = imgCollection[6];
	  } else if (DirFlagOfX == 1 && DirFlagOfY == -1) {
	   pics = imgCollection[5];
	  } else if (DirFlagOfX == -1 && DirFlagOfY == -1) {
	   pics = imgCollection[7];
	  }
	  //go into view
	  
	  //g.drawImage(pics[picNum], xloc += xIncr * DirFlagOfX, yloc += yIncr * DirFlagOfY, Color.gray, this);//I don't know how to put this into view since there is not parameter g
	  g.drawImage(pics[picNum], m.getX(), m.getY(), Color.gray, this);//I don't know how to put this into view since there is not parameter g
	  // TODO: Keep the orc from walking off-screen, turn around when bouncing
	  // off walls.
	  // Be sure that animation picture direction matches what is happening on
	  // screen.

	 }

	 // Make frame, loop on repaint and wait
	 public static void main(String[] args) {
	  JFrame frame = new JFrame();
	  frame.getContentPane().add(new Animation());
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