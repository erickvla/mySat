package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.persistence.daos.NivelEducativoDao;
import org.mysat.persistence.entities.NivelEducativo;

public class NivelEducativoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2018475451010373507L;
	private NivelEducativoDao nivelEducativoDao;
	
	public void insert(NivelEducativo nivelEducativo) throws RollbackException, IllegalArgumentException {
		getNivelEducativoDao().insert(nivelEducativo);
	}
	
	public void update(NivelEducativo nivelEducativo) throws RollbackException, IllegalArgumentException {
		getNivelEducativoDao().update(nivelEducativo);
	}
	
	public void delete(List<NivelEducativo> nivelEducativos) {
		for (NivelEducativo item : nivelEducativos) {
			getNivelEducativoDao().delete(item);
		}
	}
	
	public List<NivelEducativo> getAllItems() {
		return (List<NivelEducativo>)getNivelEducativoDao().findAll();
	}

	public NivelEducativoDao getNivelEducativoDao() {
		return nivelEducativoDao;
	}

	public void setNivelEducativoDao(NivelEducativoDao nivelEducativoDao) {
		this.nivelEducativoDao = nivelEducativoDao;
	}
	
}
