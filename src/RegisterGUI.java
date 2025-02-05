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

    /**
     * Sends the Register data to the DB
     */
    public RegisterGUI() {
        finalreigsterJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerName = nameRegisterTextField.getText();
                registerPassword = passwordRegisterTextField.getText();
                registerDB();

            }
        });
    }

    public void registerDB() {
        try {
            db1.createAcc(registerName, registerPassword);
            if (db1.createAcc(registerName, registerPassword)) {
                db1.getUser_ID(registerName, registerPassword);
                System.out.println("register Successful");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}


