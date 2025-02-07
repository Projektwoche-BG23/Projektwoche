import java.sql.SQLException;
import  java.util.Random;
import java.util.Stack;
import java.util.Random;

public class RNG {

    static Random rand = new Random();
    static  DB db = new DB();

    public static String randomDrop(String chest) throws SQLException {
        switch (chest){
            case "chapter1":
                return chest1();
            case "chapter2":
                return chest2();
            case "chapter3":
                return chest3();
            case "chapter4":
                return chest4();
            default:
                return null;

        }
    }

    public static String[] potionDrop() throws SQLException {
        return potions();
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

    private static String[] potions() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[4];
        chances[0] = new Object[]{26, 15}; // ItemID, chance
        chances[1] = new Object[]{28, 40};
        chances[2] = new Object[]{27, 70};
        chances[3] = new Object[]{28, 100};

        int count = itemDropCount();

        String[] drops = new String[count];

        for (int i = 0; i < count; i++)
        {

            int chance = rand.nextInt(100);

            for (Object item : chances) {

                Object[] chanceEntry = (Object[]) item;

                int dropChance = (int) chanceEntry[1];

                if (chance <= dropChance) {
                    Object[] droppedItem = db.itemInfo((Integer) chanceEntry[0]);
                    drops[i] = (String )droppedItem[0];
                }

            }

        }

        return drops;

    }

    private static String chest1() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[6];
        chances[0] = new Object[]{2, 16}; // ItemID, chance
        chances[1] = new Object[]{5, 32};
        chances[2] = new Object[]{13, 48};
        chances[3] = new Object[]{7, 65};
        chances[4] = new Object[]{10, 82};
        chances[5] = new Object[]{16, 100};

        // Item Anzahl bestimmen

        // Item Anzahl bestimmen
        int itemRate = 1;

        String id = "";

        int chance = rand.nextInt(100);

        for (Object item : chances) {
            Object[] chanceEntry = (Object[]) item;

            int dropChance = (int) chanceEntry[1];

            if (chance <= dropChance) {
                Object[] droppedItem = db.itemInfo((Integer) chanceEntry[0]);
                id = (String )droppedItem[0];
                return id;

            }

        }

        return id;

    }

    private static String chest2() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[6];
        chances[0] = new Object[]{19, 15}; // ItemID, chance
        chances[1] = new Object[]{17, 30};
        chances[2] = new Object[]{4, 46};
        chances[3] = new Object[]{3, 63};
        chances[4] = new Object[]{11, 80};
        chances[5] = new Object[]{8, 100};

        // Item Anzahl bestimmen

        // Item Anzahl bestimmen
        int itemRate = 1;

        String id = "";

        int chance = rand.nextInt(100);

        for (Object item : chances) {
            Object[] chanceEntry = (Object[]) item;

            int dropChance = (int) chanceEntry[1];

            if (chance <= dropChance) {
                Object[] droppedItem = db.itemInfo((Integer) chanceEntry[0]);
                id = (String )droppedItem[0];
                return id;

            }

        }

        return id;

    }

    private static String chest3() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[5];
        chances[0] = new Object[]{21, 15}; // ItemID, chance
        chances[1] = new Object[]{22, 30};
        chances[2] = new Object[]{6, 55};
        chances[3] = new Object[]{14, 75};
        chances[4] = new Object[]{15, 100};

        // Item Anzahl bestimmen

        // Item Anzahl bestimmen
        int itemRate = 1;

        String id = "";

        int chance = rand.nextInt(100);

        for (Object item : chances) {
            Object[] chanceEntry = (Object[]) item;

            int dropChance = (int) chanceEntry[1];

            if (chance <= dropChance) {
                Object[] droppedItem = db.itemInfo((Integer) chanceEntry[0]);
                id = (String )droppedItem[0];
                return id;

            }

        }

        return id;

    }

    private static String chest4() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[5];
        chances[0] = new Object[]{20, 15}; // ItemID, chance
        chances[1] = new Object[]{23, 30};
        chances[2] = new Object[]{12, 50};
        chances[3] = new Object[]{9, 75};
        chances[4] = new Object[]{18, 100};

        // Item Anzahl bestimmen

        // Item Anzahl bestimmen
        int itemRate = 1;

        String id = "";

        int chance = rand.nextInt(100);

        for (Object item : chances) {
            Object[] chanceEntry = (Object[]) item;

            int dropChance = (int) chanceEntry[1];

            if (chance <= dropChance) {
                Object[] droppedItem = db.itemInfo((Integer) chanceEntry[0]);
                id = (String )droppedItem[0];
                return id;

            }

        }

        return id;

    }

}
