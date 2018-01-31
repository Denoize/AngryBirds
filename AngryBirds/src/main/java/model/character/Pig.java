package main.java.model.character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pig extends Character {

	private static final long serialVersionUID = 1L;

	public Pig(int x, int y) {
		super(x, y);
		
	}

	/**
	 * Apparence normal (yeux ouvert)
	 */
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
	
	/**
	 * Apparence normal (yeux fermer)
	 */
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
	
	/**
	 * Apparence lors de la mort
	 */
	@Override
	public void setDead() {
		setImagePath("src/main/resource/images/character/pig_dead.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		setLive(0);
	}
}
