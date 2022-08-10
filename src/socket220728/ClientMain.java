package socket220728;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) {
		int data;
		//StringBuilder sdata=new StringBuilder();
		String sdata="";
		try {
			Socket socket=new Socket("192.168.0.10",9999);
			System.out.println("클라이언트프로그램");
			InputStream in=socket.getInputStream();
			
			while((data=in.read())!=-1) {
				System.out.println(in.available());
				//System.out.println("서버에서 온 데이터:"+data);
				//System.out.println("서버에서 온 데이터:"+(char)data);
				sdata+=(char)data;
				//System.out.println(Character.toString((char)data));
				System.out.println(sdata);
			}
			
			System.out.println("test");
			
			OutputStream out=socket.getOutputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
