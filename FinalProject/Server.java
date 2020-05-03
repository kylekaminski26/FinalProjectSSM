package FinalProject;

import java.util.Iterator;

public class Server<Customer> {
	private String name; // Express or checkout?
	private int waitTime;
	private int ServiceTime;
	private int busyTime;
	private boolean open;
	private ArrayQueue<Customer> queue;
	
	// Default constructor. Only called with ServerCreate() class.
	public Server(String n) {
		name = n;
		waitTime = 0;
		ServiceTime = 0;
		busyTime = 0;
		open = true;
		queue = new ArrayQueue<Customer>();
	}
	
	public void enqueue(Customer c) {
		queue.enqueue(c);
	}
	
	public Customer dequeue() {
		return queue.dequeue();
	}
	
	public void open() {
		open = true;
	}
	
	// Closes the server and moves all customers to another server
	public void close(Server<Customer> s) {
		open = false;
		for (int i = this.queue.size(); i < 0; i--) {
			s.enqueue(this.dequeue());
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getServiceTime() {
		return ServiceTime;
	}

	public void setServiceTime(int serviceTime) {
		ServiceTime = serviceTime;
	}

	public int getBusyTime() {
		return busyTime;
	}

	public void setBusyTime(int busyTime) {
		this.busyTime = busyTime;
	}

	public ArrayQueue<Customer> getQueue() {
		return queue;
	}

	public void setQueue(ArrayQueue<Customer> queue) {
		this.queue = queue;
	}

	public boolean getOpen() {
		return open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public double getQ_Hat(int time) {
		return 0.0; // FIX ME
	}
	
	public double getU_Hat(int time) {
		return queue.size() / time;
	}
	
	public int B_T() {
		if (queue.isEmpty())
			return 0;
		return 1;
	}
	
	@Override
	public String toString() {
		return "Server [waitTime=" + waitTime + ", ServiceTime=" + ServiceTime + ", busyTime=" + busyTime + ", open="
				+ open + ", queue=" + queue + "]";
	}	
}