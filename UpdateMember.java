package project4;

import java.util.List;
import java.util.Scanner;
/**
 * @author Christian Childress
 * This class allows the user to update information pertaining to a specified member.
 */
public class UpdateMember{
	/**
	 * This method is passed the parameters of the list of members and a scanner to read input. The user inputs the number of the
	 * member that they would like to update, and then the members list is iterated through until the correct member is found. 
	 * If the member is not found, the program prints Member does not exist. If the member is found, then the user is asked if
	 * they want to update the name, number, address, city, state and zip code in progressive order. If they say yes to any of
	 * those six, they enter in a new value for that specific field and that value is set to the correct Member object
	 * of the members list.
	 * @param members
	 * @param sc
	 */
	public void updateMember(List<Member> members, Scanner sc) {
		int num = -1;
		System.out.println("Enter number of member to update:");
		String number = sc.nextLine();
		
		for(int i = 0; i < members.size(); i++)
			if(number.equals(members.get(i).getNumber()))
				num = i;
		
		if(num == -1) {
			System.out.println("Member does not exist.");
			return;
		}
		System.out.println("Would You Like to Update Member Name? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member name:");
			members.get(num).setName(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Member Number? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member number:");
			members.get(num).setNumber(sc.nextLine(), sc, members);
		}
		System.out.println("Would You Like to Update Member Address? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member address:");
			members.get(num).setAddress(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Member State? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member state:");
			members.get(num).setState(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Member City? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member city:");
			members.get(num).setCity(sc.nextLine(), sc);
		}
		System.out.println("Would You Like to Update Member Zip Code? y/n:");
		if(sc.nextLine().equals("y")) {
			System.out.println("Enter new member zip code:");
			members.get(num).setZipCode(sc.nextLine(), sc);
		}
		return;
	}
}