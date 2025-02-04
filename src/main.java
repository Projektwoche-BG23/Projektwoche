import java.sql.SQLException;

public class Main {
    static RNG rng = new RNG();

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        System.out.println("hello my name is ");

        DB db = new DB();
        System.out.println(db.getUser_ID("test", "123"));

        Game game = new Game();

        // Beispielcode für das Öffnen einer Kiste und das Erhalten von Items
        Object[] drops = rng.randomDrop("chest1"); 
        for (Object drop : drops) {
            System.out.println(drop); // Item-Namen ausgeben
        }
    }

    public void mathew() {
        System.out.println("Gg");
    }
}

