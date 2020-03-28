import java.util.concurrent.locks.ReentrantLock;

public class X {
	
	public static void main(String[] args) {
		Display d = new Display();
			Thread t1 = new Thread(new Cr(d,"Dhoni"));
		Thread t2 = new Thread(new Cr(d,"YuV"));
		
		t1.start();
		t2.start();
		
	}
}

class Display{
	ReentrantLock a = new ReentrantLock();

	void wish(String s){
		a.lock();
		for(int i=0;i<5;i++)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(s);
		}
	  a.unlock();
	
	}
}

class Cr implements Runnable{
	String s;
	Display d;
	
	Cr(Display d,String s){
		
		this.s= s;
		this.d = d;
	}
	public void run(){
	   d.wish(s);
	}
	
}