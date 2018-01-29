package main.java.service;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.imageio.ImageIO;

import main.java.level.Level;
import main.java.level.LevelBuilder;
import main.java.level.LevelItem;
import main.java.model.Player;
import main.java.model.character.Bird;
import main.java.model.character.Pig;
import main.java.model.decor.Decor;
import main.java.model.decor.Wall;

public class Game extends Canvas implements Runnable, MouseListener, MouseMotionListener {
	//double birdX, birdY, velocityX, velocityY;  // informations relatives à l'oiseau
	final int frameWidth = 1000, frameHeight = 800;
	int ground = 675;
	Bird currentBird;  // informations relatives à l'oiseau
	double velocityX, velocityY;
	private BufferedImage background;
	private BufferedImage slingshot;
	double gravity;                             // gravité
	int mouseX, mouseY;                         // position de la souris lors de la sélection
	String message;                             // message à afficher en haut de l'écran
	int score;                                  // nombre de fois où le joueur a gagné
	boolean gameOver;                           // vrai lorsque le joueur a touché un bord ou le cochon
	boolean selecting;                          // vrai lorsque le joueur sélectionne l'angle et la vitesse
	Image buffer;                               // image pour le rendu hors écran
	final Point slingshotCenter = new Point(230,550);
	Stack<Bird> birds;
	List<Pig> pigs;
	int animation_birds;
	int animation_pigs;

	Level level;
	Player player;
	private int currentLevel;
	private List<LevelItem> items;
	private boolean a;

