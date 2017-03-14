import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	
	private final static String HOME = "HomePanel",
								LOGIN = "LoginPanel",
								REGISTER = "RegisterPanel",
								MENU = "MenuPanel",
								SERVER = "ServerPanel";
	
	private JPanel cards;
	private HomePanel panelHome;
	private RegisterPanel panelRegister;
	private LoginPanel panelLogin;
	private MenuPanel panelMenu;
	private ServerPanel panelServer;
	
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
		panelMenu = new MenuPanel(controller);
		panelServer = new ServerPanel(controller);
		
		cards.add(panelHome, HOME);
		cards.add(panelRegister, REGISTER);
		cards.add(panelLogin, LOGIN);
		cards.add(panelMenu, MENU);
		cards.add(panelServer, SERVER);
		((CardLayout)cards.getLayout()).show(cards, MENU);
		
		
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
	
	public void showMenuPanel() {
		((CardLayout)cards.getLayout()).show(cards, MENU);
	}
	
	public void showServerPanel(String type) {
		panelServer.setType(type);
		((CardLayout)cards.getLayout()).show(cards, SERVER);
	}
}