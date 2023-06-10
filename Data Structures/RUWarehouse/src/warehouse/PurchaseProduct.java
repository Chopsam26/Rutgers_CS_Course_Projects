package warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

	// Use this file to test purchaseProduct
    Warehouse w = new Warehouse();
    int n = StdIn.readInt();
    String queryType; 
    int currentDay;
    int productID;
    String productName;
    int initialItemStock;
    int intialItemDemand;
    for(int i = 0; i < n; i++) {
        queryType = StdIn.readString();
        if(queryType.equals("add") ) {
            currentDay = StdIn.readInt();
            productID = StdIn.readInt();
            productName = StdIn.readString();
            initialItemStock = StdIn.readInt();
            intialItemDemand = StdIn.readInt();
            w.addProduct(productID, productName, initialItemStock, currentDay, intialItemDemand);
        }
        else if(queryType.equals("restock")) {
            productID = StdIn.readInt();
            initialItemStock = StdIn.readInt();
            w.restockProduct(productID, initialItemStock);
        }
        else if(queryType.equals("delete")) {
            productID = StdIn.readInt();
            w.deleteProduct(productID);
        }
        else if(queryType.equals("purchase")) {
            currentDay = StdIn.readInt();
            productID = StdIn.readInt();
            intialItemDemand = StdIn.readInt();
            w.purchaseProduct(productID,currentDay,intialItemDemand);
        }
    }
    StdOut.println(w);
    }
}
