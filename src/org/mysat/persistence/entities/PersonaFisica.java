package org.mysat.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.mysat.Constants;
import org.mysat.persistence.entities.ifc.IdInterface;
import org.mysat.persistence.entities.ifc.RfcInterface;


/**
 * The persistent class for the PERSONA_FISICA database table.
 * 
 */
@Entity
@Table(name="PERSONA_FISICA")
@NamedQueries({ 
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_ALL, 
				query = "SELECT p FROM PersonaFisica p"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_ID, 
				query = "SELECT p FROM PersonaFisica p WHERE p.id = :id"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC, 
				query = "SELECT p FROM PersonaFisica p WHERE p.rfc = :rfc"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_RFC_LIKE, 
				query = "SELECT p FROM PersonaFisica p WHERE p.rfc LIKE :rfc"), 
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE, 
				query = "SELECT p FROM PersonaFisica p WHERE p.persona.nombre = :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_NOMBRE_LIKE, 
				query = "SELECT p FROM PersonaFisica p WHERE p.persona.nombre LIKE :nombre"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO, 
				query = "SELECT p FROM PersonaFisica p WHERE p.persona.apellido = :apellido"),
	@NamedQuery(name = Constants.NAMED_QUERY_PERSONA_FISICA_FIND_BY_APELLIDO_LIKE, 
				query = "SELECT p FROM PersonaFisica p WHERE p.persona.apellido LIKE :apellido")
})
public class PersonaFisica implements Serializable, IdInterface, RfcInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4832129551814558589L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSONA_FISICA_ID")
	private long id;

	@Column(name="PERSONA_FISICA_RFC")
	private String rfc;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="personaFisica")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="PERSONA_ID")
	private Persona persona;

	//bi-directional many-to-one association to PersonaFisicaEstudiante
	@ManyToMany
    @JoinTable(	name = "PERSONA_FISICA_ESTUDIANTE", 
    			joinColumns = @JoinColumn(name = "PERSONA_FISICA_ID"), 
    			inverseJoinColumns = @JoinColumn(name = "ESTUDIANTE_ID"))
    private List<Estudiante> estudiantes;

	public PersonaFisica() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	@Override
	public String toString() {
		return "PersonaFisica [id=" + id + ", rfc=" + rfc
				+ ", persona=" + persona.toString() + "]";
	}
	
	public String display() {
		return "[ " + rfc + ", " + getPersona().getNombre() + " " + getPersona().getApellido()+ " ]";
	}

}