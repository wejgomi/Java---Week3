import java.sql.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory extends JFrame {

    private static DecimalFormat currency = new DecimalFormat("$#,##0.00");

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JButton button1;
    JButton button2;

    static Supplier[] products;
    static String dbName = "products";
    private int current = 0;

    public static void main(String[] args) {
        new Inventory();
    }

    public Inventory() {
        super("Inventory List Program");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CreatePanel();
    }

    public void CreatePanel() {

        label1 = new JLabel("Item number: ");
        label2 = new JLabel("Product name: ");
        label3 = new JLabel("Units in stock: ");
        label4 = new JLabel("Price: ");
        label5 = new JLabel("Restock fee: ");
        label6 = new JLabel("Value of inventory: ");
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        button1 = new JButton("Prior");
        button2 = new JButton("Next");

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(label1,BorderLayout.WEST);
        panel.add(textField1,BorderLayout.EAST);
        panel.add(label2,BorderLayout.WEST);
        panel.add(textField2,BorderLayout.EAST);
        panel.add(label3,BorderLayout.WEST);
        panel.add(textField3,BorderLayout.EAST);
        panel.add(label4,BorderLayout.WEST);
        panel.add(textField4,BorderLayout.EAST);
        panel.add(label5,BorderLayout.WEST);
        panel.add(textField5,BorderLayout.EAST);
        panel.add(label6,BorderLayout.WEST);
        panel.add(textField6,BorderLayout.EAST);
        panel.add(button1,BorderLayout.CENTER);
        panel.add(button2,BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (current > 0) {
                    current--;
                    updateList();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (current < products.length - 1) {
                    current++;
                    updateList();
                }
            }
        });

        panel.setLayout(new GridLayout(0, 2, 8, 8));;
        getContentPane().add(panel);

        setVisible(true);
        try { GetProducts(); }catch (SQLException e) { System.out.println("Could not load"); }
    }

    public void GetProducts()
            throws SQLException {

        products = new Supplier[10];
        Statement stmt = null;
        String destination = "jdbc:mysql://localhost/newuser";
        String query =
                "select * FROM " + dbName;

        try {
            Connection con = DriverManager.getConnection(destination,"root","password");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int j = 0;
            while (rs.next()) {
                products[j] = new Supplier(rs.getInt("NUMBER"), rs.getString("NAME"), rs.getInt("STOCK"), rs.getFloat("PRICE"), rs.getString("SUPPLIER"));
                j++;
            }
        } catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        updateList();
    }

    protected void updateList() {
        Supplier s = products[current];

        textField1.setText(s.getProductName());
        textField2.setText(s.getProductName());
        textField3.setText(String.valueOf(s.getUnitsInStock()));
        textField4.setText(currency.format(s.getPrice()));
        textField5.setText(s.getSupplierName());
        textField6.setText(currency.format(s.calculateRestockFee()));
        //totalValueOfInventoryTF.setText(currency.format(calculateInventory()));
    }
}