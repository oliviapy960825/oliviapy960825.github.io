/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
//This lab is done by Peiyu Wang and Mandi Li
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	final int frameCount = 10;
	int picNum = 0;
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	BufferedImage[] pics;
	BufferedImage[][] imgCollection;
	
	Model model = new Model(getWidth(), getHeight(), getImageWidth(), getImageHeight());

 public View() {
	 BufferedImage[] img = createImage();
	 imgCollection = new BufferedImage[8][10];
	 for (int i = 0; i < 8; i++) {
		 for (int j = 0; j < frameCount; j++) {
			 imgCollection[i][j] = img[i].getSubimage(imgWidth * j, 0, imgWidth, imgHeight);
		}
	}
}

 private BufferedImage[] createImage() {
  
  BufferedImage allImgs[] = new BufferedImage[8];
  try {
   allImgs[0] = ImageIO.read(new File("src/orc_animation/orc_forward_east.png"));
   allImgs[1] = ImageIO.read(new File("src/orc_animation/orc_forward_north.png"));
   allImgs[2] = ImageIO.read(new File("src/orc_animation/orc_forward_south.png"));
   allImgs[3] = ImageIO.read(new File("src/orc_animation/orc_forward_west.png"));
   allImgs[4] = ImageIO.read(new File("src/orc_animation/orc_forward_southeast.png"));
   allImgs[5] = ImageIO.read(new File("src/orc_animation/orc_forward_northeast.png"));
   allImgs[6] = ImageIO.read(new File("src/orc_animation/orc_forward_southwest.png"));
   allImgs[7] = ImageIO.read(new File("src/orc_animation/orc_forward_northwest.png"));
   return allImgs;
   } 
  catch (IOException e) {
	  e.printStackTrace();
  }
  return null;
 }

 public void paint(Graphics g) {
  BufferedImage[] images = null;

  picNum = (picNum + 1) % frameCount;
  
  model.updateLocationAndDirection();
  
  if (model.getDirect() == Direction.SOUTHEAST) {
	  pics = imgCollection[4];
  } 
  else if (model.getDirect() == Direction.SOUTHWEST) {
	  pics = imgCollection[6];
  } 
  else if (model.getDirect() == Direction.NORTHEAST) {
	  pics = imgCollection[5];
  } 
  else if (model.getDirect() == Direction.NORTHWEST) {
	  pics = imgCollection[7];
  }
  
  g.drawImage(pics[picNum], model.updateX(), model.updateY(), Color.gray, this);
 }
 
public int getImageHeight() {
	return imgHeight;
}

public int getImageWidth() {
	return imgWidth;
}

public void update(int x, int y, Direction d) {
	model.setD(d);
	model.setXloc(x);
	model.setYloc(y);
}

public static void main(String[] args) {
	  JFrame frame = new JFrame();
	  frame.getContentPane().add(new View());
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