package main.java.service;

import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.java.model.Player;

public class Menu extends Panel implements  MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;


	public Menu(){
		
	}
	
	
	/**
	 * Creer un nouveau joueur
	 * @return
	 */
	public Player newPlayer() {
		
		Player player = new Player();
		
		
		
		return null;
		
	}
	
	/**
	 * 
	 */
	public void newGame() {
		
	}
	
	public Player loadPlayer() {
		return null;
		
	}
	
	public void quit() {
		
	}
	
	public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { 
    	//if(e.getX() > 100 && e.getX() < 200)
    		
    }
    public void mouseExited(MouseEvent e)  { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) { mouseMoved(e); }
    public void mouseMoved(MouseEvent e) { 
        
        repaint();
    }
	
	
}
