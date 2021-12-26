import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * The JPanel that contains the bulk of the systems UI and graphics
 * 
 * @author Mark Eliseo
 * @version 0.0.1
 */
public class UnoPanel extends JPanel implements MouseListener {

	private Game game;
	private Player[] players;
	private int playerCount;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Image background;
	private Image cardBack;
	private boolean gameStart = false;
	private int turn = 0;
	private boolean reversed = false;
	
	public UnoPanel() {
		
		setPreferredSize(new Dimension(910, 700));
		addMouseListener(this);
		setLayout(new GridBagLayout());
		
		try {
			Path path = Paths.get("lib");
			this.background = toolkit.getImage(path.toAbsolutePath().toString() + "\\table.jpg");
			this.cardBack = toolkit.getImage(path.toAbsolutePath().toString() + "\\cardback.png");
			this.background = background.getScaledInstance(910, 700, Image.SCALE_DEFAULT);
			this.cardBack = cardBack.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
		} catch (Exception e) {
			System.err.println(e);
			System.exit(0);
		}
	}
	
	private void initGame() {
		Integer[] totalPlayers = {2, 3, 4};
		int playerCap = JOptionPane.showOptionDialog(null, "Select the Amount of Players", "Players",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, totalPlayers, totalPlayers[0]);
		this.game = new Game(totalPlayers[playerCap]);
		this.playerCount = playerCap;
		this.players = game.getPlayers();
		System.out.println(totalPlayers[playerCap]);
		for (int i = 1; i <= totalPlayers[playerCap]; i++) {
			String name = JOptionPane.showInputDialog(null, 
                    "Enter the name of Player " + i,
                    "Input a name", JOptionPane.QUESTION_MESSAGE);
			System.out.println(name);
			players[i-1].setName(name);
		}
		
		this.repaint();
		startGame();
		
	}
	
	public void startGame() {
		//deal cards
	}
	
	public void nextTurn() {
		// potentially use this method to check for win status.
		if (reversed) {
			
		}
		turn++;
		turn = turn % playerCount;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(background, 0, 0, this);
		
		if (!gameStart) {
			Path path = Paths.get("lib/startButton3.png");
			Image startButton = toolkit.getImage(path.toAbsolutePath().toString());
			g2.drawImage(startButton, 
					(int)(this.getPreferredSize().getWidth() / 2) - (startButton.getWidth(this) / 2),
					(int)(this.getPreferredSize().getHeight() / 2) - (startButton.getHeight(this) / 2),
					this);
			System.out.println((int)(this.getPreferredSize().getWidth() / 2) + (startButton.getWidth(this) / 2));
			System.out.println((int)(this.getPreferredSize().getHeight() / 2) + (startButton.getHeight(this) / 2));
		} else {
			g2.drawImage(cardBack, 325, 225, this);
			Player currentPlayer = players[turn];
			//(dimension width / 2) - ((cardWidth * cardsInHand) / 2) for starting position.
			int panelWidth = this.getWidth();
			int panelHeight = this.getHeight(); 
			int handStartingPos = (panelWidth / 2) - ((100 * currentPlayer.getHand().size()) / 2);
			ArrayList<Card> curHand = currentPlayer.getHand();
			for (int i = 0; i < curHand.size(); i++) {
				Card curCard = curHand.get(i);
				//ADD FUNCTIONALITY FOR DETERMINING IF IT CAN BE PLAYED OR NOT
				g2.drawImage(curCard.getImage(), handStartingPos + i*100, 600, this);
				
			}
			if (playerCount == 2) {
				
			} else if (playerCount == 3) {
				
			} else {
				
			}
		}
	}
	
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {
		int y = e.getY();
		int x = e.getX();
		
		if (!gameStart) {
			//215, 103
			//807, 485
			if ((x <= 807 && x >= 215) && (y <= 485 && y >= 103)) {
				initGame();
				gameStart = true;
			}	
		} else {
			
		}
		
	}
	
	private static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		JFrame frame = new JFrame("Uno Tabletop Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UnoPanel label = new UnoPanel();
		frame.add(label);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		createAndShowGUI();
	}
	
}
