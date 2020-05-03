package FinalProject;

public class MyQueueTest {
	public static void main(String args[]) {
		ArrayQueue<Customer> q = new ArrayQueue<Customer>();

		q.enqueue(new Customer("1")); // 1
		q.enqueue(new Customer("2")); // 1 2
		q.dequeue(); // 2
		q.enqueue(new Customer("3")); // 2 3
		q.dequeue(); // 2
		q.dequeue(); // []
		q.enqueue(new Customer("4")); // 4
		q.enqueue(new Customer("5")); // 4 5
		q.dequeue(); // 5
		q.enqueue(new Customer("6")); // 5 6
		q.dequeue(); // 6

		System.out.println(q.toString()); // [6]
	}
}