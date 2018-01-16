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

    public void paint(Graphics g) {
       g.drawImage(img, (int) position.getX(), (int) position.getY(), null);
    }

    public LevelItem(String path) {
       try {
          img = ImageIO.read(new File(path));
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
}
