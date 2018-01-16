package main.java.service.factory;

import main.java.model.decor.Barrel;
import main.java.model.decor.Decor;
import main.java.model.decor.Wall;

public class DecorFactory {
	public Decor getDecor(String name){
			
		if(name.equals("wall")){
			return new Wall();
		}
		
		else if(name.equals("barrel")){
			return new Barrel();
		}
		
		return null ;
	}
}
