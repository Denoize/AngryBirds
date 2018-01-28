package main.java.model.character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird extends Character{

	boolean angry;
	
	public Bird(int x, int y) {
		super(x, y);
		
		setCalm();
	
	}
	
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
	
	public void setDead() {
		setImagePath("src/main/resource/images/character/bird_dead.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		
		setSize(getImg().getWidth(), getImg().getHeight());
		angry = false;
	}

	/**
	 * @return the angry
	 */
	public boolean isAngry() {
		return angry;
	}

	
}
