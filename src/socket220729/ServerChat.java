package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat {

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
		
		String recvdata=din.readUTF(); //데이터가 들어오기를 기다리는 상태
		System.out.println("[클라이언트 메시지]:"+recvdata);
		/****** 
		next()함수는 스페이스를 포함한 문자를 같이 보낼수 없음  
		next()함수의 활용은 성적을 입력받을 때 사용 가능
		console : 90 50 70
		int kor=sc.next();
		int eng=sc.next();
		int math=sc.next();
		********/
		Scanner scan=new Scanner(System.in);
		System.out.println("클라이언트로 보낼 데이터를 입력하세요.");
		String senddata=scan.nextLine();
		dout.writeUTF(senddata);
		
		
		
		dout.close();
		out.close();
		client.close();
		System.out.println("서버 끝");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
