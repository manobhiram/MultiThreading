import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Stack 
 {
	int[] arr;
	int size;
	int counter;
	Stack(int size)
	{
		arr = new int[size];
		counter = 0;
	}
	
	public synchronized void push(int data)
	{
	//	System.out.println("inside push");
			if(arr.length==counter){
				
				System.out.println("Queue is Full");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	
				arr[counter++]=data;
				this.notify();
			
		
	}
	
	
	public synchronized int pop(){
	//	System.out.println("Inside pop");
		if(counter==0){
			System.out.println("No Elements");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		  }
	
			int a = arr[counter-1];
			counter--;
			this.notify();
			return a;
		
	}
	
 }
 
 public class StackProg {
	 
	 public static void main(String[] args) {
		Stack s = new Stack(3);
	/*	ExecutorService insert = Executors.newFixedThreadPool(5);
		ExecutorService remove = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			insert.submit(new Insert(s));
			remove.submit(new Remove(s));
		}
        
	}*/
	 
		
		
		  Thread t1 = new Thread(new Insert(s));
		Thread t2 = new Thread(new Remove(s));
	//	 Thread t3 = new Thread(new Insert(s));
		t1.start();
		t2.start();
	//	t3.start();
		
	 }
		
 }

class Insert implements Runnable{
	Stack s;
	Insert(Stack s){
		this.s =s;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("******************pushing "+i);
		   s.push(i);
		}
	}
	
}
  
class Remove implements Runnable{
	Stack s;
	Remove(Stack s){
		this.s =s;
	}
	
	public void run(){
	//	System.out.println("run check");
		for(int i=0;i<10;i++)
		System.out.println("********Poping : "+s.pop());
	}
	
}
  

