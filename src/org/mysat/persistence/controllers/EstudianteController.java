package org.mysat.persistence.controllers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.mysat.persistence.daos.EstudianteDao;
import org.mysat.persistence.daos.PersonaDao;
import org.mysat.persistence.entities.Estudiante;

public class EstudianteController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5548823666638517808L;
	private PersonaDao personaDao;
	private EstudianteDao estudianteDao;
	
	public void insert(Estudiante estudiante) throws RollbackException, IllegalArgumentException {
		getPersonaDao().insert(estudiante.getPersona());
		getEstudianteDao().insert(estudiante);
	}
	
	public void update(Estudiante estudiante) throws RollbackException, IllegalArgumentException {
		getPersonaDao().update(estudiante.getPersona());
		getEstudianteDao().update(estudiante);
	}
	
	public void delete(List<Estudiante> estudiantes) {
		for (Estudiante item : estudiantes) {
			getEstudianteDao().delete(item);
		}
	}
	
	public List<Estudiante> getAllItems() {
		return (List<Estudiante>)getEstudianteDao().findAll();
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}

	public EstudianteDao getEstudianteDao() {
		return estudianteDao;
	}

	public void setEstudianteDao(EstudianteDao estudianteDao) {
		this.estudianteDao = estudianteDao;
	}
	
}
