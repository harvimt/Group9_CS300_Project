package border.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * copied from http://www.javapractices.com/topic/TopicAction.do?Id=180
 * textHasContent taken from http://www.javapractices.com/topic/TopicAction.do?Id=5
 * but turned into an InputVerifier
 * @author mark2
 */
public class EmailValidator extends InputVerifier {

	/**
	 * Validate the form of an email address.
	 *
	 * <P>Return <tt>true</tt> only if
	 *<ul>
	 * <li> <tt>aEmailAddress</tt> can successfully construct an
	 * {@link javax.mail.internet.InternetAddress}
	 * <li> when parsed with "@" as delimiter, <tt>aEmailAddress</tt> contains
	 * two tokens which satisfy {@link hirondelle.web4j.util.Util#textHasContent}.
	 *</ul>
	 *
	 *<P> The second condition arises since local email addresses, simply of the form
	 * "<tt>albert</tt>", for example, are valid for
	 * {@link javax.mail.internet.InternetAddress}, but almost always undesired.
	 */
	public static boolean isValidEmailAddress(String aEmailAddress) {
		if (aEmailAddress == null) {
			return false;
		}
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(aEmailAddress);
			if (!hasNameAndDomain(aEmailAddress)) {
				result = false;
			}
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	/**
	 * Returns true if aText is non-null and has visible content.
	 *
	 * This is a test which is often performed, and should probably
	 * be placed in a general utility class.
	 */
	private static boolean textHasContent(String aText) {
		String EMPTY_STRING = "";
		return (aText != null) && (!aText.trim().equals(EMPTY_STRING));
	}

	private static boolean hasNameAndDomain(String aEmailAddress) {
		String[] tokens = aEmailAddress.split("@");
		return tokens.length == 2
				&& textHasContent(tokens[0])
				&& textHasContent(tokens[1]);
	}

	public boolean verify(JComponent comp) {
		return isValidEmailAddress(((JTextField) comp).getText());
	}
}
