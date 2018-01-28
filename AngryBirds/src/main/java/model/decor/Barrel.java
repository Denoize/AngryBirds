package main.java.model.decor;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Barrel extends Decor {

	public Barrel(int x, int y) {
		super(x, y);
		setImagePath("src/main/resource/images/decor/barrel.png");
		try {
			setImg(ImageIO.read(new File(getImagePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(getImg().getWidth(), getImg().getHeight());
	}
}
