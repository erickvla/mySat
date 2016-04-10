package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.persistence.daos.DeduccionDao;
import org.mysat.persistence.entities.Deduccion;

public class DeduccionController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7980205267699810211L;
	private DeduccionDao deduccionDao;
	
	public void insert(Deduccion deduccion) throws RollbackException, IllegalArgumentException {
		getDeduccionDao().insert(deduccion);
	}
	
	public void update(Deduccion deduccion) throws RollbackException, IllegalArgumentException {
		getDeduccionDao().update(deduccion);
	}
	
	public void delete(List<Deduccion> deduccions) {
		for (Deduccion item : deduccions) {
			getDeduccionDao().delete(item);
		}
	}
	
	public List<Deduccion> getAllItems() {
		return (List<Deduccion>)getDeduccionDao().findAll();
	}

	public DeduccionDao getDeduccionDao() {
		return deduccionDao;
	}

	public void setDeduccionDao(DeduccionDao deduccionDao) {
		this.deduccionDao = deduccionDao;
	}
	
}
