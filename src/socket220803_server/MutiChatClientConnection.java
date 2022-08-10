package socket220803_server;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MutiChatClientConnection extends Thread{
	ServerSocket serversocket;
	Socket[] cs=new Socket[100];
	int cnt=0;
	public MutiChatClientConnection(ServerSocket serversocket) {
		this.serversocket=serversocket;
	}

	@Override
	public void run() {
		
		while(true) {
		try {
		System.out.println("서버프로그램[클라이언트 접속 대기중]");
		cs[cnt]=serversocket.accept();
		//접속한 클라이언트에 대한 쓰레드 실행
		System.out.println("cnt:"+cnt);
 		CSThread cst=new CSThread(cs[cnt],this);
		cst.start();
		
		OutputStream os=cs[cnt].getOutputStream();
		DataOutputStream out=new DataOutputStream(os);
		out.writeUTF("서버에 접속하신 것을 환영합니다.");
		
		System.out.println(cs[cnt].getInetAddress()+"클라이언트가 접속했습니다.");
		cnt++;
		System.out.println("현재접속자수:"+cnt);
		
		//out.close();
		//os.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
}
