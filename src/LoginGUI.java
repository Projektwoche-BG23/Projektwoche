import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class LoginGUI {
    public JPanel loginMainWindow;
    private JTextField nameLoginTextField;
    private JPasswordField passwordLoginTextField;
    private JButton loginJButton;
    private JButton registerJButton;
    private boolean registerWindowOpen = false;
    DB db1 = new DB();


    public LoginGUI() {
        /**
         * An Action listener on the login button that sends the login data to the DB and checks if the data is correct
         */
        loginJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String loginName = nameLoginTextField.getText();
            String loginPassword = passwordLoginTextField.getText();
              /**  try {
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
             */
            }
        });



        /**
         * An Action listener on the register button that opens the register window and disables the login functions
         */
        registerJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registerWindowOpen == false) {
                    openRegisterWindow();
                    registerWindowOpen = true;
                    nameLoginTextField.setEnabled(false);
                    passwordLoginTextField.setEnabled(false);
                    loginJButton.setEnabled(false);
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
            JFrame frame = new JFrame("LoginGUI");
            frame.setContentPane(new LoginGUI().loginMainWindow);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.out.println("Login window closed.");
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
            JFrame frame2 = new JFrame("RegisterGUI");
            frame2.setContentPane(new RegisterGUI().registerMainWindow);
            frame2.pack();
            frame2.setVisible(true);
            frame2.setLocationRelativeTo(null);
            frame2.setResizable(false);
            frame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) { // Changed from 'WindowClosing' to 'windowClosing'
                    registerWindowOpen = false;
                    nameLoginTextField.setEnabled(true);
                    passwordLoginTextField.setEnabled(true);
                    loginJButton.setEnabled(true);
                    System.out.println("Register window closed \n login button nametextfield, passwordtextfield enabled");
                }
            });
        });
    }

}

