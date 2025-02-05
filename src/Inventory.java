import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    DB db = new DB();
    RNG rng = new RNG();
    private String[] itemSlots = new String[6];

    int userID;

    public void equipItem(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        itemSlots[slotID - 1] = itemID;

    }

    public void unequipItem(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //item Id
        int slotID = Integer.parseInt((String) itemAttributes[3]); //equip slot
        itemSlots[slotID - 1] = "0";

    }

    public boolean hasItem(String itemID) throws SQLException {

        String[] itemsList = db.getInventory(userID);


        return itemsList[Integer.parseInt(itemID)] != null;
    }

    public boolean consum(String itemID) throws SQLException {

        Object[] itemAttributes = db.itemInfo(Integer.parseInt(itemID)); //Gets item attributes
        db.addItem(userID, Integer.parseInt(itemID), -1);

        return true;

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