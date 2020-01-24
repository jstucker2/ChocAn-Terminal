package project4;

import java.util.List;
import java.util.Scanner;

/**
 * @author Jeremy Tucker
 * This class is the menu that an operator sees when they access the ChocAn Terminal.
 * It implements the function that access the account controller.
 */

public class OperatorTerminal {
	/**
	 * This is the method used to access the account controller. It asks the user if they would like to manage member or
	 * provider accounts, and depending on the input it accesses the manageMemberAccounts or the manageProviderAccounts methods
	 * of the AccountController class.
	 * @param members
	 * @param providers
	 * @param sc
	 */
	public void accessAccountController(List<Member> members, List<Provider> providers, Scanner sc) {
		System.out.println("Press m to Manage Member Accounts");
		System.out.println("Press p to Manage Provider Accounts");
		AccountController acc = new AccountController();
		String input = sc.next();
		if(input.equals("m")) {
			acc.manageMemberAccounts(members, sc);
			return;
		}
		else if(input.equals("p")) {
			acc.manageProviderAccounts(providers, sc);
			return;
		}
	}
}
