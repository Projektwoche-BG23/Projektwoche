import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Inventory {

    DB db = new DB();
    RNG rng = new RNG();
    private String[] itemSlots = new String[6];

    int userID;

    public void setUserID(int id) {
        userID = id;
    }

    private int nameToID(String name) throws SQLException {

        for (int i = 0; i < itemSlots.length; i++) {

            String equipedID = itemSlots[i];
            Object[] attributes = db.itemInfo(Integer.parseInt(equipedID));
            String equipedName = (String) attributes[1];

            if (equipedName.equals(name)) {

                return (int) attributes[0];

            }

        }

        return 0;

    }

    public void equipItem(String name) throws SQLException {

        int itemID = nameToID(name);

        Object[] itemAttributes = db.itemInfo(itemID); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        db.equipToItemSlot(userID, slotID, itemID);
        itemSlots[slotID] = (String) itemAttributes[0];

    }

    public void unequipItem(String name) throws SQLException {

        int itemID = nameToID(name);

        Object[] itemAttributes = db.itemInfo(itemID); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        db.equipToItemSlot(userID, slotID, 0);
        itemSlots[slotID] = "0";

    }

    public void addItem(String itemID) throws SQLException {
        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID));
        int slotID = Integer.parseInt((String) itemAttributes[0]);
        db.addItem(userID, slotID, Integer.parseInt(itemID));
    }

    public boolean hasItem(String itemID) throws SQLException {

        String[] itemsList = db.getInventory(userID);

        int count = Integer.parseInt(itemsList[Integer.parseInt(itemID)]) ;

        if (count > 0)
        {
            return true;
        }else
        {
            return false;
        }

    }


    public boolean consum(String itemID, Player player) throws SQLException {
        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //Gets item attributes

        if (hasItem(itemID))
        {
            db.addItem(userID, Integer.parseInt(itemID), -1);
            //player.usePotion(itemID);
            System.out.println("consumed successfully");
            return true;
        }else{
            return false;
        }

    }

    public List<String> addPotions() throws SQLException {
        String[] potions = rng.potionDrop();
        List<String> items= List.of(potions);

        for (String item : items) {

            Object[] attributes = db.itemInfo(Integer.parseInt(item));
            String itemName = (String) attributes[1];

            item = itemName;

        }

        return items;
    }

    public String addRandom(String chapterName) throws SQLException {
        String drop = rng.randomDrop(chapterName);

        db.addItem(userID, Integer.parseInt(drop), 1);

        Object[] attributes = db.itemInfo(Integer.parseInt(drop));
        drop = (String) attributes[1];

        return drop;
    }
}