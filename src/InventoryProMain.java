import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryProMain {
    public static void main(String[] args) throws IOException {
        Controller cont = new Controller(new Model(new ArrayList<>()), new View());
        if (new File("C:\\Users\\Aaron\\Desktop\\School\\PSU Year 1\\Sem 1\\SWENG311\\InventoryPro\\inventory.dat").exists()){
            cont.readData();
        }
        else {
            cont.addItem(new InventoryItem(1, "Water Bottle", 10, 15.00));
            cont.addItem(new InventoryItem(2, "Backpack", 50, 45.00));
            cont.addItem(new InventoryItem(3, "Frying Pan", 100, 25.00));
            cont.addItem(new InventoryItem(4, "Wrapping Paper", 250, 5.00));
            cont.addItem(new InventoryItem(5, "Silverware", 1000, 10.00));
            cont.addItem(new InventoryItem(6, "Throw Pillow", 50, 15.00));
            cont.addItem(new InventoryItem(7, "Storage Tote", 150, 25.00));
            cont.addItem(new InventoryItem(8, "Pencils", 500, 2.00));
        }
        cont.showInventory();


    }
}
