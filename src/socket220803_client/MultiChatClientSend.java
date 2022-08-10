package socket220803_client;

import java.io.DataOutputStream;
import java.util.Scanner;

public class MultiChatClientSend extends Thread{
	DataOutputStream out;
	public MultiChatClientSend(DataOutputStream out) {
       this.out=out;
	}
	
	@Override
	public void run() {
		String senddata="";
		Scanner scan=new Scanner(System.in);
		while(true) {
			try {
				//System.out.print("[클라이언트 메시지 입력]:");
				senddata=scan.nextLine();
				out.writeUTF(senddata);
				if(senddata.equals("exit")) {break;}
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}
		}

	}

}
