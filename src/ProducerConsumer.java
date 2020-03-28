
import java.util.*;


public class ProducerConsumer {
      
	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		int size = 5;
		Thread t1 = new Thread(new Producer(q,size));
		Thread t2 = new Thread(new Consumer(q));
       Thread t3= new Thread(new Producer(q,size));
       Thread t4 = new Thread(new Producer(q,size));
		
		t1.start();
		t2.start();
	//	t3.start();
    //  t4.start();
	}
}


class Producer implements Runnable{
	
	Queue<Integer> q ;
	int size;
	
	Producer(Queue<Integer> q, int length){
		this.q = q;
		this.size = length;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
		   
		synchronized(q)
		  {
			  if(q.size()==size) 
			  {
				  System.out.println(Thread.currentThread().getName()+ " Queue is full");
				  try {
					q.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			  else
			  {
				  System.out.println(Thread.currentThread().getName()+" produced : "+  i);
				  q.offer(i);
				  q.notifyAll();
			  }
		  }
		  
	}
	}
}


class Consumer implements Runnable{
      Queue<Integer> q;
      
      Consumer(Queue<Integer> q){
    	  this.q=q;
      }
      
      public void run()
      {
    	   while(true)
    	   {
    		   synchronized(q)
    		   {
    			   
    			   if(q.isEmpty())
    			   {
    				   System.out.println(Thread.currentThread().getName()+" Queue is empty");
    				   try {
    					  
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			   }
    			   else
    			   {
    				   System.out.println(Thread.currentThread().getName()+" Consumed : " + q.poll());
    				   q.notifyAll();
    			   }
    		   }
    	   }
      }
}