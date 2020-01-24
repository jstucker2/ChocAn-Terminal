package project4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Christian Childress
 * This class is accessed by the GenerateReports Class. It is an extension of GenerateReports and uses the 
 * email and print report methods of GenerateReports. It reads in the data for a specific member to print out a report
 * containing the member name, number, address, city, state, zip code, and the data pertaining to any services
 * they received.
 */

public class GenerateMemberReports extends GenerateReports{
	
	/**
	 * This class asks the user to enter the number of the member they would like to generate a report for.
	 * After the number is entered, the method iterates through the members list until it finds a member number that
	 * matches the inputed number. Once the number is found, the members index in the members list is recorded, and eventually
	 * passed to the generateReport method. This class has the parameters of the list of members, list of providers,
	 * and scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void getMember(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		System.out.println("Enter the Number of the Member you would like to generate a report for.");
		sc.nextLine();
		String num = sc.nextLine();
		int index = 0;
		for(int j = 0; j < members.size(); j++) {
			if(num.equals(members.get(j).getNumber())) {
				index = j;
				break;
			}
		}
		generateReport(members, providers, sc, index, true);
	}
	/**
	 * This is the method that writes the Member report to a file. It gets its information from the parameters of the 
	 * list of members and the list of providers, and also has a scanner, index, and flag as parameters. If the flag is true,
	 * the user is given the option to print and email the report. If it is false then they are not given those options.
	 * The member that the report is generated for is decided by the index, which comes from the getMember function
	 * in this class that takes in a member number and finds its location in the member list.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param flag
	 * @param index
	 * @throws IOException
	 */
	public void generateReport(List<Member> members, List<Provider> providers, Scanner sc, int index, boolean flag) throws IOException {
		String name = "";
		for(int i = 0; i < members.get(index).getName().length(); i++) {
			if(members.get(index).getName().charAt(i) != ' ')
				name += members.get(index).getName().charAt(i);
		}
		FileWriter reportWriter = new FileWriter(name + "MemberReport.txt");
		reportWriter.write("MEMBER REPORT");
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Name: " + members.get(index).getName());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Number: " + members.get(index).getNumber());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Address: " + members.get(index).getAddress());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("City: " + members.get(index).getCity());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("State: " + members.get(index).getState());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Zip Code: "+ members.get(index).getZipCode());
		reportWriter.write(System.lineSeparator());
		reportWriter.write(System.lineSeparator());
		for(int j = 0; j < members.get(index).getSize(); j++) {
			reportWriter.write("Date of Service: " + members.get(index).getDateOfService(j));
			reportWriter.write(System.lineSeparator());
			String providerName = "";
			String providerNum = members.get(index).getProviderNumber(j);
			for(int k = 0; k < providers.size(); k++) {
				if(providerNum.equals(providers.get(k).getNumber())) {
					providerName = providers.get(k).getName();
					break;
				}
			}
			reportWriter.write("Provider Name: " + providerName);
			reportWriter.write(System.lineSeparator());
			reportWriter.write("Service Name: " + members.get(index).getServiceName(j));
			reportWriter.write(System.lineSeparator());
			reportWriter.write(System.lineSeparator());
		}
		reportWriter.close();
		if(flag == true) {
			System.out.println("Would you like to print the Report? y/n");
			if(sc.nextLine().equals("y"))
				printReport();
			System.out.println("Would you like to email the Report? y/n");
			if(sc.nextLine().equals("y")) {
				System.out.println("Enter the email you would like to send the report to.");
				String email = sc.nextLine();
				emailReport(email);
			}
		}
	}
	/**
	 * This is the method that prints the report. It calls the super class and runs the method in GenerateReports.
	 */
	public void printReport() {
		super.printReport();
	}
	/**
	 * This is the method that emails the report. It calls the super class and runs the method in GenerateReports.
	 * Its one parameter is a string that is the email that the user wants to send the report to.
	 * @param email
	 */
	public void emailReport(String email) {
		super.emailReport(email);
	}
}
