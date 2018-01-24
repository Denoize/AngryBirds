package main.java.model.character;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pig extends Character {
	
	public Pig(double x, double y) {
		super(x, y);
		setImagePath("src/main/resource/images/character/pig.png");
		getClass().getClassLoader().getResource(getImagePath());
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
	}

	
}