package main.java.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import main.java.level.Level;
import main.java.level.LevelBuilder;
import main.java.level.LevelItem;
import main.java.model.Player;
import main.java.model.character.Bird;
import main.java.model.character.Pig;

public class Game extends Panel implements Runnable, MouseListener, MouseMotionListener {
	//double birdX, birdY, velocityX, velocityY;  // informations relatives à l'oiseau
	final int frameWidth = 1000, frameHeight = 800;
	int ground = 700;
	Bird currentBird;  // informations relatives à l'oiseau
	double velocityX, velocityY;
                         // informations relatives au cochon
    double gravity;                             // gravité
    int mouseX, mouseY;                         // position de la souris lors de la sélection
    String message;                             // message à afficher en haut de l'écran
    int score;                                  // nombre de fois où le joueur a gagné
    boolean gameOver;                           // vrai lorsque le joueur a touché un bord ou le cochon
    boolean selecting;                          // vrai lorsque le joueur sélectionne l'angle et la vitesse
    Image buffer;                               // image pour le rendu hors écran
    Stack<Bird> birds = new Stack<Bird>();
    List<Pig> pigs = new ArrayList<Pig>();
    
    Level level;
    Player player;
    
    // calcule la distance entre deux points
    static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // constructeur
    Game() {
        gravity = 0.1;
        score = 0;
        addMouseListener(this);
        addMouseMotionListener(this);
        init();
        new Thread(this).start();
    }

    // gestion des événements souris
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if(gameOver) {
            init();
        } else if(selecting) {
            velocityX = (currentBird.getPosX() - mouseX) / 20.0;
            velocityY = (currentBird.getPosY() - mouseY) / 20.0;
            message = "L'oiseau prend sont envol";
            selecting = false;
        }
        repaint();
    }
    public void mouseDragged(MouseEvent e) { mouseMoved(e); }
    public void mouseMoved(MouseEvent e) { 
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    // début de partie
    void init() {
        gameOver = false;
        selecting = true;

        
        velocityX = 0;
        velocityY = 0;

        message = "Choisissez l'angle et la vitesse.";
        LevelBuilder bl = new LevelBuilder();
        level = bl.createLevel1();
        for(Component item: level.getItems()) {
        	add(item);
        	if (item instanceof Bird) {
				birds.push((Bird) item);	
			}
        	else if(item instanceof Pig){
        		pigs.add((Pig) item);	
        		
        		item.setLocation(100, 400);
        	
        	}
        }
        
        currentBird = birds.pop();
        currentBird.setPosX(175);
        currentBird.setPosY(550);
        
    }

    // fin de partie
    void stop() {
        velocityX = 0;
        velocityY = 0;
        gameOver = true;
        
    }
    
    void nextTry(){
    	velocityX = 0;
        velocityY = 0;
        gameOver = false;
        selecting = true;
    	currentBird = birds.pop();
        currentBird.setPosX(175);
        currentBird.setPosY(550);
    }

    // boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et teste les conditions de victoire
    public void run() {
        while(true) {
            // un pas de simulation toutes les 10ms
            try { Thread.currentThread().sleep(10); } catch(InterruptedException e) { }

            if(!gameOver && !selecting) {

                // moteur physique
            	currentBird.setPosX(currentBird.getPosX() + velocityX);
                currentBird.setPosY(currentBird.getPosY() + velocityY);
              
                velocityY += gravity;

                // conditions de victoire
                for(Pig pig : pigs){
                	if(distance(currentBird.getPosX(), currentBird.getPosY(), pig.getPosX(), pig.getPosY()) < 35) {
                		nextTry();
                        message = "Gagné : cliquez pour recommencer.";
                        score++;
                    }
                }
                
                if(currentBird.getPosX() < 0 || currentBird.getPosX() > frameWidth || currentBird.getPosY() < 0 || currentBird.getPosY() > ground) {
                    if(birds.isEmpty()){
                    	stop();
                    	message = "Perdu : cliquez pour recommencer.";
                    	
                    }
                    else{
                    	nextTry();
                    }
                
                    
                }

                // redessine
                repaint();
            }
        }
    }

    // évite les scintillements
    public void update(Graphics g) {
        paint(g);
    }

    // dessine le contenu de l'écran dans un buffer puis copie le buffer à l'écran
    public void paint(Graphics g2) {
        if(buffer == null) buffer = createImage(frameWidth,frameHeight);
        Graphics2D g = (Graphics2D) buffer.getGraphics();

        
       
        // fond
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // décor
        g.setColor(Color.BLACK);
        g.drawLine(0, 700, getWidth(), 700);
        g.drawLine(200, 700, 200, 600);
      
        
        // messages
        g.setColor(Color.BLACK);
        g.drawString(message, 300, 100);
        g.drawString("score: " + score, 20, 20);
        
        paintComponents(g);
        
        for(LevelItem item: level.getItems()) {
        	g.drawImage(item.getImg(), (int) item.getPosX(), (int) item.getPosY(), null);
        }
        

        // affichage à l'écran sans scintillement
        g2.drawImage(buffer, 0, 0, null);
    }

    // taille de la fenêtre
    public Dimension getPreferredSize() {
        return new Dimension(frameWidth,frameHeight);
    }


}
