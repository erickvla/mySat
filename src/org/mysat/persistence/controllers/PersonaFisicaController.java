package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import org.mysat.persistence.daos.PersonaDao;
import org.mysat.persistence.daos.PersonaFisicaDao;
import org.mysat.persistence.entities.PersonaFisica;

public class PersonaFisicaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8476058458571418237L;
	private PersonaDao personaDao;
	private PersonaFisicaDao personaFisicaDao;
	
	public void insert(PersonaFisica personaFisica) {
		getPersonaDao().insert(personaFisica.getPersona());
		getPersonaFisicaDao().insert(personaFisica);
	}
	
	public void update(PersonaFisica personaFisica) {
		getPersonaDao().update(personaFisica.getPersona());
		getPersonaFisicaDao().update(personaFisica);
	}
	
	public void delete(List<PersonaFisica> personaFisicas) {
		for (PersonaFisica item : personaFisicas) {
			getPersonaFisicaDao().delete(item);
		}
	}
	
	public List<PersonaFisica> getAllItems() {
		return (List<PersonaFisica>)getPersonaFisicaDao().findAll();
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public PersonaFisicaDao getPersonaFisicaDao() {
		return personaFisicaDao;
	}

	public void setPersonaFisicaDao(PersonaFisicaDao personaFisicaDao) {
		this.personaFisicaDao = personaFisicaDao;
	}
	
}
