package FinalProject;

import java.util.Random;

public class Customer {
	private String name; // Unique first name for the customer.
	private int entryTime; // Time they entered the queue; Qualifies as unique identifier
	private int waitTime; // Time the customer will wait.
	private int procTime; // Amount of time it will take to process.
	private int cart; // Number of items in the cart

	private Random rand = new Random();

	// Default Constructor, empty variables
	public Customer() {
		name = "";
		entryTime = 0;
		waitTime = 0;
		procTime = 0;
		cart = 0;
	}
	
	// Main Constructor
	public Customer(String n) {
		name = n;
		entryTime = 0;
		waitTime = rand.nextInt(10);
		procTime = rand.nextInt(10);
		cart = rand.nextInt(50);
	}
	
	// Constructor for replacement copy
		public Customer(String n, int e, int w, int p, int c) {
			name = n;
			entryTime = e;
			waitTime = w;
			procTime = p;
			cart = c;
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

	public String toStringName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", entryTime=" + entryTime + ", waitTime=" + waitTime + ", procTime="
				+ procTime + ", cart=" + cart + "]";
	}
}