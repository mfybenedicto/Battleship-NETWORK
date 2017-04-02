import java.awt.*;
import java.awt.event.*;
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
	
	private JToggleButton[] btns;
	
	private JButton btnOrientation;
	
	private ButtonGroup btnsgrp;
	
	private ImageIcon smallpic,
					  medpic,
					  largepic,
					  vpic,
					  hpic;
	
	private String orientation;
	
	public ShipPlacePanel() {
		super();
		setLayout(null);
		setSize(WIDTH, HEIGHT);
		
		background = new ImageIcon(getClass().getResource("sidepanel.png"));
		
		btns = new JToggleButton[6];
		btns[0] = small1;
		btns[1] = small2;
		btns[2] = small3;
		btns[3] = medium1;
		btns[4] = medium2;
		btns[5] = large1;
		
		smallpic = new ImageIcon(getClass().getResource("smallside.png"));
		medpic = new ImageIcon(getClass().getResource("mediumside.png"));
		largepic = new ImageIcon(getClass().getResource("large.png"));
		vpic = new ImageIcon(getClass().getResource("orientVert.png"));
		hpic = new ImageIcon(getClass().getResource("orientHoriz.png"));
		
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
		
		for (int i = 0 ; i < 3 ; i++) {
			btns[i].setSize(100, 50);
			btns[i].setIcon(smallpic);
		}
			
		
		for (int i = 3 ; i < 5 ; i++) {
			btns[i].setSize(150, 50);
			btns[i].setIcon(medpic);
		}
		
		btns[5].setSize(100, 200);
		btns[5].setIcon(largepic);
			
		int y = 30;
		
		for (int i = 0 ; i < btns.length ; i++) {
			btns[i].setContentAreaFilled(false);
			btns[i].setOpaque(false);
			btns[i].setBorderPainted(false);
			btns[i].setLocation(30, y);
			add(btns[i]);
			y += 60;
		}
		
		btnsgrp = new ButtonGroup();
		for (int i = 0 ; i < btns.length ; i++)
			btnsgrp.add(btns[i]);
		
		btnOrientation = new JButton();
		btnOrientation.setBounds(130,  510,  50,  50);
		btnOrientation.setIcon(vpic);
		orientation = "vertical";
		btnOrientation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (orientation.equals("vertical")) {
					orientation = "horizontal";
					btnOrientation.setIcon(hpic);
				} else {
					orientation = "vertical";
					btnOrientation.setIcon(vpic);
				}
			}
		});
		add(btnOrientation);
	}
	
	public String getSelectedType() {
		int i;
		for (i = 0 ; i < btns.length ; i++)
			if (btns[i] != null && btns[i].isSelected())
				break;
		
		switch (i) {
		case 0 :
		case 1 :
		case 2 : return "small";
		case 3 : 
		case 4 : return "medium";
		case 5 : return "large";
		default: return "none";
		}
	}
	
	public String getSelectedOrientation() {
		return orientation;
	}
	
	public void removeSelected() {
		for (int i = 0 ; i < btns.length ; i++) {
			if (btns[i] != null && btns[i].isSelected()) {
				btns[i].setSelected(false);
				btnsgrp.remove(btns[i]);
				remove(btns[i]);
				btns[i] = null;
			}
		}
		
		repaint();
	}
	
	public int shipsLeft() {
		int count = 0;
		for (int i = 0 ; i < btns.length ; i++)
			if (btns[i] != null)
				count++;
		return count;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
