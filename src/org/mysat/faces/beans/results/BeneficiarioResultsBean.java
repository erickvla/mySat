/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.Beneficiario;

/**
 * @author imac
 *
 */
@ManagedBean(name = "beneficiarioRBean")
@NoneScoped
public class BeneficiarioResultsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1489535350173502717L;
	private List<Beneficiario> resultsList;
	private String message;
	
	public List<Beneficiario> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<Beneficiario> resultsList) {
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
		return "BeneficiarioResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
