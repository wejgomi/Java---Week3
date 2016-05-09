package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class CouponGUI extends JFrame {

    public CouponGUI() {
        super("Coupong App");
        setSize(350,350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Coupon[] coupons = new Coupon[] { new Coupon("Meal",5.99),
                                            new Coupon ("Another Meal",6.99) };

        //comboBox
        JComboBox box = new JComboBox(coupons);
        getContentPane().add(box);

        JButton button1 = new JButton("Export to File");
        getContentPane().add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = box.getSelectedItem();
                if (item == null) {
                    JOptionPane.showMessageDialog(CouponGUI.this, "Select a coupon!");
                } else {
                    Coupon coupon = (Coupon) item;
                    try {
                        coupon.SaveToFile("input.txt");
                        JOptionPane.showMessageDialog(CouponGUI.this, "Successfully saved!");
                    } catch (FileNotFoundException e1) {
                        JOptionPane.showMessageDialog(CouponGUI.this, e1);
                    }
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new CouponGUI();
    }
}
