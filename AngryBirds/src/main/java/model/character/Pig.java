package main.java.model.character;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pig extends Character {
	
	public Pig(Point position) {
		super(position);
		setImagePath("./pig.png");
		getClass().getClassLoader().getResource(getImagePath());
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
	}

	
}
