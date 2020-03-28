
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueue1 {

	
	static BlockingQueue<Integer> unbounded = new ArrayBlockingQueue<>(12);
	
   
	 public static void main(String[] args) {
		
		System.out.println(unbounded);
	}
   //	Thread t1= new Thread(new Prod(que));
	//Thread t2 = new Thread(new Cons(q));
	
}

class Prod implements Runnable{
	
	BlockingQueue<Integer> q;
	Prod(BlockingQueue<Integer> q){
		this.q= q;
	}
	public void run(){
		for(int i=0;i<10;i++)
		{
			System.out.println("produced  : "+i);
		     
		}
	}
}

