import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class InventoryGUIv1 {
    public JFrame inventoryJFrame;
    public JPanel inventoryGUIMainJPanel;
    private JButton equipNewItemButton;
    private JButton continueButton;
    private JLabel newItemJLabel;
    private JLabel oldItemJLabel;
    private String oldItem = "none";
    private String newItem;
    public boolean inventoryGUIOpened = false;
    private int userId = 10;

    Inventory inv = new Inventory();
    DB db = new DB();


    public InventoryGUIv1() {
        Inventory inventory = new Inventory();
        System.out.println(inventory.drop);

        equipNewItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    inv.equipItem(newItem);
                    newItemJLabel.setText(newItem);
                    System.out.println("new item: "+newItem);
                    inventoryJFrame.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryJFrame.dispose();
            }
        });
    }
    public void setUserID(int userID){
        this.userId = userID;
    }

    public void startInventoryGUI() throws SQLException {
            inventoryGUIOpened = true;
            inventoryJFrame = new JFrame("Inventory GUI");
            inventoryJFrame.setContentPane(inventoryGUIMainJPanel);
            inventoryJFrame.pack();
            inventoryJFrame.setVisible(true);
            inventoryJFrame.setLocationRelativeTo(null);
            inventoryJFrame.setResizable(false);
            inventoryJFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
            inventoryGUIOpened = false;}
                                              });
            inv.setUserID(userId);

        try {
            newItem = inv.addRandom("chapter1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        int newItemId = inv.nameToID(newItem);
        Object[] newItemAttributes = db.itemInfo(newItemId);
        int newItemSlot = Integer.parseInt((String) newItemAttributes[3]);

        String[] equippedItems = db.getEquipped(userId);

        System.out.println(newItemSlot);

        for (int i = 0; i < equippedItems.length; i++) {

            if (newItemSlot == i) {
                oldItem = equippedItems[i];
            }

        }

        Object[] oldItemAttributes = db.itemInfo(Integer.parseInt(oldItem));
        String oldItemName = (String) oldItemAttributes[1];
        oldItemJLabel.setText(oldItemName);

        newItemJLabel.setText(newItem);

    }
    public void closeInventoryGUI() {
        inventoryJFrame.dispose();
    }
    public boolean inventoryUIWindowClosed(){
        return inventoryGUIOpened;
    }
}

