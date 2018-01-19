package main.java.model.decor;

import java.awt.Point;

public class Wall extends Decor {

	public Wall(double x, double y) {
		super(x, y);
		setImagePath("src/main/resource/images/decor/mur_50x150.jpg");
	}
}
