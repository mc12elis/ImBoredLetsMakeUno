import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand;
	private int turn;
	private int cardCount;

	public Player() {
		
	}
	
	
	public void keep(Card input) {
		hand.add(input);
	}
	
	
	public boolean endTurn() {
		return hand.isEmpty();
	}
	
	
}
