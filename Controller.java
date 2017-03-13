public class Controller {
	
	private GameFrame frame;
	
	public Controller() {
		frame = new GameFrame(this);
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
}