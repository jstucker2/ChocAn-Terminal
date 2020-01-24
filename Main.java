package project4;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author Jeremy Tucker
 * This class is the top level entry of our program. It takes user input and directs the user to the correct terminal.
 * It creates an object of the ChocAnTerminal class, which gives access to the rest of the classes in the program.
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	/**
	 * This is our main method. It starts the program and creates an object of the ChocAnTerminal class, which is used to access
	 * the rest of the project.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[]args) throws IOException {
		ChocAnTerminal choc = new ChocAnTerminal();
		while(true) {
			System.out.println("CHOCAN TERMINAL");
			System.out.println("Enter m for Manager Terminal");
			System.out.println("Enter p for Provider Terminal");
			System.out.println("Enter o for Operator Terminal");
			System.out.println("Enter c for Clock Terminal");
		
			String input = sc.nextLine();
			
			if(input.equals("m"))
				choc.accessManagerTerminal(sc);
			else if(input.equals("p"))
				choc.accessProviderTerminal(sc);
			else if(input.equals("o")) 
				choc.accessOperatorTerminal(sc);
			else if(input.equals("c")) 
				choc.accessClockTerminal(sc);
			System.out.println("Enter 1 if you would like to continue using the ChocAn Terminal");
			input = sc.nextLine();
			if(!input.contentEquals("1")) {
				sc.close();
				System.out.println("TERMINATED");
				break;
			}
		}
	}
}
