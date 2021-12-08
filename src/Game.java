import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * The potential main controller for the game "Uno". Employs a JFrame to control the UI
 * of the game and is the primary class for the other classes to interact.
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Game {
	
	private JFrame frame;
	private Deck deck;
	private Player[] players;
	private Discard discard;
	
	public Game(int playerCount) {
		players = new Player[playerCount];
		this.deck = new Deck(new ArrayList<Card>());
		
		for (int i = 0; i < playerCount; i++) {
			for (int k = 0; k < 7; k++) {
				players[i].keep(this.deck.draw());
			}
		}
	}
	
	public void draw(int player) {
		Card drawn = deck.draw();
		
	}
	
	public static void main(String[] args) {
		
	}
}
