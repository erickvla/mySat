package org.mysat.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.mysat.Constants;
import org.mysat.persistence.entities.ifc.IdNombreInterface;

/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_ALL, 
				query = "SELECT p FROM Persona p"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_BY_ID, 
				query = "SELECT p FROM Persona p WHERE p.id = :id"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_BY_NOMBRE, 
				query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_BY_NOMBRE_LIKE, 
				query = "SELECT p FROM Persona p WHERE p.nombre LIKE :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_BY_APELLIDO, 
				query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FIND_BY_APELLIDO_LIKE, 
				query = "SELECT p FROM Persona p WHERE p.apellido LIKE :apellido") 
})
public class Persona implements Serializable, IdNombreInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3141500112979951027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSONA_ID")
	private long id;

	@Column(name = "PERSONA_APELLIDO")
	private String apellido;

	@Column(name = "PERSONA_NOMBRE")
	private String nombre;

	// bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy = "persona")
	private List<Estudiante> estudiantes;

	// bi-directional many-to-one association to PersonaFisica
	@OneToMany(mappedBy = "persona")
	private List<PersonaFisica> personaFisicas;

	public Persona() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPersona(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPersona(null);

		return estudiante;
	}

	public List<PersonaFisica> getPersonaFisicas() {
		return this.personaFisicas;
	}

	public void setPersonaFisicas(List<PersonaFisica> personaFisicas) {
		this.personaFisicas = personaFisicas;
	}

	public PersonaFisica addPersonaFisica(PersonaFisica personaFisica) {
		getPersonaFisicas().add(personaFisica);
		personaFisica.setPersona(this);

		return personaFisica;
	}

	public PersonaFisica removePersonaFisica(PersonaFisica personaFisica) {
		getPersonaFisicas().remove(personaFisica);
		personaFisica.setPersona(null);

		return personaFisica;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", apellido=" + apellido + ", nombre="
				+ nombre + "]";
	}

}