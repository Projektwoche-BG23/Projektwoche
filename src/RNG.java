import java.sql.SQLException;
import  java.util.Random;
import java.util.Stack;
import java.util.Random;

public class RNG {

    static Random rand = new Random();
    static  DB db = new DB();

    public static Object[] randomDrop(String chest) throws SQLException {
        switch (chest){
            default:
                return null;
            case "chest1":
                return chest1();
        }
    }

    /**
     * Gibt an, wie viele Items der Spieler bekommen soll
     * @return Anzahl Drops
     */
    private static int itemDropCount() {
        int chanceFor1 = 50; // 50%
        int chanceFor2 = 80; // 30%
        int chanceFor3 = 90; // 10%
        int chanceFor0 = 100; // 10%

        int chance = rand.nextInt(100);

        if (chance < chanceFor1) {
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
     * Gibt an, welche Items der Spieler aus chest1 bekommen soll
     */
    private static Object[] chest1() throws SQLException {

        //Chest Inhalt
        Object[] chances = new Object[3];
        chances[0] = new Object[]{1, 34}; // ItemID, chance
        chances[1] = new Object[]{2, 67};
        chances[2] = new Object[]{3, 100};

        // Item Anzahl bestimmen
    /**
        // Item Anzahl bestimmen
        int itemRate = itemDropCount();
        Object[] droppedItems = new Object[itemRate];

        for (int i = 0; i < itemRate; i++) {
            int chance = rand.nextInt(100);

            for (Object[] chanceEntry : chances) {
                int dropChance = (int) chanceEntry[1]; // Drop Wahrscheinlichkeit

                if (chance < dropChance) {
                    Object[] droppedItem = dictionary.items((String) chanceEntry[0]); // Item aus dem Dictionary holen
                    droppedItems[i] = (droppedItem != null) ? (String) droppedItem[0] : "Unknown Item";
                    break; // Sobald ein Item gefunden wurde, aus der Schleife ausbrechen
                }
            }
        }
*/
        return chances;
    }
}
