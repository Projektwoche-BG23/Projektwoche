import java.sql.SQLException;

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

    public String[] addPotions() throws SQLException {
        return rng.potionDrop();
    }

    public String addRandom(String chapterName) throws SQLException {
        String drop = rng.randomDrop(chapterName);

        db.addItem(userID, Integer.parseInt(drop), 1);
        return drop;
    }
}