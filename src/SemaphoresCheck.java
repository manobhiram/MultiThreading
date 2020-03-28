
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class SemaphoresCheck {

	public static void main(String[] args) {
		
	BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
		
	SemaphoreProb abc = new SemaphoreProb(bq);
	
	Thread t1= new Thread(new Produ(bq,abc));
	Thread t2 = new Thread(new Consu(bq,abc));
	Thread t3= new Thread(new Produ(bq,abc));
	
	t1.start();
	t2.start();
	t3.start();
	}
}

class Consu implements Runnable{
	BlockingQueue<Integer> a;
	SemaphoreProb abc;
	int len ;
	Consu(BlockingQueue<Integer> bq,SemaphoreProb ac){
		a = bq;
		abc =ac;
	}
	
	public void run(){
		try {
			abc.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}


class Produ implements Runnable{
	BlockingQueue<Integer> a;
	SemaphoreProb abc;
	Produ(BlockingQueue<Integer> q,SemaphoreProb aa){
		a = q;
		abc = aa;
	}
	
	public void run(){
		try {
			abc.put();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}


class SemaphoreProb {
	Semaphore conSem = new Semaphore(0);
	Semaphore proSem = new Semaphore(1);
	BlockingQueue<Integer> q ;
	
	SemaphoreProb(BlockingQueue<Integer> q){
		this.q = q;
		
	}
	
	
	public void get() throws InterruptedException{
		
		while(true){
			conSem.acquire();
			System.out.println("Consumed :" + q.take());
			proSem.release();
		}
		
	
	}
	
	public void put() throws InterruptedException{
	for(int i=0;i<5;i++){	
			proSem.acquire();
			System.out.println("produced :" +i);
			q.put(i);
			conSem.release();
	 }
	}
 }