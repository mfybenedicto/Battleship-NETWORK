import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePanel extends JPanel {
	
	private JLabel lblTitle;
	private JButton btnLogin;
	private JButton btnRegister;
	
	private Controller controller;
	
	public HomePanel(Controller controller) {
		//initialization
		super();
		this.controller = controller;
		setLayout(null);
		setSize(new Dimension(1000, 600));
		
		//elements
		lblTitle = new JLabel("BATTLESHIPS!");
		lblTitle.setFont(new Font("Eras Bold ITC", Font.PLAIN, 44));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(300, 89, 400, 200);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnLogin.setBounds(300, 300, 400, 100);
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showLoginScreen();
			}
		});
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnRegister.setBounds(300, 400, 400, 100);
		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showRegisterScreen();
			}
		});		
		
		//adding
		add(btnLogin);
		add(btnRegister);
		add(lblTitle);
	}
}