package main.java.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.java.app.App;
import main.java.model.Player;

public class Menu extends Panel implements  MouseListener, MouseMotionListener{

	
	private String titleNewPlayer = "New Player";
	private String titleNewGame = "New Game";
	
	
	Image buffer;   // image pour le rendu hors écran

	public Menu(){
		addMouseListener(this);
        addMouseMotionListener(this);
		
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
		System.out.println("Log : new game");
		Game game = new Game(1);
		App.getInstance().setPanel(game);
	}
	
	public Player loadPlayer() {
		return null;
		
	}
	
	public void quit() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		// New Player
		if((e.getX() > 200 && e.getX() < 600 )&&
		e.getY() > this.getHeight()/4-50 && 
		e.getY() < this.getHeight()/4+50) {
			
			
		}
		else if((e.getX() > 200 && e.getX() < 600 )&&
				e.getY() > this.getHeight()/2-50 && 
				e.getY() < this.getHeight()/2+50) {
					
				newGame();	
		}
		
	}
    public void mouseEntered(MouseEvent e) { 
    	if((e.getX() > 200 && e.getX() < 600 )&&
				e.getY() > this.getHeight()/2-50 && 
				e.getY() < this.getHeight()/2+50) {
					
				Graphics2D g2 = (Graphics2D) getGraphics();
				g2.setColor(Color.ORANGE);
				repaint();
		}
    		
    }
    public void mouseExited(MouseEvent e)  { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) { mouseMoved(e); }
    public void mouseMoved(MouseEvent e) { 
    	
    	
    	
        //repaint();
    }
    
    
    
    
    @Override
    public void paint(Graphics g) {
    	if(buffer == null) buffer = createImage(800, 600);
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
   
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
       Font font = new Font("Serif", Font.PLAIN, 56);
       g2.setFont(font);
       printNewPlayer(g2);
       printNewGame(g2);
       
       // affichage à l'écran sans scintillement
       g.drawImage(buffer, 0, 0, null);
    }
	
    void printNewPlayer(Graphics2D g2) {
    	g2.drawString(titleNewPlayer, this.getWidth()/2-100, this.getHeight()/4);
    }
    
    void printNewGame(Graphics2D g2) {
    	g2.drawString(titleNewGame, this.getWidth()/2-100, this.getHeight()/2);
    }
	
}
