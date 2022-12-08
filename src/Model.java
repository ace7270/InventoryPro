import java.io.*;
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


    public void saveData() throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inventory.dat"));
            oos.writeObject(inventory);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readData() throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Aaron\\Desktop\\School\\PSU Year 1\\Sem 1\\SWENG311\\InventoryPro\\inventory.dat"));
            inventory = (ArrayList<InventoryItem>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder inventoryString = new StringBuilder();
        for (InventoryItem item: inventory){
            inventoryString.append(item);
            inventoryString.append("\n\n");
        }
        return inventoryString.toString();
    }
}
