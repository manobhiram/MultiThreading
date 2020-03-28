
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class Serialaization  {
	  
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		myObject ob = new myObject();
		
		ob.j=12;
		FileOutputStream fos = new FileOutputStream("hello");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ob);
		oos.close();
		System.out.println("check");
		FileInputStream fis = new FileInputStream("hello");
		ObjectInputStream ois = new ObjectInputStream(fis);
		myObject obj = (myObject)ois.readObject();
		
	   ois.close();

		System.out.println(obj.i);
	   System.out.println(obj.j);
	   
	}
	
}



class Bab  implements  Serializable{
	private static final long serialVersionUID = 1L;

	int j;
	Bab(){
		System.out.println("hea");
	 j=11;
	}

}

class myObject extends Bab  {
  /**
	 * 
	 */

	private static final long serialVersionUID = 2L;

   int i=10;

   


}





