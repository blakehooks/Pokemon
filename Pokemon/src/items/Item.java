package items;

public class Item {
	private String name;
	private int quantity;

	public Item(String n, int q) {
		this.name = n;
		this.quantity = q;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Increase quantity of item
	 */
	public void increaseQuantity() {
		this.quantity++;
	}
	
	

}
