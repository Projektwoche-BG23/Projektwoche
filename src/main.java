public class main {
    static RNG rng = new RNG();
    static Inventory inv = new Inventory();
    public static void main(String[] args)
    {
        /* --Ein Beispiel Code für chest öffnen und item drop!!!
         Object[] drops = rng.randomDrop("chest1"); // öffnen von chest (man bekommt eine array von gedroppte items
         for (int i = 0; i < drops.length; i++) //durch gehen von array
         {
           System.out.println(drops[i]); //ausdrucken von item names
         }
         */

        rng.randomDrop("chest1");
        rng.randomDrop("chest1");
        rng.randomDrop("chest1");
        rng.randomDrop("chest1");

        System.out.println(inv.getInventory());
        //Game game = new Game();
    }

}
