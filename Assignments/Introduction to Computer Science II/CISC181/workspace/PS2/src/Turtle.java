import java.awt.Color;
import java.awt.Graphics;

public class Turtle {
    private TurtleDriver driver;
    private int x;
    private int y;
    private int offsetX;
    private int offsetY;
    private double heading;
    private boolean penDown;
    private double velocity;
    private Color color;
    private Turtle oldTurtle;

    public Turtle(TurtleDriver driver) {
        this.driver = driver;
        this.x = 0;
        this.y = 0;
        this.heading = 0;
        this.penDown = false;
        // since 0, 0 is in the middle everything is offset by half world width/height
        this.offsetX = (int)(driver.getWidth()/2);
        this.offsetY = (int)(driver.getHeight()/2);
        this.velocity = 0;
        this.color = Color.WHITE; // default
    }
    
    public void setOffset(int x, int y) {
        this.offsetX = x;
        this.offsetY = y;
    }
    public void setOffset(int pos,boolean x_y) {
    	if(x_y){
    		this.offsetX = pos;
    	}else{
    		this.offsetY = pos;	
    	}
    }
    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * Moves the turtle forward the given distance in pixels.
     * 
     * @param distance
     */
    public void forward(double distance) {
        // convert to radians
        int distx = (int)(Math.cos(Math.PI * heading / 180.0) * distance);
        int disty = (int)(Math.sin(Math.PI * heading / 180.0) * distance);

        if (penDown) {
            Graphics g = driver.getGraphics();
            Color oldColor = g.getColor(); // allows us to save the old color
                                           // and reset it after we are done

            g.setColor(color); // forces to draw WHITE, you should
                                     // probably change this
            
            if (velocity == 0 || velocity == Double.POSITIVE_INFINITY) {
                // no forced repaint
                g.drawLine(x + offsetX, y + offsetY,
                     x + distx + offsetX, y + disty + offsetY);
            }
            else {
                double v = Math.max(velocity, 1); // minimum 1 pixel per second
                // turtle will repaint at 25 frames per second (40 milliseconds per frame)
                int frames = (int)Math.ceil((distance / v) * 25);
                int prevX = x+offsetX;
                int prevY = y+offsetY;
                for (int i = 1; i <= frames; i++) {
                    double fraction = (double)i/(double)frames;
                    int nextX = (int)(x+distx*fraction)+offsetX;
                    int nextY = (int)(y+disty*fraction)+offsetY;
                    g.drawLine(prevX, prevY, nextX, nextY);
                    prevX = nextX;
                    prevY = nextY;
                    driver.repaint();
                    // force program to wait
                    try {
                        Thread.sleep(40);
                    }
                    catch (Exception e) {
                    }
                }
            }
            
            g.setColor(oldColor);
        }

        x += distx;
        y += disty;
    }
    
    /**
     * Moves the turtle backward the given distance in pixels.
     * 
     * @param distance
     */
    public void back(double distance) {
        forward(-distance);
    }

    /**
     * Accessor for heading.
     * 
     * @return
     */
    public double heading() {
        return heading;
    }
    
    /**
     * Turns the turtle RIGHT by the given degree.
     * 
     * @param degree
     */
    public void right(double degree) {
        heading += degree;
    }
    
    /**
     * Turns the turtle LEFT by the given degree.
     * 
     * @param degree
     */
    public void left(double degree) {
        heading -= degree;
    }

    /**
     * Accessor for pen state
     * 
     * @return
     */
    public boolean pen() {
        return penDown;
    }
    
    /**
     * Mutator to set pen up
     */
    public void penUp() {
        penDown = false;
    }
    
    /**
     * Mutator to set pen down
     */
    public void penDown() {
        penDown = true;
    }
    
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Pushes a Turtle state onto the chain of Turtle states.
     * Returns the new state.
     * 
     * @return
     */
    public void push() {
        Turtle savedTurtle = new Turtle(this.driver);
        savedTurtle.x = this.x;
        savedTurtle.y = this.y;
        savedTurtle.offsetX = this.offsetX;
        savedTurtle.offsetY = this.offsetY;
        savedTurtle.heading = this.heading;
        savedTurtle.velocity = this.velocity;
        savedTurtle.color = this.color;
        savedTurtle.penDown = this.penDown;

        savedTurtle.oldTurtle = this.oldTurtle;
        
        this.oldTurtle = savedTurtle;
    }
    
    /**
     * Pops the Turtle state from the chain of Turtle states.
     */
    public void pop() {
        if (oldTurtle != null) {
            this.x = oldTurtle.x;
            this.y = oldTurtle.y;
            this.offsetX = oldTurtle.offsetX;
            this.offsetY = oldTurtle.offsetY;
            this.heading = oldTurtle.heading;
            this.velocity = oldTurtle.velocity;
            this.color = oldTurtle.color;
            this.penDown = oldTurtle.penDown;
            this.oldTurtle = oldTurtle.oldTurtle;
        }
    }
}

