import java.io.*; 
import java.net.*;
import java.util.ArrayList; 
class UDPServer
{    
	ArrayList<PlayerShips> players = new ArrayList<PlayerShips>();
	
	public static void main(String args[]) throws Exception       
	{          
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		String sentence;
		while(true)                
		{
			sentence = " ";
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);                   			serverSocket.receive(receivePacket);                   
			sentence = new String(receivePacket.getData());                   
			System.out.println("RECEIVED: " + sentence);                   
			InetAddress IPAddress = receivePacket.getAddress();                   
			int port = receivePacket.getPort();                   
			String capitalizedSentence = sentence.toUpperCase();                   
			sendData = capitalizedSentence.getBytes();                   
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);                   		serverSocket.send(sendPacket);                
		}       
	}
}