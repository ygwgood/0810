package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDataInputStream {

	public static void main(String[] args) {
		try {
		ServerSocket server=new ServerSocket(11111);
		System.out.println("서버프로그램[대기중]");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		OutputStream out=client.getOutputStream();
		DataOutputStream dout=new DataOutputStream(out);
		dout.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		InputStream in=client.getInputStream();
		DataInputStream din=new DataInputStream(in);
		String recvdata=din.readUTF(); //read상태는 머물러 있는 상태
		System.out.println(recvdata);  
		
		System.out.println("서버 끝");
		dout.close();
		out.close();
		client.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
