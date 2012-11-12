import java.net.*;
import java.io.*;

public class GameServer
	{


		public static void main(String[] args) throws IOException
			{
				ServerSocket server = null;
				boolean inLobby = true;
				try{										
					server = new ServerSocket(27000);     		//Make it so that the server DatagramSocket port # can change via reading a text document
				} 
				catch(IOException e) {
					System.err.println("Could not listen on port: 27000");
					System.exit(-1);
				}
				
				while(inLobby)
					new GameServerThreadTCP(server.accept()).start();
				server.close();
				
				new GameServerThread().start();
				
				
				
				
			}

	}
