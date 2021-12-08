import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class is aptly named to be the class that controls
 * the cards not currently in a player's hand. With this, the deck can
 * be drawn from and also reshuffled from the current discard pile
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Deck {

	private ArrayList<Card> deck;
	private ArrayList<Card> discard;
	
	public Deck(ArrayList<Card> discard) {
		this.discard = discard;
		deck = new ArrayList<Card>();
		
		deck.add(new Card(Integer.valueOf(0), "red"));
		deck.add(new Card(Integer.valueOf(0), "green"));
		deck.add(new Card(Integer.valueOf(0), "blue"));
		deck.add(new Card(Integer.valueOf(0), "yellow"));
		
		for (int i = 1; i < 10; i++) {
			Integer value = Integer.valueOf(1);
			for (int k = 0; k < 2; k++) {
				Card redCard = new Card(value, "red");
				Card greenCard = new Card(value, "green");
				Card blueCard = new Card(value, "blue");
				Card yellowCard = new Card(value, "yellow");
				deck.add(redCard);
				deck.add(greenCard);
				deck.add(blueCard);
				deck.add(yellowCard);
			}
		}
		
		String[] colors = {"red", "green", "blue", "yellow"};
		for (int i = 0; i < 4; i++) {
			deck.add(new Card("skip", colors[i]));
			deck.add(new Card("reverse", colors[i]));
			deck.add(new Card("draw2", colors[i]));
		}
		
		for (int i = 0; i < 4; i++) {
			deck.add(new Card("wild", "special"));
			deck.add(new Card("wild4", "special"));
		}
	}
	
	
	public Card draw() {
		if (deck.isEmpty()) {
			this.reshuffle();
			return draw();
		} else {
			Random r = new Random();
			return deck.remove(r.nextInt(deck.size()));
		}
	}
	
	private void reshuffle() {
		deck = discard;
		discard = new ArrayList<Card>();
		discard.add(deck.remove(deck.size()-1));
	}
	
}
