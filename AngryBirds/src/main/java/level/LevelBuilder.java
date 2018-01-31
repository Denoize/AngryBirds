package main.java.level;

import java.awt.Point;

import main.java.model.character.Bird;
import main.java.model.character.Pig;
import main.java.model.decor.BlackHole;
import main.java.service.factory.CharacterFactory;
import main.java.service.factory.DecorFactory;

public class LevelBuilder {

	private CharacterFactory cf = new CharacterFactory();
	private DecorFactory df = new DecorFactory();
	
	
	public Level createLevel(int number){

		switch(number){
		case 1 : return createLevel1();
		case 2 : return createLevel2();
		case 3 : return createLevel3();
		case 4 : return createLevel4();
		default : return null;
		}

	}


	private Level createLevel1(){

		Level level = new Level();


		
		level.setNumber(1);
		level.addLevelItem(cf.getCharacter("bird", 0, 675));
		level.addLevelItem(cf.getCharacter("bird", 50, 675));
		level.addLevelItem(cf.getCharacter("bird",100, 675));
		level.addLevelItem(cf.getCharacter("pig",500, 650));
		level.addLevelItem(df.getDecor("wall", 400, 550));
		
		return level;
	}

	private Level createLevel2() {

		Level level = new Level();
		
		
		level.setNumber(2);
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",500, 650));
		level.addLevelItem(cf.getCharacter("pig",600, 650));
		level.addLevelItem(df.getDecor("wall", 800, 550));
		
		
		return level;
	}
	
	private Level createLevel3() {

		Level level = new Level();
		
		
		level.setNumber(3);
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",650, 650));
		level.addLevelItem(df.getDecor("wall", 600, 550));
		level.addLevelItem(df.getDecor("wall", 700, 550));
		level.addLevelItem(df.getDecor("ceiling", 600, 500));
		return level;
	}
	
	private Level createLevel4() {

		Level level = new Level();
		
		level.setNumber(4);
		level.addLevelItem(cf.getCharacter("bird", 0, 650));
		level.addLevelItem(cf.getCharacter("bird", 50, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("bird",100, 650));
		level.addLevelItem(cf.getCharacter("pig",650, 650));
		level.addLevelItem(df.getDecor("wall", 600, 550));
		level.addLevelItem(df.getDecor("wall", 700, 550));
		level.addLevelItem(df.getDecor("ceiling", 600, 500));
		
		level.addBlackHole(new BlackHole(400, 400, 1));
		
		return level;
	}
}
