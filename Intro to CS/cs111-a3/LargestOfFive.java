/*************************************************************************
 *  Compilation:  javac LargestOfFive.java
 *  Execution:    java LargestOfFive 35 10 32 1 8
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 *  Takes five distinct integers as command-line arguments and prints the 
 *  largest value
 *
 *
 *  % java LargestOfFive 35 10 32 1 8
 *  35
 *
 *  Assume the inputs are 5 distinct integers.
 *  Print only the largest value, nothing else.
 *
 *************************************************************************/

public class LargestOfFive {

    public static void main (String[] args) {
        // WRITE YOUR CODE HERE
    int[] num = new int[5];
    
    
    for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(args[i]); 
    }

    int maxNum = num[0];
    
    for (int i = 0; i < 5; i++) {
       //if the element in num is greater than max make that element the new max 
       if (num[i] > maxNum){ 
        maxNum = num[i];
       }  
}
    System.out.println(maxNum);

} 
}