import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Inventory extends JFrame {
	private static DecimalFormat currency = new DecimalFormat("$#,##0.00");

	// Declares the TextFields used to display the value of each attribute of
	// the current product.
	private JTextField itemNumberTF;
	private JTextField productNameTF;
	private JTextField unitsInStockTF;
	private JTextField priceTF;
	private JTextField supplierNameTF;
	private JTextField restockFeeTF;
	private JTextField valueOfInventoryTF;

	// Declares a TextField to display the value of the entire inventory
	private JTextField totalValueOfInventoryTF;

	// Declare buttons to navigate through the products in the inventory
	private JButton priorBT;
	private JButton nextBT;

	// This array holds all products in the inventory.
	private Supplier[] products;

	// Indicates the index of the product displayed onto the screen.
	private int current = 0;

	/**
	 * Starts the application
	 *
	 * @param args
	 *            Not used by this application
	 */
	public static void main(String[] args) {
		// Creates and displays the GUI
		new Inventory();
	}

	/**
	 * Creates a new instance of the GUI and displays the frame.
	 */
	public Inventory() {
		super("Inventory Part 4");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creates the array with 5 elements
		products = new Supplier[5];

		// Creates some products
		products[0] = new Supplier(500, "Latitude", 10, 800, "Dell");
		products[1] = new Supplier(200, "Vostro", 20, 650, "Dell");
		products[2] = new Supplier(300, "Pavilion", 15, 890, "HP");
		products[3] = new Supplier(350, "Vaio", 10, 1200, "Sony");
		products[4] = new Supplier(400, "MacBook", 80, 1500, "Apple");

		// Sorts products by name
		sortArray();

		// Creates the visual components
		createComponents();

		// Shows the GUI
		setVisible(true);

		// Displays the first product
		updateFields();
	}

	private void createComponents() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		p.add(createFieldsPanel(), BorderLayout.CENTER);
		p.add(createButtonsPanel(), BorderLayout.SOUTH);

		setContentPane(p);
	}

	private JPanel createButtonsPanel() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));

		priorBT = new JButton("Prior");
		priorBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current > 0) {
					current--;
					updateFields();
				}
			}
		});
		p.add(priorBT);

		nextBT = new JButton("Next");
		nextBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (current < products.length - 1) {
					current++;
					updateFields();
				}
			}
		});
		p.add(nextBT);

		return p;
	}

	/**
	 * Updates the fields to reflect the current product.
	 */
	protected void updateFields() {
		Supplier s = products[current];

		itemNumberTF.setText(String.valueOf(s.getItemNumber()));
		productNameTF.setText(s.getProductName());
		unitsInStockTF.setText(String.valueOf(s.getUnitsInStock()));
		priceTF.setText(currency.format(s.getPrice()));
		supplierNameTF.setText(s.getSupplierName());
		restockFeeTF.setText(currency.format(s.calculateRestockFee()));
		valueOfInventoryTF.setText(currency.format(s.calculateInventory()));

		totalValueOfInventoryTF.setText(currency.format(calculateInventory()));
	}

	private JPanel createFieldsPanel() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0, 2, 5, 5));

		p.add(new JLabel("Item Number"));
		itemNumberTF = new JTextField();
		p.add(itemNumberTF);

		p.add(new JLabel("Product Name"));
		productNameTF = new JTextField();
		p.add(productNameTF);

		p.add(new JLabel("Units In Stock"));
		unitsInStockTF = new JTextField();
		p.add(unitsInStockTF);

		p.add(new JLabel("Unit Price"));
		priceTF = new JTextField();
		p.add(priceTF);

		p.add(new JLabel("Supplier Name"));
		supplierNameTF = new JTextField();
		p.add(supplierNameTF);

		p.add(new JLabel("Restock Fee"));
		restockFeeTF = new JTextField();
		p.add(restockFeeTF);

		p.add(new JLabel("Value Of Inventory"));
		valueOfInventoryTF = new JTextField();
		p.add(valueOfInventoryTF);

		p.add(new JLabel(""));
		p.add(new JLabel(""));

		p.add(new JLabel("Value Of The Entire Inventory"));
		totalValueOfInventoryTF = new JTextField();
		p.add(totalValueOfInventoryTF);

		return p;
	}

	/**
	 * A method to calculate the value of the entire inventory. This method
	 * should take in an array of type Software, Printer or Computer and should
	 * traverse through all the elements of the array and calculate the
	 * inventory.
	 *
	 * @return The value of the entire inventory.
	 */
	public double calculateInventory() {
		double value = 0;
		for (int i = 0; i < products.length; i++) {
			value += products[i].calculateInventory();
		}
		return value;
	}

	/**
	 * Sorts the products by name, using the Bubble Sort algorithm.
	 * http://en.wikipedia.org/wiki/Bubble_sort
	 */
	public void sortArray() {
		int n = products.length; // size;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				String name1 = products[i].getProductName();
				String name2 = products[i + 1].getProductName();
				if (name1.compareToIgnoreCase(name2) > 0) {
					// swap
					Supplier temp = products[i];
					products[i] = products[i + 1];
					products[i + 1] = temp;
					swapped = true;
				}
			}
			n = n - 1;
		} while (swapped);
	}
}
