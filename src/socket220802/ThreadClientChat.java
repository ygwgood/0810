package socket220802;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClientChat {

	public static void main(String[] args) {
		try {
			System.out.println("[클라이언트 프로그램]");
			System.out.println("엔트키를 누르시면 서버에 접속합니다.");
			Socket socket=new Socket("192.168.0.10",11111);
			InputStream is=socket.getInputStream();
			DataInputStream in=new DataInputStream(is);
			String recvdata=in.readUTF();
			System.out.println(recvdata);  
			
			OutputStream os=socket.getOutputStream();
			DataOutputStream out=new DataOutputStream(os);
			
			
			Scanner scan=new Scanner(System.in);
			String senddata="";
			
			while(true) {
				System.out.print("[클라이언트 메시지 입력]:");
				senddata=scan.nextLine();
				out.writeUTF(senddata);
				if(senddata.equals("exit")) {break;}
				
				recvdata=in.readUTF();
				if(recvdata.equals("exit")) {break;}
			
				System.out.println("[서버 메시지]:"+recvdata);  
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
