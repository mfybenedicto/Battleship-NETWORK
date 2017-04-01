import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
	
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	public BoardPanel() {
		super();
		setLayout(null);
		setOpaque(false);
		
		setSize(WIDTH, HEIGHT);
	}
	
	public void paintComponent(Graphics g) {
		//g.setColor(Color.BLUE);
		//g.fillRect(0, 0, WIDTH, HEIGHT);
	}
}
