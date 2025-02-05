import java.sql.SQLException;

public class Main {

    static Inventory inv = new Inventory();

    public static void main(String[] args) throws SQLException {

        DB db = new DB();
        //System.out.println(db.getUser_ID("test", "123"));

        //Game game = new Game();

        // Beispielcode für das Öffnen einer Kiste und das Erhalten von Items
        String[] drops = inv.addRandom("chest1");
        for (int i = 0; i < drops.length; i++) {
            inv.equipItem(drops[i]);
        }
        System.out.println(inv.getInventory());
        String[] equips = inv.getEquiped();
        for (int j = 0; equips.length > j; j++) {
            System.out.println(equips[j]);
        }

    }

}

