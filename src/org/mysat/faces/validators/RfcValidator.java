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
	private final String REGEX_RFC = "regex.rfc";

	public RfcValidator() {
		resourceBundleKey = REGEX_RFC;
	}

}
