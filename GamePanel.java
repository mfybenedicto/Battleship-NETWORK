import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GamePanel extends JPanel {

	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private static final String PLACE = "ShipPlacementPhase",
								ATTACK = "AttackPhase";
	
	private Controller controller;
	
	private String phase;
	
	private BoardPanel board;
	private ShipPlacePanel pShipPlace;
	private AttackPanel pAttack;
	
	private GridButton[][] cell;
	
	private ImageIcon background;
	
	public GamePanel(Controller controller) {
		super();
		setLayout(null);
		this.controller = controller;
		
		background = new ImageIcon(getClass().getResource("background.png"));
		
		pShipPlace = new ShipPlacePanel();
		pShipPlace.setBounds(800, 0, 200, 600);
		add(pShipPlace);
		
		phase = PLACE;
		
		/*pAttack = new AttackPanel();
		pAttack.setBounds(800, 0, 200, 600);
		add(pAttack);*/
		
		cell = new GridButton[10][10];
		
		int x = 250;
		int y = 30;
		for (int r = 0 ; r < cell.length ; r++) {
			x = 250;
			for (int c = 0 ; c < cell[0].length ; c++) {
				cell[r][c] = new GridButton(r, c);
				cell[r][c].setBounds(x, y, 50, 50);
				cell[r][c].setOpaque(false);
				cell[r][c].setContentAreaFilled(false);
				cell[r][c].addActionListener(new BtnListener());
				cell[r][c].addMouseListener(new HoverListener());
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
	
	private class BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (phase.equals(PLACE)) {
				GridButton btn = (GridButton)e.getSource();
				int r = btn.getRow();
				int c = btn.getCol();
				String type = pShipPlace.getSelectedType();
				String orientation = pShipPlace.getSelectedOrientation();
				if (!type.equals("none") && Ship.isValidPlacement(c, r, 10, 10, type, orientation) &&
					!Ship.isOverlapping(Ship.getSlotsToOccupy(c, r, type, orientation), board.getShips())) {
					board.addShip(new Ship(c, r, type, orientation));
					pShipPlace.removeSelected();
				}
			}
		}
	}
	
	private class HoverListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {
			if (phase.equals(PLACE)) {
				GridButton btn = (GridButton)e.getSource();
				int r = btn.getRow();
				int c = btn.getCol();
				String type = pShipPlace.getSelectedType();
				String orientation = pShipPlace.getSelectedOrientation();
				if (!type.equals("none"))
					board.setViewShip(new Ship(c, r, type, orientation));
			}
		}

		public void mouseExited(MouseEvent e) {
			if (phase.equals(PLACE)) {
				board.setViewShip(null);
			}
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
		
	}
}
