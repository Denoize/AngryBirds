package main.java.level;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Gravity;
import main.java.model.character.Character;
import main.java.model.decor.BlackHole;

public class Level extends Panel {
	
	private static final long serialVersionUID = 1L;
	private int number;
	private List<LevelItem> items = new ArrayList<LevelItem>();
	private Gravity gravity;
	
	public Level() {
		gravity = new Gravity();
	}
	
	public void setGravity(double value) {
		gravity.setGravity(value);
	}
	
	public void addLevelItem(LevelItem  item){
		items.add(item);
	}
	
	/**
	 * Ajouter un trou noir
	 * @param blackHole
	 */
	public void addBlackHole(BlackHole blackHole) {
		gravity.addBlackHole(blackHole);
	}
	
	/**
	 * Obtenir la liste des trous noir
	 * 
	 * @return
	 */
	public List<BlackHole> getBlackHoles() {
		return gravity.getBlackHoles();
	}
	
	public void getGravity(Character character) {
		gravity.underGravity(character);
	}

	/**
	 * @return the items
	 */
	public List<LevelItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<LevelItem> items) {
		this.items = items;
	}

	/**
	 * le numero du niveau
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	public void setNumber(int numero) {
		this.number = numero;
	}
}
