package project4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jeremy Tucker
 * @author Colin Adreon
 * This class sets and stores all data for an individual provider
 */
public class Provider {
	private String name;
	private String number;
	private String address;
	private String city;
	private String state;
	private String zip;
	private List<String> dateOfServices = new ArrayList<String>();
	private List<String> serviceCodes = new ArrayList<String>();
	private List<String> serviceFees = new ArrayList<String>();
	private List<String> serviceNames = new ArrayList<String>();
	private List<String> memberNumbers = new ArrayList<String>();
	private List<String> currentDates = new ArrayList<String>();
	private List<String> currentTimes = new ArrayList<String>();
	private List<String> comments = new ArrayList<String>();
	private int size;
	
	/**
	 * This is the default constructor for our class that sets the name, number, address, city, state, and zip to an empty string
	 * while setting the size to zero.
	 */
	public Provider() {
		name = "";
		number = "";
		address = "";
		city = "";
		state = "";
		zip = "";
		size = 0;
	}

	/**
	 * This is the method that sets the name of the provider. It takes in the parameters of the String nam and the scanner, and if 
	 * the name is greater than 25 characters, the user is told to reenter the name. If the name is the correct length,
	 * it is added to the name field of the Provider class.
	 * @param nam
	 * @param sc
	 */
	public void setName(String nam, Scanner sc) {
		String str = nam;
		while (str.length() > 25) {
			System.out.println("25 character maximum, try again:");
			str = sc.nextLine();
		}
		name = str;
		return;
	}
	/**
	 * This is the method that sets the number of the provider. It takes in the parameters of the String num and the scanner, and if 
	 * the number is not equal to 9 characters or if the number is not unique, the user is told to reenter the number. If the number is the correct length,
	 * it is added to the number field of the Provider class.
	 * @param num
	 * @param sc
	 */
	public void setNumber(String num, Scanner sc, List<Provider> providers) {
		String str = num;
		boolean flag = false;
		while (flag == false) {
			while (str.length() != 9) {
				System.out.println("Must be 9 digits, try again:");
				str = sc.nextLine();
			}
			if(providers.size() == 0)
				flag = true;
			for(int i = 0; i < providers.size(); i++) {
				if(providers.get(i).getNumber().equals(str)) {
					System.out.println("ERROR: Number must be unique. Try again.");
					str = sc.nextLine();
					break;
				}
				else if(i == providers.size()-1)
					flag = true;
			}
			
		}
		number = str;
		return;
	}
	/**
	 * This is the method that sets the address of the provider. It takes in the parameters of the String adr and the scanner, and if 
	 * the address is greater than 25 characters, the user is told to reenter the address. If the address is the correct length,
	 * it is added to the address field of the Provider class.
	 * @param adr
	 * @param sc
	 */
	public void setAddress(String adr, Scanner sc) {
		String str = adr;
		while (str.length() > 25) {
			System.out.println("25 character maximum, try again:");
			str = sc.nextLine();
		}
		address = str;
		return;
	}
	/**
	 * This is the method that sets the city of the provider. It takes in the parameters of the String cty and the scanner, and if 
	 * the city is greater than 14 characters, the user is told to reenter the city. If the city is the correct length,
	 * it is added to the city field of the Provider class.
	 * @param cty
	 * @param sc
	 */
	public void setCity(String cty, Scanner sc) {
		String str = cty;
		while (str.length() > 14) {
			System.out.println("14 character maximum, try again:");
			str = sc.nextLine();
		}
		city = str;
		return;
	}
	/**
	 * This is the method that sets the state of the provider. It takes in the parameters of the String st and the scanner,
	 * and the st String is passed to the State class to check if it is a valid state. If it is, then the string
	 * is added to the state field of the provider class, and if not the user is told to enter a new state.
	 * @param st
	 * @param sc
	 */
	public void setState(String st, Scanner sc) {
		String str = st;
		while (true) {
			try {
				str = State.stateCode(str);
				break;
			}
			catch (ThatsNotAState e) {
				System.out.println("Invalid state, try again:");
				str = sc.nextLine();
				continue;
			}
		}
		state = str;
		return;
	}
	/**
	 * This is the method that sets the zip code of the provider. It takes in the parameters of the String code and the scanner
	 * and passes the code to the checkValid method of the ZipCode class. If the zip code is vaid, it is set as the ZipCode field
	 * in the provider class, and if not, the user is asked to enter in a new zip code.
	 * @param code
	 * @param sc
	 */
	public void setZipCode(String code, Scanner sc) {
		String str = code;
		while (true) {
			try {
				str = ZipCode.checkValid(str);
				break;
			}
			catch (ThatsNotAZipCode e) {
				System.out.println("Invalid Zip code, try again:");
				str = sc.nextLine();
				continue;
			}
		}
		zip = str;
		return;
	}
	/**
	 * This sets the name of the provider.
	 * @param str
	 */
	public void setName(String str) {
		name = str;
	}
	/**
	 * This sets the number of the provider.
	 * @param str
	 */
	public void setNumber(String str) {
		number = str;
	}
	/**
	 * This sets the address of the provider.
	 * @param str
	 */
	public void setAddress(String str) {
		address = str;
	}
	/**
	 * This sets the city of the provider.
	 * @param str
	 */
	public void setCity(String str) {
		city = str;
	}
	/**
	 * This sets the state of the provider.
	 * @param str
	 */
	public void setState(String str) {
		state = str;
	}
	/**
	 * This sets the zip code of the provider.
	 * @param str
	 */
	public void setZipCode(String str) {
		zip = str;
	}
	/**
	 * This adds a date of service to the provider and increases the size by 1.
	 * @param str
	 */
	public void setDateOfService(String str) {
		dateOfServices.add(str);
		size++;
	}
	/**
	 * This adds a service code to the provider.
	 * @param str
	 */
	public void setServiceCode(String str) {
		serviceCodes.add(str);
	}
	/**
	 * This adds a service fee to the provider.
	 * @param str
	 */
	public void setServiceFee(String str) {
		serviceFees.add(str);
	}
	/**
	 * This adds a service name to the provider.
	 * @param str
	 */
	public void setServiceName(String str) {
		serviceNames.add(str);
	}
	/**
	 * This adds a member number to the provider.
	 * @param str
	 */
	public void setMemberNumber(String str) {
		memberNumbers.add(str);
	}
	/**
	 * This adds the current date the provider.
	 * @param str
	 */
	public void setCurrentDate(String str) {
		currentDates.add(str);
	}
	/**
	 * This adds the current time to the provider.
	 * @param str
	 */
	public void setCurrentTime(String str) {
		currentTimes.add(str);
	}
	/**
	 * This adds a comment to the provider
	 * @param str
	 */
	public void setComments(String str) {
		comments.add(str);
	}
	/**
	 * gets provider name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets provider number
	 * @return number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * gets provider address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * gets provider city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * gets provider state
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * gets provider zip code
	 * @return zip
	 */
	public String getZipCode() {
		return zip;
	}
	/**
	 * gets date of service for service i
	 * @param i
	 * @return dateOfService
	 */
	public String getDateOfService(int i) {
		if(i >= dateOfServices.size()) {
			return "OUT OF BOUNDS";
		}
		return dateOfServices.get(i);
	}
	/**
	 * gets service code for service i
	 * @param i
	 * @return serviceCode
	 */
	public String getServiceCode(int i) {
		if(i >= serviceCodes.size()) {
			return "OUT OF BOUNDS";
		}
		return serviceCodes.get(i);
	}
	/**
	 * gets service fee for service i
	 * @param i
	 * @return serviceFee
	 */
	public String getServiceFee(int i) {
		if(i >= serviceFees.size()) {
			return "OUT OF BOUNDS";
		}
		return serviceFees.get(i);
	}
	/**
	 * gets service name for service i
	 * @param i
	 * @return serviceName
	 */
	public String getServiceName(int i) {
		if(i >= serviceNames.size()) {
			return "OUT OF BOUNDS";
		}
		return serviceNames.get(i);
	}
	/**
	 * gets member number for service i
	 * @param i
	 * @return memberNumber
	 */
	public String getMemberNumber(int i) {
		if(i >= memberNumbers.size()) {
			return "OUT OF BOUNDS";
		}
		return memberNumbers.get(i);
	}
	/**
	 * gets current date for service i
	 * @param i
	 * @return currentDate
	 */
	public String getCurrentDate(int i) {
		if(i >= currentDates.size()) {
			return "OUT OF BOUNDS";
		}
		return currentDates.get(i);
	}
	/**
	 * gets current time for service i
	 * @param i
	 * @return currentTime
	 */
	public String getCurrentTime(int i) {
		if(i >= currentTimes.size()) {
			return "OUT OF BOUNDS";
		}
		return currentTimes.get(i);
	}
	/**
	 * gets comments for service i
	 * @param i
	 * @return comments
	 */
	public String getComments(int i) {
		if(i >= comments.size()) {
			return "OUT OF BOUNDS";
		}
		return comments.get(i);
	}
	/**
	 * returns the number of services the provider has provided.
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}