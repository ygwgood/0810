package socket220802;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadServerChat {

	public static void main(String[] args) {
		try {
		Scanner scan=new Scanner(System.in);
		String recvdata="";
		String senddata="";
		
		ServerSocket server=new ServerSocket(11111);
		
		while(true) {
		System.out.println("서버프로그램[대기중]");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		OutputStream os=client.getOutputStream();
		DataOutputStream out=new DataOutputStream(os);
		out.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		InputStream is=client.getInputStream();
		DataInputStream in=new DataInputStream(is);
		
		while(true) {
		recvdata=in.readUTF(); //데이터가 들어오기를 기다리는 상태
		if(recvdata.equals("exit")) {break;}
		System.out.println("[클라이언트 메시지]:"+recvdata);
				
		System.out.print("[서버 메시지 입력]:");
		senddata=scan.nextLine();
		if(senddata.equals("exit")) {break;}
		else {out.writeUTF(senddata); }
		
		}//end while 클라이언트와 챗팅 종료
		
		out.close();
		out.close();
		os.close();
		client.close();
		System.out.println("클라이언트와 챗팅 종료");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
