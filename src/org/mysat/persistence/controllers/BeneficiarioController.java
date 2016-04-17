package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.persistence.daos.BeneficiarioDao;
import org.mysat.persistence.entities.Beneficiario;

public class BeneficiarioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2017241557484409251L;
	private BeneficiarioDao beneficiarioDao;
	
	public void insert(Beneficiario beneficiario) throws RollbackException, IllegalArgumentException {
		getBeneficiarioDao().insert(beneficiario);
	}
	
	public void update(Beneficiario beneficiario) throws RollbackException, IllegalArgumentException {
		getBeneficiarioDao().update(beneficiario);
	}
	
	public void delete(List<Beneficiario> beneficiarios) {
		for (Beneficiario item : beneficiarios) {
			getBeneficiarioDao().delete(item);
		}
	}
	
	public List<Beneficiario> getAllItems() {
		return (List<Beneficiario>)getBeneficiarioDao().findAll();
	}

	public BeneficiarioDao getBeneficiarioDao() {
		return beneficiarioDao;
	}

	public void setBeneficiarioDao(BeneficiarioDao beneficiarioDao) {
		this.beneficiarioDao = beneficiarioDao;
	}
	
}
