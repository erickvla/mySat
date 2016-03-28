/**
 * 
 */
package org.mysat.faces.validators;

import java.util.regex.Pattern;

/**
 * @author sian
 *
 */
public class RfcValidator extends AbstractRegexValidator {
	private final String RFC_REGEX = "/^[A-Za-z]{3,4}[ |\\-]{0,1}[0-9]{6}[ |\\-]{0,1}[0-9A-Za-z]{3}$";

	public RfcValidator() {
		pattern = Pattern.compile(RFC_REGEX);
	}

}
