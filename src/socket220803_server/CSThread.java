package socket220803_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CSThread extends Thread{
	Socket socket;
	MutiChatClientConnection mc;
	public CSThread(Socket socket,MutiChatClientConnection mc) {
		this.socket=socket;
		this.mc=mc;
		System.out.println("cstread:"+ mc.cnt);
	}
	
	@Override
	public void run() {
		
		InputStream is=null;
		DataInputStream in=null;
		String recvdata="";
		while(true) {
		try {
		is=socket.getInputStream();
		in=new DataInputStream(is);
		recvdata=in.readUTF();
		//////////
		System.out.println("cstread run:"+ mc.cnt);
		for(int i=0;i<mc.cnt;i++) {
			OutputStream os=mc.cs[i].getOutputStream();
			DataOutputStream out=new DataOutputStream(os);
			out.writeUTF("["+mc.cs[i].getInetAddress()+"]"+recvdata);
		}		
		///////
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	}

}
