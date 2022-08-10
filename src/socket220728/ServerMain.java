package socket220728;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		try {
		ServerSocket server=new ServerSocket(9999);
		
		while(true) {
		System.out.println("클라이언트를 기다리는 중");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		System.out.println(client.getRemoteSocketAddress());
		System.out.println(client.getInetAddress());
		
		OutputStream out=client.getOutputStream();
		String data="hello";
		out.write(data.getBytes());
		out.flush();
		
		InputStream in=client.getInputStream();
		}

		}catch(Exception e) {
		e.printStackTrace();
		
	}
  }
}

