package FinalProject;

// DO NOT use this class to create customer. Use CustomerCreate()

public class Customer {
	private String name; // Unique first name for the customer.
	private int entryTime;
	private int waitTime;
	private int procTime;
	private int cart; // Number of items in the cart

	// Only called with CustomerCreate() class.
	public Customer(String n) {
		name = n;
		entryTime = 0;
		waitTime = 0;
		procTime = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(int entryTime) {
		this.entryTime = entryTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getProcTime() {
		return procTime;
	}

	public void setProcTime(int procTime) {
		this.procTime = procTime;
	}
	
	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", entryTime=" + entryTime + ", waitTime=" + waitTime
				+ ", procTime=" + procTime + "]";
	}
}