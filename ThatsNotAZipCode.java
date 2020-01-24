package project4;

/**
 * 
 * @author Colin
 * This class is for the exception associated with Zip codes.
 */
public class ThatsNotAZipCode extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor for ThatsNotAZipCode exception
	 * @param str
	 */
	public ThatsNotAZipCode(String str) {
		System.out.println(str + " is not a valid zip code!");
	}
}
