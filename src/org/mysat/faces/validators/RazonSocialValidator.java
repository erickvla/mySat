/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class RazonSocialValidator extends AbstractRegexValidator {
	private final String REGEX_RAZON_SOCIAL = "regex.razon.social";

	public RazonSocialValidator() {
		resourceBundleKey = REGEX_RAZON_SOCIAL;
	}

}
