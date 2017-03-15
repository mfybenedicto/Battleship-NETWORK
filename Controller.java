public class Controller {
	
	private GameFrame frame;
	
	public Controller() {
		frame = new GameFrame(this, new DBConnect());
	}
	
	public void showHomeScreen() {
		frame.showHomePanel();
	}
	
	public void showLoginScreen() {
		frame.showLoginPanel();
	}
	
	public void showRegisterScreen() {
		frame.showRegisterPanel();
	}
	
	public void showMenuScreen() {
		frame.showMenuPanel();
	}
	
	public void showServerScreen(String type) {
		frame.showServerPanel(type);
	}
	
	public void updateLoggedInUser(String username, String picpath) {
		frame.updateLoggedInUser(username, picpath);
	}
}