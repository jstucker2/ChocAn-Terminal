package project4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jake Eagle
 * This class  gives access to the providers to bill through ChocAn. It is accessed by the Provider Terminal.
 */
public class BillChocoholicsAnonymous {
	private int memberIndex = 0;
	private int providerIndex = 0;
	
	/**
	 * This method allows the user to enter a member number to bill choc an. It has the parameters of the list of
	 * members, providers, and it is also passed scanner to read user input. After a correct unique number is detected,
	 * the method writes it to the providers list for the specific provider.
	 * @param members
	 * @param providers
	 * @param sc
	 */
	public void enterMemberNumber(List<Member> members, List<Provider> providers, Scanner sc) {
		boolean flag = true;
		String memberNumber = "";
		while(flag == true) {
			System.out.println("Enter 9 digit Member Number:");
			memberNumber = sc.nextLine();
			while (memberNumber.length() != 9){
				System.out.println("Member number must be 9 digits, enter again:");
				memberNumber = sc.nextLine();
			}
			for(int i = 0; i < members.size(); i++) {
				if(memberNumber.equals(members.get(i).getNumber())) {
					flag = false;
					memberIndex = i;
					break;
				}
			}
			if(flag == true)
				System.out.println("Member Not Found");
		}
		System.out.println("VALIDATED");
		providers.get(providerIndex).setMemberNumber(memberNumber);
		members.get(memberIndex).setProviderNumber(providers.get(providerIndex).getNumber());
		return;
	}
	
	/**
	 * This method gets the index of the provider in the list of the providers. It has the parameters of the 
	 * list of members, providers, scanner, and the provider number input to access the Provider Terminal.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param str
	 */
	public void getProviderIndex(List<Member> members, List<Provider> providers, Scanner sc, String str) {
		String providerNumber = str;
		for(int i = 0; i < providers.size(); i++) {
			if(providerNumber.equals(providers.get(i).getNumber())) {
				providerIndex = i;
				break;
			}
		}
		return;
	}
	
	/**
	 * This method allows the user to enter the date of the service provided. It takes the parameters of the
	 * list of members, the list of providers, and the scanner to read user input. If the date is too long, it asks the 
	 * user to enter again. Then, once a correct date is entered, it is written to the correct member in the member list
	 * and the correct provider in the provider list.
	 * @param members
	 * @param providers
	 * @param sc
	 */
	public void enterDateOfService(List<Member> members, List<Provider> providers, Scanner sc) {
		System.out.println("Enter Date of Service in the format MM-DD-YYYY:");
		String dateOfService = sc.nextLine();
		while (dateOfService.length() != 10){
			System.out.println("Date Of Service must be in the format MM-DD-YYYY, enter again:");
			dateOfService = sc.nextLine();
		}
		members.get(memberIndex).setDateOfService(dateOfService);
		providers.get(providerIndex).setDateOfService(dateOfService);
		return;
	}
	/**
	 * This is the method that allows the user to enter a service code. Once a correct code has been entered, it
	 * displays the service corresponding to the code and asks the user if this is the correct service.
	 * If they enter y, then the service code, fee, and name are both written to the correct provider and member.
	 * The parameters passed to this method are the list of members, list of providers, the scanner to read user input,
	 * the array of service codes, the array of service names, and the array of service fees.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param serviceCodes
	 * @param serviceFees
	 * @param serviceNames
	 */
	public void enterServiceCode(List<Member> members, List<Provider> providers, Scanner sc, String [] serviceCodes, String [] serviceFees, String [] serviceNames) {
		boolean flag = false;
		int index = 0;
		String serviceCode = "";
		while(flag == false) {
			System.out.println("Enter 6 digit Service Code:");
			serviceCode = sc.nextLine();
			for(int i = 0; i < serviceCodes.length; i++) {
				if(serviceCode.equals(serviceCodes[i])) {
					System.out.println("Is this the service you entered? : " + serviceNames[i]);
					System.out.println("Enter y for yes or n for no");
					if(sc.nextLine().equals("y")) {
						flag = true;
						index = i;
						break;
					}
					break;
				}
			}
			if(flag == false)
				System.out.println("Invalid Service Code.");
		}
		members.get(memberIndex).setServiceCode(serviceCode);
		providers.get(providerIndex).setServiceCode(serviceCode);
		members.get(memberIndex).setServiceFee(serviceFees[index]);
		providers.get(providerIndex).setServiceFee(serviceFees[index]);
		members.get(memberIndex).setServiceName(serviceNames[index]);
		providers.get(providerIndex).setServiceName(serviceNames[index]);
		return;
	}
	/**
	 * This method gets the current date and time and writes it to the correct member and provider in their respective
	 * lists. It has the parameters of the list of members and the list of providers.
	 * @param members
	 * @param providers
	 */
	public void getCurrentDateAndTime(List<Member> members, List<Provider> providers) {
		String currentTime = "";
		String currentDate = "";
		
		DateFormat time = new SimpleDateFormat("HH:mm:ss");
		Date cal = Calendar.getInstance().getTime();
		currentTime = time.format(cal);
		
		DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		Date date2 = new Date();
		currentDate = date.format(date2);
		
		members.get(memberIndex).setCurrentDate(currentDate);
		providers.get(providerIndex).setCurrentDate(currentDate);
		members.get(memberIndex).setCurrentTime(currentTime);
		providers.get(providerIndex).setCurrentTime(currentTime);
		return;
	}
	
	/**
	 * This method allows the user to enter additional comments up to 100 characters to add to the choc an bill.
	 * The comments are then written to the member and provider being acted upon.
	 * This method has the paramters of the list of members, list of providers, and scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 */
	public void enterAdditionalComments(List<Member> members, List<Provider> providers, Scanner sc) {
		System.out.println("Enter Additional Comments (up to 100 characters):");
		String additionalComments = sc.nextLine();
		while (additionalComments.length() > 100){
			System.out.println("Comments can not exceed 100 characters, enter again:");
			additionalComments = sc.nextLine();
		}
		members.get(memberIndex).setComments(additionalComments);
		providers.get(providerIndex).setComments(additionalComments);
		return;
	}
}