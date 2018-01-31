package main.java.service.factory;

import main.java.model.character.Bird;
import main.java.model.character.Character;
import main.java.model.character.Pig;

public class CharacterFactory {
	public Character getCharacter(String name, int x, int y){
		
		if(name.equals("bird")){
			return new Bird(x, y);
		}
		
		else if(name.equals("pig")){
			return new Pig(x, y);
		}
		
		return null ;
	}
}
