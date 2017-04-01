import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerPanel extends JPanel
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	
	public final static String CREATE = "CREATE";
	public final static String JOIN = "JOIN";
	
	private String type;
	
	private JLabel lblIP,
				   lblPort;
	
	private JTextField txtIP,
					   txtPort;
	
	private JButton backButton;
	private JButton confirmButton;
	
	private ImageIcon background,
					  confirm,
					  back;
	
	private Controller controller;
	
	public ServerPanel(Controller controller)
	{
		//initialization
		super();
		this.controller = controller;
		setLayout(null);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		//elements
		background = new ImageIcon(getClass().getResource("background.png"));
		confirm = new ImageIcon(getClass().getResource("next.png"));
		back = new ImageIcon(getClass().getResource("back.png"));
		
		lblIP = new JLabel("IP Address:");
		lblIP.setBounds(350, 90, 250, 25);
		lblIP.setForeground(Color.white);
		lblIP.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		//lblIP.setHorizontalAlignment(SwingConstants.RIGHT);
		//lblIP.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		lblPort = new JLabel("Port:");
		lblPort.setBounds(350, 170, 250, 25);
		lblPort.setForeground(Color.white);
		lblPort.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		//lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
		//lblPort.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		txtIP = new JTextField();
		txtIP.setBounds(350, 125, 250, 25);
		
		txtPort = new JPasswordField();
		txtPort.setBounds(350, 205, 250, 25);
		
		backButton = new JButton();
		backButton.setBounds(325, 285, 145, 40);
		backButton.setIcon(back);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFont(new Font("Eras Demi ITC", Font.PLAIN, 14));
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.showMenuScreen();
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
				controller.showMenuScreen();
			}
		});
		
		//add
		add(lblIP);
		add(txtIP);
		add(lblPort);
		add(txtPort);
		add(backButton);
		add(confirmButton);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, WIDTH, HEIGHT, null);
		g.setColor(new Color(25, 50, 80));
		g.fillRect(325, 80, 300, 180);
	}
	
	public void setType(String type) {
		this.type = type;
	}
}