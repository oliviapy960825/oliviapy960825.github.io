import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class Controller {
	private Model model;
	private View view;
	private ActionListener actionListener;
	private KeyListener keyListener;
	private boolean pressed; 
	private boolean movementN;
	private boolean movementE;
	private boolean movementW;
	private boolean movementS;
	private boolean jump;
	private boolean fire;

	public Controller(){
		
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		pressed = true; //flag to check button press
		movementN = false;
		movementE = false;
		movementW = false;
		movementS = false;
		jump = false;
		fire = false;
	}
	
	public void start(){
		keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				if (keyCode == KeyEvent.VK_J){
					jump = !jump;
				}
				if (keyCode == KeyEvent.VK_F){
					fire = !fire;
				}
				
				if (keyCode == KeyEvent.VK_UP){
					model.setDirect(Direction.NORTH);
					view.update(model.getX(), model.getY(), model.getDirect(), fire, jump);
					movementN = true;
				}
				if (keyCode == KeyEvent.VK_DOWN){
					model.setDirect(Direction.SOUTH);
					view.update(model.getX(), model.getY(), model.getDirect(), fire, jump);
					movementS = true;
				}
				if (keyCode == KeyEvent.VK_LEFT){
					model.setDirect(Direction.WEST);
					view.update(model.getX(), model.getY(), model.getDirect(), fire, jump);
					movementW = true;
				}
				if (keyCode == KeyEvent.VK_RIGHT){
					model.setDirect(Direction.EAST);
					view.update(model.getX(), model.getY(), model.getDirect(), fire, jump);
					movementE = true;
				}

			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		};
		
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				view.getButton().setFocusable(true);
				view.getButton().requestFocus(true);
				stopMVT(); //change pressed whenever
				// button pressed
			}
		};
		
		view.getButton().addActionListener(actionListener);   
		view.addKeyListener(keyListener);
		
		for(int i = 0; i < 5000; i++)
		{
			if (pressed == false) {
				view.getButton().setFocusable(false);
				view.getButton().requestFocus(false);
				model.updateLocationAndDirection();
				
				if (movementS == true)
				{
					view.getButton().setFocusable(false);
					view.getButton().requestFocus(false);
					model.updateLocationAndDirection();
				}
				else if (movementN == true)
				{
					view.getButton().setFocusable(false);
					view.getButton().requestFocus(false);
					model.updateLocationAndDirection();
				}
				else if (movementE == true)
				{
					view.getButton().setFocusable(false);
					view.getButton().requestFocus(false);
					model.updateLocationAndDirection();
				}
				else if (movementW == true)
				{
					view.getButton().setFocusable(false);
					view.getButton().requestFocus(false);
					model.updateLocationAndDirection();
				}
			}
			
			//increment the x and y coordinates, alter direction if necessary

			else if (pressed == true)
			{
				view.getButton().setFocusable(true);
				view.getButton().requestFocus(true);
			}
			
			
			//update the view
			view.update(model.getX(), model.getY(), model.getDirect(), fire, jump);
		}
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			
				Timer t = new Timer(30, view.getdrawAction());
				t.start();
			}
		});
	}
	// keeps tracked of whether or not the orc should be 
	// moving 
	protected void stopMVT() {
		view.getButton().setFocusable(false);
		view.getButton().requestFocus(false);
		pressed = !pressed; //change pressed's state
	}
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
