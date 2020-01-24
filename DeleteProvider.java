package project4;

import java.util.List;
import java.util.Scanner;

/**
 * @author Colin Adreon
 * This class is accessed by the account controller and its one method is passed the list of providers and scanner. 
 * It deletes a specified provider from the provider list.
 */
public class DeleteProvider {
	/**
	 * This method is passed the parameters of the list of providers and a scanner to read input. The user inputs the number of the
	 * provider that they would like to delete, and then the providers list is iterated through until the correct provider is found
	 * and removed from the list. If the provider is not found, the program prints Provider does not exist.
	 * @param providers
	 * @param sc
	 */
	public void deleteProvider(List<Provider> providers, Scanner sc) {
		System.out.println("Enter the number of the provider you would like to delete.");
		String number = sc.nextLine();
		for(int i = 0; i < providers.size(); i++) {
			if(number.equals(providers.get(i).getNumber())) {
				providers.remove(i);
				System.out.println("Provider successfully deleted");
				return;
			}
		}
		System.out.println("Provider does not exist");
		return;
	}
}