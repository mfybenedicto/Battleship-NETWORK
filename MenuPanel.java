import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageFilter;

public class MenuPanel extends JPanel
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	private JPanel menuHeader;
	
	private JLabel lblUsername;
	
	private JButton btnLogout,
					btnPic;
	
	private JButton btnCreateGame,
					btnJoinGame;
	
	private Controller controller;
	private DBConnect db;
	
	private ImageIcon background,
					  title,
					  createGame,
					  joinGame;
					  
	public MenuPanel(Controller controller, DBConnect db)
	{
		//initialization
		super();
		this.controller = controller;
		this.db = db;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("images/background.png"));
		title = new ImageIcon(getClass().getResource("images/title.png"));
		createGame = new ImageIcon(getClass().getResource("images/create.png"));
		joinGame = new ImageIcon(getClass().getResource("images/join.png"));
		
		btnCreateGame = new JButton();
		btnCreateGame.setFont(new Font("Eras Demi ITC", Font.PLAIN, 26));
		btnCreateGame.setIcon(createGame);
		btnCreateGame.setBounds(300, 300, 400, 100);
		btnCreateGame.setOpaque(false);
		btnCreateGame.setContentAreaFilled(false);
		btnCreateGame.setBorderPainted(false);
		btnCreateGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showServerScreen(ServerPanel.CREATE);
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
				controller.showServerScreen(ServerPanel.JOIN);
			}
		});		
		
		menuHeader = new JPanel();
		menuHeader.setLayout(null);
		menuHeader.setBackground(new Color(25, 50, 80));
		menuHeader.setBounds(0, 0, 1000, 80);
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBounds(890, 25, 100, 30);
		btnLogout.setForeground(Color.white);
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showHomeScreen();
				controller.updateLoggedInUser("", null);
			}
		});
		
		btnPic = new JButton();
		btnPic.setIcon(createGame);
		btnPic.setBounds(800, 0, 80, 80);
		btnPic.setOpaque(false);
		btnPic.setContentAreaFilled(false);
		btnPic.setBorderPainted(false);
		btnPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					updateProfilePic((fc.getSelectedFile()).toString());
					db.updateProfilePic(lblUsername.getText(), (fc.getSelectedFile()).toString());
				}
			}
		});
		
		lblUsername = new JLabel();
		lblUsername.setText("TEST_name12345");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsername.setForeground(Color.white);
		lblUsername.setBounds(490, 25, 300, 30);
		
		//adding
		menuHeader.add(btnLogout);
		menuHeader.add(btnPic);
		menuHeader.add(lblUsername);
		add(menuHeader);
		add(btnCreateGame);
		add(btnJoinGame);
	}
	
	public void updateUsername(String username) {
		lblUsername.setText(username);
	}
	
	public void updateProfilePic(String picpath) {
		if (picpath != null && picpath.length() > 0) {
			ImageIcon newicon = new ImageIcon(picpath);
			Image newimg = newicon.getImage();
			newimg = newimg.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
			btnPic.setIcon(new ImageIcon(newimg));
		}
		else btnPic.setIcon(createGame); //will add default later
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.drawImage(title.getImage(), 
		  250, 100, 775, 270, 
		  0, 0, 957, 524,
		  null);
	}
}