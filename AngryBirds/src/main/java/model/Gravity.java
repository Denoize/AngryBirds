package main.java.model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import main.java.model.character.Character;
import main.java.model.decor.BlackHole;
import main.java.tools.Tools;

public class Gravity {

	private double global;
	private List<BlackHole> blackholes;

	public Gravity(double global) {
		super();
		this.global = global;
		blackholes = new ArrayList<>();
	}

	public Gravity() {
		this.global = 0.1;
		blackholes = new ArrayList<>();
	}

	public void addBlackHole(BlackHole blackHole) {
		blackholes.add(blackHole);
	}

	/**
	 * Calcul la gravité selon la position du bird
	 * si le bird est à coté d'un troui noir, la gravité est altéré.
	 * 
	 * @param birdPosition
	 * @return
	 */
	public double getGravity(Character character) {
		Rectangle bounds = character.getBounds();
		// Si le bird est à coté d'un trou noir
		for(BlackHole bh:blackholes)
			if(bounds.intersects(bh.getBounds())) {
				double bhFactor = bh.getAttractionFactor();
				double ccx = bounds.getCenterX();
				double ccy = bounds.getCenterY();
				double bhcx = bh.getBounds().getCenterX();
				double bhcy = bh.getBounds().getCenterY();
				double distance = Tools.distance(ccx, ccy, bhcx, bhcy);
				bhFactor = distance/20;
				// coin superieur gauche
				if( ccx < bhcx &&
					ccy < bhcy) {
					character.getVelocity().addX(bhFactor);
					character.getVelocity().addY(bhFactor);
					return bhFactor;
					
				}//coin superieur droit
				else if(ccx > bhcx &&
						ccy < bhcy) {
					character.getVelocity().addX(bhFactor*(-1));
					character.getVelocity().addY(bhFactor);
					
				}//coin inferieur gauche
				else if(ccx < bhcx &&
						ccy > bhcy) {
					character.getVelocity().addX(bhFactor);
					character.getVelocity().addY(bhFactor*(-1));
				}//coin inferieur droit
				else if(ccx > bhcx &&
						ccy > bhcy) {
					character.getVelocity().addX(bhFactor*(-1));
					character.getVelocity().addY(bhFactor*(-1));
				}
				else {
					
				}
			}

		character.getVelocity().addY(global);
		return global;
	}

	public void setGravity(double value) {
		if(value >0 && value < 2)
			global = value;
		else
			global = 0.1;

	}

	public List<BlackHole> getBlackHoles() {
		return blackholes;
	}



}
