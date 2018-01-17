package main.java.model.character;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends Character{

	public Bird(Point position){
		super(position);
		
		setImagePath("main/resource/images/character/angrybirds.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
	}
}
