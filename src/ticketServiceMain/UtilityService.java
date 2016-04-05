package ticketServiceMain;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Provide basic functionalities
 * 
 * @author TT
 *
 */
public class UtilityService {

	public UtilityService() {

	}

	/**
	 * Validate email address;
	 * 
	 * @param email
	 *            email input by user
	 * @return boolean value depends on validity of email
	 */
	public boolean isEmailValid(String email) {

		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}
}
