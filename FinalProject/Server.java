package FinalProject;
import java.util.Iterator;
import java.util.Random;

public class Server {
	private String name; // Express or checkout?
    private float Q_T_SUM; //iterative subtotal of customer wait time | Q(t) without factoring T(n)
    private float U_N_SUM; //iterative subtotal of Server Utilization | U(N) without factoring T(n)
	private boolean open;
	private ArrayQueue<Customer> queue;
    private int time;
    private int startProcessTime; //holds the time of the most recent started process
    private Random randy;
	// Default constructor. Only called with ServerCreate() class.
	public Server(String n) {
		name = n;
		open = true;
		queue = new ArrayQueue<Customer>();
        Q_T_SUM = 0;
        U_N_SUM = 0;
        this.time = 0;
        this.randy = new Random();
	}
	
	public void enqueue(Customer c) {
		queue.enqueue(c);
        if (queue.size() == 1){
            startProcessTime = time;
        }
	}
	
	public Customer dequeue() {
		return queue.dequeue();
	}
	
	public void open() {
		open = true;
	}
	
	// Closes the server and moves all customers to another server
	public void close(Server s) {
		open = false;
		for (int i = this.queue.size(); i < 0; i--) {
			s.enqueue(this.dequeue());
		}
	}

    //update the server by 1 time step
    public void update(){

       //reneger?
       reneg(); 

       //update the time
       time++;

       //Customers in Queue after curent process?
       if (queue.size() > 1){
            Customer current =(Customer) queue.peek();
            //is the curent customer done being processed?
            if (current.getProcTime() + startProcessTime < time){
                 //dequeue the current Customer
                 //set the startProcess time for next
                 dequeue();
                 startProcessTime = time;
                 System.out.println(current.getName() + " has finished processing");
            }
       //Just one Customer in the Queue?           
       }else if (queue.size() == 1){
            Customer current =(Customer) queue.peek();
            //is the curent customer done being processed?
            if (current.getProcTime() + startProcessTime < time){
                 //dequeue the current Customer
                 //set the startProcess time for next
                 dequeue();
                 System.out.println(current.getName() + " has finished processing");
            }
        }
    
       //update customer wait time
       Iterator itty = queue.iterator();     
       itty.next(); //skip first person  
       while (itty.hasNext())
       {    
           Customer c = (Customer) itty.next();
           c.setWaitTime(c.getWaitTime()+1);
       }  


       //update analytics
       Q_T_SUM += queue.size();
       U_N_SUM += B_T();         
       System.out.println(toString());

    }



	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ArrayQueue<Customer> getQueue() {
		return queue;
	}


	public boolean getOpen() {
		return open;
	}

	public int getSize() {
		return queue.size();
	}

    public void setOpen(boolean t){
        open = t;
    }
	
    //douchey customers


    //Give the customers in the queue a chance
    //to reneg
    public void reneg(){
    
       if (queue.size < 2){
            return;
       }
    
       //every time step the customers in the line will have 
       //a 2 percent chance of reneging
       if (randy.nextInt(100) % 10 == 0){ //10% for debug
            //pick a customer to reneg
            int douche = randy.nextInt(queue.size()-2);//person being processed should not leave 
            Customer customer = queue.remove(douche);     
            System.out.println(customer.getName() + " reneged");   
            System.out.println(customer.getName() + " reneged");        
       }  
    }

	@Override
	public String toString() {
		return  "Server [busyTime=" + B_T() + "open="
				+ open + " queue=" + queue + "]";
	}	


    //Server Analytics

	public double getQ_Hat(int time) {
		return (Q_T_SUM/time); 
	}
	
	public double getU_Hat(int time) {
		return (U_N_SUM/time);
	}
	
	public int B_T() {
		if (queue.isEmpty())
			return 0;
		return 1;
	}




}
