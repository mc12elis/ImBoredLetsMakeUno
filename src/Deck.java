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
		
		deck.add(new Card("red0.png", Integer.valueOf(0), "red"));
		deck.add(new Card("green0.png", Integer.valueOf(0), "green"));
		deck.add(new Card("blue0.png", Integer.valueOf(0), "blue"));
		deck.add(new Card("yellow0.png", Integer.valueOf(0), "yellow"));
		
		for (int i = 1; i < 10; i++) {
			Integer value = Integer.valueOf(i);
			for (int k = 0; k < 2; k++) {
				Card redCard = new Card("red"+value+".png", value, "red");
				Card greenCard = new Card("green"+value+".png", value, "green");
				Card blueCard = new Card("blue"+value+".png", value, "blue");
				Card yellowCard = new Card("yellow"+value+".png", value, "yellow");
				deck.add(redCard);
				deck.add(greenCard);
				deck.add(blueCard);
				deck.add(yellowCard);
			}
		}
		
		String[] colors = {"red", "green", "blue", "yellow"};
		for (int i = 0; i < 4; i++) {
			deck.add(new Card(colors[i]+"skip.png", "skip", colors[i]));
			deck.add(new Card(colors[i]+"reverse.png", "reverse", colors[i]));
			deck.add(new Card(colors[i]+"draw2.png", "draw2", colors[i]));
		}
		
		for (int i = 0; i < 4; i++) {
			deck.add(new Card("specialwild.png", "wild", "special"));
			deck.add(new Card("specialwild4.png", "wild4", "special"));
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
	
	protected void reshuffle() {
		deck = discard;
		discard = new ArrayList<Card>();
		discard.add(deck.remove(deck.size()-1));
	}
	
	public Card getPlayed() {
		if (discard.isEmpty()) {
			return null;
		} else {
			return discard.get(discard.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck(new ArrayList<Card>());
		for (int i = 0; i < 10; i++) {
			Card thisCard = deck.draw();
			System.out.println(thisCard.getValue() + "     " + thisCard.getColor());
		}
	}
	
}
