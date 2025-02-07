import javax.swing.*;
import java.awt.*;

public class InventoryItemRenderer extends JLabel implements ListCellRenderer<InventoryItem>
{

    @Override
    public Component getListCellRendererComponent(JList<? extends InventoryItem> list, InventoryItem value, int index, boolean isSelected, boolean cellHasFocus) {

        //Set element text
        setText(value.itemName);

        //Handle Element Selection
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }

}
