package socket220729;

import java.io.IOException;

public class CmdMain {

	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
