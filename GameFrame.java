import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
	
	private final static String HOME = "HomePanel",
								LOGIN = "LoginPanel",
								REGISTER = "RegisterPanel";
	
	private JPanel cards;
	private JPanel panelHome,
				   panelLogin,
				   panelRegister;
	
	public GameFrame() {
		//initialization
		super("Battleships!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1000, 600));
		setLocationRelativeTo(null);
		setLayout(new CardLayout());
		setResizable(false);
		
		//elements
		cards = new JPanel(new CardLayout());
		panelHome = new HomePanel();
		
		cards.add(panelHome, HOME);
		
		//adding
		add(cards);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}