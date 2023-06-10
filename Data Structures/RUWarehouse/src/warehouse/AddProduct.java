package warehouse;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

	// Use this file to test addProduct
    //write for loop to read each line first line is n 
    //create a product corepsonding to each line by caling add product 
    Warehouse w = new Warehouse();
    int n = StdIn.readInt();
    int currentDay;
    int productID;
    String productName;
    int initialItemStock;
    int intialItemDemand;
    for(int i = 0; i < n; i++) {

     currentDay = StdIn.readInt();
     productID = StdIn.readInt();
     productName = StdIn.readString();
     initialItemStock = StdIn.readInt();
     intialItemDemand = StdIn.readInt();
     w.addProduct(productID, productName, initialItemStock, currentDay, intialItemDemand);
    }
    StdOut.println(w);
    }
}
