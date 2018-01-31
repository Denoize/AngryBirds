package main.java.model.decor;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlackHole extends Decor {

	private static final long serialVersionUID = 1L;
	private double attractionFactor;
	
	public BlackHole(int x, int y, double attraction) {
		super(x, y);
		setAttractionFactor(attraction);
		
		setImagePath("src/main/resource/images/decor/black_hole.png");
		try {
			setImg(ImageIO.read(new File(getImagePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(getImg().getWidth(), getImg().getHeight());
	}
	
	/**
	 * @return the attractionFactor
	 */
	public double getAttractionFactor() {
		return attractionFactor;
	}

	/**
	 * @param attractionFactor the attractionFactor to set
	 */
	private void setAttractionFactor(double attractionFactor) {
		this.attractionFactor = attractionFactor;
	}
}