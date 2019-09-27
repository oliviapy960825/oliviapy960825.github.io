package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import Model.Orc;

public class Orcview {
	List<Orc> orcList = new ArrayList<Orc>();
	BufferedImage[][][] pic_file;
	
	
	
	public Orcview(){
		orcList = new ArrayList<Orc>();
		// pic_file[] = actions: run, jump, shoot, die
		// pic_file[][] = direction: north, south, east. etc
		// pic_file[][][] = where all the orc_pics are

		//pic_file[0] = action
		/*
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
		*/

		/*
		pics = new BufferedImage[8][];
		for (int i = 0; i < 8; i++){
			pics[i] = new BufferedImage[10];
			for(int j = 0; j < frameCount; j++){
				BufferedImage img = pic_file[i];
				pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
			}
		}
		// Change this constructor so that at least eight orc animation pngs are loaded
		 * */
	}  
	
	
	public void addOrc(Orc orc){
		orcList.add(orc);
		Orcview ov =  new Orcview();
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

	
	// when add, call animation()
	// when tick(), call paint()
	
}
