package avengers;

import java.util.ArrayList;

/**
 * Given an adjacency matrix, use a random() function to remove half of the nodes. 
 * Then, write into the output file a boolean (true or false) indicating if 
 * the graph is still connected.
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * PredictThanosSnapInputFile name is passed through the command line as args[0]
 * Read from PredictThanosSnapInputFile with the format:
 *    1. seed (long): a seed for the random number generator
 *    2. p (int): number of people (vertices in the graph)
 *    2. p lines, each with p edges: 1 means there is a direct edge between two vertices, 0 no edge
 * 
 * Note: the last p lines of the PredictThanosSnapInputFile is an ajacency matrix for
 * an undirected graph. 
 * 
 * The matrix below has two edges 0-1, 0-2 (each edge appear twice in the matrix, 0-1, 1-0, 0-2, 2-0).
 * 
 * 0 1 1 0
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 
 * Step 2:
 * Delete random vertices from the graph. You can use the following pseudocode.
 * StdRandom.setSeed(seed);
 * for (all vertices, go from vertex 0 to the final vertex) { 
 *     if (StdRandom.uniform() <= 0.5) { 
 *          delete vertex;
 *     }
 * }
 * Answer the following question: is the graph (after deleting random vertices) connected?
 * Output true (connected graph), false (unconnected graph) to the output file.
 * 
 * Note 1: a connected graph is a graph where there is a path between EVERY vertex on the graph.
 * 
 * Note 2: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, isConnected is true if the graph is connected,
 *   false otherwise):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(isConnected);
 * 
 * @author Yashas Ravi
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/PredictThanosSnap predictthanossnap.in predictthanossnap.out
*/

public class PredictThanosSnap {
	 //
    private static void dfs(int[][] adjMatrix, int nodeV, ArrayList<Integer> connectedVertices ) {
        connectedVertices.add(nodeV);
        for(int nodeW = 0; nodeW < adjMatrix.length; nodeW++) {

        //find other nodes connected to nodeV , this is when adjMatrix[nodeV][nodeW] == 1
        if(adjMatrix[nodeV][nodeW] == 1) {
            
            if(!connectedVertices.contains(nodeW)) {  
                dfs(adjMatrix, nodeW, connectedVertices);
            }
        }
        }

    }
    public static void main (String[] args) {
 
        if ( args.length < 2 ) {
            StdOut.println("Execute: java PredictThanosSnap <INput file> <OUTput file>");
            return;
        }
        
    	// WRITE YOUR CODE HERE
        //set file name and read in file inputs
        String PredictThanosSnapInputFile = args[0];
        String PredictThanosSnapOutputFile = args[1];
        StdIn.setFile(PredictThanosSnapInputFile);
        //read the seed into a long 
        long seed = StdIn.readLong();
        //read number of vertices 
        int numVertices = StdIn.readInt();
        //create a 2d array called orignalAm 
        int[][] originalAM = new int[numVertices][numVertices];
        //read in adjecy matrix to that array 
        for(int i = 0; i < numVertices; i++) {

            for(int j = 0; j < numVertices; j++) {

                originalAM[i][j] = StdIn.readInt();

            }   
        }
        // randomly select half the nodes to be saved by first setting seed and save in arraylist called chosen of size n/2 (This is for the list of nodes that will remain) 
        StdRandom.setSeed(seed);
        ArrayList<Integer> chosen = new ArrayList<Integer>();
        for(int i = 0; i < numVertices; i++) {
                if(StdRandom.uniform() > 0.5) {
                    chosen.add(i);
                }
        }
        //populate a second 2d array adjecy matrix called newAM of int to save the new adjenecy matrix by iterating over newAM length in nested for loop and setting the newAM[i][j] equal to orignal[x][y]
        int x = 0; 
        int y = 0;
        int[][] newAM = new int[chosen.size()][chosen.size()];
        for(int i = 0; i < chosen.size(); i++) {
             x = chosen.get(i);   
             for(int j = 0; j < chosen.size(); j++) {
                y = chosen.get(j);
                newAM[i][j] = originalAM[x][y];
             }
        }
        // conduct depth first search tracking visited nodes in a list called connected
        ArrayList<Integer> connected = new ArrayList<Integer>(); 
        dfs(newAM, 0, connected);
        //if the length of connected equals n/2 then reutrn true otherise return false
       StdOut.setFile(PredictThanosSnapOutputFile);
        if(connected.size() == chosen.size()) {
            StdOut.print("true");
        } else {
            StdOut.print("false");
        }
    }
    
}
