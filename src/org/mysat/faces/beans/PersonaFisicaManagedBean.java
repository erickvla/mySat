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
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.RollbackException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mysat.faces.beans.results.PersonaFisicaResultsBean;
import org.mysat.persistence.controllers.PersonaFisicaController;
import org.mysat.persistence.entities.Persona;
import org.mysat.persistence.entities.PersonaFisica;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "personaFisicaMBean")
@ApplicationScoped
public class PersonaFisicaManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4674668943431460532L;
	private static final Log LOG = LogFactory.getLog(PersonaFisicaManagedBean.class);
	@ManagedProperty(value = "#{personaFisicaRBean}")
	private PersonaFisicaResultsBean results;
	@ManagedProperty(value = "#{personaFisicaCtrl}")
	private PersonaFisicaController controller;
	private PersonaFisica properties;
	private PersonaFisica selected;
	private List<PersonaFisica> selectedItems;
	
	public PersonaFisicaManagedBean() {
		properties = new PersonaFisica();
		properties.setPersona(new Persona());
		selectedItems = new ArrayList<PersonaFisica>(0);
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
			PersonaFisica newPF = (PersonaFisica)event.getObject();
			
			LOG.debug("Row Edit: " + event.getObject());
			
			getController().update(newPF);
	
			loadAllItems();
			
			if (newPF != null) {
	            addMessage(getUpdateSuccessMessage(newPF), FacesMessage.SEVERITY_INFO);
	        }
		} catch(IllegalArgumentException iaException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		} catch (RollbackException rException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void viewItemListener(PersonaFisica item) {
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
		List<PersonaFisica> allItems = getController().getAllItems();
		
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
		
		for (PersonaFisica pf : getSelectedItems()) {
			sb.append(pf.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(PersonaFisica newPF) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newPF.display());
		
		return sb.toString();
	}

	public PersonaFisicaResultsBean getResults() {
		return results;
	}

	public void setResults(PersonaFisicaResultsBean results) {
		this.results = results;
	}

	public PersonaFisicaController getController() {
		return controller;
	}

	public void setController(PersonaFisicaController controller) {
		this.controller = controller;
	}

	public PersonaFisica getProperties() {
		return properties;
	}

	public void setProperties(PersonaFisica properties) {
		this.properties = properties;
	}

	public List<PersonaFisica> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<PersonaFisica> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public PersonaFisica getSelected() {
		return selected;
	}

	public void setSelected(PersonaFisica selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "PersonaFisicaManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
