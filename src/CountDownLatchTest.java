import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		
	
	CountDownLatch cd = new CountDownLatch(3);
	
	Thread t1 = new Thread(new Waiter(cd));
	
	 t1.start();
	 cd.countDown();
	 try {
		cd.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 System.out.println("hello in final latch");
	}
}


class Waiter implements Runnable{
	
	private CountDownLatch latch;
	Waiter(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run(){
		System.out.println("Count 1");
		latch.countDown();
		System.out.println("Count 2");
		latch.countDown();
		System.out.println("Count 3");
		
	//	latch.countDown();
		
		System.out.println("Done run waiter");
	
		System.out.println("Done run 2nd count");
		
	}
	
}