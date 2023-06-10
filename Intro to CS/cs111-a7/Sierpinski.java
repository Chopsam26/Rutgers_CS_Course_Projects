/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:Sammy Chopra sammy.chopra@rutgers.edu sc2364
 *
 *************************************************************************/

public class Sierpinski {

    
    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        //make variables for the sides of the triangle 
        //use formula for height to find the height of the triangle 
        //return the height 

	// WRITE YOUR CODE HERE
    double height = length * Math.sqrt(3)/2 ;
    return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length.
    //create the x and y arrays 
    // first draw standard polgyon that takes in the array of x and array of y 
    //use the calcucations to populate those arrays  
    public static void filledTriangle(double x, double y, double length) {

	// WRITE YOUR CODE HERE
    double[] xCalc = {x,x - (length/2),x + (length/2)};
    double[] yCalc = {y,y + height(length),y + height(length)};
    StdDraw.filledPolygon(xCalc, yCalc);
    
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    //use if statment to set boundary coniditon 
    //call sierpinksi method three times and decrease n by one each time
    public static void sierpinski(int n, double x, double y, double length) {

	// WRITE YOUR CODE HERE
    if (n > 0) 
         {
            filledTriangle(x, y, length);

            sierpinski(n - 1, x - length/2 ,y,  length/2);

            sierpinski(n - 1, x ,y + height(length),  length/2); 

            sierpinski(n - 1, x + length/2 ,y,  length/2);
        }

    
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline.

    //draw my equalitalral troangle using polygon method
    //create my x array holding the points 0  and 1 
    //create my y array holding the points 0 and 0
    //call sierpinksi method and test the values   

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    double[] xValues = {0,1,0.5};
    double[] yValues = {0,0,height(1)};
     int n = Integer.parseInt(args[0]);
     StdDraw.polygon(xValues, yValues);
     sierpinski(n, 0.5, 0, 0.5);

    }
}
