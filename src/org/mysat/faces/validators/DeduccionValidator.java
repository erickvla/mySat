/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class DeduccionValidator extends AbstractRegexValidator {
	private final String REGEX_DEDUCCION = "regex.deduccion";

	public DeduccionValidator() {
		resourceBundleKey = REGEX_DEDUCCION;
	}

}
