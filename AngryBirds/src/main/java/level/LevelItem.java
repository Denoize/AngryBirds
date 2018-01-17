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
	private Point position;
	private String imagePath;
	

    public void paint(Graphics g) {
       g.drawImage(img, (int) position.getX(), (int) position.getY(), null);
    }

    public LevelItem(Point position){
       this.position = position;
       try {
          img = ImageIO.read(new File(imagePath));
       } catch (IOException e) {
          e.printStackTrace();
       }
    }

    public Dimension getPreferredSize() {
       if (img == null) {
          return new Dimension(100,100);
       } else {
          return new Dimension(img.getWidth(), img.getHeight());
       }
    }

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
