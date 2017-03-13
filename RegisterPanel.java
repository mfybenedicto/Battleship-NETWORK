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
	
	//attribute for the image(if optional)
	
	public RegisterPanel(Controller controller)
	{
		super();
		this.controller = controller;
		//initialization
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));

		//elements
		background = new ImageIcon(getClass().getResource("/images/background.png"));
		
		nameLabel = new JLabel("Enter your new Username:");
		nameLabel.setBounds(300, 90, 170, 25);
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		createPLabel = new JLabel("Enter your new password:");
		createPLabel.setBounds(300, 125, 170, 25);
		createPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//createPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		confirmPLabel = new JLabel("Confirm your new password:");
		confirmPLabel.setBounds(300, 160, 170, 25);
		confirmPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//confirmPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		userName = new JTextField();
		userName.setBounds(480, 90, 170, 25);
		
		createPassword = new JPasswordField();
		createPassword.setBounds(480, 125, 170, 25);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(480, 160, 170, 25);
		
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