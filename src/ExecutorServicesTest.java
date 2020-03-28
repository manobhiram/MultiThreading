
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicesTest {
      
	public static void main(String[] args) {
		
	
	ExecutorService executor = Executors.newFixedThreadPool(5);
	
	 Queue<Integer> queue = new LinkedList<>(); 
	for(int i=0;i<2;i++)
	{
	     	Runnable worker = new Producer(queue,5);
	     
	     	Runnable worker1 = new Consumer(queue);
	     	executor.execute(worker);
	     
	     	executor.submit(worker1);
	     	
	     	
	}
/*	for(int i=0;i<10;i++)
	{
	     	Runnable worker = new Cons(queue,5);
	     	executor.execute(worker);
	}
	*/
    	executor.shutdown();
    	while(!executor.isTerminated()){}
    	System.out.println("done all");
	}
}


class MyClass implements Runnable{
	   
	   private String command;
	   MyClass(String s){
		  
		   this.command= s;
	  }
	   
	   
	   public void run(){
		   System.out.println(Thread.currentThread().getName() + " Started " + command);
		   System.out.println(Thread.currentThread().getName() + " ended " + command);
			 }
	   
	   
}