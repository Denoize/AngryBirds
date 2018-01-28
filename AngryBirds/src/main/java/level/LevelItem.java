package main.java.level;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class LevelItem extends Component{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private String imagePath;
	

    public void paint(Graphics g) {
    }

   

    public LevelItem(int x, int y) {
		super();
		setLocation(x, y);
		
	}



	public Dimension getPreferredSize() {
       if (img == null) {
          return new Dimension(0,0);
       } else {
          return new Dimension(img.getWidth(), img.getHeight());
       }
    }

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}



	/**
	 * @return the centerX
	 */
	public double getCenterX() {
		return getX() - (getWidth()/2);
	}


	/**
	 * @return the centerY
	 */
	public double getCenterY() {
		return getY() - (getHeight()/2);
	}

	
	
	
}
