package main.java.model.character;

import main.java.level.LevelItem;

public abstract class Character extends LevelItem{

	private static final long serialVersionUID = 1L;
	
	int live = 1; // vie du personnage
	
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
	
	/**
	 * @return the live
	 */
	public int getLive() {
		return live;
	}

	/**
	 * @param live the live to set
	 */
	public void setLive(int live) {
		this.live = live;
	}
}
