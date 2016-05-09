package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class SimpleGUI implements ActionListener {

    JFrame frame = new JFrame("Test Application");
    JButton button1 = new JButton("Submit");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleGUI gui = new SimpleGUI();
        gui.AddStuff();
    }

    public void actionPerformed(ActionEvent e) {
        //Object item = box.getSelectedItem();
        //if (item == null) {
        //    JOptionPane.showMessageDialog(CouponGUI.this, "Select a coupon!");
    }

    public void action(ActionEvent event){
        button1.setText("Changed");
    }

    public void AddStuff() {
        frame.getContentPane().add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,350);
        frame.setVisible(true);

        button1.addActionListener(this);
    }
}
