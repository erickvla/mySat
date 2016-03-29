package org.mysat.faces.utils;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class ResourceBundleUtils {
	private static final String RESOURCE_BUNDLE_ID = "bundle";

	public static final String getValue(String key) {
		ResourceBundle rb = null;
		String value = null;

		if (key != null) {
			rb = getResourceBundle();

			if (rb != null && rb.containsKey(key)) {
				value = rb.getString(key);
			}
		}

		return value;
	}
	
	public static final boolean contains(String key) {
		ResourceBundle rb = null;
		boolean contains = false;

		if (key != null) {
			rb = getResourceBundle();

			contains = rb.containsKey(key);
		}

		return contains;
	}
	
	private static final ResourceBundle getResourceBundle() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle rb = facesContext.getApplication().getResourceBundle(facesContext, RESOURCE_BUNDLE_ID);
		
		return rb;
	}

}
