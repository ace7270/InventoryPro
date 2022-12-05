import java.io.IOException;
import java.util.ArrayList;

public class InventoryProMain {
    public static void main(String[] args) throws IOException {
        Controller cont = new Controller(new Model(new ArrayList<>()), new View());
        cont.addItem(new InventoryItem(123, "Water Bottle", 10, 15.00));
        cont.addItem(new InventoryItem(124, "Backpack", 50, 45.00));
        cont.saveData();
        cont.readData();
    }
}
