import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * The Card object simply holds a card's value and color
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class Card {
	
	private Image image;
	private Image scaledImage;
	private Object value;
	private String color;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public Card(String fileName, Object value, String color) {
		this.value = value;
		this.color = color;
		
		Path path = Paths.get("lib/cards/"+color+value+".png");    
		this.image = toolkit.getImage(path.toAbsolutePath().toString());
		this.scaledImage = image.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
	}
	
	public Object getValue() {
		return value;
	}
	
	public String getColor() {
		return color;
	}
	
	public Image getImage() {
		return image;
	}
	
	public Image getScaledImage() {
		return scaledImage;
	}
}