import java.sql.SQLException;
import  java.util.Random;
import java.util.Stack;
import java.util.Random;

public class RNG {

    static Random rand = new Random();
    static  DB db = new DB();

    public static String[] randomDrop(String chest) throws SQLException {
        switch (chest){
            default:
                return null;
            case "chest1":
                return chest1();
        }
    }

    /**
     * gibt an wie viele item der spieler bekommen soll
     * @return anzahl Drops
     */
    static private int itemDropCount()
    {
        int chanceFor1 = 50; //50%
        int chanceFor2 = 80; //30%
        int chanceFor3 = 90; //10%
        int chanceFor0 = 100; //10%

        int chance = rand.nextInt(100);

        if (chance < chanceFor1)
        {
            return 1;
        } else if (chance < chanceFor2) {
            return 2;
        } else if (chance < chanceFor3) {
            return 3;
        } else {
            return 0;
        }

    }

    /**
     * gibt an welche item der spieler aus chest1 bekommen soll
     */
    private static String[] chest1() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[3];
        chances[0] = new Object[]{1, 34}; // ItemID, chance
        chances[1] = new Object[]{2, 67};
        chances[2] = new Object[]{3, 100};

        //Item anzahl bestimmen
        int itemRate = itemDropCount();
        String[] droppedItems = new String[itemRate];

        for (int i = 0; i < itemRate; i++)
        {

            int chance = rand.nextInt(100);

            for (Object item : chances) {
                Object[] chanceEntry = (Object[]) item;
                int dropChance = (int) chanceEntry[1];  // Get the chance value (second element)

                // Check if the random chance is less than the drop chance
                if (chance < dropChance) {
                    int itemID = (int) chanceEntry[0];
                    Object[] droppedItem = db.itemInfo(itemID);
                    droppedItems[i] = (String) droppedItem[0];
                    break;  // Exit the loop once an item is dropped
                }
            }
        }

        return droppedItems;

    }

}