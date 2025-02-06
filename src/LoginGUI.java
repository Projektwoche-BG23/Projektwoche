import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class LoginGUI {
    DB db1 = new DB(); //gets db
    public static JFrame loginFrame; //login window jframe
    public static JFrame registerFrame; //register window jframe
    private JPanel loginMainWindow; //JPanel for loginwindow
    private JTextField nameLoginTextField; //Textfield for login
    private JPasswordField passwordLoginTextField;  //textfield for password
    private JButton loginJButton;   //Button login
    private JButton registerJButton;    //Button register
    public boolean registerWindowOpen = false; //boolean to know if register window is open
    private int dbLoginID = 0; //default ID 0 so it doesn't work will be overwritten by login data ID
    private String loginName = ""; //String for name to ask DB
    private String loginPassword = ""; //String for password to ask DB
    public int AccountID; //AccountID to use for Save and load in Game



    public LoginGUI() {
        /**
         * An Action listener on the login button that sends the login data to the DB and checks if the data is correct
         */
        loginJButton.addActionListener(_ -> {
        loginName = nameLoginTextField.getText(); //sets namelogin text to string
        loginPassword = passwordLoginTextField.getText(); //sets passwordlogin text to string
            try {
                dbLoginID = db1.getUser_ID(loginName,loginPassword); //Asks DB if namelogin and passwordlogin is in DB
                if (!(dbLoginID == 0)) {
                    AccountID = dbLoginID; //sets account id to string that will be sent to game
                    System.out.println("login successful with id: " + AccountID);
                    loginFrame.dispose();
                    if (registerWindowOpen) {
                        registerFrame.dispose();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Login failed. Please check your username and password and try again");
                }
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });



        /**
         * An Action listener on the register button that opens the register window and disables the login functions
         */
        registerJButton.addActionListener(_ -> {
            if (!registerWindowOpen) {
                openRegisterWindow();
                disableLoginUI();
            }
            else {
                JOptionPane.showMessageDialog(null,"Register window already open");
            }
        });
        }



    /**
     * This is here to open the Login Window
     */
    public void openLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            loginFrame = new JFrame("LoginGUI");
            loginFrame.setContentPane(new LoginGUI().loginMainWindow);
            loginFrame.pack();
            loginFrame.setVisible(true);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setResizable(false);
            loginFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { //when login window gets closed register window also get closed
                    System.out.println("Login window closed.");
                    registerFrame.dispose();
                }
            });
        });
    }



    /**
     * This is here to open the Register Window. When the window closes it enables the LoginJButton,
     * passwordLoginTextField ,NameLoginTextField and sets the registerWindowOpen to false
     */
    public void openRegisterWindow() {
        SwingUtilities.invokeLater(() -> {
            registerFrame = new JFrame("RegisterGUI");
            registerFrame.setContentPane(new RegisterGUI().registerMainWindow);
            registerFrame.pack();
            registerFrame.setVisible(true);
            registerFrame.setLocationRelativeTo(null);
            registerFrame.setResizable(false);
            registerFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    enableLoginUI();
                    System.out.println("Register window closed \n login button nametextfield, passwordtextfield enabled");
                }
            });
        });
    }
    public void disableLoginUI(){
        loginFrame.setVisible(false);
        registerWindowOpen = true;
    }
    public void enableLoginUI(){
        loginFrame.setVisible(true);
        registerWindowOpen = false;
        System.out.print("LoginGUI enabled\n");
    }
}

