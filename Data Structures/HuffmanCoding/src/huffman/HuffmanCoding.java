package huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class contains methods which, when used together, perform the
 * entire Huffman Coding encoding and decoding process
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class HuffmanCoding {
    private String fileName;
    private ArrayList<CharFreq> sortedCharFreqList;
    private TreeNode huffmanRoot;
    private String[] encodings;

    /**
     * Constructor used by the driver, sets filename
     * DO NOT EDIT
     * @param f The file we want to encode
     */
    public HuffmanCoding(String f) { 
        fileName = f; 
    }

    /**
     * Reads from filename character by character, and sets sortedCharFreqList
     * to a new ArrayList of CharFreq objects with frequency > 0, sorted by frequency
     */
    //as you read in the next chracter update count in counter varible 
    //create arraylist of type Charfreq named sortedCharFreqList, add character in arraylist for every element 
    //with a nonzero counter
    //edge case of 1 element  
    public void makeSortedList() {
        StdIn.setFile(fileName);

        int[] counts = new int[128];
        int totalcount = 0;
        char currentCharacter = ' ';
	/* Your code goes here */
        while(StdIn.hasNextChar()) {

           currentCharacter = StdIn.readChar();
           counts[currentCharacter]++;
           totalcount++;
        }
        
        sortedCharFreqList = new ArrayList<CharFreq>();
        CharFreq currentCharFreq;
        for(int i = 0; i < counts.length; i++) {

            if(counts[i] > 0) {
                currentCharFreq = new CharFreq((char)i,counts[i]/(double)totalcount);
                sortedCharFreqList.add(currentCharFreq);

            }
        }
        if(sortedCharFreqList.size() == 1) {
            //add dummy node
            if ((int)currentCharacter == 127) { 
                currentCharacter = 0;
            } 
            else {
                currentCharacter = (char)((int)(currentCharacter) + 1);
            }
            currentCharFreq = new CharFreq(currentCharacter,0);
            sortedCharFreqList.add(currentCharFreq);
        }
        Collections.sort(sortedCharFreqList);
    }

    /**
     * Uses sortedCharFreqList to build a huffman coding tree, and stores its root
     * in huffmanRoot
     */
    public void makeTree() {

	/* Your code goes here */
    //create source queue and target queue 
    //use for each loop to iterate over arraylist and enqueue to source in increaseing order 
    //create tree node objects to enqueue 
    //while source queue is not empty and size of target queue is not equal to 1 
    //use peek method to access front nodes of soruce and target the comparen cherFreq objects and dequeue (do this twice)
    //if source.peek() <= Target.peek() then dequue source else dequeue Target. set this as left child (do this twice)
    //set second dequeued node to right child 
    //create new node with sum of left and right child probibilities 
    //enqueue new node to target 
    //store final target node in huffman root 
        Queue<TreeNode> source = new Queue<TreeNode>();
        Queue<TreeNode> target = new Queue<TreeNode>();
        TreeNode treeNode;
        TreeNode leftNode;
        TreeNode rightNode; 
        CharFreq middleCf;


        for (CharFreq cf : sortedCharFreqList) {
            treeNode = new TreeNode(cf, null, null);
            source.enqueue(treeNode);
        }
        while(!source.isEmpty() || (target.size() != 1)) {
            //left node 
            //comparing data in first node of source using compareTo operator with first node of target
            //compareTo returns 0 if equal, less than 0 if source is smaller 
            //if target is empty dequeue from source, if source is empty dequeue from target
            if(source.isEmpty()) {
                leftNode = target.dequeue();
            } else if(target.isEmpty()) {
                leftNode = source.dequeue();
            } else if(source.peek().getData().getProbOcc() <= target.peek().getData().getProbOcc()) { 
                //dequeue source and set to left child 
                leftNode = source.dequeue();
                
            }
            else {
                leftNode = target.dequeue();
            }

            //for the right node 
            if(source.isEmpty()) {
                rightNode = target.dequeue();
            } else if(target.isEmpty()) {
                rightNode = source.dequeue();
            } else if(source.peek().getData().getProbOcc() <= target.peek().getData().getProbOcc()) { 
                //dequeue source and set to right child 
                rightNode = source.dequeue();
                
            }
            else {
                rightNode = target.dequeue();
            }
            //new node with a null character and sum of probalities 
            middleCf = new CharFreq(null, leftNode.getData().getProbOcc() + rightNode.getData().getProbOcc());


            treeNode = new TreeNode(middleCf,leftNode,rightNode); 
            
            //enqueue treeNode to target queue 
            target.enqueue(treeNode);
        }

        huffmanRoot = target.dequeue();
    }

    //create sepreate method for pre order traversal called potEncodings
    //use pre order traversal to add 1 or 0 to characters in the huffman coding tree
    //traverse thorugh a recursive call, pre order traversal root,left,right 
    //method signiture: private void potEncodings(Treenode n, String prefix)
    private void potEncodings(TreeNode n, String prefix) {
        //if node is null then return;
        if(n == null) {
            System.out.println("leaf");
            return;
        }
        //checks if node is a dummy node 
        //if n.getData().getCharacter() == null 
        Character currentCharacter = n.getData().getCharacter();
        if(currentCharacter == null) {

            //potEnocdings(n.getLeft(),prefix + "0")
            //potEnocdings(n.getLeft(),prefix + "1")
            potEncodings(n.getLeft(),prefix + "0");
            potEncodings(n.getRight(),prefix + "1");
            
        }else { 
            //else not a dummy node 
            encodings[currentCharacter] = prefix;
        }

        

        
       

        
    }


    /**
     * Uses huffmanRoot to create a string array of size 128, where each
     * index in the array contains that ASCII character's bitstring encoding. Characters not
     * present in the huffman coding tree should have their spots in the array left null.
     * Set encodings to this array.
     */
     public void makeEncodings() {

	/* Your code goes here */
    //set string array of size 128 to store binary encodings 
    //call potEnocdings with the root and prefix is empty string 
        encodings = new String[128];
        potEncodings(huffmanRoot,"");

    }


    /**
     * Using encodings and filename, this method makes use of the writeBitString method
     * to write the final encoding of 1's and 0's to the encoded file.
     * 
     * @param encodedFile The file name into which the text file is to be encoded
     */
    public void encode(String encodedFile) {
        StdIn.setFile(fileName);

	/* Your code goes here */
    //read in each character from file 
    //create string and store encodings in string to be converted into bits 
    //call writeBitString method with the file being read and the string with the encodings 
    String encoString = "";
    char character = ' ';
    while(StdIn.hasNextChar()) {

        character = StdIn.readChar();
         encoString += encodings[character];
        
     }
     writeBitString(encodedFile, encoString);
    }
    
    /**
     * Writes a given string of 1's and 0's to the given file byte by byte
     * and NOT as characters of 1 and 0 which take up 8 bits each
     * DO NOT EDIT
     * 
     * @param filename The file to write to (doesn't need to exist yet)
     * @param bitString The string of 1's and 0's to write to the file in bits
     */
    public static void writeBitString(String filename, String bitString) {
        byte[] bytes = new byte[bitString.length() / 8 + 1];
        int bytesIndex = 0, byteIndex = 0, currentByte = 0;

        // Pad the string with initial zeroes and then a one in order to bring
        // its length to a multiple of 8. When reading, the 1 signifies the
        // end of padding.
        int padding = 8 - (bitString.length() % 8);
        String pad = "";
        for (int i = 0; i < padding-1; i++) pad = pad + "0";
        pad = pad + "1";
        bitString = pad + bitString;

        // For every bit, add it to the right spot in the corresponding byte,
        // and store bytes in the array when finished
        for (char c : bitString.toCharArray()) {
            if (c != '1' && c != '0') {
                System.out.println("Invalid characters in bitstring");
                return;
            }

            if (c == '1') currentByte += 1 << (7-byteIndex);
            byteIndex++;
            
            if (byteIndex == 8) {
                bytes[bytesIndex] = (byte) currentByte;
                bytesIndex++;
                currentByte = 0;
                byteIndex = 0;
            }
        }
        
        // Write the array of bytes to the provided file
        try {
            FileOutputStream out = new FileOutputStream(filename);
            out.write(bytes);
            out.close();
        }
        catch(Exception e) {
            System.err.println("Error when writing to file!");
        }
    }

    /**
     * Using a given encoded file name, this method makes use of the readBitString method 
     * to convert the file into a bit string, then decodes the bit string using the 
     * tree, and writes it to a decoded file. 
     * 
     * @param encodedFile The file which has already been encoded by encode()
     * @param decodedFile The name of the new file we want to decode into
     */
    public void decode(String encodedFile, String decodedFile) {
        StdOut.setFile(decodedFile);

	/* Your code goes here */
    //read from my encoded file using readBitString method 
    //readBitString reads into encoString 
    //access character at encoString and add all 1's and 0's from encoString 
    //iterating over encoString if 0 go left if 1 go right on the tree 
    //if you reach a character print out the character, dont print out dummy nodes
    //if print character go back to root then find next character to print out
        TreeNode node = huffmanRoot;
        char encoCharacter = ' ';
        String encoString = readBitString(encodedFile);
        for(int i = 0; i < encoString.length(); i++) {
            encoCharacter = encoString.charAt(i);
            if(encoCharacter == '0') {
                node = node.getLeft();
            }
            else  {
             node = node.getRight();
            }
            if(node.getData().getCharacter() != null) {
                StdOut.print(node.getData().getCharacter());
                node = huffmanRoot;
            }
        }
        
    }

    /**
     * Reads a given file byte by byte, and returns a string of 1's and 0's
     * representing the bits in the file
     * DO NOT EDIT
     * 
     * @param filename The encoded file to read from
     * @return String of 1's and 0's representing the bits in the file
     */
    public static String readBitString(String filename) {
        String bitString = "";
        
        try {
            FileInputStream in = new FileInputStream(filename);
            File file = new File(filename);

            byte bytes[] = new byte[(int) file.length()];
            in.read(bytes);
            in.close();
            
            // For each byte read, convert it to a binary string of length 8 and add it
            // to the bit string
            for (byte b : bytes) {
                bitString = bitString + 
                String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            }

            // Detect the first 1 signifying the end of padding, then remove the first few
            // characters, including the 1
            for (int i = 0; i < 8; i++) {
                if (bitString.charAt(i) == '1') return bitString.substring(i+1);
            }
            
            return bitString.substring(8);
        }
        catch(Exception e) {
            System.out.println("Error while reading file!");
            return "";
        }
    }

    /*
     * Getters used by the driver. 
     * DO NOT EDIT or REMOVE
     */

    public String getFileName() { 
        return fileName; 
    }

    public ArrayList<CharFreq> getSortedCharFreqList() { 
        return sortedCharFreqList; 
    }

    public TreeNode getHuffmanRoot() { 
        return huffmanRoot; 
    }

    public String[] getEncodings() { 
        return encodings; 
    }
}
