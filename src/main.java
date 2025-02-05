import java.sql.SQLException;

public class main {


    static RNG rng = new RNG();
    static Inventory inv = new Inventory();


        /* --Ein Beispiel Code für chest öffnen und item drop!!!
         Object[] drops = rng.randomDrop("chest1"); // öffnen von chest (man bekommt eine array von gedroppte items
         for (int i = 0; i < drops.length; i++) //durch gehen von array
         {
           System.out.println(drops[i]); //ausdrucken von item names
         }
         */


    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        System.out.println("hello my name is ");
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.openLoginWindow();
        DB db = new DB();
        System.out.println(db.getUser_ID("test", "123"));

        Game game = new Game();

        // Beispielcode für das Öffnen einer Kiste und das Erhalten von Items
        Object[] drops = rng.randomDrop("chest1"); 
        for (Object drop : drops) {
            System.out.println(drop); // Item-Namen ausgeben
        }

        // Chest drops (previous functionality)
        rng.randomDrop("chest1");
        rng.randomDrop("chest1");
        rng.randomDrop("chest1");
        rng.randomDrop("chest1");

        System.out.println(inv.getInventory());
    }

    public void mathew() {
        System.out.println("Gg");
    }
}
