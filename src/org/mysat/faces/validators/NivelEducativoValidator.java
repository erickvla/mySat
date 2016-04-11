/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class NivelEducativoValidator extends AbstractRegexValidator {
	private final String REGEX_NIVEL_EDUCATIVO = "regex.nivel.educativo";

	public NivelEducativoValidator() {
		resourceBundleKey = REGEX_NIVEL_EDUCATIVO;
	}

}
