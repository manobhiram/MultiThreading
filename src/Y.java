
public class Y {
	public static void main(String[] args) {
		R r=new R();
			Thread t1 = new Thread(new Check1(r));
		Thread t2 = new Thread(new Check2(r));
		
		t1.start();
		t2.start();
		
	}
}

class R{
	int i=0;
}


class Check1 implements Runnable{
	R r;
	
	Check1(R r){
		this.r =r;
	}
	public void run(){
		
		
		synchronized(r){
			System.out.println("before wait");
			try {
				r.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After wait");
			System.out.println("printing i "+ r.i);
		}
	}
}


class Check2 implements Runnable{
      R r;
	
	Check2(R r){
		this.r =r;
	}
public void run(){
	
	synchronized(r){
		r.notify();
		System.out.println("seting print ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.i=1;
		
	   }
	}
}