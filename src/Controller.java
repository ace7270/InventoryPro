public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
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
}
