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
	
	private ImageIcon background,
					  confirm,
					  back;
	
	private Controller controller;
	private DBConnect db;
	
	public RegisterPanel(Controller controller, DBConnect db)
	{
		super();
		this.controller = controller;
		this.db = db;
		//initialization
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));

		//elements
		background = new ImageIcon(getClass().getResource("background.png"));
		confirm = new ImageIcon(getClass().getResource("next.png"));
		back = new ImageIcon(getClass().getResource("back.png"));
		
		nameLabel = new JLabel("Enter your new Username:");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		nameLabel.setBounds(350, 90, 249, 25);
		//nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		createPLabel = new JLabel("Enter your new password:");
		createPLabel.setForeground(Color.white);
		createPLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		createPLabel.setBounds(350, 170, 249, 25);
		//createPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//createPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		confirmPLabel = new JLabel("Confirm your new password:");
		confirmPLabel.setForeground(Color.white);
		confirmPLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmPLabel.setBounds(350, 250, 249, 25);
		//confirmPLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//confirmPLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		userName = new JTextField();
		userName.setBounds(350, 125, 250, 25);
		
		createPassword = new JPasswordField();
		createPassword.setBounds(350, 205, 250, 25);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(350, 285, 250, 25);
		
		backButton = new JButton();
		backButton.setBounds(325, 365, 145, 40);
		backButton.setIcon(back);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				clearFields();
				controller.showHomeScreen();
			}
		});
		
		confirmButton = new JButton();
		confirmButton.setBounds(480, 365, 145, 40);
		confirmButton.setIcon(confirm);
		confirmButton.setOpaque(false);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setBorderPainted(false);
		confirmButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (db.isUsernameAvailable(userName.getText())) {
					int nameLength = userName.getText().length();
					int passLength = createPassword.getText().length();
					
					if (!(nameLength >= 4 && nameLength <= 45))
						JOptionPane.showMessageDialog(null, "Username must be 4 to 45 characters long only.");
					if (!(passLength >= 4 && passLength <=  45))
						JOptionPane.showMessageDialog(null, "Password must be 4 to 45 characters long only.");
					if (!(createPassword.getText().equals(confirmPassword.getText())))
						JOptionPane.showMessageDialog(null, "The input passwords do not match!");
					
					if (nameLength >= 4 && nameLength <= 45 && passLength >=4 && passLength <= 45 &&
						createPassword.getText().equals(confirmPassword.getText())) {
						db.addUser(userName.getText(), createPassword.getText());
						controller.showHomeScreen();
					}
				} else
					JOptionPane.showMessageDialog(null, "Username is already taken!");
					
				clearFields();
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
	
	public void clearFields() {
		userName.setText("");
		createPassword.setText("");
		confirmPassword.setText("");
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.setColor(new Color(25, 50, 80));
		g.fillRect(325, 80, 300, 260);
	}
}