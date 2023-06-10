package avengers;
import java.util.*;
/**
 * Given a Set of Edges representing Vision's Neural Network, identify all of the 
 * vertices that connect to the Mind Stone. 
 * List the names of these neurons in the output file.
 * 
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * MindStoneNeighborNeuronsInputFile name is passed through the command line as args[0]
 * Read from the MindStoneNeighborNeuronsInputFile with the format:
 *    1. v (int): number of neurons (vertices in the graph)
 *    2. v lines, each with a String referring to a neuron's name (vertex name)
 *    3. e (int): number of synapses (edges in the graph)
 *    4. e lines, each line refers to an edge, each line has 2 (two) Strings: from to
 * 
 * Step 2:
 * MindStoneNeighborNeuronsOutputFile name is passed through the command line as args[1]
 * Identify the vertices that connect to the Mind Stone vertex. 
 * Output these vertices, one per line, to the output file.
 * 
 * Note 1: The Mind Stone vertex has out degree 0 (zero), meaning that there are 
 * no edges leaving the vertex.
 * 
 * Note 2: If a vertex v connects to the Mind Stone vertex m then the graph has
 * an edge v -> m
 * 
 * Note 3: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut:
 *     StdOut.setFile(outputfilename);
 *     //Call StdOut.print() for EVERY neuron (vertex) neighboring the Mind Stone neuron (vertex)
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/MindStoneNeighborNeurons mindstoneneighborneurons.in mindstoneneighborneurons.out
 *
 * @author Yashas Ravi
 * 
 */


public class MindStoneNeighborNeurons {
    
    public static void main (String [] args) {
        
    	if ( args.length < 2 ) {
            StdOut.println("Execute: java MindStoneNeighborNeurons <INput file> <OUTput file>");
            return;
        }
    	
    	// WRITE YOUR CODE HERE
        String MindStoneNeighborNeuronsInputFile = args[0];
        String MindStoneNeighborNeuronsOutputFile = args[1];

        StdIn.setFile(MindStoneNeighborNeuronsInputFile);
        int neuronCount = StdIn.readInt();
        HashSet<String> neurons = new HashSet<String>();

        //read neurons 
        for(int i = 0; i < neuronCount; i++) {
            neurons.add(StdIn.readString());
        }

        int synapsesCount = StdIn.readInt();
        HashMap<String, String> synapses = new HashMap<String, String>();
        
        //read synapses
        for( int i = 0; i < synapsesCount; i++) {
            synapses.put(StdIn.readString(), StdIn.readString());
        }

        //Create another hashSet called potential to store potential neurons that can be the mindstone 
        //iterate over the synapes using for each key, if the key exists in the pontential then remove from potential
        HashSet<String> potential = neurons;
        for(String key : synapses.keySet()) {
            potential.remove(key);
        }
        //now potential has only one value which is the mindstone 
        String mindStone = "";
        for(String i : potential) {
            mindStone = i;
        }

        //set output file before printing 
        StdOut.setFile(MindStoneNeighborNeuronsOutputFile);

        //iterate over the keys in the synapes hashMap
        //if the value in the hashap is equal to the mindStone then print the key as you iterate
        for(String key : synapses.keySet()) {
            if(synapses.get(key).equals(mindStone)) {
                StdOut.println(key);
            }
        }
    }

}
