import java.sql.*;
import java.util.Objects;

/*
Class to access the Database. We will add more features in the future.
Every Character has a unique user_ID, it is needed to access the Character Information.
 */
public class DB
{
    // Login information of the Database
    private static final String URL = "jdbc:mysql://192.168.102.39:3306/projektwoche-2025"; // IP may be changed later.
    private static final String USER = "everyone";
    private static final String PASSWORD = "";

    // Variables to use the database
    Connection con;
    PreparedStatement stmt;
    String sql;
    ResultSet rs;

    // Constructor that connects to the database
    public DB()
    {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            throw new RuntimeException(e);
        }
    }


    /*
    Checks if the login information is correct and returns the user_ID
    @param username : Username of the Player
    @param password : Password of the Player
    standard for testing: (test, 123)
    !returns 0 if incorrect!
     */
    public int getUser_ID(String username, String password) throws SQLException
    {
        int user_ID = 0;
        sql = "SELECT * FROM Login WHERE name=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            if(Objects.equals(rs.getString(2), password))
            {
                user_ID = Integer.parseInt(rs.getString(3));
            }
            else
            {
                System.out.println("password wrong");
            }
        }
        return user_ID;
    }
    public void createAcc(String username, String password) throws SQLException
    {

        sql = "INSERT INTO login (name, password) VALUES(?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.executeUpdate();
    }


}