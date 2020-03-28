import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	
public static void main(String[] args) throws InterruptedException {
	
	Barrier1 b1= new Barrier1();
	Barrier2 b2= new Barrier2();
	CyclicBarrier cb1 = new CyclicBarrier(2,b1);
	CyclicBarrier cb2 = new CyclicBarrier(2,b2);
	Thread t1=  new Thread(new Waiter1(cb1,cb2));
   Thread t2=  new Thread(new Waiter1(cb1,cb2));
	t1.start();
	
	t2.start();
	
}
}

class Barrier1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("action 1 performed");
		
	}
	
}


class Barrier2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("action 2 performed");
		
	}
	
}


class Waiter1 implements Runnable{
	private CyclicBarrier barrier1;
	private CyclicBarrier barrier2;
	Waiter1(CyclicBarrier cb1,CyclicBarrier cb2){
		barrier1 = cb1;
		barrier2 =cb2;
	}
	
	public void run(){
		
		
		System.out.println(Thread.currentThread().getName()+" at barrier 1 " );
		try {
			Thread.sleep(200);
			barrier1.await();
		   
		System.out.println(Thread.currentThread().getName()+" at barrier 2 " );
		 barrier2.await();
		 barrier2.await();
	
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
		System.out.println("in excetion");
		//	e.printStackTrace();
		}
		
		System.out.println("done all");
		
		
	}
}



