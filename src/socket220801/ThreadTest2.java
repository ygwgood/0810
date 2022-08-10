package socket220801;
class RunableMyThread implements Runnable{
	int num;
	String name;
	
	public RunableMyThread(String name,int num) {
		this.num = num;
		this.name = name;
	}
	@Override
	public void run() {
		  for(int i=0; i<num; i++)
	      System.out.println(name + " : " + i);
	}
}
public class ThreadTest2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunableMyThread("first", 100));
		Thread t2 = new Thread(new RunableMyThread("second", 100));
		Thread t3 = new Thread(new RunableMyThread("third", 100));
		t1.start();
		t2.start();
		t3.start();
		
	}

}
