/**
 * The Card object simply holds a card's value and color
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Card {
	
	private Object value;
	private String color;
	
	public Card(Object value, String color) {
		this.value = value;
		this.color = color;
	}
	
	public Object getValue() {
		return value;
	}
	
	public String getColor() {
		return color;
	}
	
	
	
}
