package week2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TurtleDriver {
    private Graphics graphics;
    private BufferedImage image;
    private JLabel label;
    private Turtle turtle;
    private int width;
    private int height;
    
	public TurtleDriver(int width, int height) {
	    this.width = width;
	    this.height = height;
	    
	    // Code that sets up the graphics window on which we can draw
        JFrame window = new JFrame("Turtle");
        // makes sure that when user closes window the JVM also exits
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets the width and height of the window
        window.setSize(width, height);
        // allocates memory to store a width x height image with 3 color bands (RGB)
        image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        // create something to draw directly to image using
        graphics = image.createGraphics();
        // creates GUI object for the image to be displayed in the application
        label = new JLabel(new ImageIcon(image));
        // sets the GUI image as the content of the window
        window.setContentPane(label);
        // tells the window we are done adding GUI components
        window.pack();
        // makes the window visible to user
        window.setVisible(true);
        
        // Creates a Turtle
        turtle = new Turtle(this);
	}
	
	public int getWidth() {
	    return width;
	}
	
    public int getHeight() {
        return height;
    }

    public Graphics getGraphics() {
	    return graphics;
	}
	
	public void repaint() {
        // forces the image to on-screen to update from the image buffer
        label.repaint();
	}
	
	public BufferedImage getImage() {
	    return image;
	}
	public void square(){
		for(int i=0;i<4;i++){
			turtle.forward(200);
			turtle.right(90);
		}
	}
	public void flower(){
		for(int i=0;i<100;i++){
			turtle.forward(i+2);
			turtle.left(i+1);
			if(i%2==0){
				turtle.setColor(Color.BLUE);
				
			}
			else{
				turtle.setColor(Color.GREEN);
			}
			
		}
	}
	
	public void drive() {
	    // code to do things with the turtle goes here
	    //turtle.setVelocity(4000);
	    turtle.setVelocity(1);
	    //turtle.setVelocity(0);
        turtle.penDown();
        
        turtle.forward(200);
        
        turtle.penUp();
        repaint();
	}
	public void drawaSquare(){
		turtle.setVelocity(50);
		turtle.penDown();
		square();
		turtle.penUp();
		repaint();
	}
	public void drawaFlower(){
		turtle.setVelocity(50);
		turtle.penDown();
		flower();
		turtle.penUp();
		repaint();
	}
	
	
    public static void main(String[] args) throws Exception {
        TurtleDriver turtleDriver = new TurtleDriver(500, 500);
        turtleDriver.drawaFlower();
        // writes the image to a png file (it will end up in your project folder's root)
        ImageIO.write(turtleDriver.getImage(), "png", new File("turtledrawing.png"));
    }
}
