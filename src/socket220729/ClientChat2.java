package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat2 {

	public static void main(String[] args) {
		try {
			System.out.println("클라이언트 프로그램");
			System.out.println("엔트키를 누르시면 서버에 접속합니다.");
			System.in.read();
			Socket socket=new Socket("192.168.0.81",11111);
			InputStream in=socket.getInputStream();
			DataInputStream din=new DataInputStream(in);
			String recvdata=din.readUTF();
			System.out.println(recvdata);  
			
			OutputStream out=socket.getOutputStream();
			DataOutputStream dout=new DataOutputStream(out);
			
			Scanner scan=new Scanner(System.in);
			String senddata="";
			
			byte[] rdata=new byte[1024];
			
			while(true) {
			System.out.println("서버로 보낼 데이터를 입력하세요.");
			senddata=scan.nextLine();
			dout.write(senddata.getBytes());
			if(senddata.equals("exit")) {
				break;
			}
			
			//recvdata=din.readUTF();
			din.read(rdata);
			recvdata=rdata.toString();
			
			if(recvdata.equals("exit")) {
				break;
			}
			System.out.println("[서버에서 보내온 메시지]:"+recvdata);  
			}
			din.close();
			in.close();
			socket.close();
			System.out.println("클라이언트 끝");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
