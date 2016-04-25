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
import org.mysat.faces.beans.results.PersonaMoralResultsBean;
import org.mysat.persistence.controllers.PersonaMoralController;
import org.mysat.persistence.entities.PersonaMoral;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "personaMoralMBean")
@ApplicationScoped
public class PersonaMoralManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5306856991898121893L;
	private static final Log LOG = LogFactory.getLog(PersonaMoralManagedBean.class);
	@ManagedProperty(value = "#{personaMoralRBean}")
	private PersonaMoralResultsBean results;
	@ManagedProperty(value = "#{personaMoralCtrl}")
	private PersonaMoralController controller;
	private PersonaMoral properties;
	private PersonaMoral selected;
	private List<PersonaMoral> selectedItems;
	
	public PersonaMoralManagedBean() {
		properties = new PersonaMoral();
		selectedItems = new ArrayList<PersonaMoral>(0);
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
			PersonaMoral newPM = (PersonaMoral)event.getObject();
			
			LOG.debug("Row Edit: " + event.getObject());
			
			getController().update(newPM);
	
			loadAllItems();
			
			if (newPM != null) {
	            addMessage(getUpdateSuccessMessage(newPM), FacesMessage.SEVERITY_INFO);
	        }
		} catch(IllegalArgumentException iaException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		} catch (RollbackException rException) {
			addMessage("El registro no pudo ser guardado, tal vez exista un registro con los mismos datos.", FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void viewItemListener(PersonaMoral item) {
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
		List<PersonaMoral> allItems = getController().getAllItems();
		
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
		
		for (PersonaMoral pf : getSelectedItems()) {
			sb.append(pf.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(PersonaMoral newPM) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newPM.display());
		
		return sb.toString();
	}

	public PersonaMoralResultsBean getResults() {
		return results;
	}

	public void setResults(PersonaMoralResultsBean results) {
		this.results = results;
	}

	public PersonaMoralController getController() {
		return controller;
	}

	public void setController(PersonaMoralController controller) {
		this.controller = controller;
	}

	public PersonaMoral getProperties() {
		return properties;
	}

	public void setProperties(PersonaMoral properties) {
		this.properties = properties;
	}

	public List<PersonaMoral> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<PersonaMoral> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public PersonaMoral getSelected() {
		return selected;
	}

	public void setSelected(PersonaMoral selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "PersonaMoralManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
