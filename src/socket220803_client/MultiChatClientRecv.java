package socket220803_client;

import java.io.DataInputStream;

public class MultiChatClientRecv extends Thread{
	DataInputStream in;
	public MultiChatClientRecv(DataInputStream in) {
		this.in=in;
	}
	
	@Override
	public void run() {
		String recvdata="";
	while(true) {
		try {
		recvdata=in.readUTF();
		if(recvdata.equals("exit")) {break;}
		System.out.println(recvdata);
		}catch(Exception e) {
			e.printStackTrace();
			break;
		}
	}

	}

}
