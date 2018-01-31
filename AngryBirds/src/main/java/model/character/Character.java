package main.java.model.character;

import java.awt.Point;

import main.java.level.LevelItem;
import main.java.model.Velocity;

public abstract class Character extends LevelItem{


	int live = 1;
	
	public Character(int x, int y) {
		super(x, y);
	}

	public void setDead() {
		live = 0;
	}
	
	public void hit() {
		live--;
	}

	public boolean isAlive() {
		if(live == 0) return false;
		
		return true;
	}
}
