import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    RNG rng = new RNG();
    private List<String> inventory;
    private String[] itemSlots = new String[6];

    public Inventory(){
        inventory = new ArrayList<>();
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void addItem(String itemName) {
        System.out.println("added item: " + itemName);
        inventory.add(itemName);
    }

    public void removeItem(String itemName) {
        inventory.remove(itemName);
    }

    public boolean containsItem(String itemName) {
        return inventory.contains(itemName);
    }

    public void equipItem(String itemName) {

    }
/**
    public String[] addRandom(String chestName)
    {
        String[] drops = rng.randomDrop(chestName);
        for (int i = 0; i < drops.length; i++)
        {
            inventory.add(drops[i]);
        }
        return drops;
    }
*/

}
