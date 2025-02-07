import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class LoginGUI {
    DB db1 = new DB(); // gets db
    public static JFrame loginFrame; // login window JFrame
    public static JFrame registerFrame; // register window JFrame
    private JPanel loginMainWindow; // JPanel for login window
    private JTextField nameLoginTextField; // Text field for login
    private JPasswordField passwordLoginTextField; // Text field for password
    private JButton loginJButton; // Login button
    private JButton registerJButton; // Register button
    public boolean registerWindowOpen = false; // Boolean to check if the register window is open
    private int dbLoginID = 0; // Default ID (0 means login fails) to be overwritten by login data ID
    private String loginName = ""; // String for name to query DB
    private String loginPassword = ""; // String for password to query DB
    public int accountID; // Account ID to be used in-game for saving/loading

    // Constructor
    public LoginGUI() {
        initializeUI(); // Initialize GUI components
        setupListeners(); // Set up action listeners
    }

    // Initialize all GUI components
    private void initializeUI() {
        // Main panel
        loginMainWindow = new JPanel(new GridLayout(3, 2, 5, 5)); // Create panel with a grid layout

        // Input fields
        nameLoginTextField = new JTextField();
        passwordLoginTextField = new JPasswordField();

        // Buttons
        loginJButton = new JButton("Login");
        registerJButton = new JButton("Register");

        // Adding components to panel
        loginMainWindow.add(new JLabel("Username:"));
        loginMainWindow.add(nameLoginTextField);
        loginMainWindow.add(new JLabel("Password:"));
        loginMainWindow.add(passwordLoginTextField);
        loginMainWindow.add(loginJButton);
        loginMainWindow.add(registerJButton);
    }

    // Set up action listeners
    private void setupListeners() {
        /**
         * Action listener for the login button to send login data to the DB and check if the data is correct
         */
        loginJButton.addActionListener(_ -> {
            loginName = nameLoginTextField.getText(); // Get username
            loginPassword = new String(passwordLoginTextField.getPassword()); // Get password
            try {
                dbLoginID = db1.getUser_ID(loginName, loginPassword); // Query DB for user ID
                if (dbLoginID != 0) {
                    accountID = dbLoginID; // Pass account ID to game
                    System.out.println("Login successful with ID: " + accountID);
                    loginFrame.dispose();

                    Game game = new Game(accountID);

                    if (registerWindowOpen) {
                        registerFrame.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your username and password and try again");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        /**
         * Action listener for the register button to open the register window and disable the login functions
         */
        registerJButton.addActionListener(_ -> {
            if (!registerWindowOpen) {
                openRegisterWindow();
                disableLoginUI();
            } else {
                JOptionPane.showMessageDialog(null, "Register window already open");
            }
        });
    }

    /**
     * Open the login window
     */
    public void openLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            loginFrame = new JFrame("LoginGUI");
            loginFrame.setContentPane(loginMainWindow); // Use the initialized panel
            loginFrame.pack();
            loginFrame.setVisible(true);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setResizable(false);
            loginFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { // When login window closes, close register window
                    System.out.println("Login window closed.");
                    if (registerWindowOpen) {
                        registerFrame.dispose();
                    }
                }
            });
        });
    }

    /**
     * Open the Register Window. When the window closes, enable the login button,
     * passwordLoginTextField, NameLoginTextField, and set registerWindowOpen to false
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
                    System.out.println("Register window closed \nLoginButton, username/password fields enabled");
                }
            });
        });
    }

    public void disableLoginUI() {
        loginFrame.setVisible(false);
        registerWindowOpen = true;
    }

    public void enableLoginUI() {
        loginFrame.setVisible(true);
        registerWindowOpen = false;
        System.out.print("LoginGUI enabled\n");
    }

    public int getDBLoginID() {
        return accountID;
    }
}