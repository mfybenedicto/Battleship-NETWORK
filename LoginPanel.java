import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private JLabel nameLabel;
	private JLabel pwordLabel;
	
	private JTextField userName;
	private JPasswordField pwordField;
	
	private JButton backButton;
	private JButton confirmButton;
	
	private ImageIcon background;
	
	private Controller controller;
	
	public LoginPanel(Controller controller)
	{
		//initialization
		super();
		this.controller = controller;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("/images/background.png"));
		
		nameLabel = new JLabel("Username:");
		nameLabel.setBounds(350, 90, 70, 25);
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		pwordLabel = new JLabel("Password:");
		pwordLabel.setBounds(350, 125, 70, 25);
		pwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//pwordLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		userName = new JTextField();
		userName.setBounds(430, 90, 170, 25);
		
		pwordField = new JPasswordField();
		pwordField.setBounds(430, 125, 170, 25);
		
		backButton = new JButton("Back");
		backButton.setBounds(350, 230, 120, 40);
		backButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showHomeScreen();
			}
		});
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(480, 230, 120, 40);
		confirmButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showHomeScreen();
			}
		});
		
		//add
		add(nameLabel);
		add(userName);
		add(pwordLabel);
		add(pwordField);
		add(backButton);
		add(confirmButton);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
	}
}