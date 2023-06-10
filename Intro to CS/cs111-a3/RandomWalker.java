/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author: Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    int n = Integer.parseInt(args[0]);
    int currentX = 0; 
    int currentY = 0; 
    int direction = 0; 
    double euclidean = 0; 
    
    //start with an x and a y. choose a direction randomly. 
    //if facing north add 1 to y if south subtract 1 from y if east add 1 to x if west 
    //-1 from x  
    
    //use the for loop and iterate n amount of times and print of currentX and current
    // Y at each i from 0 less than n 
    System.out.println("(" + currentX + "," + currentY + ")" );
    for (int i = 0; i < n; i++){
        direction = ((int)(Math.random()* 4) + 1);
        if (direction == 1){ 
            currentY += 1;
        }
        else if (direction == 2) {
            currentY -= 1;
        }
        else if (direction == 3){ 
            currentX += 1;
        }
        else   {
            currentX -= 1;
        }
        System.out.println("(" + currentX + "," + currentY + ")" );
    }
        euclidean = (currentX * currentX) + (currentY * currentY);
        System.out.println("Squared distance = " + euclidean);
    }
}
