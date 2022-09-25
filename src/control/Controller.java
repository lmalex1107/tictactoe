package control;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.GameModel;
import view.Field;
import view.GUI;

public class Controller implements MouseListener, ActionListener, ItemListener{
	int player = 1;
	GUI gui;
	GameModel gamemodel;
	Field field;
	Button newGame;
	String level = "einfach";
	Button exit;
	Choice choice;
	//String level;
	
	public Controller() {
		
		
		gamemodel = new GameModel();
		gamemodel.setSettingZero();
		
		gui = new GUI();
		gui.setLayout(new BorderLayout());
		
		newGame = new Button("Neues Spiel");
		newGame.addActionListener(this);
		//level = new Button("Schwierigkeitsgrad");
		//level.addActionListener(this);
		exit = new Button("Beenden");
		exit.addActionListener(this);
		
		JPanel menu = new JPanel();
		menu.add(newGame);
		//menu.add(level);
		menu.add(exit);
		menu.setBackground(Color.LIGHT_GRAY);
		
		field = new Field();
		field.addMouseListener(this);
		
		
		
		gui.add(menu, BorderLayout.NORTH);
		gui.add(field, BorderLayout.CENTER);
	}
	
	private void changePlayer() {
		if (player == 1) {
			player = 2;
		}
		else {
			player = 1;
		}
	}
	
	public void changeLevel (String choice) {
		this.level = choice;
		System.out.println("Sie haben den Schwierigkeitsgrad " + this.level + " gewählt.");
	}
	
	public void makeChoice(int x, int y) {
		int xfactor = 0;
		int ysum = 0;
		int region = 0;
		if ((x >= 100) && (x <= 300)){				//Spalte bestimmen
			ysum = 1;
		}
		if ((x >= 300) && (x <= 600)) {
			ysum = 2;
		}
		if ((x >= 600) && (x < 900)) {
			ysum = 3;
		}
		
		if ((y >= 100) && (y <= 250)) {
			xfactor = 0;
		}
		
		if ((y >= 250) && (y <= 500)) {
			xfactor = 1;
		}
		
		if ((y >= 500) && (y <= 750)) {
			xfactor = 2;
		}
		region = 3 * xfactor + ysum;
		System.out.println(region);
		if (gamemodel.makeSign(region, player) == false) {
			field.setPosition(gamemodel.getSetting());
		changePlayer();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		int pos_x = me.getX();
		int pos_y = me.getY();
		makeChoice(pos_x, pos_y);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == newGame ) {
			System.out.println("Neues Spiel");
			gamemodel.setSettingZero();
			field.setPosition(gamemodel.getSetting());
			choice = new Choice(this);
		}
		
		
		
		if (ae.getSource() == exit) {
			System.exit(0);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
