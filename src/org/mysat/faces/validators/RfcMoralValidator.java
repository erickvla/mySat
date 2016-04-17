/**
 * 
 */
package org.mysat.faces.validators;

import java.util.regex.Pattern;

/**
 * @author sian
 *
 */
public class RfcMoralValidator extends AbstractRegexValidator {
	private final String REGEX_RFC = "regex.rfc";

	public RfcMoralValidator() {
		resourceBundleKey = REGEX_RFC;
	}

}
