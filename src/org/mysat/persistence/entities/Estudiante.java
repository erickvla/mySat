package org.mysat.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mysat.Constants;
import org.mysat.persistence.entities.ifc.IdInterface;

import java.util.List;


/**
 * The persistent class for the ESTUDIANTE database table.
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_ALL, 
				query = "SELECT e FROM Estudiante e"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_ID, 
				query = "SELECT e FROM Estudiante e WHERE e.id = :id"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP, 
				query = "SELECT e FROM Estudiante e WHERE e.curp = :curp"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_CURP_LIKE, 
				query = "SELECT e FROM Estudiante e WHERE e.curp LIKE :curp"), 
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE, 
				query = "SELECT e FROM Estudiante e WHERE e.persona.nombre = :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_NOMBRE_LIKE, 
				query = "SELECT e FROM Estudiante e WHERE e.persona.nombre LIKE :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO, 
				query = "SELECT e FROM Estudiante e WHERE e.persona.apellido = :apellido"),
	@NamedQuery(name = Constants.NAMED_QUERY_ESTUDIANTE_FIND_BY_APELLIDO_LIKE, 
				query = "SELECT e FROM Estudiante e WHERE e.persona.apellido LIKE :apellido")
})
public class Estudiante implements Serializable, IdInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2188880594339178689L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ESTUDIANTE_ID")
	private long id;

	@Column(name="ESTUDIANTE_CURP")
	private String curp;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA_ID")
	private Persona persona;

	//bi-directional many-to-one association to PersonaFisicaEstudiante
	@ManyToMany(mappedBy = "estudiantes")
	private List<PersonaFisica> personaFisicas;
	
	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="estudiante")
	private List<Factura> facturas;

	public Estudiante() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<PersonaFisica> getPersonaFisicas() {
		return this.personaFisicas;
	}

	public void setPersonaFisicas(List<PersonaFisica> personaFisicas) {
		this.personaFisicas = personaFisicas;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", curp=" + curp + ", persona=" + persona
				+ ", personaFisicas=" + personaFisicas + "]";
	}

	public String display() {
		return "[ " + curp + ", " + getPersona().getNombre() + " " + getPersona().getApellido() + " ]";
	}
}