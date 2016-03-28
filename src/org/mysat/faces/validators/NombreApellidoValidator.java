/**
 * 
 */
package org.mysat.faces.validators;

import java.util.regex.Pattern;

/**
 * @author sian
 *
 */
public class NombreApellidoValidator extends AbstractRegexValidator {
	private final String NOMBRE_REGEX = "/^[a-z ,.'-]+$/i";

	public NombreApellidoValidator() {
		pattern = Pattern.compile(NOMBRE_REGEX);
	}

}
