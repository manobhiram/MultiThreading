
public class MultiThreadingPrintingString {

	public static void main(String[] args)  {
		
		obj newobj = new obj();
		newobj.i=0;
		Thread t1 = new Thread(new PrintSap(newobj));
		Thread t2 = new Thread(new PrintGlob(newobj));
		Thread t3 = new Thread(new PrintMarket(newobj));
	        
	    t1.start();
	    
	    t2.start();
	  
	    t3.start();
	}
	
}

class obj{
	int i=0;
}


class PrintSap implements Runnable{
	obj a ;
	PrintSap (obj abc){
		a = abc;
	}
	public void run(){
		int i=0;
		while(i<10)
		{
			synchronized(a)
			{
			//	System.out.println("i Sapient is  "+ a.i+ " i is " + i);
				if(a.i==0)
				{
					System.out.print("Sapient ");
					i++;
		            try {
		            	a.notify();
		            	a.i++;
		            	 if(i!=10)
						a.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class PrintGlob implements Runnable{
	obj a;
	PrintGlob(obj abc)
	{
		a = abc;
	}
	public void run(){
		int i=0;
		
		while(i<10)
		{
			
		synchronized(a)
		{
		//	System.out.println("in Global " + a.i + " i is " + i);
			if(a.i==1)
			{
				System.out.print("Global ");
				i++;
				
	            try {
	            	a.notify();
	            	a.i++;
	            	 if(i!=10)
					a.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
			}
			
			
		}
    
}
	}
}

class PrintMarket implements Runnable{
	obj a ;
	PrintMarket(obj abc){
		a = abc;
	}
	public void run(){
		int i=0;
		
		
			while(i<10)
			{
				synchronized(a)
				{
	//	System.out.println("in markets " + a.i + " i is " + i);
						if(a.i==2)
						{
							System.out.print("Markets ");
							System.out.println();
							i++;
							try {
								a.notify();
								a.i=0;
	            	            if(i!=10)
								a.wait();
							} catch (InterruptedException e) {
					// TODO Auto-generated catch block
								e.printStackTrace();
								}
						}

					
				}
			}
    
	}
}
