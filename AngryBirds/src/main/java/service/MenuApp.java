package main.java.service;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import main.java.app.App;
import main.java.model.Player;

public class MenuApp extends MenuBar{

	Menu gameMenu;
	Menu retryMenu;
	Menu helpMenu;
	
	public MenuApp(){
		buildMenu();
	}
	
	private void buildMenu() {
		gameMenu = new Menu("Jeu");
		helpMenu = new Menu("Aide");
		
		// Les items du menu Jeu
		MenuItem newGameMenuItem  = new MenuItem("Nouvelle partie");
		MenuItem loadGameMenuItem = new MenuItem("Charger...");
		MenuItem saveGameMenuItem = new MenuItem("Sauvegarder...");
		MenuItem quitMenuItem     = new MenuItem("Quitter");

		newGameMenuItem.addActionListener(new NewGameListener());
		loadGameMenuItem.addActionListener(new LoadGameListener());
		saveGameMenuItem.addActionListener(new SaveGameListener());
		quitMenuItem.addActionListener(new QuitGameListener());
		
		gameMenu.add(newGameMenuItem);
		gameMenu.add(loadGameMenuItem);
		gameMenu.add(saveGameMenuItem);
		gameMenu.add(quitMenuItem);
		
			
		// A propos
		MenuItem aboutMenuItem = new MenuItem("A propos...");
		aboutMenuItem.addActionListener(new AboutListener());
		
		helpMenu.add(aboutMenuItem);
		add(gameMenu);
		add(helpMenu);
		

	}
		
	/**
	 * Creer une nouvelle partie
	 */
	class NewGameListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().getGame().newGame();
			
		}
		
	}
	class LoadGameListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	class SaveGameListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	class QuitGameListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().quit();
		}
		
	}
	class RetryListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			App.getInstance().getGame().retry();

		}
		
	}
	class AboutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
						
			Dialog d = new Dialog(App.getInstance().getMainFrame(), "A propos", false);
			d.setSize(400, 200);
			
			d.setLayout(new GridLayout(4, 1));
			d.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent windowEvent){
					d.dispose();
				}        
			}); 
			
			d.add(new Label("AngryBirds"));
			d.add(new Label("Master ISL 2017/2018"));
			d.add(new Label("Aix Marseille Université"));
			d.add(new Label("Aurélien Denoize & Antonin Boudes"));
			d.setLocationRelativeTo(null);
			d.pack();
			d.setVisible(true);
		}
		
	}
	
	
	
	
}
