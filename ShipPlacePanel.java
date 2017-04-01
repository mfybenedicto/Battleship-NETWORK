import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ShipPlacePanel extends JPanel {

	private final int WIDTH = 200;
	private final int HEIGHT = 600;
	
	private ImageIcon background;
	
	private JToggleButton small1,
						  small2,
						  small3,
						  medium1,
						  medium2,
						  large1;
	
	public ShipPlacePanel() {
		super();
		setLayout(null);
		setSize(WIDTH, HEIGHT);
		
		background = new ImageIcon(getClass().getResource("sidepanel.png"));
		
		JToggleButton[] btns = new JToggleButton[6];
		btns[0] = small1;
		btns[1] = small2;
		btns[2] = small3;
		btns[3] = medium1;
		btns[4] = medium2;
		btns[5] = large1;
		
		for (int i = 0 ; i < btns.length ; i++) {
			btns[i] = new JToggleButton(){
				/*public void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2d = (Graphics2D)g;
					
					AffineTransform orig = g2d.getTransform();
					
					g2d.rotate(Math.toRadians(90));
					
					g2d.drawIm
				}
			*/};
		}
		
		for (int i = 0 ; i < 3 ; i++)
			btns[i].setSize(100, 50);
		
		for (int i = 3 ; i < 5 ; i++)
			btns[i].setSize(150, 50);
		
		btns[5].setSize(100, 200);
			
		int y = 30;
		
		for (int i = 0 ; i < btns.length ; i++) {
			//btns[i].setContentAreaFilled(false);
			//btns[i].setOpaque(false);
			btns[i].setLocation(30, y);
			add(btns[i]);
			y += 60;
		}
		
		ButtonGroup btnsgrp = new ButtonGroup();
		for (int i = 0 ; i < btns.length ; i++)
			btnsgrp.add(btns[i]);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
