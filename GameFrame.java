import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	
	private final static String HOME = "HomePanel",
								LOGIN = "LoginPanel",
								REGISTER = "RegisterPanel";
	
	private JPanel cards;
	private HomePanel panelHome;
	private RegisterPanel panelRegister;
	private LoginPanel panelLogin;
	
	private Controller controller;
	
	public GameFrame(Controller controller) {
		//initialization
		super("Battleships!");
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		setLayout(new CardLayout());
		setResizable(false);
		
		//elements
		cards = new JPanel(new CardLayout());
		panelHome = new HomePanel(controller);
		panelRegister = new RegisterPanel(controller);
		panelLogin = new LoginPanel(controller);
		
		cards.add(panelHome, HOME);
		cards.add(panelRegister, REGISTER);
		cards.add(panelLogin, LOGIN);
		((CardLayout)cards.getLayout()).show(cards, HOME);
		
		
		//adding
		add(cards);
		
		setVisible(true);
	}
	
	public void showHomePanel() {
		((CardLayout)cards.getLayout()).show(cards, HOME);
	}
	
	public void showLoginPanel() {
		((CardLayout)cards.getLayout()).show(cards, LOGIN);
	}
	
	public void showRegisterPanel() {
		((CardLayout)cards.getLayout()).show(cards, REGISTER);
	}
}