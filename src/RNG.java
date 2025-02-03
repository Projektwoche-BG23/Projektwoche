import  java.util.Random;
import java.util.Stack;

public class RNG {

    static ItemsDictionary dictionary = new ItemsDictionary();
    static Random rand = new Random();

    public static String[] randomDrop(String chest)
    {
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
    private static String[] chest1()
    {

        //Chest Inhalt
        Object[] chances = new Object[3];
        chances[0] = new Object[]{"healthPotion", 34}; //name, chance
        chances[1] = new Object[]{"manaPotion", 67};
        chances[2] = new Object[]{"luckPotion", 100};

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
                    droppedItems[i] = (String) chanceEntry[0];
                    break;  // Exit the loop once an item is dropped
                }
            }
        }

        return droppedItems;

    }

}