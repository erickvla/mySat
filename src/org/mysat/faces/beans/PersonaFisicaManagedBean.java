/**
 * 
 */
package org.mysat.faces.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mysat.faces.beans.results.PersonaFisicaResultsBean;
import org.mysat.persistence.controllers.PersonaFisicaController;
import org.mysat.persistence.entities.Persona;
import org.mysat.persistence.entities.PersonaFisica;
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
	private List<PersonaFisica> selectedItems;
	
	public PersonaFisicaManagedBean() {
		properties = new PersonaFisica();
		properties.setPersona(new Persona());
	}

	public String loadDashboard() {
		loadAllItems();

		return "success";
	}

	public void insertItemListener(ActionEvent event) {

		getController().insert(getProperties());

		loadAllItems();
		
		//getResults().setMessage(getInsertSuccessMessage());
		addMessage(getInsertSuccessMessage(), FacesMessage.SEVERITY_INFO);
	}

	public void deleteItemsListener(AjaxBehaviorEvent event) {
		LOG.debug(getSelectedItems());
		
		getController().delete(getSelectedItems());

		loadAllItems();
		
		//getResults().setMessage(getDeleteSuccessMessage());
		addMessage(getDeleteSuccessMessage(), FacesMessage.SEVERITY_INFO);
	}

	public void rowSelectListener(SelectEvent event) {
		LOG.debug(event.getObject());
		if (event != null) {
			System.out.println(event.getObject());
		}
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
		
		sb.append("Registro creado: \r");
		sb.append(getProperties().display());
		
		return sb.toString();
	}
	
	private String getDeleteSuccessMessage() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro(s) eliminado(s): \r");
		
		for (PersonaFisica pf : getSelectedItems()) {
			sb.append(pf.display());
			sb.append("\r");
		}
		
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

}
