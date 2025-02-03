import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<String> inventory;

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addItem(String itemName) {
        inventory.add(itemName);
        System.out.println(itemName + " added");
    }

    public void removeItem(String itemName) {
        inventory.remove(itemName);
    }

    public boolean containsItem(String itemName) {
        return inventory.contains(itemName);
    }

    public void addRandom(String chestName)
    {

    }

}
