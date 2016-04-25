package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.persistence.daos.PersonaMoralDao;
import org.mysat.persistence.entities.PersonaMoral;

public class PersonaMoralController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7338861928528283161L;
	private PersonaMoralDao personaMoralDao;
	
	public void insert(PersonaMoral personaMoral) throws RollbackException, IllegalArgumentException {
		getPersonaMoralDao().insert(personaMoral);
	}
	
	public void update(PersonaMoral personaMoral) throws RollbackException, IllegalArgumentException {
		getPersonaMoralDao().update(personaMoral);
	}
	
	public void delete(List<PersonaMoral> personaMorals) {
		for (PersonaMoral item : personaMorals) {
			getPersonaMoralDao().delete(item);
		}
	}
	
	public List<PersonaMoral> getAllItems() {
		return (List<PersonaMoral>)getPersonaMoralDao().findAll();
	}

	public PersonaMoralDao getPersonaMoralDao() {
		return personaMoralDao;
	}

	public void setPersonaMoralDao(PersonaMoralDao personaMoralDao) {
		this.personaMoralDao = personaMoralDao;
	}
	
}
