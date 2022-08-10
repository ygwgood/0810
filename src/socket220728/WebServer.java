package socket220728;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

	public static void main(String[] args) {
		try {
			int count=0;
			
			ServerSocket server=new ServerSocket(9090);
			
			while(true) {
				
				System.out.println("서버 접속대기중.......");
				Socket client=server.accept();
				String senddata=
	"HTTP/1.1 200 OK Content-Type:text/html;charset=utf-8\r\n\n";
				
				senddata+="<h1>hello</h1>";
				senddata+=":"+count++;
				
				client.getOutputStream().write(senddata.getBytes());
				//System.in.read();
				client.getOutputStream().flush();
				client.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
