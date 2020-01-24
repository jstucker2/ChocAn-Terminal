package project4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Christian Childress
 * This class is accessed by the GenerateReports Class. It is an extension of GenerateReports and uses the 
 * email and print report methods of GenerateReports. It prints out the providers names and numbers who provided services, 
 * the provideers fees, and the total number of consultations and the total fee.
 */
public class GenerateSummaryReports extends GenerateReports {
	/**
	 * This is the method that writes the Summary report to a file. It gets its information from the parameters of the 
	 * list of members and the list of providers, and also has a scanner and flag as parameters. If the flag is true,
	 * the user is given the option to print and email the report. If it is false then they are not given those options.
	 * @param members
	 * @param providers
	 * @param sc
	 * @param flag
	 * @throws IOException
	 */
	public void generateReport(List<Member> members, List<Provider> providers, Scanner sc, boolean flag) throws IOException {
		List<String> fees = new ArrayList<String>();
		int counter = 0;
		int secondcounter = 0;
		double overallFee = 0;
		FileWriter reportWriter = new FileWriter("SummaryReport.txt");
		reportWriter.write("SUMMARY REPORT");
		reportWriter.write(System.lineSeparator());
		reportWriter.write(System.lineSeparator());
		for(int i = 0; i < providers.size(); i++) {
			double fee = 0;
			for(int j = 0; j < providers.get(i).getSize(); j++) {
				if(j == 0) {
					reportWriter.write("Provider Name: " + providers.get(i).getName());
					reportWriter.write(System.lineSeparator());
					reportWriter.write("Provider Number: " + providers.get(i).getNumber());
					reportWriter.write(System.lineSeparator());
					counter ++;
				}
				secondcounter++;
				fees.add(providers.get(i).getServiceFee(j));	
			}
			if(providers.get(i).getSize() > 0) {
				for(int j = 0; j < fees.size(); j++) {
					fee += Double.parseDouble(fees.get(j));
				}
				overallFee += fee;
				reportWriter.write("Number of Consultations: " + providers.get(i).getSize());
				reportWriter.write(System.lineSeparator());
				reportWriter.write("Provider Fees: " + fee);
				reportWriter.write(System.lineSeparator());
			}
			fees = new ArrayList<String>();
			reportWriter.write(System.lineSeparator());
		}
		reportWriter.write("Number of Providers Who Provided Services: " + counter);
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Total Number of Consultations: " + secondcounter);
		reportWriter.write(System.lineSeparator());
		reportWriter.write("Overall Fee: " + overallFee);
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
