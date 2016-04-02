/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class CurpValidator extends AbstractRegexValidator {
	private final String REGEX_CURP = "regex.curp";

	public CurpValidator() {
		resourceBundleKey = REGEX_CURP;
	}

}
