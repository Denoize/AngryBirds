package main.java.model.character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends Character{

	private static final long serialVersionUID = 1L;
	private boolean angry;
	
	public Bird(int x, int y) {
		super(x, y);
		
		setCalm();
	
	}
	
	/**
	 * Apparence lors du vol
	 */
	public void setInFlight() {
		setImagePath("src/main/resource/images/character/bird_fast_flight.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		angry = true;
	}
	
	/**
	 * Apparence lors de la selection
	 */
	public void setRoar() {
		setImagePath("src/main/resource/images/character/bird_roar.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		angry = true;
	}
	
	/**
	 * Apparence normale
	 */
	public void setCalm() {
		setImagePath("src/main/resource/images/character/bird_calm.png");
		try {
			setImg(ImageIO.read(new File(getImagePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setSize(getImg().getWidth(), getImg().getHeight());
		angry = false;
	}
	
	/**
	 * Apparence lors de l'attente de lancement
	 */
	public void setBoring() {
		setImagePath("src/main/resource/images/character/bird_boring.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		angry = false;
	}
	
	/**
	 * Apparence lors de la mort
	 */
	@Override
	public void setDead() {
		setImagePath("src/main/resource/images/character/bird_dead.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		setLive(0);
		angry = false;
	}

	/**
	 * @return the angry
	 */
	public boolean isAngry() {
		return angry;
	}

	
}
