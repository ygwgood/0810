package socket220729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat3 {

	public static void main(String[] args) {
		try {
			System.out.println("클라이언트 프로그램");
			System.out.println("엔트키를 누르시면 서버에 접속합니다.");
			System.in.read();
			Socket socket=new Socket("192.168.0.10",11111);
			
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader in=new BufferedReader(isr);
			
			String recvdata=in.readLine();
			System.out.println(recvdata);  
			
			Scanner scan=new Scanner(System.in);
			String senddata="";
			
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			BufferedWriter out=new BufferedWriter(osw);
						
			while(true) {
			System.out.println("서버로 보낼 데이터를 입력하세요.");
			senddata=scan.nextLine();//스캐너를 사용할 경우 스페이스가 문장을 구분하므로 앞에 문장만 변수에 입력됨
			out.write(senddata);
			out.newLine();
			out.flush();
			
			if(senddata.equals("exit")) {
				break;
			}
			
			recvdata=in.readLine();			
			if(recvdata.equals("exit")) {
				break;
			}
			System.out.println("[서버에서 보내온 메시지]:"+recvdata);  
			}
			
			in.close();
			isr.close();
			is.close();
		
			out.close();
			osw.close();
			os.close();
			
			socket.close();
			System.out.println("클라이언트 끝");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
