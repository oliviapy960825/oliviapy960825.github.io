import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class View extends JFrame{
	BufferedImage[] pics;
	BufferedImage img;
	final int frameCount = 10;
	int picNum = 0;
	int xloc;
	int yloc;
	Direction d = Direction.WEST;
	final static int frameWidth = 700;
    final static int frameHeight = 700;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    final int drawDelay = 30; //msec
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;
    String[] adrr = new String[] {"images/orc_animation/orc_forward_west.png","images/orc_animation/orc_forward_east.png",
    		"images/orc_animation/orc_forward_north.png","images/orc_animation/orc_forward_south.png",
    		"images/orc_animation/orc_forward_northwest.png","images/orc_animation/orc_forward_southwest.png",
    		"images/orc_animation/orc_forward_northeast.png","images/orc_animation/orc_forward_southeast.png",
    		};
    ArrayList<BufferedImage[]> orcImages = new ArrayList<BufferedImage[]>();

    private JButton button;
		
    public View(){
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
    	
    	drawAction = new AbstractAction(){
    		public void actionPerformed(ActionEvent e){
    			drawPanel.repaint();
    			try {
    				Thread.sleep(50);
    			} catch (InterruptedException ie) {
    				ie.printStackTrace();
    			}
    		}
    	};
    	
    	add(drawPanel);
    	
    	for (int i = 0; i < adrr.length; i++) {
    		img = createImage(new File(adrr[i]));
    		
    		pics = new BufferedImage[10];
        	for(int j = 0; j < frameCount; j++)
        	{
        		pics[j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
        	}
        	orcImages.add(pics);
    	}
    	//img = createImage(new File("images/orc_animation/orc_forward_"+d.getName()+".png"));
    	
    	/* pics = new BufferedImage[frameCount];//get this dynamically
    	for(int k = 0; k < frameCount; k++)
    		pics[k] = img.getSubimage(imgWidth*k, 0, imgWidth, imgHeight); */
    	
    	button = new JButton("Stop/Start Movement");
    	getContentPane().add(button, BorderLayout.NORTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(Color.gray);
    	setSize(frameWidth, frameHeight);
    	setVisible(true);
    	
    	pack();
    }
//////////////////////////////////////////////////////////////////////////////
    private BufferedImage createImage(File f){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(f);
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
//////////////////////////////////////////////////////////////////////////////
	public int getWidth(){
		return frameWidth;
	}
	public int getHeight(){
		return frameHeight;
	}
	public int getImageWidth(){
		return imgWidth;
	}
	public int getImageHeight(){
		return imgHeight;
	}
	public int getdrawDelay(){
		return drawDelay;
	}
	public Action getdrawAction(){
		return drawAction;
	}
	public JButton getButton() {
		return button;
	}
	
	public void update(int x, int y, Direction d){
		xloc = x;
		yloc = y;
		this.d = d;
		
		repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private class DrawPanel extends JPanel {
    	int picNum = 0;
    	
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.gray);
			g.setColor(Color.gray);
			
			switch(d) {
			case NORTH:
				pics = orcImages.get(2);
				break;
			case NORTHEAST:
				pics = orcImages.get(7);
				break;
			case NORTHWEST:
				pics = orcImages.get(4);
				break;
			case EAST:
				pics = orcImages.get(1);
				break;
			case SOUTHEAST:
				pics = orcImages.get(6);
				break;
			case SOUTH:
				pics = orcImages.get(3);
				break;
			case SOUTHWEST:
				pics = orcImages.get(5);
				break;
			case WEST:
				pics = orcImages.get(0);
				break;
			}
			
	    	picNum = (picNum + 1) % frameCount;
	    	g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameWidth, frameHeight);
		}
	}
}
