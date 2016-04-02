/**
 * 
 */
package org.mysat.faces.beans.results;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.mysat.persistence.entities.Estudiante;

/**
 * @author imac
 *
 */
@ManagedBean(name = "estudianteRBean")
@NoneScoped
public class EstudianteResultsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852052695045095743L;
	private List<Estudiante> resultsList;
	private String message;
	
	public List<Estudiante> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<Estudiante> resultsList) {
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
		return "EstudianteResultsBean [resultsList=" + resultsList + ", message=" + message + "]";
	}

}
