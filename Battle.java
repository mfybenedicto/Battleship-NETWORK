public class Battle
{
	private Player[] commanders;
	private Player currPlayerTurn;
	
	public Battle(Player[] players)
	{
		commanders = new Player[players.length];
		
		for(int ctr = 0; ctr < players.length; ctr++){
			commanders[ctr] = players[ctr];
		}
		
		currPlayerTurn = commanders[0];
	}
	
	public void nextTurn()
	{
		for(int i = 0; i < commanders.length; i++){
			if(currPlayerTurn.getAccount().getAccName() == commanders[i].getAccount().getAccName()){
				if(i == commanders.length - 1)
					currPlayerTurn = commanders[0];
				else
					currPlayerTurn = commanders[i++];
			}
		}
	}
}