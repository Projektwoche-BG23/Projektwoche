import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterGUI {
    public JPanel registerMainWindow;
    private JTextField nameRegisterTextField;
    private JTextField passwordRegisterTextField;
    private JButton finalreigsterJButton;
    String registerName= "";
    String registerPassword = "";
    DB db1 = new DB();
    private LoginGUI loginGUI = new LoginGUI();
    /**
     * Sets the registerName and the registerPassword from textfield to String
     */
    public RegisterGUI() {
        finalreigsterJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameRegisterTextField.getText().isEmpty() && !passwordRegisterTextField.getText().isEmpty()) {
                    registerName = nameRegisterTextField.getText();
                    registerPassword = passwordRegisterTextField.getText();
                    registerDB();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please fill in all the fields");
                }

            }
        });
    }

    /**
     * Sends data to DB and creates an UserID
     */
    public void registerDB() {
        try {
            db1.createAcc(registerName, registerPassword);
            db1.getUser_ID(registerName, registerPassword);
            if (0!=db1.getUser_ID(registerName, registerPassword)) {
                JOptionPane.showMessageDialog(null,"Register Successful");
                LoginGUI.frame2.dispose();
                loginGUI.enableLoginUI();
            }
            else {
                JOptionPane.showMessageDialog(null,"Register failed, Username might exsist already or ask Oke");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}


