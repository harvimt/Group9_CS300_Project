/**
 * Taken from: http://www.rgagnon.com/javadetails/java-0198.html
 * made constructors public & changed import com.sun.swing.text etc. to javax.swing.text
 * ran source-code formatter & added serialVersionUID to placate eclipse's warning
 */
package border.util;

import javax.swing.text.*;

public class JTextFieldLimit
	extends
	PlainDocument {

	private static final long serialVersionUID = 8367624949048931666L;
	private int limit;
	
	// optional upper-case conversion
	private boolean toUppercase = false;

	public JTextFieldLimit(
		int limit) {
		
		super();
		this.limit = limit;
	}

	public JTextFieldLimit(
		int limit,
		boolean upper) {
		
		super();
		this.limit = limit;
		toUppercase = upper;
	}

	public void insertString(
		int offset,
		String str,
		AttributeSet attr)
		throws BadLocationException {
		
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			if (toUppercase)
				str = str.toUpperCase();
			super.insertString(offset,str,attr);
		}
	}
}
