import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePanel extends JPanel {
	
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private JButton btnLogin;
	private JButton btnRegister;
	
	private Controller controller;
	
	private ImageIcon background,
					  title,
					  login,
					  register;
	
	public HomePanel(Controller controller) {
		//initialization
		super();
		this.controller = controller;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("/images/background.png"));
		title = new ImageIcon(getClass().getResource("/images/title.png"));
		login = new ImageIcon(getClass().getResource("/images/login.png"));
		register = new ImageIcon(getClass().getResource("/images/register.png"));
		
		btnLogin = new JButton();
		btnLogin.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnLogin.setIcon(login);
		btnLogin.setBounds(300, 300, 400, 100);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showLoginScreen();
			}
		});
		
		btnRegister = new JButton();
		btnRegister.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnRegister.setIcon(register);
		btnRegister.setBounds(300, 420, 400, 100);
		btnRegister.setOpaque(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showRegisterScreen();
			}
		});		
		
		//adding
		add(btnLogin);
		add(btnRegister);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.drawImage(title.getImage(), 
		  175, 30, 850, 270, 
		  0, 0, 957, 524,
		  null);
	}
}