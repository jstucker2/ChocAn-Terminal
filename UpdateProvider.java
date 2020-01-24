package project4;

import java.util.List;
import java.util.Scanner;
/**
 * @author Christian Childress
 * This class allows the user to update information pertaining to a specified provider.
 */
public class UpdateProvider{
	/**
	 * This method is passed the parameters of the list of providers and a scanner to read input. The user inputs the number of the
	 * provider that they would like to update, and then the provider list is iterated through until the correct provider is found. 
	 * If the provider is not found, the program prints Provider does not exist. If the provider is found, then the user is asked if
	 * they want to update the name, number, address, city, state and zip code in progressive order. If they say yes to any of
	 * those six, they enter in a new value for that specific field and that value is set to the correct Provider object
	 * of the providers list.
	 * @param providers
	 * @param sc
	 */
	public void updateProvider(List<Provider> providers, Scanner sc) {
		int num = -1;
		System.out.println("Enter number of provider to update:");
		String number = sc.nextLine();
		
		for(int i = 0; i < providers.size(); i++)
			if(number.equals(providers.get(i).getNumber()))
				num = i;
		
		if(num == -1) {
			System.out.println("Provider does not exist.");
			return;
		}
		System.out.println("Would You Like to Update Provider Name? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider name:");
			providers.get(num).setName(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Provider Number? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider number:");
			providers.get(num).setNumber(sc.nextLine(), sc, providers);
		}
		System.out.println("Would You Like to Update Provider Address? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider address:");
			providers.get(num).setAddress(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Provider State? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider state:");
			providers.get(num).setState(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Provider City? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider city:");
			providers.get(num).setCity(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Provider Zip Code? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new provider zip code:");
			providers.get(num).setZipCode(sc.nextLine(), sc);
		}
		return;
	}
}