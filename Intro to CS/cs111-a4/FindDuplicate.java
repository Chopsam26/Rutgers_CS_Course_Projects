/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    /**
     * @param args
     */
    public static void main(String[] args) {

		//WRITE YOUR CODE HERE
		//use the internger parse to get input for array 
		//create the array 
		//use a for loops to iterate through the array looking for duplicate 
		//compare the first element with the second thorough thte last element. 
		//if equals then print true and break the loop else keep iterarting. 
		//for the next elements iterarting thoruhg the ith + 1 to last

		//initalize nums array to equal args array
		int[] nums = new int[args.length];
		boolean duplicate = false;
		
		for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(args[i]); 
    }
		//iterates through ith element then compares the the elemement 
		//its stopped at to the other elements
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] == nums[j]) {
				
				duplicate = true;
				System.out.println(duplicate);
				break;
				}
					
				
			}
			if (duplicate) {
				break;
			}
		}
		if (duplicate == false) {
			System.out.println(duplicate);
		}
		

	}
}
