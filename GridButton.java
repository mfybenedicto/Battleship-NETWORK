import javax.swing.*;

public class GridButton extends JButton {
	
	private int row,
				col;
	
	public GridButton(int row, int col) {
		super();
		
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
