package project4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jeremy Tucker
 * This class is the main terminal. It creats the storage variables for members and providers, and also sets
 * the service codes, names, and fees. This class gives access to the 4 other terminals depending on user input.
 */

public class ChocAnTerminal {
	private final String [] serviceCodes = {"123456", "654321", "111111", "222222", "598470", "123654", "883948"};
	private final String [] serviceNames = {"Yoga", "Chocolate Detox", "Massage", "Personal Training", "Dietician", "Therapy", "Aerobics Exercise Session"};
	private final String [] serviceFees = {"75.50", "30.35", "100", "157.75", "130.15", "75", "50.50"};
	private  List<Member> members = new ArrayList<Member>();
	private  List<Provider> providers = new ArrayList<Provider>();
	
	/**
	 * Gives access to the Manager Terminal and calls upon the generateReports method. The generateReports method 
	 * uses the parameters of the list of members, providers, and the scanner used to read user input.
	 * @param sc
	 * @throws IOException
	 */
	public void accessManagerTerminal(Scanner sc) throws IOException {
		ManagerTerminal m = new ManagerTerminal();
		m.generateReports(members, providers, sc);
	}
	/**
	 * Gives access to the Provider Terminal if the user can input a valid provider number. Sends you back to the main 
	 * terminal if no members exist yet or if an invalid number was entered. If a valid number was entered and there
	 * exists at least one member, then the Provider starts to enter the information needed to bill Choc An.
	 * @param sc
	 */
	
	public void accessProviderTerminal(Scanner sc) {
		System.out.println("To Access the Provider Terminal, Enter your Provider Number:");
		String providerNum = sc.nextLine();
		boolean flag = false;
		for(int i = 0; i < providers.size(); i++) {
			if(providers.get(i).getNumber().equals(providerNum)){
				flag = true;
				System.out.println("ACCESS GRANTED");
				break;
			}
		}
		if(flag == true) {
			ProviderTerminal p = new ProviderTerminal();
			System.out.println("PROVIDER TERMINAL");
			System.out.println("Enter b to Bill ChocAn");
			System.out.println("Enter p to look up Provider Directory");
			String input = sc.nextLine();
			if(input.equals("b")) {
				if(members.size() > 0)
					p.billChocAn(members, providers, sc, serviceCodes, serviceNames, serviceFees, providerNum);
				else
					System.out.println("You must add a member before you can bill Chocoholics Anonymous");
			}
			else if(input.equals("p")) {
				p.viewProviderDirectory(serviceNames, serviceCodes);
			}
		}
		else {
			System.out.println("ACCESS DENIED");
		}
	}
	
	/**
	 * This gives access to the operator terminal and more specfically the account controller method. The parameters
	 * passed to the method are the list of members, providers, and the scanner used to read user input.
	 * @param sc
	 */
	public void accessOperatorTerminal(Scanner sc) {
		OperatorTerminal o = new OperatorTerminal();
		o.accessAccountController(members, providers, sc);
	}
	
	/**
	 * This gives access to the clock terminal and more specifically the runMainAccountingProcedure method. The
	 * parameters passed to the method are the list of members, providers, and the scanner used to read user input.
	 * @param sc
	 * @throws IOException
	 */
	public void accessClockTerminal(Scanner sc) throws IOException {
		ClockTerminal c = new ClockTerminal();
		c.runMainAccountingProcedure(members, providers, sc);
	}
}
