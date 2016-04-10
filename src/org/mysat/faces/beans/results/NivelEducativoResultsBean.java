/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.NivelEducativo;

/**
 * @author imac
 *
 */
@ManagedBean(name = "nivelEducativoRBean")
@NoneScoped
public class NivelEducativoResultsBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8284947333679148072L;
	private List<NivelEducativo> resultsList;
	private String message;
	
	public List<NivelEducativo> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<NivelEducativo> resultsList) {
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
		return "NivelEducativoResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
