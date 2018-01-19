package main.java.level;

import java.awt.Point;

import main.java.model.character.Bird;
import main.java.model.character.Pig;
import main.java.service.factory.CharacterFactory;

public class LevelBuilder {
	public Level createLevel1(){
		Level level = new Level();
		CharacterFactory cf = new CharacterFactory();
		level.initLevel();
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",500, 650));
		
		return level;
	}
}
