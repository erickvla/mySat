package org.mysat.faces.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;
import org.mysat.faces.utils.ResourceBundleUtils;
import org.primefaces.component.inputtext.InputText;

public abstract class AbstractRegexValidator implements Validator {
	private static final Logger LOG = Logger.getLogger(AbstractRegexValidator.class);
	protected String resourceBundleKey;
	private final String ERROR_MESSAGE_REGEX = "error.message.regex";

	@Override
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		FacesMessage message = null;
		StringBuffer sb = null;
		InputText inputText = null;
		Pattern pattern = null;
		Matcher matcher = null;

		if (facesContext != null && component != null && value != null) {
			
			if (ResourceBundleUtils.contains(resourceBundleKey)) {
				pattern = Pattern.compile(ResourceBundleUtils.getValue(resourceBundleKey));
				matcher = pattern.matcher(value.toString());
	
				if (!matcher.matches()) {
					inputText = (InputText)component;
					sb = new StringBuffer(inputText.getLabel());
					
					if (ResourceBundleUtils.contains(ERROR_MESSAGE_REGEX)) {
						sb.append(": ");
						sb.append(ResourceBundleUtils.getValue(ERROR_MESSAGE_REGEX));
					}
					
					message = new FacesMessage(FacesMessage.SEVERITY_ERROR, sb.toString(), sb.toString());
	
					throw new ValidatorException(message);
				}
				
			}

		}

	}

}
