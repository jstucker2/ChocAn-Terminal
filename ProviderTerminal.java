package project4;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jeremy Tucker
 * This is the menu that providers interact with when using the ChocAn Terminal.
 * Implements functionalities of verifying service codes, looking up service codes, billing
 * Chocan, and requesting provider directory.
 */
public class ProviderTerminal {
	/**
	 * This is the method that is accessed when billing choc an, it first gets the provider index, then allows the user to
	 * enter a member number, enter a date of service, and then asks the user if they would like to view the provider directory.
	 * If yes, the provider directory is displayed. Then a service code gets entered, the current date and time are retrieved,
	 * and lastly additional comments are entered.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param serviceCodes
	 * @param serviceNames
	 * @param serviceFees
	 * @param providerNum
	 */
	public void billChocAn(List<Member> members, List<Provider> providers, Scanner sc, String [] serviceCodes, String [] serviceNames, String [] serviceFees, String providerNum) {
		BillChocoholicsAnonymous bill = new BillChocoholicsAnonymous();
		bill.getProviderIndex(members, providers, sc, providerNum);
		bill.enterMemberNumber(members, providers, sc);
		bill.enterDateOfService(members, providers, sc);
		System.out.println("Would you like to use the provider directory to look up a service code? y/n");
		if(sc.nextLine().equals("y")) {
			for(int i = 0; i < serviceCodes.length; i++) {
				System.out.println("SERVICE: " + serviceNames[i]);
				System.out.println("CODE: " + serviceCodes[i]);
				System.out.println();
			}
		}	
		bill.enterServiceCode(members, providers, sc, serviceCodes, serviceFees, serviceNames);
		bill.getCurrentDateAndTime(members, providers);
		bill.enterAdditionalComments(members, providers, sc);
	}
	/**
	 * This is the method that allows the user to view the provider directory. It iterates through its two paramters to display
	 * all of the available services and their respective service codes.
	 * @param serviceNames
	 * @param serviceCodes
	 */
	public void viewProviderDirectory(String [] serviceNames, String [] serviceCodes) {
		for(int i = 0; i < serviceCodes.length; i++) {
			System.out.println("SERVICE: " + serviceNames[i]);
			System.out.println("CODE: " + serviceCodes[i]);
			System.out.println();
		}
	}
}
