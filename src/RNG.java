import  java.util.Random;

public class RNG {

    static ItemsDictionary dictionary = new ItemsDictionary();
    static Random rand = new Random();

    public static void randomDrop(String chest)
    {
        switch (chest){
            case "chest1":
                chest1();
        }
    }

    /**
     * gibt an wie viele item der spieler bekommen soll
     * @return anzahl Drops
     */
    static private int itemDropCount()
    {
        int chanceFor1 = 50;
        int chanceFor2 = 80;
        int chanceFor3 = 90;
        int chanceFor0 = 100;

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
    private static void chest1()
    {
        //Chest Inhalt
        Object[] chances = new Object[3];
        chances[0] = new Object[]{"healthPotion", 33}; //name, chance
        chances[1] = new Object[]{"manaPotion", 66};
        chances[2] = new Object[]{"luckPotion", 100};

        int itemRate = itemDropCount();
        Object[] drops = new Object[itemRate];

        for (int i = 0; i < itemRate; i++)
        {

            int chance = rand.nextInt(100);

            for (Object item : chances) {
                Object[] chanceEntry = (Object[]) item;
                int dropChance = (int) chanceEntry[1];  // Get the chance value (second element)

                // Check if the random chance is less than the drop chance
                if (chance < dropChance) {
                    Object[] droppedItem = dictionary.items((String) chanceEntry[0]);  // Get item using its name
                    System.out.println("Name: " + droppedItem[0]);
                    System.out.println("Description: " + droppedItem[1]);
                    System.out.println("Stats: " + droppedItem[2]);
                    break;  // Exit the loop once an item is dropped
                }
            }
        }

    }

}