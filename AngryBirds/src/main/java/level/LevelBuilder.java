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
		level.addLevelItem(cf.getCharacter("bird", new Point(50, 100)));
		level.addLevelItem(cf.getCharacter("bird", new Point(100, 100)));
		level.addLevelItem(cf.getCharacter("bird", new Point(150, 100)));
		level.addLevelItem(cf.getCharacter("pig", new Point(500, 100)));
		
		return level;
	}
}
