package View;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import Model.Orc;

public class Orc_View extends JPanel{
	// fields
	ArrayList<Orc> orcList = new ArrayList<Orc>(); 
	BufferedImage[][] pics;
	final int frameCount = 10;
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	
	// methods
	public void addOrc(Orc orc){ // orc Spawn
		orcList.add(orc);
		// call animation()
	}
	
	public void removeOrc(Orc orc){
		orcList.remove(orc); // RETURNS A BOOLEAN orc Kill
	}
	
	public void changeOrc(int i, Orc orc){
		orcList.set(i, orc);
		// Replaces the element at the specified 
		// 	position i in this list with the specified element orc.
	}



	//Constructor: get image, segment and store in array
	public Orc_View(){ // Animation
		BufferedImage[] pic_file = new BufferedImage[] {
				createImage("orc_forward_east.png"),   // pic frames (2nd)
				createImage("orc_forward_north.png"),
				createImage("orc_forward_northeast.png"),
				createImage("orc_forward_northwest.png"),
				createImage("orc_forward_south.png"),
				createImage("orc_forward_southeast.png"),
				createImage("orc_forward_southwest.png"),
				createImage("orc_forward_west.png"),
		};

		pics = new BufferedImage[8][];
		for (int i = 0; i < 8; i++){
			pics[i] = new BufferedImage[10];
			for(int j = 0; j < frameCount; j++){
				BufferedImage img = pic_file[i];
				pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
			}
		}
		// Change this constructor so that at least eight orc animation pngs are loaded
	}  

	//Read image from file and return
	private BufferedImage createImage(String file_name){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("orc_animation/" + file_name));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// Change this method so you can load other orc animation bitmaps
	} 
	
	
	
	public void buttons(){
		JButton spawnButton = new JButton("Spawn New Orc");
		JButton removeButton = new JButton("Remove An Orc");
		JButton changeButton = new JButton("Change An Orc");
		
		spawnButton.setActionCommand("spawn");
		removeButton.setActionCommand("remove");
		changeButton.setActionCommand("change");
		
		spawnButton.addActionListener(new ButtonClickListener());
		removeButton.addActionListener(new ButtonClickListener());
		changeButton.addActionListener(new ButtonClickListener());
		
		// ADD THE BUTTONS TO THE controlPanel/frame
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			
			if (command.equals("spawn")){
				// CREATE AN ORC & ADD THE ORC TO ARRAYLIST
			}
			else if (command.equals("remove")){
				// REMOVE AN ORC (CALL REMOVEORC FUNCTION)
			}
			else{
				// CHANGE AN ORC
			}
		}
	}
}
