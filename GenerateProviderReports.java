package project4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Christian Childress
 * This class is accessed by the GenerateReports Class. It is an extension of GenerateReports and uses the 
 * email and print report methods of GenerateReports. It reads in the data for a specific provider to print out a report
 * containing the provider name, number, address, city, state, zip code, and the data pertaining to any services. It also
 * contains the total number of consultations and the total fee.
 * they received.
 */
public class GenerateProviderReports extends GenerateReports {
	/**
	 * This class asks the user to enter the number of the provider they would like to generate a report for.
	 * After the number is entered, the method iterates through the providers list until it finds a provider number that
	 * matches the inputed number. Once the number is found, the providers index in the providers list is recorded, and eventually
	 * passed to the generateReport method. This class has the parameters of the list of members, list of providers,
	 * and scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void getProvider(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		System.out.println("Enter the Number of the Provider you would like to generate a report for.");
		sc.nextLine();
		String num = sc.nextLine();
		int index = 0;
		for(int j = 0; j < providers.size(); j++) {
			if(num.equals(providers.get(j).getNumber())) {
				index = j;
				break;
			}
		}
		generateReport(members, providers, sc, index, true);
	}
	/**
	 * This is the method that writes the Provider report to a file. It gets its information from the parameters of the 
	 * list of members and the list of providers, and also has a scanner, index, and flag as parameters. If the flag is true,
	 * the user is given the option to print and email the report. If it is false then they are not given those options.
	 * The Provider that the report is generated for is decided by the index, which comes from the getProvider function
	 * in this class that takes in a provider number and finds its location in the provider list.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param index
	 * @param flag
	 * @throws IOException
	 */
	public void generateReport(List<Member> members, List<Provider> providers, Scanner sc, int index, boolean flag) throws IOException {
		String name = "";
		for(int i = 0; i < providers.get(index).getName().length(); i++) {
			if(providers.get(index).getName().charAt(i) != ' ')
				name += providers.get(index).getName().charAt(i);
		}
		FileWriter reportWriter = new FileWriter(name + "ProviderReport.txt");
		reportWriter.write("PROVIDER REPORT");
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Name: " + providers.get(index).getName());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Number: " + providers.get(index).getNumber());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Address: " + providers.get(index).getAddress());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("City: " + providers.get(index).getCity());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("State: " + providers.get(index).getState());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Zip Code: "+ providers.get(index).getZipCode());
		reportWriter.write(System.lineSeparator());
		reportWriter.write(System.lineSeparator());
		double totalFee = 0;
		for(int i = 0; i < providers.get(index).getSize(); i++) {
			reportWriter.write("Date of Service: " + providers.get(index).getDateOfService(i));
			reportWriter.write(System.lineSeparator());
			reportWriter.write("Date Data was Received by the Computer: " + providers.get(index).getCurrentDate(i));
			reportWriter.write(System.lineSeparator());
			reportWriter.write("Time Data was Received by the Computer: " + providers.get(index).getCurrentTime(i));
			reportWriter.write(System.lineSeparator());
			String memberName = "";
			String memberNum = providers.get(index).getMemberNumber(i);
			for(int j = 0; j < providers.size(); j++) {
				if(memberNum.equals(members.get(j).getNumber())) {
					memberName = members.get(j).getName();
					break;
				}
			}
			reportWriter.write("Name of Member who Received Service: " + memberName);
			reportWriter.write(System.lineSeparator());
			reportWriter.write("Number of Member who Received Service: " + memberNum);
			reportWriter.write(System.lineSeparator());
			reportWriter.write("Service Code: " + providers.get(index).getServiceCode(i));
			reportWriter.write(System.lineSeparator());
			String fee = providers.get(index).getServiceFee(i);
			reportWriter.write("Service Fee: " + fee);
			reportWriter.write(System.lineSeparator());
			reportWriter.write(System.lineSeparator());
			totalFee += Double.parseDouble(fee);
		}
		reportWriter.write("Total Number Of Consultations: " + providers.get(index).getSize());
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Total Service Fee: " + totalFee);
		reportWriter.write(System.lineSeparator());
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
