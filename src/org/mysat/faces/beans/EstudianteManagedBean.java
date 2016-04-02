/**
 * 
 */
package org.mysat.faces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mysat.faces.beans.results.EstudianteResultsBean;
import org.mysat.persistence.controllers.EstudianteController;
import org.mysat.persistence.entities.Estudiante;
import org.mysat.persistence.entities.Persona;
import org.mysat.persistence.entities.PersonaFisica;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "estudianteMBean")
@ApplicationScoped
public class EstudianteManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7792518692430492485L;
	private static final Log LOG = LogFactory.getLog(EstudianteManagedBean.class);
	@ManagedProperty(value = "#{estudianteRBean}")
	private EstudianteResultsBean results;
	@ManagedProperty(value = "#{estudianteCtrl}")
	private EstudianteController controller;
	private Estudiante properties;
	private Estudiante selected;
	private List<Estudiante> selectedItems;
	
	public EstudianteManagedBean() {
		properties = new Estudiante();
		properties.setPersona(new Persona());
		selectedItems = new ArrayList<Estudiante>(0);
	}

	public String loadDashboard() {
		loadAllItems();

		return "success";
	}

	public void insertItemListener() {

		try {
			getController().insert(getProperties());

			loadAllItems();
		
			addMessage(getInsertSuccessMessage(), FacesMessage.SEVERITY_INFO);
		} catch(IllegalArgumentException iaException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		} catch (RollbackException rException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void deleteItemsListener() {
		LOG.debug(getSelectedItems());
		
		getController().delete(getSelectedItems());

		loadAllItems();
		
		addMessage(getDeleteSuccessMessage(), FacesMessage.SEVERITY_INFO);
	}

	public void rowSelectListener(SelectEvent event) {
		if (event != null) {
			LOG.debug(event.getObject());
		}
	}
	
	public void updateItemListener(RowEditEvent event) {
		
		try {
			Estudiante newE = (Estudiante)event.getObject();
			
			LOG.debug("Row Edit: " + event.getObject());
			
			getController().update(newE);
	
			loadAllItems();
			
			if (newE != null) {
	            addMessage(getUpdateSuccessMessage(newE), FacesMessage.SEVERITY_INFO);
	        }
		} catch(IllegalArgumentException iaException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		} catch (RollbackException rException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void viewItemListener(Estudiante item) {
		setSelected(item);
	}
	
	public void rowCancelListener(RowEditEvent event) {
		LOG.debug("Cancel edit");
	}
	
	private void addMessage(String message, FacesMessage.Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(severity, message, message));
	}
	
	private void loadAllItems() {
		List<Estudiante> allItems = getController().getAllItems();
		
		getResults().setResultsList(allItems);
	}
	
	private String getInsertSuccessMessage() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro creado: \n");
		sb.append(getProperties().display());
		
		return sb.toString();
	}
	
	private String getDeleteSuccessMessage() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro(s) eliminado(s): \n");
		
		for (Estudiante est : getSelectedItems()) {
			sb.append(est.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(Estudiante newE) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newE.display());
		
		return sb.toString();
	}

	public EstudianteResultsBean getResults() {
		return results;
	}

	public void setResults(EstudianteResultsBean results) {
		this.results = results;
	}

	public EstudianteController getController() {
		return controller;
	}

	public void setController(EstudianteController controller) {
		this.controller = controller;
	}

	public Estudiante getProperties() {
		return properties;
	}

	public void setProperties(Estudiante properties) {
		this.properties = properties;
	}

	public List<Estudiante> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<Estudiante> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public Estudiante getSelected() {
		return selected;
	}

	public void setSelected(Estudiante selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "EstudianteManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
