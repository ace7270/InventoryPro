import java.io.IOException;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void addItem(InventoryItem item){
        model.addItem(item);
    }

    public void removeItem(InventoryItem item){
        model.removeItem(item);
    }

    public void removeItem(int itemID){
        model.removeItem(itemID);
    }

    public void sell(int itemID, int amtSold){
        model.getItem(itemID).sell(amtSold);
    }

    public void increaseStock(int itemID, int amtAdded){
        model.getItem(itemID).increaseStock(amtAdded);
    }

    public void changePrice(int itemID, double newPrice){
        model.getItem(itemID).changePrice(newPrice);
    }

    public void changeName(int itemID, String newName){
        model.getItem(itemID).changeName(newName);
    }

    public void saveData() throws IOException {
        model.saveData();
    }

    public void readData() throws IOException {
        model.readData();
    }

    public void showInventory(){
        view.showInventory(model);
    }
}
