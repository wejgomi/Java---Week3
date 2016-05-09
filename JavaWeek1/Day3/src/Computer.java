/**
 * Represents a product.
 */
public class Computer {
	private int itemNumber;
	private String productName;
	private int unitsInStock;
	private double price;

	/**
	 * Default constructor
	 */
	public Computer() {
	}

	/**
	 * Handy constructor to initialize all attributes of the product.
	 */
	public Computer(int itemNumber, String productName, int unitsInStock,
			double price) {
		this.itemNumber = itemNumber;
		this.productName = productName;
		this.unitsInStock = unitsInStock;
		this.price = price;
	}

	/**
	 * @return The value of the inventory (the number of units in stock
	 *         multiplied by the price of each unit).
	 */
	public double calculateInventory() {
		return this.unitsInStock * this.price;
	}

	/**
	 * @return the itemNumber
	 */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the unitsInStock
	 */
	public int getUnitsInStock() {
		return unitsInStock;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param itemNumber
	 *            the itemNumber to set
	 */
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @param name
	 *            the product name to set
	 */
	public void setName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param unitsInStock
	 *            the unitsInStock to set
	 */
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}

