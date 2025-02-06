import javax.swing.*;
import java.sql.SQLException;

public class RegisterGUI {
    public JPanel registerMainWindow;
    private JTextField nameRegisterTextField;
    private JTextField passwordRegisterTextField;
    private JButton finalreigsterJButton;
    private String registerName= "";
    private String registerPassword = "";
    private final DB db1 = new DB();
    private final LoginGUI loginGUI = new LoginGUI();
    /**
     * Sets the registerName and the registerPassword from textfield to String
     */
    public RegisterGUI() {
        finalreigsterJButton.addActionListener(_ -> {
            if (!nameRegisterTextField.getText().isEmpty() && !passwordRegisterTextField.getText().isEmpty()) {
                registerName = nameRegisterTextField.getText();
                registerPassword = passwordRegisterTextField.getText();
                registerDB();
            }
            else {
                JOptionPane.showMessageDialog(null,"Please fill in all the fields");
            }

        });
    }

    /**
     * Sends data to DB and creates an UserID if successful closes register UI, if fail err msg
     */
    public void registerDB() {
        try {
            db1.createAcc(registerName, registerPassword);
            db1.getUser_ID(registerName, registerPassword);
            System.out.println(db1.getUser_ID(registerName, registerPassword));

            if (0!=db1.getUser_ID(registerName, registerPassword)) {
                JOptionPane.showMessageDialog(null,"Register Successful");
                loginGUI.registerFrame.dispose();
                loginGUI.enableLoginUI();
                loginGUI.registerWindowOpen = false;
            }
            else {
                JOptionPane.showMessageDialog(null,"Register failed, Username might exsist already or ask Oke");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}


