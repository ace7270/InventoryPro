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
            area.setBounds(5,0,300,300);

            JButton sellButton = new JButton("Sell 1");
            sellButton.setBounds(5,80,95,30);
            area.add(sellButton);

            JButton buyButton = new JButton("Buy 1");
            buyButton.setBounds(105,80,95,30);
            area.add(buyButton);

            JTextField priceField = new JTextField();
            priceField.setBounds(325, 80, 95, 30);
            area.add(priceField);

            JButton priceButton = new JButton("Update Price:");
            priceButton.setBounds(205,80,115,30);
            priceButton.addActionListener(e -> {
                item.price = Double.parseDouble(priceField.getText());
            });
            area.add(priceButton);
            frame.add(area);
        }
        frame.setSize(900,550);
        frame.setLayout(new GridLayout(0, 2, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
