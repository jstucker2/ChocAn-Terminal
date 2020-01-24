package project4;

/**
 * @author Colin Adreon
 * This class is is used to validate a users input for states.
 */
public class State {
	/**
	 * 
	 * @param str
	 * @return String state abbreviation
	 * @throws ThatsNotAState
	 */
	public static String stateCode(String str) throws ThatsNotAState {
		int i = 0;
		while (i != 50) {
			if(str.equals(abbr[i]))
				return str;
			else
				i++;
		}
		i = 0;
		
		while(i != 50) {
			if(str.equals(name[i]))
				return abbr[i];
			else
				i++;
		}
		throw new ThatsNotAState(str);
	}

	private static final String[] abbr = {
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
		"HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
		"MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
		"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
		"SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
	};

	private static final String[] name = {
		"Alabama", "Alaska", "Arizona", "Arkansas", "California",
		"Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
		"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
		"Kansas", "Kentucky", "Lousiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
		"Montana", "Nebraska", "Nevada", "New Hampshire", "New Jesrey",
		"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
		"South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
		"Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
	};
}