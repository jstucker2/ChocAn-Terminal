package project4;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Jeremy Tucker
 * This class is accessed by the operator terminal.
 * Implements the functions of managing member and provider accounts.
 * 
 */
public class AccountController {
	/**
	 * This method allows the user to choose to add update or delete a member. It takes the parameters of the list of members,
	 * and the scanner to read input. It accessed the AddMember Class for adding a member, DeleteMember Class for deleting a
	 * member, and UpdateMember class for updating a member.
	 * @param members
	 * @param sc
	 */
	public void manageMemberAccounts(List<Member> members, Scanner sc) {
		System.out.println("Enter a to Add Member");
		System.out.println("Enter d to Delete Member");
		System.out.println("Enter u to Update Member");
		sc.nextLine();
		String input = sc.nextLine();
		if(input.equals("a")) {
			AddMember add = new AddMember();
			add.addMember(members, sc);
		}
		else if(input.equals("d")) {
			DeleteMember delete = new DeleteMember();
			delete.deleteMember(members, sc);
		}
		else if(input.equals("u")) {
			UpdateMember update = new UpdateMember();
			update.updateMember(members, sc);
		}
		return;
	}

	/**
	 * This method allows the user to choose to add update or delete a provider. It takes the parameters of the list of providers,
	 * and the scanner to read input. It accessed the AddProvider Class for adding a provider, DeleteProvider Class for deleting a
	 * provider, and UpdateProvider class for updating a provider.
	 * @param providers
	 * @param sc
	 */
	public void manageProviderAccounts(List<Provider> providers, Scanner sc) {
		System.out.println("Enter a to Add Provider");
		System.out.println("Enter d to Delete Provider");
		System.out.println("Enter u to Update Provider");
		sc.nextLine();
		String input = sc.nextLine();
		if(input.equals("a")){
			AddProvider add = new AddProvider();
			add.addProvider(providers, sc);
		}
		else if(input.equals("d")) {
			DeleteProvider delete = new DeleteProvider();
			delete.deleteProvider(providers, sc);
		}
		else if(input.equals("u")) {
			UpdateProvider update = new UpdateProvider();
			update.updateProvider(providers, sc);
		} 
		return;
	}
}