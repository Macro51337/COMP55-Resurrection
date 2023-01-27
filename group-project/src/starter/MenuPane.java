package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls
	private GButton play;
	private GButton exit;
	private GLabel title;
	private GLabel author;
	private GButton scoreboard;
	private GImage alien;
	private GLabel point;
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		play = new GButton("Start Game", program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/2 - 100, program.BUTTON_WIDTH, program.BUTTON_HEIGHT); 
		exit = new GButton("Exit Game", program.WINDOW_WIDTH/4, program.WINDOW_HEIGHT/2, program.BUTTON_WIDTH, program.BUTTON_HEIGHT);
		title = new GLabel("Space Invaders", 100, 100);
		title.setFont("ShowcardGothic-80");
		title.setColor(Color.YELLOW);
		
		author = new GLabel("Created by Coders-19 (Team 2)", 150, 150);
		author.setFont("Lato-36");
		author.setColor(Color.WHITE);
		
		scoreboard = new GButton("Scoreboard", 150, 400, 500, 100);
		alien = new GImage("alien.png", 225, 515);
		alien.setSize(100, 75);
		point = new GLabel("- 10 points", 350, 565);
		point.setFont("Serif-50");
	    point.setColor(Color.WHITE);
		
		play.setFillColor(Color.GREEN);
		exit.setFillColor(Color.RED);
		scoreboard.setFillColor(Color.ORANGE);
	}
	
	@Override
	public void showContents() {
		program.add(play);
		program.add(exit);
		program.add(title);
		program.add(author);
		program.add(scoreboard);
		program.add(alien);
		program.add(point);
	}
	
	@Override
	public void hideContents() {
		program.remove(play);
		program.remove(exit);
		program.remove(title);
		program.remove(author);
		program.remove(scoreboard);
		program.remove(alien);
		program.remove(point);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			program.switchToGame(); //need to create game screen
		}
		if (obj == exit) {
			program.switchToExit(); //need to create exit screen for this condition
		}
		if (obj == scoreboard) {
			program.switchToScore(); //need to finish scoreboard screen
		}
	}
}
