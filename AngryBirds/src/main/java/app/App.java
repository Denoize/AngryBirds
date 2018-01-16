package main.java.app;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame{
	

	private static final long serialVersionUID = 1L;
	public static Graphics graphic;
	
	public App(){
	      super("Java AWT Examples");
	      prepareGUI();
	   }

	   public static void main(String[] args){
		   App  awtGraphicsDemo = new App();  
	      awtGraphicsDemo.setVisible(true);
	   }

	   private void prepareGUI(){
	      setSize(800,600);
	      addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      }); 
	      
	      graphic = getGraphics();
	   }    

}
