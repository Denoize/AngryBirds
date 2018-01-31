package main.java.app;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import main.java.service.Game;
import main.java.service.MenuApp;
import main.java.tools.Constante;

public class App{

	private static App angryBirds;
	
	private Frame mainFrame;

	/**
	 * @return the mainFrame
	 */
	public Frame getMainFrame() {
		return mainFrame;
	}

	public static Graphics graphic;
	public static Panel pane;
	private Game game;

	public App(){
		prepareGUI();
	}

	public static void main(String[] args){
		angryBirds = new App();  
	}

	private void prepareGUI(){
		mainFrame = new Frame("AngryBirds");
		mainFrame.setSize(Constante.FRAME_WIDTH, Constante.FRAME_HEIGHT);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    

		game = new Game(1);
		mainFrame.add(game);
		mainFrame.setMenuBar(new MenuApp());
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}    

	public static Graphics getGraphicsContext() {
		return graphic;

	}

	public static Panel getPanel() {
		return pane;
	}

	/**
	 * @return the angryBirds
	 */
	public static App getInstance() {
		return angryBirds;
	}

	public Game getGame() {
		return game;
	}

	public void quit() {
		mainFrame.dispose();
		
	}


}
