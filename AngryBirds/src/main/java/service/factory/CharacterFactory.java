package main.java.service.factory;

import java.awt.Point;

import main.java.model.character.Bird;
import main.java.model.character.Character;
import main.java.model.character.Pig;

public class CharacterFactory {
	public Character getCharacter(String name, Point position){
		
		if(name.equals("bird")){
			return new Bird(position);
		}
		
		else if(name.equals("pig")){
			return new Pig(position);
		}
		
		return null ;
	}
}
