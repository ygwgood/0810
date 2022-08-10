package socket220729;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CmdSocket {

	public static void main(String[] args) {
		try {
			System.out.println("클라이언트 프로그램");
			Socket socket=new Socket("192.168.0.81",11111);
			InputStream in=socket.getInputStream();
			DataInputStream din=new DataInputStream(in);
			String recvdata=din.readUTF();
			System.out.println(recvdata);  
			
			OutputStream out=socket.getOutputStream();
			DataOutputStream dout=new DataOutputStream(out);
			
			Scanner scan=new Scanner(System.in);
			
			while(true) {
			System.out.println("서버에 동작할 명령을 입력하세요.");
			String cmd=scan.nextLine();
			dout.writeUTF(cmd);
			dout.flush();
			if(cmd.equals("exit")) { break;}
			}
			
			dout.close();
			out.close();
			din.close();
			in.close();
			socket.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
