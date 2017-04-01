import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
	
	private ImageIcon background,
					  confirm,
					  back;
	
	private Controller controller;
	private DBConnect db;
	
	public LoginPanel(Controller controller, DBConnect db)
	{
		//initialization
		super();
		this.controller = controller;
		this.db = db;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("images/background.png"));
		confirm = new ImageIcon(getClass().getResource("images/next.png"));
		back = new ImageIcon(getClass().getResource("images/back.png"));
		
		nameLabel = new JLabel("Username:");
		nameLabel.setBounds(350, 90, 250, 25);
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		//nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		pwordLabel = new JLabel("Password:");
		pwordLabel.setBounds(350, 170, 250, 25);
		pwordLabel.setForeground(Color.white);
		pwordLabel.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		//pwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		//pwordLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		userName = new JTextField();
		userName.setBounds(350, 125, 250, 25);
		
		pwordField = new JPasswordField();
		pwordField.setBounds(350, 205, 250, 25);
		
		backButton = new JButton();
		backButton.setBounds(325, 285, 145, 40);
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
		confirmButton.setBounds(480, 285, 145, 40);
		confirmButton.setIcon(confirm);
		confirmButton.setOpaque(false);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setBorderPainted(false);
		confirmButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String username = userName.getText();
				String password = pwordField.getText();
				int userID = db.login(username, password);
				if (userID != -1) {
					ArrayList<String> info = db.getUserInfo(userID);
					controller.updateLoggedInUser(info.get(0), info.get(2));
					controller.showMenuScreen();
				} else
					JOptionPane.showMessageDialog(null, "Username and/or password is incorrect.");
				clearFields();
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
	
	public void clearFields() {
		userName.setText("");
		pwordField.setText("");
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.setColor(new Color(25, 50, 80));
		g.fillRect(325, 80, 300, 180);
	}
}