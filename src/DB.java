import java.sql.*;
import java.util.Objects;

/**
 * Class to access the Database. We will add more features in the future.
 * Every Character has a unique user_ID, it is needed to access the Character Information.
 */
public class DB {
    // Login information of the Database
    private static final String URL = "jdbc:mysql://192.168.102.39:3306/projektwoche-2025"; // IP may be changed later.
    private static final String USER = "everyone";
    private static final String PASSWORD = "";

    // Variables to use the database
    private Connection con;
    private PreparedStatement stmt;
    private String sql;
    private ResultSet rs;


    // Constructor that connects to the database
    public DB() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            throw new RuntimeException(e);
        }
    }


    /**
     * Checks if the login information is correct and returns the user_ID
     *
     * @param username Username of the Player
     * @param password Password of the Player
     * @return user_ID if correct, 0 if incorrect
     */
    public int getUser_ID(String username, String password) throws SQLException {
        int user_ID = 0;
        sql = "SELECT * FROM Login WHERE name=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        while (rs.next()) {
            if (Objects.equals(rs.getString(2), password)) {
                user_ID = rs.getInt(3);
            } else {
                System.out.println("Password wrong");
            }
        }
        return user_ID;
    }


    /**
     * Creates a new account in the database
     *
     * @param username Desired username
     * @param password Desired password
     * @throws SQLException if the query fails
     */
    public boolean createAcc(String username, String password) throws SQLException {
        // Check if username is already taken.
        sql = "SELECT * FROM login WHERE name = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return false;
        }

        // create new login-line / account
        sql = "INSERT INTO Login (name, password) VALUES (?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.executeUpdate();

        // get user_ID of the acc we just created
        sql = "SELECT * FROM login WHERE name = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        int user_ID = 0;
        if (rs.next()) {
            user_ID = Integer.parseInt(rs.getString(3));
        }

        // Create new gamefiles line.
        sql = "INSERT INTO gamefiles (user_ID, Location) VALUES (?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, user_ID);
        stmt.setString(2, "anfangsSzene");
        stmt.executeUpdate();

        // Create new inventory line
        sql = "INSERT INTO inventory (user_ID) VALUES (?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, user_ID);
        stmt.executeUpdate();

        // Create new equipped_items line
        sql = "INSERT INTO equipped_items (user_ID) VALUES (?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, user_ID);
        stmt.executeUpdate();

        return true;
    }



        // get user_ID of the acc we just created
        sql = "SELECT * FROM login WHERE name = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        int user_ID = 0;
        if (rs.next()) {
            user_ID = Integer.parseInt(rs.getString(3));
        }

        // Create new gamefiles line.
        sql = "INSERT INTO gamefiles (user_ID, Location, important_decision_A) VALUES (?, ?, ?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, user_ID);
        stmt.setString(2, "anfangsSzene");
        stmt.setInt(3, 0);
        stmt.executeUpdate();

        // Create new inventory space
        sql = "INSERT INTO inventory (user_ID, slot_1, slot_2, slot_3, slot_4, slot_5, slot_6, slot_7, slot_8, slot_9, slot_10, slot_11, slot_12, slot_13, slot_14, slot_15, slot_16, slot_17, slot_18, slot_19) VALUES (?, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, user_ID);
        stmt.executeUpdate();

        return true;
    }
    /*
     * Method to get the stats of items
     * @param itemID the id of the target item
     * returns a String arry of information
     * 0 = item_ID
     * 1 = item_name
     * 2 = path to image
     * 3 = defence value
     * 4 = special_defence value
     * 5 = agility value
     * 6 = health value
     * 7 = health_regen value
     * 8 = mana value
     * 9 = mana_regen value
     * 10 = magic_power value
     * 11 = luck value
     * 12 = damage value
     * 13 = strength value
    /*
     * Method to get the stats of items
     * @param itemID the id of the target item
     * returns a String array of information
     * 0 = item_ID
     * 1 = item_name
     * 2 = path to image
     * 3 = slot_ID:   1 = Brustpanzer, 2 = Hose, 3 = Waffe, 4 = Offhand, 5 = Accessory
     * 4 = defence value
     * 5 = special_defence value
     * 6 = agility value
     * 7 = health value
     * 8 = health_regen value
     * 9 = mana value
     * 10 = mana_regen value
     * 11 = magic_power value
     * 12 = luck value
     * 13 = damage value
     * 14 = strength value
     *
     * Usage example:
     * Sting[] item = db.itemInfo(1);
     * int defence = Integer.parseInt(item[4]);
     */

        public String[] itemInfo(int itemID) throws SQLException {
        sql = "SELECT * FROM items WHERE item_ID=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, itemID);
        rs = stmt.executeQuery();
        String[] item = new String[14];
        while (rs.next()) {
            for (int i = 0; i < 14; i++) {
                item[i] = rs.getString(i + 1);
            }
        }
        return item;
    }

    /*     * Indicates how much the player has of a certain item
     * @param userID: userID of the player
     */
        public String[] getInventory(int userID) throws SQLException {
        sql = "SELECT * FROM inventory WHERE user_ID=?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, userID);
        rs = stmt.executeQuery();
        String[] inv = new String[20];
        while (rs.next()) {
            for (int i = 0; i < 14; i++) {
                inv[i] = rs.getString(i + 1);
            }
        }
        return inv;
    }
            /**
             * Retrieves information about the player's position and decisions
             * @param userID: userID of the player
             */

        public String[] playerInfo ( int userID) throws SQLException
        {
            sql = "SELECT * FROM gamefiles WHERE user_ID=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();
            String[] player = new String[3];
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    player[i] = rs.getString(i + 1);
                }
            }
            return player;

        }

        /**
         * Tells what item ist equipped in which slot
         * @param user_ID: user_ID of teh player
         */

        public String[] getEquipped ( int user_ID) throws SQLException
        {
            sql = "SELECT * FROM equipped_items WHERE user_ID=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user_ID);
            rs = stmt.executeQuery();
            String[] equipped = new String[6];
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    equipped[i] = rs.getString(i + 1);
                }
            }
            return equipped;
        }


        /*
         * Equip an item to a item slot
         * @param user_ID: user_ID of teh palyer
         * @param equip_slot: which slot where to equip the item
         * @param item_ID: item_ID of the item that gets equipped
         */

        public void equipToItemSlot ( int user_ID, int equip_slot, int item_ID) throws SQLException
        {
            sql = "UPDATE equipped_items SET slot_ID_?=? WHERE user_ID=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, equip_slot);
            stmt.setInt(2, item_ID);
            stmt.setInt(3, user_ID);
            stmt.executeUpdate();
        }
    }
