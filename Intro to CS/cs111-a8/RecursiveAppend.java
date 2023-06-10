/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    
    //boundary condition would be if n is greater or equal to 0  
    //add the orignal string to the appendNTimes method 
    // reuturn empty stirng if boundary condition is not met
     
    
    public static String appendNTimes(String original, int n) {

	// WRITE YOUR CODE HERE
    //if n is one it wil call cat twice because the if statement is 
    //checked for each time the method is called. 
        if(n >= 0) {

       return original + appendNTimes(original, n - 1);
        
        } 
        return " ";
    }

    public static void main (String[] args) {
    //interger parse n bc int command line arguement
	// WRITE TEST CASES HERE to test your method
    int n = Integer.parseInt(args[0]);
    System.out.println(appendNTimes("cat", n));
    
    }
}
