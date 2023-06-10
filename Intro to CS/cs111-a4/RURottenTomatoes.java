/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {
		//create a two dimsional array and use nested for loop to set each element 
		//to an int
		//add the elements in each column using a seperate variable total and display
		//the index of the column if the total sum is greater than the other column
		
		// WRITE YOUR CODE HERE
		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);
		int[][] ru = new int[rows][columns];
		int sum;
		int maxSum = 0;
		int maxCol = 0;
		int k = 2;

		//Iteriated through the rows and columns setting the [i][j] element to the next
		//argument from String[] args
		
		for (int i = 0; i < rows; i++) {


			for (int j = 0; j < columns; j++) {

				ru[i][j] = Integer.parseInt(args[k]);
				k++;

			} 
			
		}
		//[0][0]+ [1][0] + [2][0] make a new 
		 //iterate over the columns and for each cloumn iterate over the rows
		 //to add the elements to clacuate the sum for each column
		 //create variable called maxSum and update the maxSum to the currentSum 
		 //if is greater than the maxSum
		 
		for (int j = 0; j < columns; j++) {
			sum = 0; //resets the sum back to 0 for a new column
			
			for (int i = 0; i < rows; i++) {

				sum += ru[i][j]; //added up each row of ratings 
				

			} 
			if (sum > maxSum) { //if found a new maxSum update the max sum and track 
				//the column that has the maxSum

				maxSum = sum; 
				maxCol = j;

			}
		}
			System.out.println(maxCol);

	}
}
