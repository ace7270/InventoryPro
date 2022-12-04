import java.util.ArrayList;

public class Model {
    protected ArrayList<InventoryItem> inventory;

    public Model(ArrayList<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public void addItem(InventoryItem item){
        inventory.add(item);
    }

    public void removeItem(InventoryItem item){
        inventory.remove(item);
    }

    public void removeItem(int itemID){
        inventory.removeIf(item -> item.itemID == itemID);
    }

    public InventoryItem getItem(int itemID){
        for (InventoryItem item: inventory){
            if (item.itemID == itemID){
                return item;
            }
        }
        return null;
    }
}
