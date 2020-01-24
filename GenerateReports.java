package project4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Tucker
 * This class is accessed by the manager terminal when they select the option of generating reports.
 * Implements the functions of generating summary, provider, and member reports.
 * Also, it gives the functionality of generating a report, printing a report, and emailing a report
 * to its three subclasses, which are the generate summary, provider, and member reports classes.
 *
 */

public class GenerateReports {
	/**
	 * This is the method that is accessed when generating a summary report. It creates an object of the GenerateSummaryReports
	 * class, and calls upon the generateReport method in that object. It has the parameters of the list of members, the list
	 * of providers, and the scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void generateSummaryReport(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		GenerateSummaryReports s = new GenerateSummaryReports();
		s.generateReport(members, providers, sc, true);
	}
	/**
	 * This is the method that is accessed when generating a provider report. It creates an object of the GenerateProviderReports
	 * class, and calls upon the generateReport method in that object. It has the parameters of the list of members, the list
	 * of providers, and the scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void generateProviderReport(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		GenerateProviderReports p = new GenerateProviderReports();
		p.getProvider(members, providers, sc);
	}
	/**
	 * This is the method that is accessed when generating a member report. It creates an object of the GenerateMemberReports
	 * class, and calls upon the generateReport method in that object. It has the parameters of the list of members, the list
	 * of providers, and the scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void generateMemberReport(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		GenerateMemberReports m = new GenerateMemberReports();
		m.getMember(members, providers, sc);
	}
	/**
	 * This is the method that prints the report. It is accessed by its three subclasses if the user decides to print the
	 * report they generated.
	 */
	public void printReport() {
		System.out.println("Report Printing");
	}
	/**
	 * This is the method that theoretically emails the report. It is accessed by its three subclasses if the user decides
	 * to email the report they generated. Its one parameter is the String of the email that the user wants to send the report
	 * to.
	 * @param email
	 */
	public void emailReport(String email) {
		System.out.println("Report sent to " + email);
	}

}
