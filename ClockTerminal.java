package project4;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * @author Jake Eagle
 * @author Garrett Peppers
 * This is the terminal that the clock interacts with to run the main accounting procedure.
 */

public class ClockTerminal {
	/**
	 * This is the method that is used to generate all reports at the end of the day on friday.
	 * @param members
	 * @param providers
	 * @param sc
	 * @throws IOException
	 */
	public void runMainAccountingProcedure(List<Member> members, List<Provider> providers, Scanner sc) throws IOException {
		GenerateSummaryReports sum = new GenerateSummaryReports();
		GenerateMemberReports mem = new GenerateMemberReports();
		GenerateProviderReports prov = new GenerateProviderReports();
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("EEE hh:mm:ss");  
		String strDate = dateFormat.format(date);
		
		if(strDate.equals("Sat 00:00:00")){
			
			sum.generateReport(members, providers, sc, false);
			for(int i = 0; i < members.size(); i++)
				mem.generateReport(members, providers, sc, i, false);
			for(int i = 0; i < providers.size(); i++)
				prov.generateReport(members, providers, sc, i, false);
		}
		
		else {
			System.out.println("It is not midnight on friday.");
			System.out.println("If you would like to generate reports anyway, override by typing y.");
			String input = sc.nextLine();
			if(input.equals("y")) {
				sum.generateReport(members, providers, sc, false);
				for(int i = 0; i < members.size(); i++)
					mem.generateReport(members, providers, sc, i, false);
				for(int i = 0; i < providers.size(); i++)
					prov.generateReport(members, providers, sc, i, false);
				
			}
		}
	}
}
