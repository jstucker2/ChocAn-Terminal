package project4;

import java.util.List;
import java.util.Scanner;

/**
 * @author Colin Adreon
 * This class gives the functionality of adding a provider. It is accessed by the Account Controller and access the
 * Provider class.
 */
public class AddProvider {
	/**
	 * This is the specific method that accesses the Provider class to make a provider and then add it to the provider
	 * list parameter. It is also passed scanner as a paramater to read user input.
	 * @param providers
	 * @param sc
	 */
	public void addProvider(List<Provider> providers, Scanner sc) {
		Provider provider = new Provider();
		System.out.println("Enter provider name:");
		provider.setName(sc.nextLine(), sc);
		System.out.println("Enter provider address:");
		provider.setAddress(sc.nextLine(), sc);
		System.out.println("Enter provider city:");
		provider.setCity(sc.nextLine(), sc);
		System.out.println("Enter provider state:");
		provider.setState(sc.nextLine(), sc);
		System.out.println("Enter provider Zip code:");
		provider.setZipCode(sc.nextLine(), sc);
		System.out.println("Enter provider Number: ");
		provider.setNumber(sc.nextLine(), sc, providers);
		System.out.println("Provider Successfully Added.");
		providers.add(provider);
		return;
	}
}