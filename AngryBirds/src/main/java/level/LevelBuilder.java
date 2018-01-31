package main.java.level;

import java.awt.Point;

import main.java.model.character.Bird;
import main.java.model.character.Pig;
import main.java.model.decor.BlackHole;
import main.java.service.factory.CharacterFactory;
import main.java.service.factory.DecorFactory;

public class LevelBuilder {
	
	private final int ground_character = 675;

	private CharacterFactory cf = new CharacterFactory();
	private DecorFactory df = new DecorFactory();
	
	
	public Level createLevel(int number){

		switch(number){
		case 0 : return gameFinish();
		case 1 : return createLevel1();
		case 2 : return createLevel2();
		case 3 : return createLevel3();
		case 4 : return createLevel4();
		case 5 : return createLevel5();
		case 6 : return createLevel6();
		default : return null;
		}

	}


	private Level gameFinish() {
		Level level = new Level();
		level.setNumber(0);
		return level;
	}


	private Level createLevel1(){

		Level level = new Level();
		
		level.setNumber(1);
		level.addLevelItem(cf.getCharacter("bird", 0, 675));
		level.addLevelItem(cf.getCharacter("bird", 50, 675));
		level.addLevelItem(cf.getCharacter("pig",600, ground_character));
		
		return level;
	}

	private Level createLevel2() {
		
		Level level = new Level();
		
		
		level.setNumber(2);
		level.addLevelItem(cf.getCharacter("bird", 0, ground_character));
		level.addLevelItem(cf.getCharacter("bird", 50, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("pig",550, ground_character));
		level.addLevelItem(cf.getCharacter("pig",750, ground_character));
		
		
		return level;
	}
	
	private Level createLevel3() {

		Level level = new Level();
		
		
		level.setNumber(3);
		level.addLevelItem(cf.getCharacter("bird", 0, ground_character));
		level.addLevelItem(cf.getCharacter("bird", 50, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("pig",550, ground_character));
		level.addLevelItem(df.getDecor("wall", 650, 525));
		level.addLevelItem(cf.getCharacter("pig",750, ground_character));
		
		
		return level;
	}
	
	private Level createLevel4() {

		Level level = new Level();
		
		
		level.setNumber(4);
		level.addLevelItem(cf.getCharacter("bird", 0, ground_character));
		level.addLevelItem(cf.getCharacter("bird", 50, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("pig",650, ground_character));
		level.addLevelItem(df.getDecor("wall", 575, 525));
		level.addLevelItem(df.getDecor("wall", 755, 525));
		level.addLevelItem(df.getDecor("ceiling", 575, 510));
		return level;
	}
	
	private Level createLevel5() {
		
		Level level = new Level();
		
		level.setNumber(5);
		level.addLevelItem(cf.getCharacter("bird", 0, ground_character));
		level.addLevelItem(cf.getCharacter("bird", 50, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		
		level.addLevelItem(cf.getCharacter("pig",750, ground_character));
		
		level.addLevelItem(df.getDecor("wall", 675, 525));
		level.addLevelItem(df.getDecor("wall", 855, 525));
		
		level.addBlackHole(new BlackHole(500, 300, 1));
		
		return level;
	}
	
	private Level createLevel6() {

		Level level = new Level();
		
		level.setNumber(6);
		level.addLevelItem(cf.getCharacter("bird",100, ground_character));
		
		level.addLevelItem(cf.getCharacter("pig",750, ground_character));
		
		level.addLevelItem(df.getDecor("barrel", 675, 630));
		level.addLevelItem(df.getDecor("barrel", 775, 630));
		level.addLevelItem(df.getDecor("barrel", 775, 570));
		
		level.addBlackHole(new BlackHole(500, 300, 1));
		
		return level;
	}
}
