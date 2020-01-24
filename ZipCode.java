package project4;

/**
 * @author Colin Adreon
 * This class checks that the Zip code entered by the user is a valid Zip code.
 */
public class ZipCode {
	/**
	 * This method checks if a string contains a valid Zip Code
	 * @param str
	 * @return Zip Code
	 * @throws ThatsNotAZipCode
	 */
	public static String checkValid(String str) throws ThatsNotAZipCode {
		int zip = 0;
		try {
			zip = Integer.parseInt(str);
		}
		catch (NumberFormatException e) {
			zip = 0;//
		}

		if (zip > 499 && zip < 100000 && str.length() == 5)
			return str;
		else {
			throw new ThatsNotAZipCode(str);
		}
	}
}
