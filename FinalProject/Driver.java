package FinalProject;

/*
 * @author Kyle K, Tim G, Matt K, Victor C
 * @purpose SSM Final Project
 * @prof Professor Safko
 * @date May 4, 2020
 */

public class Driver {
	/*
	 * Balk: A customer can decide to not join a queue in the first place Renege: A
	 * customer can decide to leave the queue without being served Jockey: A
	 * customer can decide to jump to another server if that server opens.
	 */

	public static void main(String[] args) {
		boolean run = true;
		CustomerCreate custList = new CustomerCreate(); // Class for creating customer (DO NOT use Customer() class when making new customer).
		ServerCreate servList = new ServerCreate(); // Class for creating server (DO NOT use Server() class when making new server).

		System.out.println("Welcome to the SSM Queue and Server System");
		System.out.println("Team: Team Geese 2.0");
		System.out.println("Members: Kyle K, Tim G, Matt K, Victor C\n\n*****");

		do { // Repeating Menu + Selections
			System.out.println("\nSelect an Option for the System:");
		} while (run);
	}
}