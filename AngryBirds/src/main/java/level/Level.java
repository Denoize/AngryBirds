package main.java.level;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

public class Level extends Panel {
	
	private int number;
	private List<LevelItem> items = new ArrayList<LevelItem>();
	
	
	public void addLevelItem(LevelItem  item){
		items.add(item);
	}
	
	public void initLevel(){
//		Graphics2D g = (Graphics2D) getGraphics();
//		g.setColor(Color.BLACK);
//        g.drawLine(0, 500, 800, 500);
//        g.drawLine(100, 500, 100, 400);
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int numero) {
		this.number = numero;
	}
}
