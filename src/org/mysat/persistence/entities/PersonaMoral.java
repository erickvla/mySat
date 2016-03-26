package org.mysat.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.mysat.persistence.entities.ifc.IdNombreInterface;
import org.mysat.persistence.entities.ifc.RfcInterface;


/**
 * The persistent class for the PERSONA_MORAL database table.
 * 
 */
@Entity
@Table(name="PERSONA_MORAL")
@NamedQuery(name="PersonaMoral.findAll", query="SELECT p FROM PersonaMoral p")
public class PersonaMoral implements Serializable, IdNombreInterface, RfcInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6236599043792874910L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSONA_MORAL_ID")
	private long id;

	@Column(name="PERSONA_MORAL_RAZON_SOCIAL")
	private String nombre;

	@Column(name="PERSONA_MORAL_RFC")
	private String rfc;

	public PersonaMoral() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long personaMoralId) {
		this.id = personaMoralId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "PersonaMoral [id=" + id + ", nombre=" + nombre + ", rfc=" + rfc + "]";
	}

}