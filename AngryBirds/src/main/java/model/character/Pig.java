package main.java.model.character;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pig extends Character {
	
	public Pig(int x, int y) {
		super(x, y);
		
	}

	public void setNormal() {
		setImagePath("src/main/resource/images/character/pig_normal.png");
		getClass().getClassLoader().getResource(getImagePath());
		try {
			setImg(ImageIO.read(new File(getImagePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(getImg().getWidth(), getImg().getHeight());
	}
	
	public void setBlind() {
		setImagePath("src/main/resource/images/character/pig_blind.png");
		getClass().getClassLoader().getResource(getImagePath());
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		setSize(getImg().getWidth(), getImg().getHeight());
	}
	
}
