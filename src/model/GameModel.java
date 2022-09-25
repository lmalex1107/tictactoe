package model;

public class GameModel {
	
	//player 0 = no entry;
	//player 1 = cross
	//player 2 = circle
	
	int[][] Setting;
	
	public GameModel () {
		Setting = new int[3][3];
	}
	
	public boolean provewinning(int user) {
		boolean haswon = false;
		for (int i = 0; i < 3; i++) {																				
			if ((Setting[0][i] == Setting[1][i]) && (Setting[1][i] == Setting[2][i]) &&(Setting[0][i] != 0))  {		//Spalten auf Gewinnsituation untersuchen
				haswon = true;
			}
			if ((Setting[i][0] == Setting[i][1]) && (Setting[i][1] == Setting[i][2]) &&(Setting[i][0] != 0)) {		//Zeilen auf Gewinnsituation untersuchen
				haswon = true;
			}
		}
		
		if ((Setting[0][0] == Setting[1][1]) && (Setting[1][1] == Setting[2][2]) && (Setting[0][0] != 0)) {			//Diagobnale links oben nach rechts unten auf Gewinnsituation untersuchen
			haswon = true;
		}
		
		if ((Setting[0][2] == Setting[1][1]) && (Setting[1][1] == Setting[2][0]) && (Setting[0][2] != 0)) {			//Diagobnale rechts oben nach links unten auf Gewinnsituation untersuchen
			haswon = true;
		}
		
		if (haswon == true) {
			System.out.println("Spieler Nr. " + user + " hat  gewonnen!");	
		}
		return haswon;
	}
	
	public int[][] getSetting() {
		return this.Setting;
	}
	
	public void setSettingZero() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Setting[i][j] = 0;
			}
		}
	}
	
	public boolean makeSign(int position, int player) {
		boolean alreadymarked = true;
		switch (position) {
		case 1: 
			if (Setting[0][0] == 0) {
				Setting[0][0] = player;
				alreadymarked = false;
			}
			break;
		case 2: 
			if (Setting[0][1] == 0) {
				Setting[0][1] = player;
				alreadymarked = false;
			}
			break;
		case 3: 
			if (Setting[0][2] == 0) {
				Setting[0][2] = player;
				alreadymarked = false;
			}
			break;
		case 4: 
			if (Setting[1][0] == 0) {
				Setting[1][0] = player;
				alreadymarked = false;
			}
			break;
		case 5: 
			if (Setting[1][1] == 0) {
				Setting[1][1] = player;
				alreadymarked = false;
			}
			break;
		case 6: 
			if (Setting[1][2] == 0) {
				Setting[1][2] = player;
				alreadymarked = false;
			}
			break;
		case 7: 
			if (Setting[2][0] == 0) {
				Setting[2][0] = player;
				alreadymarked = false;
			}
			break;
		case 8: 
			if (Setting[2][1] == 0) {
				Setting[2][1] = player;
				alreadymarked = false;
			}
			break;
		case 9: 
			if (Setting[2][2] == 0) {
				Setting[2][2] = player;
				alreadymarked = false;
			}
			break;
		}
		provewinning(player);
		//if (player == 0) {
			return alreadymarked;
		//}
		//else {
			//return 0;
		//}
	}
}
