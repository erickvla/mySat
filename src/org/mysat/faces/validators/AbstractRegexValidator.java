package org.mysat.faces.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.component.inputtext.InputText;

public abstract class AbstractRegexValidator implements Validator {
	protected Pattern pattern;
	protected Matcher matcher;
	private final String ERROR_MESSAGE = "El valor no es válido.";

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		FacesMessage message = null;
		StringBuffer sb = null;
		InputText inputText = null;

		if (facesContext != null && component != null && value != null) {
			matcher = pattern.matcher(value.toString());

			if (!matcher.matches()) {
				inputText = (InputText)component;
				sb = new StringBuffer(inputText.getLabel());
				
				sb.append(": ");
				sb.append(ERROR_MESSAGE);
				
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, sb.toString(), sb.toString());

				throw new ValidatorException(message);
			}

		}

	}

}
