
public class TrafficSignal {

	
	public static void main(String[] args) {
		
		Flag flag = new Flag();
		flag.check=1;
		flag.count=1;
		Thread t1 = new Thread(new North(flag));
		Thread t2 = new Thread(new South(flag));
		Thread t3 = new Thread(new East(flag));
		Thread t4 = new Thread(new West(flag));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Flag{
	int check;
	int count;
	
}


class North implements Runnable{
	Flag flag;
	North(Flag flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		
		while(true)
		{
			
			synchronized(flag)
			{
			//	System.out.println("In North : "+ flag.check);
				
				if(flag.check==1)
				{
			//		System.out.println("In North  : count"+ flag.count + "Flag Check2 " + flag.check);
					
					if((1+(flag.check-1)*5) == flag.count)
					{
					System.out.println("North is Green");
					}
					else
					{
					   System.out.println("North is Red");
					}
					 flag.check++;
		                flag.count++;
					
				}
				try {
					flag.notify();
	              
	  //              System.out.println("In before North : wait");
	            	flag.wait();
	//           System.out.println("In after North : wait");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			
				}
				
				
			}
		}
		
	}
}

class South implements Runnable{
	Flag flag;
	
	South(Flag flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		while(true)
		{
			
			synchronized(flag)
			{
				
			//	System.out.println("In South : "+ flag.check);
				
				if(flag.check==2)
				{
			//		System.out.println("In South  : count"+ flag.count + "Flag Check2 " + flag.check);
					
					if((1+(flag.check-1)*5) == flag.count)
					{
					System.out.println("South is Green");
					}
					else
					{
					   System.out.println("South is Red");
					}
					 flag.check++;
		                flag.count++;
				
			}
				try {
				 	flag.notify();
	               
	//                System.out.println("In before south : wait");
	            	flag.wait();
	//            	System.out.println("In after South wait : ");
	    			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			
				}
		}
	}
}
}

class East implements Runnable{
	Flag flag;
	East(Flag flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		while(true)
		{
			
			synchronized(flag)
			{
				
		//		System.out.println("In East  : "+ flag.check);
				if(flag.check==3)
				{
			//		System.out.println("In East  : count"+ flag.count + "Flag Check2 " + flag.check);
							
					if((1+(flag.check-1)*5) == flag.count)
					{
					System.out.println("East is Green");
					
					}
					else
					{
					   System.out.println("East is Red");
					   
					}
					  flag.check++;
		                flag.count++;
					
			}
				try {
				 	flag.notify();
	               
	     //       	System.out.println("In before East wait : ");
		    		
	                flag.wait();
	       //     	System.out.println("In after East wait : ");
	    			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			
				}
		}
	}
}
}
class West implements Runnable{
	Flag flag;
	West(Flag flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		
		while(true)
		{
			
			synchronized(flag)
			{
				
		//		System.out.println("In West  : "+ flag.check);
				
				if(flag.check==4)
				{
					
			//		System.out.println("In West  : count"+ flag.count + "Flag Check2 " + flag.check);
					
					if((1+(flag.check-1)*5) == flag.count)
					{
					System.out.println("West is Green");
					System.out.println();
					}
					else
					{
					   System.out.println("West is Red");
					   System.out.println();
					}
					 flag.check=1;
		                flag.count++;
		                if(flag.count==17)
		                	flag.count=1;
				}
				try {
				 	flag.notify();
	             
	         //      System.out.println("flag count is "+ flag.count);
	                
	          //      System.out.println("In Before West wait : ");
	    			
	            	flag.wait();
	            //	System.out.println("In after West wait : ");
	    			
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			
				}
				
			}
		}
	}
}