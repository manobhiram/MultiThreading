import java.io.*;
import java.util.*;

/*
* Instructions to Candidate
* This is **NOT** a math problem. You are required to code up a simple mathematical technique to find the square root of a number.
* The Newton-Raphson method can be used to find the square root of a number N as follows
    ** Make an initial guess
    ** Update the guess using the below formula
    ** New Estimate = Current Estimate - ( F(Current Estimate) / F'(Current Estimate) ), where
     F(Current Estimate) = Current Estimate * Current Estimate - N
     F'(Current Estimate) = 2*Current Estimate
    ** Repeat till you are close enough
* Run this code in the REPL to observe its behaviour. The
   execution entry point is main().
* Consider adding some additional tests in doTestsPass()
*/
public class Solution {

	public static void main(String[] args) {
		int x=0;
		
		 System.out.println(m1(x));	
		
	}
 
	 public static int m1(int x)
	 {
		 x = 5;
		  
		  try{
			  return 3;
		  }
		  catch (Exception e){
			  System.out.println("hello");
		  }
		  finally{
			  
			  x=10;
			  System.out.println(x);
			  //return 2;
			  
		  }
		  
		 return x;
	 }
  }
  
