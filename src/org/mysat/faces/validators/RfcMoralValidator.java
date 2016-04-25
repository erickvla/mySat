/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class RfcMoralValidator extends AbstractRegexValidator {
	private final String REGEX_RFC_MORAL = "regex.rfc.moral";

	public RfcMoralValidator() {
		resourceBundleKey = REGEX_RFC_MORAL;
	}

}
