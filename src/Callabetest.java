
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class Callabetest {

	public static void main(String[] args) {
		String Results=null;
		Future<String> obj = null;
		List<Future<String>> futures=null;
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//ExecutorService executor1 = Executors.new
		
		executor.execute(new test1());
		executor.execute(new test1());
		
		Set<Callable<String>> hm = new HashSet<Callable<String>>();
		
		hm.add(new test2());
		hm.add(new test3());
		hm.add(new test4());
		
		try {
			futures =  executor.invokeAll(hm);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for(Future<String> f : futures)
		{
		try {
			System.out.println(" Result print is "+ f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		executor.shutdown();
		
		/*obj=executor.submit(new test2());
		executor.shutdown();
		
		try {
			  System.out.println(obj.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}


class test1 implements Runnable{
	
	public void run(){
     
		 System.out.println(Thread.currentThread().getName()+ " In test1");
		 
	}
}

class test2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Ram2 is here";
	}
	
	
}

class test3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Ram3 is here";
	}
	
	
}
class test4 implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Ram4 is here";
	}
	
	
}