import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Ship {
	
	private int row,
				col,
				width,
				height;
	
	private String type,
				   orientation;
	
	private ImageIcon img;
	
	private ArrayList<GridSlot> occupiedSlots;
	
	public Ship(int x, int y, String type, String rot) {
		col = x;
		row = y;
		this.type = type;
		orientation = rot;
		occupiedSlots = new ArrayList<GridSlot>();
		occupiedSlots.add(new GridSlot(x, y));
		
		if (type.equals("small")) {
			if (orientation.equals("vertical")) {
				img = new ImageIcon(getClass().getResource("small.png"));
				width = 50;
				height = 100;
				occupiedSlots.add(new GridSlot(x, y+1));
			}
			else {
				img = new ImageIcon(getClass().getResource("smallside.png"));
				width = 100;
				height = 50;
				occupiedSlots.add(new GridSlot(x+1, y));
			}
		}
		else if (type.equals("medium")) {
			if (orientation.equals("vertical")) {
				img = new ImageIcon(getClass().getResource("medium.png"));
				width = 50;
				height = 150;
				occupiedSlots.add(new GridSlot(x, y+1));
				occupiedSlots.add(new GridSlot(x, y+2));
			}
			else {
				img = new ImageIcon(getClass().getResource("mediumside.png"));
				width = 150;
				height = 50;
				occupiedSlots.add(new GridSlot(x+1, y));
				occupiedSlots.add(new GridSlot(x+2, y));
			}
		}
		else {
			if (orientation.equals("vertical")) {
				img = new ImageIcon(getClass().getResource("large.png"));
				width = 100;
				height = 200;
				occupiedSlots.add(new GridSlot(x, y+1));
				occupiedSlots.add(new GridSlot(x, y+2));
				occupiedSlots.add(new GridSlot(x, y+3));
				occupiedSlots.add(new GridSlot(x+1, y));
				occupiedSlots.add(new GridSlot(x, y+1));
				occupiedSlots.add(new GridSlot(x, y+2));
				occupiedSlots.add(new GridSlot(x, y+3));
			}
			else {
				img = new ImageIcon(getClass().getResource("largeside.png"));
				width = 200;
				height = 100;
				occupiedSlots.add(new GridSlot(x+1, y));
				occupiedSlots.add(new GridSlot(x+2, y));
				occupiedSlots.add(new GridSlot(x+3, y));
				occupiedSlots.add(new GridSlot(x, y+1));
				occupiedSlots.add(new GridSlot(x+1, y));
				occupiedSlots.add(new GridSlot(x+2, y));
				occupiedSlots.add(new GridSlot(x+3, y));
			}
		}
	}
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public ArrayList<GridSlot> getOccupied() {
		return occupiedSlots;
	}
	
	public Image getImage() {
		return img.getImage();
	}
	
	public static boolean isValidPlacement(int col, int row, int numCol, int numRow, String type, String orientation) {
		switch (type) {
		case "small"  : if (orientation.equals("vertical")) {
							if (row+1 < numRow)
								return true;
							return false;
						} else {
							if (col+1 < numCol)
								return true;
							return false;
						}
		case "medium" : if (orientation.equals("vertical")) {
							if (row+2 < numRow)
								return true;
							return false;
						} else {
							if (col+2 < numCol)
								return true;
							return false;
						}
		case "large"  : if (orientation.equals("vertical")) {
							if (row+3 < numRow && col+1 < numCol)
								return true;
							return false;
						} else {
							if (col+3 < numCol && row+1 < numRow)
								return true;
							return false;
						}
		default: return false;
		}
	}
	
	public static boolean isOverlapping(ArrayList<GridSlot> slots, ArrayList<Ship> others) {
		for (int i = 0 ; i < others.size(); i++) {
			Ship other = others.get(i);
			for (int j = 0 ; j < other.getOccupied().size() ; j++) {
				GridSlot occupied = other.getOccupied().get(j);
				for (int k = 0 ; k < slots.size() ; k++) {
					GridSlot toOccupy = slots.get(k);
					if (toOccupy.getCol() == occupied.getCol() &&
						toOccupy.getRow() == occupied.getRow())
						return true;
				}
			}
		}
		return false;
	}
	
	public static ArrayList<GridSlot> getSlotsToOccupy(int c, int r, String type, String orientation)  {
		ArrayList<GridSlot> slots = new ArrayList<GridSlot>();
		
		switch (type) {
			case "small"  : switch (orientation) {
				case "vertical"   : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c, r+1));
									return slots;
				case "horizontal" : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c+1, r));
									return slots;
				default: return null;
			}
			case "medium" : switch (orientation) {
				case "vertical"   : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c, r+1));
									slots.add(new GridSlot(c, r+2));
									return slots;
				case "horizontal" : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c+1, r));
									slots.add(new GridSlot(c+2, r));
									return slots;
				default: return null;
			}
			case "large"  : switch (orientation) {
				case "vertical"   : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c, r+1));
									slots.add(new GridSlot(c, r+2));
									slots.add(new GridSlot(c, r+3));
									slots.add(new GridSlot(c+1, r));
									slots.add(new GridSlot(c+1, r+1));
									slots.add(new GridSlot(c+1, r+2));
									slots.add(new GridSlot(c+1, r+3));
									return slots;
				case "horizontal" : slots.add(new GridSlot(c, r));
									slots.add(new GridSlot(c+1, r));
									slots.add(new GridSlot(c+2, r));
									slots.add(new GridSlot(c+3, r));
									slots.add(new GridSlot(c, r+1));
									slots.add(new GridSlot(c+1, r+1));
									slots.add(new GridSlot(c+2, r+1));
									slots.add(new GridSlot(c+3, r+1));
									return slots;
				default: return null;
			}
			default : return null;
		}
	}
}
