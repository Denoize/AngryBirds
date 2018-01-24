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
	private double posX;
	private double posY;
	private String imagePath;
	

    public void paint(Graphics g) {
//       g.drawImage(img, (int) posX, (int) posY, null);
    }

   

    public LevelItem(double x, double y) {
		super();
		this.posX = x;
		this.posY = y;
	}



	public Dimension getPreferredSize() {
       if (img == null) {
          return new Dimension(100,100);
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



	public double getPosX() {
		return posX;
	}



	public void setPosX(double posX) {
		this.posX = posX;
	
	}



	public double getPosY() {
		return posY;
	}



	public void setPosY(double posY) {
		this.posY = posY;
	}

	
}
