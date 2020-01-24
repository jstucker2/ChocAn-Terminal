package project4;

import java.util.List;
import java.util.Scanner;

/**
 * @author Colin Adreon
 * This class is accessed by the account controller and its one method is passed the list of members and scanner. 
 * It deletes a specified member from the member list.
 */
public class DeleteMember {
	/**
	 * This method is passed the parameters of the list of members and a scanner to read input. The user inputs the number of the
	 * member that they would like to delete, and then the members list is iterated through until the correct member is found
	 * and removed from the list. If the member is not found, the program prints Member does not exist.
	 * @param members
	 * @param sc
	 */
	public void deleteMember(List<Member> members, Scanner sc) {
		System.out.println("Enter the number of the member you would like to delete.");
		String number = sc.nextLine();
		for(int i = 0; i < members.size(); i++) {
			if(number.equals(members.get(i).getNumber())) {
				members.remove(i);
				System.out.println("Member successfully deleted");
				return;
			}
		}
		System.out.println("Member does not exist");
		return;
	}
}