	// calcule la distance entre deux points
	static double distance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}

	// constructeur
	public Game(int currentLevel) {
		setVisible(true);
		this.currentLevel = currentLevel;
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
			velocityX = (slingshotCenter.getX() - mouseX ) / 15.0;
			velocityY = (slingshotCenter.getY()  - mouseY) / 15.0;

			message = "L'oiseau prend sont envol";
			selecting = false;

			currentBird.setInFlight();
		}
		repaint();
	}
	public void mouseDragged(MouseEvent e) { mouseMoved(e); }
	public void mouseMoved(MouseEvent e) { 
		mouseX = e.getX();
		mouseY = e.getY();
		if(selecting) {
			if(distance(mouseX, mouseY, slingshotCenter.getX(), slingshotCenter.getY()) < 100) {

				currentBird.setLocation(mouseX, mouseY);
				currentBird.setCalm();
			}else {
				double factor = 100 / distance(mouseX, mouseY, slingshotCenter.getX(), slingshotCenter.getY());
				double x = ((mouseX - slingshotCenter.getX()) * factor) + slingshotCenter.getX();
				double y = ((mouseY - slingshotCenter.getY()) * factor) + slingshotCenter.getY();

				currentBird.setLocation((int)x, (int) y);
				currentBird.setRoar();


			}
		}


		repaint();
	}
	
	public void newGame(){
		this.currentLevel = 1;
		score = 0;
		init();
	}


	// début de partie
	void init() {


		try {
			background = ImageIO.read(new File("src/main/resource/images/decor/background.jpg"));
			slingshot = ImageIO.read(new File("src/main/resource/images/decor/slingshot_200.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		gameOver = false;
		selecting = true;


		velocityX = 0;
		velocityY = 0;

		birds = new Stack<Bird>();
		pigs = new ArrayList<Pig>();

		message = "Choisissez l'angle et la vitesse.";


		LevelBuilder bl = new LevelBuilder();

		level = bl.createLevel(currentLevel);

		for(Component item: level.getItems()) {

			// creer les listes d'oiseaux et de cochons
			if (item instanceof Bird) {
				birds.push((Bird) item);	
			}
			else if(item instanceof Pig){
				pigs.add((Pig) item);
			}
		}

		currentBird = birds.pop();
		currentBird.setLocation((int)slingshotCenter.getX(),(int) slingshotCenter.getY());

		items = level.getItems();

	}

	// fin de partie
	void retry() {
		velocityX = 0;
		velocityY = 0;
		gameOver = true;
	}

	void newAttempt(){
		velocityX = 0;
		velocityY = 0;
		gameOver = false;
		selecting = true;
		currentBird = birds.pop();
		currentBird.setLocation((int)slingshotCenter.getX(),(int) slingshotCenter.getY());

	}

	void nextLevel(){

		currentLevel++;

		init();

		// TODO Code a supprimer plus tard.
		if(currentLevel==3)currentLevel=1;

	}

	// boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et teste les conditions de victoire
	@SuppressWarnings("static-access")
	public void run() {
		while(true) {
			// un pas de simulation toutes les 10ms
			try { Thread.currentThread().sleep(10); } catch(InterruptedException e) { }
			if(animation_birds>0)
				animation_birds--;
			if(animation_pigs>0)
				animation_pigs--;
			if(!gameOver && !selecting) {

				// moteur physique

				int x,y;
				x = (int)(currentBird.getX() + velocityX);
				if((int)(currentBird.getY() + velocityY)>ground)
					y = ground;
				else
					y = (int)(currentBird.getY() + velocityY);
				currentBird.setLocation(x,y);

				velocityY += gravity;

				// conditions de victoire
				List<Pig> pigsCopy = new ArrayList<Pig>(pigs);

				// test les collisions entre le currentBird et les pigs
				for(Pig pig : pigsCopy){
					if(distance(currentBird.getCenterX(), currentBird.getCenterY(), pig.getCenterX(), pig.getCenterY()) < 25) {

						pigs.remove(pig);
						items.remove(pig);
						score++;
						// Si il reste des birds et des pigs

						if (pigs.isEmpty()){
							message = "Gagné : cliquez pour recommencer.";
							nextLevel();

						}
					}
				}

				if(currentBird.getX() < -60 || currentBird.getX() > frameWidth+60 || currentBird.getY() < -60) {
					currentBird.setCalm();
					if(birds.isEmpty()){
						retry();
						message = "Perdu : cliquez pour recommencer.";

					}else{

						newAttempt();
					}					 
				}

				// detecte les collisions
				collision();




			}
			// redessine
			repaint();
		}
	}


	boolean collision() {
		List<LevelItem> itemsCopy = new ArrayList<LevelItem>(items);

		for(LevelItem i : itemsCopy ) {
			if(i instanceof Decor) {
				Decor d = (Decor) i;

				if(currentBird.getBounds().intersects(d.getBounds())) {
					items.remove(d);

					velocityX = -velocityX/20;
					velocityY = -velocityY/20;
					return true;
				}
			}
		}
		if(currentBird.getY() >= ground) {
			currentBird.setCalm();
			if(Math.abs(velocityX) < 2) {
				currentBird.setDead();
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				items.remove(currentBird);
				if(birds.isEmpty()){
					retry();
					message = "Perdu : cliquez pour recommencer.";

				}else{

					newAttempt();
				}
			}else
				velocityY = -velocityY/4;

			if(velocityX >= 0)
				velocityX = velocityX - (velocityX/4);
			else if(velocityX < 0)
				velocityX = velocityX + (velocityX/4);
		}


		return false;
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
		g.drawImage(background, 0, 0, null);
		g.drawImage(slingshot, (int) 200, (int) 500, null);

		if(currentBird.isAngry() && selecting) {
			if(a)
				currentBird.setLocation(currentBird.getX()+1, currentBird.getY()+1);
			else
				currentBird.setLocation(currentBird.getX()-1, currentBird.getY()-1);
			a=!a;
		}
		if(!birds.isEmpty()) {
			if(Math.random() < 0.01 ) {
				int choice  = (int)(( Math.random() * 10) % birds.size());
				birds.get(choice).setBoring();
				animation_birds = 30;
			}
			else {
				if(animation_birds==0)
					for(Bird bird : birds) bird.setCalm();
			}
		}
		if(!pigs.isEmpty()) {
			if(Math.random() < 0.01) {
				int choice  = (int) ((Math.random() * 10) % pigs.size());
				pigs.get(choice).setBlind();
				animation_pigs = 20;
			}
			else {
				if(animation_pigs==0)
					for(Pig pig : pigs) pig.setNormal();
			}
		}

		// décor
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(2));
		if(distance(currentBird.getX(), currentBird.getY(), slingshotCenter.getX(), slingshotCenter.getY()) < 110) {

			g.drawLine(250, 540, (int) currentBird.getX(), (int) currentBird.getY());
			g.drawLine(210, 535, (int) currentBird.getX(), (int) currentBird.getY());
		}
		else {
			g.drawLine(250, 540, 210, 535);

		}

		g.setStroke(new BasicStroke(1));

		// messages
		g.setColor(Color.BLACK);
		g.drawString(message, this.getWidth()/2 - message.length()*3, 100);
		g.drawString("score: " + score, 20, 20);



		for(LevelItem item: items) {
			if(item instanceof Bird) {

				g.drawImage(item.getImg(), (int) item.getCenterX(), (int) item.getCenterY(), null);

			}
			else {
				g.drawImage(item.getImg(), (int) item.getX(), (int) item.getY(), null);

			}
		}


		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(frameWidth,frameHeight);
	}


}
