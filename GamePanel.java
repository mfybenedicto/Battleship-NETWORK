import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.*;

public class GamePanel extends JPanel {

	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private Controller controller;
	
	private BoardPanel board;
	private ShipPlacePanel pShipPlace;
	private AttackPanel pAttack;
	
	private JButton[][] cell;
	
	private ImageIcon background;
	
	public GamePanel(Controller controller) {
		super();
		setLayout(null);
		this.controller = controller;
		
		background = new ImageIcon(getClass().getResource("background.png"));
		
		/*pShipPlace = new ShipPlacePanel();
		pShipPlace.setBounds(800, 0, 200, 600);
		add(pShipPlace);*/
		
		pAttack = new AttackPanel();
		pAttack.setBounds(800, 0, 200, 600);
		add(pAttack);
		
		cell = new JButton[10][10];
		
		int x = 250;
		int y = 30;
		for (int r = 0 ; r < cell.length ; r++) {
			x = 250;
			for (int c = 0 ; c < cell[0].length ; c++) {
				cell[r][c] = new JButton();
				cell[r][c].setBounds(x, y, 50, 50);
				cell[r][c].setOpaque(false);
				cell[r][c].setContentAreaFilled(false);
				//cell[r][c].setBorder(BorderFactory.createLineBorder(Color.CYAN));
				add(cell[r][c]);
				x += 50;
			}
			y += 50;
		}
		
		board = new BoardPanel();
		board.setBounds(250, 30, 500, 500);
		add(board);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
	}
}
