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
import org.mysat.faces.beans.results.BeneficiarioResultsBean;
import org.mysat.persistence.controllers.BeneficiarioController;
import org.mysat.persistence.entities.Beneficiario;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 * @author imac
 *
 */
@ManagedBean(name = "beneficiarioMBean")
@ApplicationScoped
public class BeneficiarioManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1306099828813208285L;
	private static final Log LOG = LogFactory.getLog(BeneficiarioManagedBean.class);
	@ManagedProperty(value = "#{beneficiarioRBean}")
	private BeneficiarioResultsBean results;
	@ManagedProperty(value = "#{beneficiarioCtrl}")
	private BeneficiarioController controller;
	private Beneficiario properties;
	private Beneficiario selected;
	private List<Beneficiario> selectedItems;
	
	public BeneficiarioManagedBean() {
		properties = new Beneficiario();
		selectedItems = new ArrayList<Beneficiario>(0);
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
			Beneficiario newE = (Beneficiario)event.getObject();
			
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
	
	public void viewItemListener(Beneficiario item) {
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
		List<Beneficiario> allItems = getController().getAllItems();
		
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
		
		for (Beneficiario est : getSelectedItems()) {
			sb.append(est.display());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private String getUpdateSuccessMessage(Beneficiario newE) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Registro actualizado: \n");
		
		sb.append(newE.display());
		
		return sb.toString();
	}

	public BeneficiarioResultsBean getResults() {
		return results;
	}

	public void setResults(BeneficiarioResultsBean results) {
		this.results = results;
	}

	public BeneficiarioController getController() {
		return controller;
	}

	public void setController(BeneficiarioController controller) {
		this.controller = controller;
	}

	public Beneficiario getProperties() {
		return properties;
	}

	public void setProperties(Beneficiario properties) {
		this.properties = properties;
	}

	public List<Beneficiario> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<Beneficiario> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public Beneficiario getSelected() {
		return selected;
	}

	public void setSelected(Beneficiario selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "BeneficiarioManagedBean [results=" + results + ", properties=" + properties + ", selected=" + selected
				+ ", selectedItems=" + selectedItems + "]";
	}

}
