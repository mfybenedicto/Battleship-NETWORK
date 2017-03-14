public class Player
{
	private Ships[] ships;
	private int whitePegs;
	private int redPegs;
	private Account acc;
	
	public Player(Account acc, int w, int r)
	{
		this.acc = acc;
		
		ships = new Ships[5];
		for(int i = 0; i < 5; i++){
			ships[i] = new Ships(i + 2);
		}
		
		whitePegs = w;
		redPegs = r;
	}
	
	public Account getAccount()
	{
		return acc;
	}
	
	public void commandAttack()
	{
		//fires a position
	}
	
	public void commandTransport()
	{
		//moves to a position
	}
}