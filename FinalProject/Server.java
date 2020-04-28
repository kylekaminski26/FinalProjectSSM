package FinalProject;

import java.util.PriorityQueue;
import java.util.Queue;

//DO NOT use this class to create server. Use ServerCreate()

public class Server {
	private int ID; // each ID is unique
	private int waitTime;
	private int ServiceTime;
	private int busyTime;
	private boolean open;
	private Queue<Customer> queue;
	
	// Default constructor. Only called with ServerCreate() class.
	public Server(int IDIncr) {
		ID = IDIncr; // Will be unique upon each server creation.
		waitTime = 0;
		ServiceTime = 0;
		busyTime = 0;
		open = true;
		queue = new PriorityQueue<Customer>();
	}

	@Override
	public String toString() {
		return "Server [ID=" + ID + ", waitTime=" + waitTime + ", ServiceTime=" + ServiceTime + ", busyTime=" + busyTime
				+ ", open=" + open + ", queue=" + queue + "]";
	}
}
