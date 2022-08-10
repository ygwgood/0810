package socket220728;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain2 {

	public static void main(String[] args) {
		int data;
		//StringBuilder sdata=new StringBuilder();
		String sdata="";
		try {
			Socket socket=new Socket("192.168.0.81",9999);
			System.out.println("클라이언트프로그램");
			InputStream in=socket.getInputStream();
			System.in.read();
			//while(true) {
			while(in.available()>0) {
				data=in.read();
				sdata+=(char)data;
			}
			
			System.out.println(sdata);
			
			//OutputStream out=socket.getOutputStream();
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
