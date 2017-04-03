import java.io.*; 
import java.net.*; 
class UDPClient 
{    
	PlayerShips ships = new PlayerShips(); 
	public static void main(String args[]) throws Exception    
	{       
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
		DatagramSocket clientSocket = new DatagramSocket();       
		InetAddress IPAddress = InetAddress.getByName("10.100.215.228");    //<- this is my PC IP Address    
		byte[] sendData = new byte[1024];       
		byte[] receiveData = new byte[1024];
		String sentence = "";
		while(sentence != " "){
		sentence = "";
		sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);       
		clientSocket.send(sendPacket);       
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);       
		clientSocket.receive(receivePacket);       
		String modifiedSentence = new String(receivePacket.getData());       
		System.out.println("FROM SERVER:" + modifiedSentence);
		sentence = null;
		modifiedSentence = null;
		}
		clientSocket.close();    
	}
	
	public void sendShipData(InetAddress ip, Dimension ship, Coordinates xy){
		ships.userIp = ip;
		int i = ships.userships.lastIndexOf(ship);
		
		ShipData newShip = new ShipData();
		
		newShip.dimen.length = ship.length;
		newShip.dimen.width = ship.width;
		
		newShip.xy.x = xy.x;
		newShip.xy.y = xy.y;
		
		ships.userships.add(newShip);
	}
	
}