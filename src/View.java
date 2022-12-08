import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

public class View {
    protected JFrame frame;

    public View(){
        frame = new JFrame("InventoryPro");
    }

    public void showItems(ArrayList<InventoryItem> items, Controller cont){


        for (InventoryItem item: items){
            JTextArea area = new JTextArea(item.toString());

            area.setEditable(false);
            area.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            area.setBounds(5,0,350,350);

            JButton sellButton = new JButton("Sell 1");
            sellButton.setBounds(5,80,95,30);
            sellButton.addActionListener(e -> {
                item.currentStock -= 1;
                area.setText(item.toString());
            });
            area.add(sellButton);

            JButton deleteButton = new JButton("Delete Item");
            deleteButton.setBounds(5,120,105,30);
            deleteButton.addActionListener(e -> {
                frame.remove(area);
                items.remove(item);
                JTextArea addArea = new JTextArea();
                addArea.setBounds(area.getBounds());
                addArea.setEditable(false);
                JButton addButton = new JButton("Add Item");
                addButton.setBounds(deleteButton.getBounds());
                addArea.add(addButton);
                frame.add(addArea);
                frame.repaint();

            });
            area.add(deleteButton);

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
        frame.setSize(950,700);
        frame.setLayout(new GridLayout(0, 2, 10, 10));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    cont.saveData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
