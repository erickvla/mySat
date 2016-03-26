/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.PersonaFisica;

/**
 * @author imac
 *
 */
@ManagedBean(name = "personaFisicaRBean")
@NoneScoped
public class PersonaFisicaResultsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5922527660235884707L;
	private List<PersonaFisica> resultsList;
	private String message;
	
	public List<PersonaFisica> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<PersonaFisica> resultsList) {
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
		return "PersonaFisicaResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
