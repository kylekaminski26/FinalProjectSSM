package FinalProject;

//DO NOT use this class to create server. Use ServerCreate()

public class Server<Customer> {
	private int waitTime;
	private int ServiceTime;
	private int busyTime;
	private boolean open;
	private Queue<Customer> queue;
	
	// Default constructor. Only called with ServerCreate() class.
	public Server() {
		waitTime = 0;
		ServiceTime = 0;
		busyTime = 0;
		open = true;
		queue = new Queue<Customer>();
	}
	
	public void enqueue(Customer c) {
		queue.enqueue(c);
	}
	
	public Customer dequeue(Customer c) {
		return queue.dequeue();
	}
	
	public void open() {
		open = true;
	}
	
	public void close() {
		open = false;
	}

	@Override
	public String toString() {
		return "Server [waitTime=" + waitTime + ", ServiceTime=" + ServiceTime + ", busyTime=" + busyTime + ", open="
				+ open + ", queue=" + queue + "]";
	}
}