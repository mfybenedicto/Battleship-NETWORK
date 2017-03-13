import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPanel extends JPanel
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private JLabel nameLabel;
	private JLabel createPLabel;
	private JLabel confirmPLabel;
	
	private JTextField userName;
	private JPasswordField createPassword;
	private JPasswordField confirmPassword;
	
	private JButton backButton;
	private JButton confirmButton;
	
	private ImageIcon background;
	
	private Controller controller;
	
	public RegisterPanel(Controller controller)
	{
		super();
		this.controller = controller;
		//initialization
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));

		//elements
		background = new ImageIcon(getClass().getResource("images/background.png"));
		
		nameLabel = new JLabel("Enter your new Username:");
		nameLabel.setForeground(new Color(0, 0, 0));
		nameLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		nameLabel.setBounds(350, 90, 249, 25);
		//nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		createPLabel = new JLabel("Enter your new password:");
		createPLabel.setForeground(new Color(0, 0, 0));
		createPLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		createPLabel.setBounds(350, 170, 249, 25);
		//createPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//createPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		confirmPLabel = new JLabel("Confirm your new password:");
		confirmPLabel.setForeground(new Color(0, 0, 0));
		confirmPLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmPLabel.setBounds(350, 265, 249, 25);
		//confirmPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//confirmPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		userName = new JTextField();
		userName.setBounds(350, 125, 250, 25);
		
		createPassword = new JPasswordField();
		createPassword.setBounds(350, 205, 250, 25);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(350, 300, 250, 25);
		
		backButton = new JButton("Back");
		backButton.setBounds(350, 380, 120, 40);
		backButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showHomeScreen();
			}
		});
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(480, 380, 120, 40);
		confirmButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showHomeScreen();
			}
		});
		
		//adding
		add(nameLabel);
		add(userName);
		add(createPLabel);
		add(createPassword);
		add(confirmPLabel);
		add(confirmPassword);
		add(backButton);
		add(confirmButton);
		
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
	}
}