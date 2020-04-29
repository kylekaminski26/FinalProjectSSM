package FinalProject;

import java.util.ArrayList;

public class CustomerCreate {
	private int IDIncr;
	private ArrayList<Customer> fullCustList; // List of created customers.

	// default constructor
	public CustomerCreate() {
		IDIncr = 0; // Initial ID, increments automatically with every customer added
		fullCustList = new ArrayList<Customer>();
	}

	// Add new customer
	public void newCustomer(String name) {
		Customer c = new Customer(name, IDIncr);
		IDIncr++;
		fullCustList.add(c);
	}
	
	// Returns full Customer list
	public ArrayList<Customer> getFullCustList() {
		return fullCustList;
	}
	
	// Returns the customer with specified ID
	public Customer returnCustomerWithSpecifiedID(int ID) {
		for (Customer c : fullCustList) // For all Customer objects not processed
			if (ID == c.getID()) // If customer ID is found (customer not yet processed)
				return c; // Return customer
		return null; // Return null if customer not found (should never happen if correct input is assumed)
	}
	
//	// Returns the customer with specified name
//		public Customer returnCustomerWithSpecifiedName(String name) {
//			for (Customer c : fullCustList) // For all Customer objects not processed
//				if (name.equals(c.getName())) // If customer name is found (customer not yet processed)
//					return c; // Return customer (first customer found with this name)
//			return null; // Return null if customer not found (should never happen if correct input is assumed)
//		}
	
	// Returns customer at specified index	
	public Customer returnCustomer(int i) {
		return fullCustList.get(i);
	}
	
	@Override
	public String toString() {
		return "TotalCustomers=" + IDIncr + ", fullCustList=" + fullCustList;
	}
	
}