package main.java.service.factory;

import main.java.model.character.Bird;
import main.java.model.character.Character;
import main.java.model.character.Pig;

public class CharacterFactory {
	public Character getCharacter(String name){
		
		if(name.equals("bird")){
			return new Bird();
		}
		
		else if(name.equals("pig")){
			return new Pig();
		}
		
		return null ;
	}
}
