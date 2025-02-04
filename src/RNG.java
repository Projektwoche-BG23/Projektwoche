import java.util.Random;

public class RNG {

    static ItemsDictionary dictionary = new ItemsDictionary();
    static Random rand = new Random();

    public static String[] randomDrop(String chest) {
        switch (chest) {
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
    private static String[] chest1() {
        // Chest Inhalt
        Object[][] chances = {
            {"healthPotion", 34}, // Name, Chance
            {"manaPotion", 67},
            {"luckPotion", 100}
        };

        // Item Anzahl bestimmen
        int itemRate = itemDropCount();
        String[] droppedItems = new String[itemRate];

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

        return droppedItems;
    }
}
