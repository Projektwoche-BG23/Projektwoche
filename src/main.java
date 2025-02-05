import com.sun.security.jgss.GSSUtil;

import java.sql.SQLException;

public class main {
    static Inventory inv = new Inventory();

    public static void main(String[] args) throws SQLException {


        DB db = new DB();
        //System.out.println(db.getUser_ID("test", "123"));

        //Game game = new Game();


        inv.setUserID(10);
        inv.unequipItem("2");
        /**
         String[] drops = inv.addRandom("chest1");
         for (int i = 0; i < drops.length; i++) {
         System.out.println(drops[i]);
         }
        System.out.println(inv.hasItem("2"));
        inv.consum("2");
        System.out.println(inv.hasItem("2"));
*/
    }

    public void mathew() {
        System.out.println("Gg");
    }
}
