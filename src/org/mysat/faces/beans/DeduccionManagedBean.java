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
import org.mysat.faces.beans.results.DeduccionResultsBean;
import org.mysat.persistence.controllers.DeduccionController;
import org.mysat.persistence.entities.Deduccion;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "deduccionMBean")
@ApplicationScoped
public class DeduccionManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5029642045617034361L;
	private static final Log LOG = LogFactory.getLog(DeduccionManagedBean.class);
	@ManagedProperty(value = "#{deduccionRBean}")
	private DeduccionResultsBean results;
	@ManagedProperty(value = "#{deduccionCtrl}")
	private DeduccionController controller;
	private Deduccion properties;
	private Deduccion selected;
	private List<Deduccion> selectedItems;
	
	public DeduccionManagedBean() {
		properties = new Deduccion();
		selectedItems = new ArrayList<Deduccion>(0);
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
			Deduccion newE = (Deduccion)event.getObject();
			
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
	
	public void viewItemListener(Deduccion item) {
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
		List<Deduccion> allItems = getController().getAllItems();
		
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
		
		for (Deduccion est : getSelectedItems()) {
			sb.append(est.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(Deduccion newE) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newE.display());
		
		return sb.toString();
	}

	public DeduccionResultsBean getResults() {
		return results;
	}

	public void setResults(DeduccionResultsBean results) {
		this.results = results;
	}

	public DeduccionController getController() {
		return controller;
	}

	public void setController(DeduccionController controller) {
		this.controller = controller;
	}

	public Deduccion getProperties() {
		return properties;
	}

	public void setProperties(Deduccion properties) {
		this.properties = properties;
	}

	public List<Deduccion> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<Deduccion> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public Deduccion getSelected() {
		return selected;
	}

	public void setSelected(Deduccion selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "DeduccionManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
