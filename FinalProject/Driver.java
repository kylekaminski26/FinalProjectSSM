package FinalProject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

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
	
	/*
	 * ISSUES:
	 * Code for Balk needed
	 * Code for Renege needed
	 * Code for Jockey needed
	 */
	
	static int time = 0; // Global time keeper
	public static void main(String[] args) {
		final int EXPRESS_CHECKOUT_SIZE = 5; // Number of items allowed for express checkout
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Random randy = new Random();
		Server server1 = new Server("Regular");
		Server server2 = new Server("Express");

		server1.setOpen(true); // Start the first server open; can take any size cart
		server2.setOpen(false); // Start the second server closed; counts as the express lane

		Customer c;
		String name;

		System.out.println("Welcome to the SSM Queue and Server System");
		System.out.println("Team: Team Geese 2.0");
		System.out.println("Members: Kyle K, Tim G, Matt K, Victor C\n\n*****");

		do { // Repeating Menu + Selections
            clearScreen();
			System.out.println("\nSelect an Option for the System:");
			System.out.println("1. Create a [Customer]");
			System.out.println("2. Increment Time"); //Process a [Customer]");
			System.out.println("3. Open the second server");
			System.out.println("4. Close the second server");
			System.out.println("5. Find q-hat");
			System.out.println("6. Find u-hat");
			System.out.println("7. Find B(t)");
			System.out.println("8. Report on balking [customers]");
			System.out.println("9. Report on reneging [customers]");
			System.out.println("10. Report on jockeying [customers]");
			System.out.println("11. Quit");
			int choice = sc.nextInt();


			switch (choice) {

			case 1: // Create a [Customer]
				System.out.println("Enter Customer name:");
				name = sc.next();
				c = new Customer(name,getTime()); //Matt -K : changed constructor
				String added = "null";

                // Server Placement (will they go to express?)
		// This also includes the statements of whether they balk or not	
				if (server2.getOpen() && c.getCart() <= EXPRESS_CHECKOUT_SIZE) {
					//
					if(server2.getSize() > 5 && randy.nextInt(100) % 10 == 0){
						System.out.println(c.getName() + " choose to balk.");
						enterToContinue();
					}
					else {
						server2.enqueue(c);
						added = server2.getName();
						System.out.println(c.getName() + " added to " + added + ".");
					}	

				} else {
					if(server1.getSize() > 5 && randy.nextInt(100) % 10 == 0){
						System.out.println(c.getName() + " choose to balk.");
						enterToContinue();
					}
					else {
						server1.enqueue(c);
						added = server1.getName();
						System.out.println(c.getName() + " added to " + added + ".");
					}
				}				
				break;

			case 2:    //increment time and update system 

                addTime();

                //process servers

                server1.update();
                server2.update();                
                System.out.print("Time: " + time);

                enterToContinue();


                        break;
			case 3: // Open the second server
				server2.open();
				System.out.println(server2.getName() + " is now open.");
                enterToContinue();
				break;
			case 4: // Close the second server
				server2.close(server1);
				System.out.println(server2.getName() + " is now closed.");
				System.out.println("Moving all customers to the end of " + server1.getName());
			    enterToContinue();	
				break;
			case 5: // Find q-hat
				System.out.println("q_hat of " + server1.getName() + ": " + server1.getQ_Hat(time));
				System.out.println("q_hat of " + server2.getName() + ": " + server2.getQ_Hat(time));
                enterToContinue();
				break;
			case 6: // Find u-hat
				System.out.println("u_hat of " + server1.getName() + ": " + server1.getU_Hat(time));
				System.out.println("u_hat of " + server2.getName() + ": " + server2.getU_Hat(time));
                enterToContinue();
				break;
			case 7: // Find B(t)
				System.out.println("B(T) of " + server1.getName() + ": " + server1.B_T());
				System.out.println("B(T) of " + server2.getName() + ": " + server2.B_T());
                enterToContinue();
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
	
	/*
	 * @returns the global time.
	 * 
	 */
	private static int getTime() {
		return time;
	}

	/*
	 * Increments the global time.
	 */
	private static void addTime() {
		time++;
//		balk();
//		renege();
//		jockey();
	}
	
//	private static String renege() {
//		
//	}
 
   public static void clearScreen() {  
         System.out.print("\033[H\033[2J");  
         System.out.flush();  
    }   

   //halts program execution until an input is given
   public static void enterToContinue()
    {
         try {
             System.in.read();
         } catch (IOException e){}
    } 




}
