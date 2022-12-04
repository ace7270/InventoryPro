public class InventoryItem {
    protected int itemID;
    protected String itemName;
    protected int currentStock;
    protected double price;

    public InventoryItem(int itemID, String itemName, int currentStock, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.currentStock = currentStock;
        this.price = price;
    }


}
