import com.sun.security.jgss.GSSUtil;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.lang.Character;
import java.sql.SQLException;

public class main {



        /* --Ein Beispiel Code für chest öffnen und item drop!!!
         Object[] drops = rng.randomDrop("chest1"); // öffnen von chest (man bekommt eine array von gedroppte items
         for (int i = 0; i < drops.length; i++) //durch gehen von array
         {
           System.out.println(drops[i]); //ausdrucken von item names
         }
         */


    public static void main(String[] args) throws SQLException {


        DB db = new DB();
        //System.out.println(db.getUser_ID("test", "123"));
        RNG rng = new RNG();
        Inventory inv = new Inventory();
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.openLoginWindow();



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
