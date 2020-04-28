package FinalProject;

// DO NOT use this class to create customer. Use CustomerCreate()

public class Customer {
	private int ID; // each ID is unique
	private String name; // non-unique first name for the customer.
	private int entryTime;
	private int waitTime;
	private int procTime;

	// Default constructor. Only called with CustomerCreate() class.
	public Customer(int IDIncr) {
		ID = IDIncr; // Will be unique upon each customer creation.
		name = "";
		entryTime = 0;
		waitTime = 0;
		procTime = 0;
	}
	
	// Only called with CustomerCreate() class.
		public Customer(String n, int IDIncr) {
			ID = IDIncr; // Will be unique upon each customer creation.
			name = n;
			entryTime = 0;
			waitTime = 0;
			procTime = 0;
		}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", name=" + name + ", entryTime=" + entryTime + ", waitTime=" + waitTime
				+ ", procTime=" + procTime + "]";
	}
}