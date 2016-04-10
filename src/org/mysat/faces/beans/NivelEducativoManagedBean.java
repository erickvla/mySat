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
import org.mysat.faces.beans.results.NivelEducativoResultsBean;
import org.mysat.persistence.controllers.NivelEducativoController;
import org.mysat.persistence.entities.NivelEducativo;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "deduccionMBean")
@ApplicationScoped
public class NivelEducativoManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5029642045617034361L;
	private static final Log LOG = LogFactory.getLog(NivelEducativoManagedBean.class);
	@ManagedProperty(value = "#{nivelEducativoRBean}")
	private NivelEducativoResultsBean results;
	@ManagedProperty(value = "#{nivelEducativoCtrl}")
	private NivelEducativoController controller;
	private NivelEducativo properties;
	private NivelEducativo selected;
	private List<NivelEducativo> selectedItems;
	
	public NivelEducativoManagedBean() {
		properties = new NivelEducativo();
		selectedItems = new ArrayList<NivelEducativo>(0);
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
			NivelEducativo newE = (NivelEducativo)event.getObject();
			
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
	
	public void viewItemListener(NivelEducativo item) {
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
		List<NivelEducativo> allItems = getController().getAllItems();
		
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
		
		for (NivelEducativo est : getSelectedItems()) {
			sb.append(est.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(NivelEducativo newE) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newE.display());
		
		return sb.toString();
	}

	public NivelEducativoResultsBean getResults() {
		return results;
	}

	public void setResults(NivelEducativoResultsBean results) {
		this.results = results;
	}

	public NivelEducativoController getController() {
		return controller;
	}

	public void setController(NivelEducativoController controller) {
		this.controller = controller;
	}

	public NivelEducativo getProperties() {
		return properties;
	}

	public void setProperties(NivelEducativo properties) {
		this.properties = properties;
	}

	public List<NivelEducativo> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<NivelEducativo> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public NivelEducativo getSelected() {
		return selected;
	}

	public void setSelected(NivelEducativo selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "NivelEducativoManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
