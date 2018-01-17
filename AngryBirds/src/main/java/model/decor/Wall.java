package main.java.model.decor;

import java.awt.Point;

public class Wall extends Decor {

	public Wall(Point position) {
		super(position);
		setImagePath("/AngryBirds/src/main/resource/images/decor/mur_50x150.jpg");
	}
}
