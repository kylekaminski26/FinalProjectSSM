package FinalProject;

import java.util.PriorityQueue;

public class Server {
	private int ID; //so we know when the server was created
	private int waitTime;
	private int ServiceTime;
	private int busyTime;
	
	private PriorityQueue<Customer> server = new PriorityQueue<Customer>();
}
