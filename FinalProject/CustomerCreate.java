package FinalProject;

import java.util.ArrayList;

public class CustomerCreate {
	private int IDIncr = 0;
	

	private ArrayList<Customer> fullCustList = new ArrayList<Customer>(); // List of created customers.

	// default constructor
	public CustomerCreate() {
		Customer c = new Customer(IDIncr);
		IDIncr++;
		fullCustList.add(c);
	}

	// Constructor with customer name
	public CustomerCreate(String name) {
		Customer c = new Customer(name, IDIncr);
		IDIncr++;
		fullCustList.add(c);
	}
	
	@Override
	public String toString() {
		return "TotalCustomers=" + IDIncr + ", fullCustList=" + fullCustList;
	}
}