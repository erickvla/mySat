/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.PersonaMoral;

/**
 * @author imac
 *
 */
@ManagedBean(name = "personaMoralRBean")
@NoneScoped
public class PersonaMoralResultsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3629919758353110398L;
	private List<PersonaMoral> resultsList;
	private String message;
	
	public List<PersonaMoral> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<PersonaMoral> resultsList) {
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
		return "PersonaMoralResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
