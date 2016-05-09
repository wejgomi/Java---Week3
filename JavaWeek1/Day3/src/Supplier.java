/**
 * This class should inherit from the Product class. Recall that the extends
 * keyword is used in java to represent inheritance
 */
public class Supplier extends Computer {
	/** Supplier Name */
	private String supplierName;

	/**
	 * Constructor should have 5 parameters:
	 *
	 * - Item Number
	 *
	 * - Product Name
	 *
	 * - Number of Units in Stock
	 *
	 * - Price of each Unit
	 *
	 * - Supplier Name
	 */
	public Supplier(int itemNumber, String productName, int unitsInStock,
			double price, String supplierName) {
		/*
		 * Note you will use the super keyword to invoke the constructor in your
		 * Product class.
		 */
		super(itemNumber, productName, unitsInStock, price);
		this.supplierName = supplierName;
	}

	/**
	 * This method returns the product of price and available units multiplied
	 * by 5% ((price * product) * .05);
	 */
	public double calculateRestockFee() {
		return super.calculateInventory() * .05;
	}

	/**
	 * This method returns the product of price and available units plus the
	 * restock fee.
	 */
	public double calculateInventory() {
		return super.calculateInventory() + calculateRestockFee();
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName
	 *            the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
