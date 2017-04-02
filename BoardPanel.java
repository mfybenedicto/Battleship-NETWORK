import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
	
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	private ArrayList<Ship> ships;
	
	private Ship viewship;
	
	public BoardPanel() {
		super();
		setLayout(null);
		setOpaque(false);
		setSize(WIDTH, HEIGHT);
		
		ships = new ArrayList<Ship>();
	}
	
	public void addShip(Ship ship) {
		ships.add(ship);
		
		repaint();
	}
	
	public void setViewShip(Ship ship) {
		viewship = ship;
		
		repaint();
	}
	
	public ArrayList<Ship> getShips() {
		return ships;
	}
	
	public void paintComponent(Graphics g) {
		for (int i = 0 ; i < ships.size() ; i++) {
			if (ships.get(i) != null) {
				int r = ships.get(i).getRow();
				int c = ships.get(i).getCol();
				
				g.drawImage(ships.get(i).getImage(), c*50, r*50, null);
			}
		}
		
		if (viewship != null) {
			int r = viewship.getRow();
			int c = viewship.getCol();
			g.drawImage(viewship.getImage(), c*50, r*50, null);
		}
	}
}
