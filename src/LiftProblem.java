
public class LiftProblem {
	public static void main(String[] args) {
	Flag1 flag = new Flag1();
	flag.check=1;
	Thread t1 = new Thread(new Odd(flag));
	Thread t2 = new Thread(new Even(flag));
	
	t1.start();
	t2.start();
	}
}


class Flag1{
	int check;
	
	
	
}


class Odd implements Runnable{
	Flag1 flag;
	Odd(Flag1 flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		while(true)
		{
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("CHec in ODD");
			synchronized(flag){
			if(flag.check %2 == 1)
			{
				System.out.println("ODD : " +flag.check);
				flag.check++;
			
			}
			flag.notify();
			
	    	}
			
		}
	}
}

class Even implements Runnable{
	Flag1 flag;
	Even(Flag1 flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("CHec in EVEN");
			synchronized(flag){
				
			if(flag.check %2 == 0)
			{
				System.out.println("Even : " +flag.check);
				flag.check++;

				try {
					flag.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
	    	}
		}
		
	}
}