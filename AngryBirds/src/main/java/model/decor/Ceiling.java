package main.java.model.decor;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ceiling extends Decor{
	
	public Ceiling(int x, int y) {
		super(x, y);
		setImagePath("src/main/resource/images/decor/plafond_150x50.jpg");
		try {        
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		setSize(getImg().getWidth(), getImg().getHeight());
	}
}
