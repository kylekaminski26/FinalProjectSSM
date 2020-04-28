package FinalProject;

import java.util.Scanner;

/*
 * @author Kyle K, Tim G, Matt K, Victor C
 * @purpose SSM Final Project
 * @prof Professor Safko
 * @date May 4, 2020
 */

public class Driver {
	/*
	 * Balk: A customer can decide to not join a queue in the first place
	 * Renege: A customer can decide to leave the queue without being served 
	 * Jockey: A customer can decide to jump to another server if that server opens.
	 */

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		CustomerCreate custList = new CustomerCreate();
		// Class for creating customer (DO NOT use Customer() when making new customer).
		ServerCreate servList = new ServerCreate();
		// Class for creating server (DO NOT use Server() when making new server).
		//...Create() classes must be used to properly track unique ID numbers.

		System.out.println("Welcome to the SSM Queue and Server System");
		System.out.println("Team: Team Geese 2.0");
		System.out.println("Members: Kyle K, Tim G, Matt K, Victor C\n\n*****");

		do { // Repeating Menu + Selections
			System.out.println("\nSelect an Option for the System:");
			System.out.println("1. Create a [Customer]");
			System.out.println("2. Process a [Customer]");
			System.out.println("3. Open the second server");
			System.out.println("4. Close the second server");
			System.out.println("5. Find q-hat");
			System.out.println("6. Find u-hat");
			System.out.println("7. Find B(t)");
			System.out.println("8. Report on balking [customers]");
			System.out.println("9. Report on reneging [customers]");
			System.out.println("10. Report on jockeying [customers]");
			System.out.println("11. Quit");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Create a [Customer]

				break;
			case 2: // Process a [Customer]

				break;
			case 3: // Open the second server

				break;
			case 4: // Close the second server

				break;
			case 5: // Find q-hat

				break;
			case 6: // Find u-hat

				break;
			case 7: // Find B(t)

				break;
			case 8: // Report on balking [customers]

				break;
			case 9: // Report on reneging [customers]

				break;
			case 10: // Report on jockeying [customers]

				break;
			case 11: // Quit
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid choice.");
			}
		} while (run);
	}
}