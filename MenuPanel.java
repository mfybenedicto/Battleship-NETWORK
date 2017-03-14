import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends JPanel
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private JButton btnCreateGame;
	private JButton btnJoinGame;
	
	private Controller controller;
	
	private ImageIcon background,
					  title,
					  createGame,
					  joinGame;
					  
	public MenuPanel(Controller controller)
	{
		//initialization
		super();
		this.controller = controller;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("/images/background.png"));
		title = new ImageIcon(getClass().getResource("/images/title.png"));
		createGame = new ImageIcon(getClass().getResource("/images/login.png"));
		joinGame = new ImageIcon(getClass().getResource("/images/register.png"));
		
		btnCreateGame = new JButton();
		btnCreateGame.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnCreateGame.setIcon(createGame);
		btnCreateGame.setBounds(300, 300, 400, 100);
		btnCreateGame.setOpaque(false);
		btnCreateGame.setContentAreaFilled(false);
		btnCreateGame.setBorderPainted(false);
		btnCreateGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//controller.showLoginScreen();
			}
		});
		
		btnJoinGame = new JButton();
		btnJoinGame.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnJoinGame.setIcon(joinGame);
		btnJoinGame.setBounds(300, 420, 400, 100);
		btnJoinGame.setOpaque(false);
		btnJoinGame.setContentAreaFilled(false);
		btnJoinGame.setBorderPainted(false);
		btnJoinGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//controller.showRegisterScreen();
			}
		});		
		
		//adding
		add(btnCreateGame);
		add(btnJoinGame);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.drawImage(title.getImage(), 
		  175, 30, 850, 270, 
		  0, 0, 957, 524,
		  null);
	}
}