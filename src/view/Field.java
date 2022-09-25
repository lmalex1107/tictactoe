package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Field extends JPanel{
	
	int[][] Setting;
	
	public Field() {
		this.setBackground(Color.ORANGE);
	}
	
	public void setPosition(int Setting[][]) {
		this.Setting = Setting;
		repaint();
	}
	
	private boolean clear() {
		boolean allarezero = true;
		if (this.Setting != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (this.Setting[i][j] != 0 ) {
						allarezero = false;
					}
				}
			}
		}
		return allarezero;
	}
	
	@override
	public void paintComponent(Graphics g) {
		
		
		//g.setColor(Color.WHITE);
		if (clear () == true) {
			System.out.println("Test A");
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		
		g.setColor(Color.BLACK);
		g.fillRect(300, 100, 10, 600);		//senkrechter Strich
		g.fillRect(600, 100, 10, 600);		//senkrechter Strich
		g.fillRect(100, 250, 700, 10);		//waagerechter Strich
		g.fillRect(100, 500, 700, 10);		//waagerechter Strich
		
		
		if (Setting != null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int pos_x = 0;
					int pos_y = 0;
					switch (i*3 + j + 1) {
					case 1:
						pos_x = 200;
						pos_y = 175;
					break;
					case 2:
						pos_x = 450;
						pos_y = 175;
					break;
					case 3:
						pos_x = 750;
						pos_y = 175;
					break;
					case 4:
						pos_x = 200;
						pos_y = 375;
					break;
					case 5:
						pos_x = 450;
						pos_y = 375;
					break;
					case 6:
						pos_x = 750;
						pos_y = 375;
					break;
					case 7:
						pos_x = 200;
						pos_y = 650;
					break;
					case 8:
						pos_x = 450;
						pos_y = 650;
					break;
					case 9:
						pos_x = 750;
						pos_y = 650;
					break;
					}
					
					if (Setting[i][j] == 1) {
						g.drawLine(pos_x - 100, pos_y - 100, pos_x + 100, pos_y + 100);
						g.drawLine(pos_x - 100, pos_y + 100, pos_x + 100, pos_y - 100);
					}
					if (Setting[i][j] == 2) {
						g.drawOval(pos_x - 100, pos_y - 100, 200, 200);
					}
				}
			}
		}
		
	}
	
	
}
