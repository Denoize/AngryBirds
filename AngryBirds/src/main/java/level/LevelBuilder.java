package main.java.level;

import java.awt.Point;

import main.java.model.character.Bird;
import main.java.model.character.Pig;
import main.java.service.factory.CharacterFactory;

public class LevelBuilder {

	public Level createLevel(int number){

		switch(number){
			case 1 : return createLevel1();
			case 2 : return createLevel2();
			default : return null;
		}

	}


	private Level createLevel1(){

		Level level = new Level();
		CharacterFactory cf = new CharacterFactory();
		level.initLevel();
		level.setNumber(1);
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",500, 650));
		return level;
	}

	private Level createLevel2() {
		
		Level level = new Level();
		CharacterFactory cf = new CharacterFactory();
		level.initLevel();
		level.setNumber(1);
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",500, 650));
		level.addLevelItem(cf.getCharacter("pig",600, 650));
		return level;
	}
}
