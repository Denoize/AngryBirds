package main.java.service.factory;

import java.awt.Point;

import main.java.model.decor.Barrel;
import main.java.model.decor.Decor;
import main.java.model.decor.Wall;

public class DecorFactory {
	public Decor getDecor(String name, double x, double y){
			
		if(name.equals("wall")){
			return new Wall(x, y);
		}
		
		else if(name.equals("barrel")){
			return new Barrel(x, y);
		}
		
		return null ;
	}
}
