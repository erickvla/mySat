package org.mysat.persistence.entities;

import java.io.Serializable;

import org.mysat.persistence.entities.ifc.IdInterface;


/**
 * The persistent class for the PERSONA_FISICA_ESTUDIANTE database table.
 * 
 */
/*@Entity
@Table(name="PERSONA_FISICA_ESTUDIANTE")
@NamedQuery(name="PersonaFisicaEstudiante.findAll", query="SELECT p FROM PersonaFisicaEstudiante p")*/
public class PersonaFisicaEstudiante implements Serializable, IdInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1930213465408827505L;

	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSONA_FISICA_ESTUDIANTE_ID")*/
	private long id;

	//bi-directional many-to-one association to Estudiante
	/*@ManyToOne
	@JoinColumn(name="ESTUDIANTE_ID")*/
	private Estudiante estudiante;

	//bi-directional many-to-one association to PersonaFisica
	/*@ManyToOne
	@JoinColumn(name="PERSONA_FISICA_ID")*/
	private PersonaFisica personaFisica;

	public PersonaFisicaEstudiante() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long personaFisicaEstudianteId) {
		this.id = personaFisicaEstudianteId;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public PersonaFisica getPersonaFisica() {
		return this.personaFisica;
	}

	public void setPersonaFisica(PersonaFisica personaFisica) {
		this.personaFisica = personaFisica;
	}

}