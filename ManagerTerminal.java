package project4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Tucker
 * This class is what the manager sees when they access our program.
 * It gives them access to the functionalities of view/edit summary, provider, and member reports.
 */

public class ManagerTerminal {
	/**
	 * This is the method that contains the manager terminal that gives the user the choice of which report to generate.
	 * It creates an object of the GenerateReports class, and depending on user input, it either accesses the 
	 * generateSummaryReport method, the generateProviderReport method, or the generateMemberReport method.
	 * It takes parameters of the list of providers, the list of members, and the scanner to read user input.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void generateReports(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		GenerateReports generate = new GenerateReports();
		System.out.println("MANAGER TERMINAL");
		System.out.println("Enter s to Generate Summary Report");
		System.out.println("Enter p to Generate Provider Report");
		System.out.println("Enter m to Generate Member Report");
		String input = sc.next();
		if(input.equals("s"))
			generate.generateSummaryReport(members, providers, sc);
		else if(input.equals("p"))
			generate.generateProviderReport(members, providers, sc);
		else if(input.equals("m"))
			generate.generateMemberReport(members, providers, sc);
	}
}