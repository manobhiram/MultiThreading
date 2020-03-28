
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Threadscheck {

	public static void main(String[] args) {
		ob a = new ob();
		a.chec= 0;
		ReentrantLock i = new ReentrantLock();
		
	//	ExecutorService e = Executors.newSingleThreadExecutor();
		
		
	//	ConcurrentHashMap chm = new ConcurrentHashMap();
	
		
	//	ThreadPoolExecutor a = new ThreadPoolExecutor();
		
		
		
		
		Thread t1 = new Thread(new A(i,a));
		Thread t2 = new Thread(new B(i));
		t1.start();
		t2.start();
	}
	
}

class ob{
	int chec;
}

class A implements Runnable{
	
	
	ReentrantLock i;
	ob a;
	
	A(ReentrantLock i,ob a){
		this.i= i;
		this.a = a;
	}
	
	public void run(){
		i.lock();
		
		System.out.println("hello");
		System.out.println(i.getHoldCount());
		
		m1();
		
		
		a.chec++;
		i.unlock();
		
	}
	
	void m1(){
		i.lock();
		System.out.println(i.getHoldCount());
		System.out.println("hello");
		i.unlock();
	}
	
}


class B implements Runnable{
	ReentrantLock i;
	B(ReentrantLock i){
		this.i = i;
	}
	public void run(){
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("T2 "+i.getQueueLength());
	}
}