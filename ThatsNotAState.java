package project4;

/**
 * @author Colin Adreon
 * This class is for the exception associated with states.
 */
public class ThatsNotAState extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the constructor for the ThatsNotAState exception
	 * @param str
	 */
	public ThatsNotAState(String str) {
		System.out.println(str + " is not a state!");
	}
}
