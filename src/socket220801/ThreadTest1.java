package socket220801;
class MyThread extends Thread{
	int num;
	String name;
	
	public MyThread(String name,int num) {
		this.num = num;
		this.name = name;
	}
	@Override
	public void run() {
		  for(int i=0; i<num; i++)
	      System.out.println(name + " : " + i);
	}
	
}
public class ThreadTest1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread("first", 100);
		MyThread t2 = new MyThread("second", 100);
		MyThread t3 = new MyThread("third", 100);
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(15);
		t2.stop();
	}

}
