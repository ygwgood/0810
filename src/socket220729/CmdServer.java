package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CmdServer {

	public static void main(String[] args) {
		try {
		ServerSocket server=new ServerSocket(11111);
		while(true) {
		System.out.println("원격 프로그램 실행 서버[대기중]");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		OutputStream out=client.getOutputStream();
		DataOutputStream dout=new DataOutputStream(out);
		dout.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		InputStream in=client.getInputStream();
		DataInputStream din=new DataInputStream(in);
		while(true) {
		String cmd=din.readUTF(); //데이터가 들어오기를 기다리는 상태
		System.out.println("[클라이언트 명령]:"+cmd);
		if(cmd.equals("exit")) { break;}
		else if(cmd.equals("notpad")) {
		Runtime.getRuntime().exec("notpad");
		}
		}
		din.close();
		in.close();
		dout.close();
		out.close();
		client.close();
		}
		//server.close();
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		
	}
}
}

	

