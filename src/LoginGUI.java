import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class LoginGUI {
    DB db1 = new DB(); //gets db
    private JPanel loginMainWindow; //JPanel for loginwindow
    private JTextField nameLoginTextField; //Textfield for login
    private JPasswordField passwordLoginTextField;  //textfield for password
    private JButton loginJButton;   //Button login
    private JButton registerJButton;    //Button register
    private boolean registerWindowOpen = false; //boolean to know if register window is open
    public static JFrame frame2; //register window jframe
    private static JFrame frame; //login window jframe
    private int dbLoginID = 0; //default ID 0 so it doesn't work will be overwritten by login data ID
    String loginName = ""; //String for name to ask DB
    String loginPassword = ""; //String for password to ask DB
    public int AccountID; //AccountID to use for Save in Game


    public LoginGUI() {
        /**
         * An Action listener on the login button that sends the login data to the DB and checks if the data is correct
         */
        loginJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            loginName = nameLoginTextField.getText();
            loginPassword = passwordLoginTextField.getText();
                try {
                    dbLoginID = db1.getUser_ID(loginName,loginPassword);
                    if (!(dbLoginID == 0)) {
                        System.out.println("login successful with id: " + dbLoginID);
                        frame.dispose();
                        if (registerWindowOpen) {
                            frame2.dispose();
                        }
                        AccountID = dbLoginID;
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Login failed. Please check your username and password and try again");
                    }
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        /**
         * An Action listener on the register button that opens the register window and disables the login functions
         */
        registerJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!registerWindowOpen) {
                    openRegisterWindow();
                    disableLoginUI();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Register window already open");
                }
            }
        });
        }



    /**
     * This is here to open the Login Window
     */
    public void openLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("LoginGUI");
            frame.setContentPane(new LoginGUI().loginMainWindow);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.out.println("Login window closed.");
                    frame2.dispose();
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
            frame2 = new JFrame("RegisterGUI");
            frame2.setContentPane(new RegisterGUI().registerMainWindow);
            frame2.pack();
            frame2.setVisible(true);
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    registerWindowOpen = false;
                    enableLoginUI();
                    System.out.println("Register window closed \n login button nametextfield, passwordtextfield enabled");
                }
            });
        });
    }
    public void disableLoginUI(){
        nameLoginTextField.setEnabled(false);
        passwordLoginTextField.setEnabled(false);
        loginJButton.setEnabled(false);
        registerWindowOpen = true;
    }
    public void enableLoginUI(){
        nameLoginTextField.setEnabled(true);
        passwordLoginTextField.setEnabled(true);
        loginJButton.setEnabled(true);
        registerWindowOpen = false;
        System.out.printf("LoginGUI enabled\n");
    }
}

