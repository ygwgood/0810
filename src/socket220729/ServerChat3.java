package socket220729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat3 {

	public static void main(String[] args) {
		try {
		Scanner scan=new Scanner(System.in);
		String recvdata="";
		String senddata="";
		
		ServerSocket server=new ServerSocket(11111);
		System.out.println("서버프로그램[대기중]");
		Socket client=server.accept();
		System.out.println("클라이언트가 접속했습니다.");
		
		OutputStream os=client.getOutputStream();
		OutputStreamWriter osw=new OutputStreamWriter(os);
		BufferedWriter out=new BufferedWriter(osw);
		out.write("서버에 접속하신 것을 환영합니다.");
		out.newLine();
		out.flush();
		
		InputStream is=client.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader in=new BufferedReader(isr);
			
		
		while(true) {
		recvdata=in.readLine();
		if(recvdata.equals("exit")) {break;}
		System.out.println("[클라이언트 메시지]:"+recvdata);
				
		System.out.println("클라이언트로 보낼 데이터를 입력하세요.");
		senddata=scan.nextLine();
		if(senddata.equals("exit")) {break;}
		else {out.write(senddata); out.newLine(); out.flush();}
		
		}
		
		in.close();
		isr.close();
		is.close();
	
		out.close();
		osw.close();
		os.close();
		
		client.close();
		server.close();
		System.out.println("서버 끝");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
