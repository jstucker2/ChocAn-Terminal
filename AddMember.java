package project4;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Colin Adreon
 * This class gives the functionality of adding a member. It is accessed by the Account Controller and access the
 * Member class.
 */
public class AddMember {

	/**
	 * This is the specific method that accesses the Member class to make a member and then add it to the member
	 * list parameter. It is also passed scanner as a paramater to read user input.
	 * @param members
	 * @param sc
	 */
	public void addMember(List<Member> members, Scanner sc) {
		Member member = new Member();
		System.out.println("Enter member name:");
		member.setName(sc.nextLine(), sc);
		System.out.println("Enter member address:");
		member.setAddress(sc.nextLine(), sc);
		System.out.println("Enter member city:");
		member.setCity(sc.nextLine(), sc);
		System.out.println("Enter member state:");
		member.setState(sc.nextLine(), sc);
		System.out.println("Enter member Zip code:");
		member.setZipCode(sc.nextLine(), sc);
		System.out.println("Enter member Number: ");
		member.setNumber(sc.nextLine(), sc, members);
		System.out.println("Member Successfully Added.");
		members.add(member);
		return;
	}
}
