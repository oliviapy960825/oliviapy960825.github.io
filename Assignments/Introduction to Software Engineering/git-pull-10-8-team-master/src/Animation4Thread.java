import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Animation4Thread extends JFrame implements ActionListener {

	final int frameCount = 10;
    BufferedImage[] pics;
    int xloc = 100;
    int yloc = 100;
    final int xIncr = 1;
    final int yIncr = 1;
    final int picSize = 165;
    final int frameStartSize = 700;
    final int drawDelay = 30; //msec
    JButton button;
    boolean isRunning=true;
    
    String[] adrr = new String[] {"images/orc_animation/orc_forward_west.png","images/orc_animation/orc_forward_east.png",
    		"images/orc_animation/orc_forward_north.png","images/orc_animation/orc_forward,south.png",
    		"images/orc_animation/orc_forward_northwest.png","images/orc_animation/orc_forward_southwest.png",
    		"images/orc_animation/orc_forward_northeast.png","images/orc_animation/orc_forward_southeast.png",
    		};
    
    DrawPanel drawPanel = new DrawPanel();
    Action drawAction;

    public Animation4Thread() {
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
    	BufferedImage img = createImage(new File(adrr[7])); //add switch
    	pics = new BufferedImage[frameCount];//get this dynamically
    	for(int i = 0; i < frameCount; i++)
    		pics[i] = img.getSubimage(picSize*i, 0, picSize, picSize);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setBackground(Color.gray);
    	setSize(frameStartSize, frameStartSize);
    	setVisible(true);
    	button=new JButton("start/stop");
    	button.setBounds(50,100,95,30);
    	drawPanel.add(button);
    	button.addActionListener(this);
    	pack();
    }
	
    private class DrawPanel extends JPanel {
    	int picNum = 0;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.gray);
			g.setColor(Color.gray);
	    	picNum = (picNum + 1) % frameCount;
	    	if(isRunning){
	    	xloc+=xIncr;
	    	yloc+=yIncr;
	    	}
	    	g.drawImage(pics[picNum], xloc, yloc, Color.gray, this);
		}

		public Dimension getPreferredSize() {
			return new Dimension(frameStartSize, frameStartSize);
		}
	}
    
    //run the simulation, call constructor
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Animation4Thread a = new Animation4Thread();
				Timer t = new Timer(a.drawDelay, a.drawAction);
				t.start();
			}
		});
	}
    
    //Read image from file and return
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		isRunning=!isRunning;
	}
}

