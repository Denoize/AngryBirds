package main.java.app;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import main.java.service.Menu;

public class App{

	private static App angryBirds;
	
	private Frame mainFrame;

	public static Graphics graphic;
	public static Panel pane;

	public App(){
		prepareGUI();
	}

	public static void main(String[] args){
		angryBirds = new App();  
	}

	private void prepareGUI(){
		mainFrame = new Frame("AngryBirds");
		mainFrame.setSize(800,600);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    


		Menu menu = new Menu();
		pane = menu;
		mainFrame.add(pane);
		mainFrame.setVisible(true);
		
	}    

	public static Graphics getGraphicsContext() {
		return graphic;

	}

	public static Panel getPanel() {
		return pane;
	}
	
	public void setPanel(Panel panel) {
		
		mainFrame.remove(pane);
		pane = panel;
		mainFrame.add(pane);
		mainFrame.setVisible(true);
	}

	/**
	 * @return the angryBirds
	 */
	public static App getInstance() {
		return angryBirds;
	}

	


}
