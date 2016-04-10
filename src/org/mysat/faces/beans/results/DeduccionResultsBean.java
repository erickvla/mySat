/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.Deduccion;

/**
 * @author imac
 *
 */
@ManagedBean(name = "deduccionRBean")
@NoneScoped
public class DeduccionResultsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7106255802997571307L;
	private List<Deduccion> resultsList;
	private String message;
	
	public List<Deduccion> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<Deduccion> resultsList) {
		this.resultsList = resultsList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeduccionResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
