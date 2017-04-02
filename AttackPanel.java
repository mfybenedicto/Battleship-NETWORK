import java.awt.Graphics;

import javax.swing.*;
import java.awt.Font;

public class AttackPanel extends JPanel {

	private final int WIDTH = 200;
	private final int HEIGHT = 600;
	
	private ImageIcon background;
	
	private JButton[] pic;
	private JLabel[] enemy;
	
	public AttackPanel() {
		super();
		setLayout(null);
		setSize(200, 600);
		
		JLabel lblAttack = new JLabel("Attack:");
		lblAttack.setFont(new Font("Stencil Std", Font.PLAIN, 18));
		lblAttack.setBounds(28, 11, 105, 25);
		add(lblAttack);
		
		pic = new JButton[2];
		enemy = new JLabel[2];
		int y  = 50;
		for (int i = 0 ; i < enemy.length ; i++) {
			pic[i] = new JButton();
			//pic[i].setOpaque(false);
			//pic[i].setContentAreaFilled(false);
			pic[i].setBounds(30, y, 80, 80);
			add(pic[i]);
			
			enemy[i] = new JLabel("USERNAME " + (i+1));
			enemy[i].setBounds(30, y+80, 150, 30);
			add(enemy[i]);
			
			y+= 150;
		}
		
		background = new ImageIcon(getClass().getResource("sidepanel.png"));
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
