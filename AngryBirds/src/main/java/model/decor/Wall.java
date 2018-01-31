package main.java.model.decor;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wall extends Decor {

	private static final long serialVersionUID = 1L;

	public Wall(int x, int y) {
		super(x, y);
		setImagePath("src/main/resource/images/decor/wall.png");
		try {
	          setImg(ImageIO.read(new File(getImagePath())));
	       } catch (IOException e) {
	          e.printStackTrace();
	    }
		setSize(getImg().getWidth(), getImg().getHeight());
	}
}
