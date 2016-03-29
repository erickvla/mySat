package org.mysat.faces.beans.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class UppercaseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		return value.toUpperCase();
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		return value.toString().toUpperCase();
	}

}
