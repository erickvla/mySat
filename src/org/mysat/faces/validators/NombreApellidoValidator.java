/**
 * 
 */
package org.mysat.faces.validators;

/**
 * @author sian
 *
 */
public class NombreApellidoValidator extends AbstractRegexValidator {
	private final String REGEX_NOMBRE_APELLIDO = "regex.nombre.apellido";

	public NombreApellidoValidator() {
		resourceBundleKey = REGEX_NOMBRE_APELLIDO;
	}

}
