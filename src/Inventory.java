import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    DB db = new DB();
    RNG rng = new RNG();
    private String[] itemSlots = new String[6];

    int userID;

    public void setUserID(int id) {
        userID = id;
    }

    public void equipItem(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        db.equipToItemSlot(userID, slotID, Integer.parseInt(itemID));
        itemSlots[slotID] = itemID;

    }

    public void unequipItem(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        db.equipToItemSlot(userID, slotID, 0);
        itemSlots[slotID] = itemID;

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

    public boolean consum(String itemID,Character player) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //Gets item attributes

        if (hasItem(itemID))
        {
            db.addItem(userID, Integer.parseInt(itemID), -1);
            player.usePotion(itemID);
            System.out.println("consumed successfully");

            return true;
        }else{
            return false;
        }

    }

    public String[] addRandom(String chestName) throws SQLException {
        String[] drops = rng.randomDrop(chestName);
        for (int i = 0; i < drops.length; i++)
        {
            db.addItem(userID, Integer.parseInt(drops[i]), 1);
        }
        return drops;
    }
}