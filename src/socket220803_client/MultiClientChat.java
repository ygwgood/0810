package socket220803_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiClientChat {
	public static void main(String[] args) {
		try {
			System.out.println("[클라이언트 프로그램]");
			Socket socket=new Socket("192.168.0.7",11111);
			InputStream is=socket.getInputStream();
			DataInputStream in=new DataInputStream(is);
			String recvdata=in.readUTF();
			System.out.println(recvdata);  
			
			OutputStream os=socket.getOutputStream();
			DataOutputStream out=new DataOutputStream(os);
			
			
			Scanner scan=new Scanner(System.in);
			String senddata="";
			
			MultiChatClientSend clientsend=new MultiChatClientSend(out);
			clientsend.start();
				
			MultiChatClientRecv clientrecv=new MultiChatClientRecv(in);
			clientrecv.start();
			
			while(true) {
				
				if(!clientrecv.isAlive()) {break;}
				if(!clientsend.isAlive()) {break;}
				
				
			}
			
			in.close();
			is.close();
			out.close();
			os.close();
			socket.close();
			System.out.println("클라이언트 프로그램 종료");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
