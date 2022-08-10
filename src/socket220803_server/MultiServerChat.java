package socket220803_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiServerChat {

	public static void main(String[] args) {
		try {
		
		ServerSocket serversocket=new ServerSocket(11111);
		
		MutiChatClientConnection clientsocket=new 
				MutiChatClientConnection(serversocket);
		clientsocket.start();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
