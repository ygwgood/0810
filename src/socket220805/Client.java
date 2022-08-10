package socket220805;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws Exception{
	
			Socket socket = new Socket("192.168.0.65", 11112);
			System.out.println("클라이언트 ");
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			Member member = new Member();
			member.setId("admin1");
			member.setPassword("1234");
			//데이터를 보내기 전 시간 측정
			//받은 쪽은 데이터를 받은 후 시간을 측정하고
			//보내시간과 받은시간을 빼면 전송시간 계산
			long beforeTime=
					System.currentTimeMillis();
			System.out.println("beforeTime:"+beforeTime);
			DataOutputStream out=new DataOutputStream(os);
			out.writeUTF(String.valueOf(beforeTime));
			out.flush();
			
			oos.writeObject(member);
			oos.flush();	
			
			oos.close();
			os.close();
			socket.close();
		
	}

}
