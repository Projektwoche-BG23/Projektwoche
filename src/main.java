//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.SQLException;

public class main {

    static RNG rng = new RNG();
    static Inventory inv = new Inventory();

    public main() {
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello");
        System.out.println("hello my name is ");
        DB db = new DB();
        System.out.println(db.getUser_ID("test", "123"));
        new Game();
        RNG var10000 = rng;
        Object[] drops = RNG.randomDrop("chest1");
        Object[] var4 = drops;
        int var5 = drops.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Object drop = var4[var6];
            System.out.println(drop);
        }

        var10000 = rng;
        RNG.randomDrop("chest1");
        var10000 = rng;
        RNG.randomDrop("chest1");
        var10000 = rng;
        RNG.randomDrop("chest1");
        var10000 = rng;
        RNG.randomDrop("chest1");
        System.out.println(inv.getInventory());
    }

    public void mathew() {
        System.out.println("Gg");
    }
}
