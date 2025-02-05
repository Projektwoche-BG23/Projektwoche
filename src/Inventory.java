import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    DB db = new DB();
    RNG rng = new RNG();
    private List<String> inventory;
    private String[] itemSlots = new String[6];

    public Inventory(){
        inventory = new ArrayList<>();

    }

    public List<String> getInventory() {
        return inventory;
    }

    public String[] getEquiped() {
        return itemSlots;
    }

    public void addItem(String itemID) {
        System.out.println("added item: " + itemID);
        inventory.add(itemID);
    }

    public void removeItem(String itemName) {
        inventory.remove(itemName);
    }

    public boolean containsItem(String itemName) {
        return inventory.contains(itemName);
    }

    public void equipItem(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID));

        System.out.println("ItemID: " + itemID);

        int slotID = Integer.parseInt((String) itemAttributes[3]);
        System.out.println("SlotID: " + slotID);
        itemSlots[slotID - 1] = itemID;

    }

    public String[] addRandom(String chestName) throws SQLException {
        String[] drops = rng.randomDrop(chestName);
        for (int i = 0; i < drops.length; i++)
        {
            addItem(drops[i]);
        }
        return drops;
    }

}
