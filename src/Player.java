import java.util.ArrayList;

/**
 * Class for each Player partaking in the game. Keeps tabs on 
 * their hand and card count.
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Player {
	
	private ArrayList<Card> hand;
	private int cardCount;

	public Player(ArrayList<Card> hand, int turn) {
		this.hand = hand;
		this.cardCount = hand.size();
	}
	
	
	public void keep(Card input) {
		hand.add(input);
		cardCount++;
	}
	
	public void play(int card) {
		hand.remove(card);
		cardCount--;
	}
	
	public boolean endTurn() {
		return hand.isEmpty();
	}
	
	
}
