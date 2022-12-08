import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class View {
    protected JFrame frame;

    public View(){
        frame = new JFrame("InventoryPro");
    }

    public void showItems(ArrayList<InventoryItem> items){


        for (InventoryItem item: items){
            JTextArea area = new JTextArea(item.toString());

            area.setEditable(false);
            area.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            area.setBounds(5,0,350,300);

            JButton sellButton = new JButton("Sell 1");
            sellButton.setBounds(5,80,95,30);
            sellButton.addActionListener(e -> {
                item.currentStock -= 1;
                area.setText(item.toString());
            });
            area.add(sellButton);

            JButton buyButton = new JButton("Add 1 to Stock");
            buyButton.setBounds(105,80,125,30);
            buyButton.addActionListener(e -> {
                item.currentStock += 1;
                area.setText(item.toString());
            });
            area.add(buyButton);

            JTextField priceField = new JTextField();
            priceField.setBounds(355, 80, 95, 30);
            area.add(priceField);

            JButton priceButton = new JButton("Update Price:");
            priceButton.setBounds(235,80,115,30);
            priceButton.addActionListener(e -> {
                item.price = Double.parseDouble(priceField.getText());
                area.setText(item.toString());
            });
            area.add(priceButton);
            frame.add(area);
        }
        frame.setSize(950,550);
        frame.setLayout(new GridLayout(0, 2, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
