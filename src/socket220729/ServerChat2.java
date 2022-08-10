package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat2 {

	public static void main(String[] args) {
		try {
		Scanner scan=new Scanner(System.in);
		String recvdata="";
		String senddata="";
		
		ServerSocket server=new ServerSocket(11111);
		System.out.println("서버프로그램[대기중]");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		OutputStream out=client.getOutputStream();
		DataOutputStream dout=new DataOutputStream(out);
		dout.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		InputStream in=client.getInputStream();
		DataInputStream din=new DataInputStream(in);
		
		byte[] rdata=new byte[1024];
		
		while(true) {
		//recvdata=din.readUTF(); //데이터가 들어오기를 기다리는 상태
		din.read(rdata);
		recvdata=new String(rdata);
		if(recvdata.equals("exit")) {break;}
		System.out.println("[클라이언트 메시지]:"+recvdata);
				
		System.out.println("클라이언트로 보낼 데이터를 입력하세요.");
		senddata=scan.nextLine();
		if(senddata.equals("exit")) {break;}
		else {dout.writeUTF(senddata); }
		
		}
		
		dout.close();
		out.close();
		client.close();
		System.out.println("서버 끝");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
