import java.util.ArrayList;

public class Discard {

	private ArrayList<Card> discard;
	private Card inPlay;
	
	
	public Discard() {
		discard = new ArrayList<Card>();
		inPlay = discard.get(discard.size()-1);
	}
}
