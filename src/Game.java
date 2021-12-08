/**
 * The potential main controller for the game "Uno". Employs a JFrame to control the UI
 * of the game and is the primary class for the other classes to interact.
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Game {
	
	private Deck deck;
	private Player[] players;
	private Discard discard;
	
	
	
	public Game(int playerCount) {
		players = new Player[playerCount];
	}
	
	public static void main(String[] args) {
		
	}
}
