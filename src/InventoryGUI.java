import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class InventoryGUI extends JFrame implements ActionListener {

    private JPanel mainPanel;

    private JList inventoryList;
    private JList equippedList;

    private JPanel hpStatPanel;
    private JPanel maxManaPanel;
    private JPanel baseDamage;
    private JPanel defense;
    private JPanel strengthPanel;
    private JPanel agilityPanel;
    private JPanel luckPanel;
    private JPanel manaRegPanel;

    private List<InventoryItem> _currentInventoryItems = new ArrayList<InventoryItem>();
    private List<InventoryItem> _currentEquippmentItems = new ArrayList<InventoryItem>();

    public InventoryGUI()
    {
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(600, 400);

        //Initialisierung des Inventories
        inventoryList.setCellRenderer(new InventoryItemRenderer());
        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = inventoryList.locationToIndex(e.getPoint());
                if (index != -1) {
                    //Item wird Doppeclicked
                    //=> Item Equippen
                    InventoryItem clickedItem = (InventoryItem) inventoryList.getModel().getElementAt(index);
                    AddItemToEquippedInventory(clickedItem);
                    RemoveItemFromInventory(clickedItem);
                }
            }
        });


        //Initialisierung des Equippments
        equippedList.setCellRenderer(new InventoryItemRenderer());
        equippedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        equippedList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = equippedList.locationToIndex(e.getPoint());
                if (index != -1) {
                    //Item wird Doppeclicked
                    //=> Item Equippen
                    InventoryItem clickedItem = (InventoryItem) equippedList.getModel().getElementAt(index);
                    AddItemToInventory(clickedItem);
                    RemoveItemFromEquippedInventory(clickedItem);
                }
            }
        });


        //Hinzufügen von Items zum Inventar
        InventoryItem testItem01 = new InventoryItem("testItem01","Test Item");
        InventoryItem testItem02 = new InventoryItem("testItem02","Test Item 2");
        InventoryItem testItem03 = new InventoryItem("testItem03","Test Item 3");
        AddItemToInventory(testItem01);
        AddItemToInventory(testItem02);
        AddItemToInventory(testItem03);
    }



    public void AddItemToInventory(InventoryItem item){
        _currentInventoryItems.add(item);
        inventoryList.setListData(_currentInventoryItems.toArray());
    }

    public void AddItemToEquippedInventory(InventoryItem item){
        _currentEquippmentItems.add(item);
        equippedList.setListData(_currentEquippmentItems.toArray());
    }

    public void RemoveItemFromInventory(InventoryItem item){
        _currentInventoryItems.remove(item);
        inventoryList.setListData(_currentInventoryItems.toArray());
    }

    public void RemoveItemFromEquippedInventory(InventoryItem item)
    {
        _currentEquippmentItems.remove(item);
        equippedList.setListData(_currentEquippmentItems.toArray());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
