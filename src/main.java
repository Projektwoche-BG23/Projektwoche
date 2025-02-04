import java.sql.SQLException;

public class main {


    static RNG rng = new RNG();


        /* --Ein Beispiel Code für chest öffnen und item drop!!!
         Object[] drops = rng.randomDrop("chest1"); // öffnen von chest (man bekommt eine array von gedroppte items
         for (int i = 0; i < drops.length; i++) //durch gehen von array
         {
           System.out.println(drops[i]); //ausdrucken von item names
         }
         */


    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        System.out.println("hello my namsssdae is ");

        DB db = new DB();
        System.out.println(db.getUser_ID("test", "123"));

        Game game = new Game();

    }

    public void Mathew() {
        System.out.println("Gg");
    }
}
