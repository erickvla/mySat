package org.mysat.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mysat.persistence.entities.ifc.IdInterface;

import java.util.Date;


/**
 * The persistent class for the FACTURA database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable, IdInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5939790971160792208L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FACTURA_ID")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="FACTURA_FECHA")
	private Date fecha;

	@Column(name="FACTURA_FOLIO")
	private String folio;

	//bi-directional many-to-one association to PersonaFisica
	@ManyToOne
	@JoinColumn(name="PERSONA_FISICA_ID")
	private PersonaFisica personaFisica;

	//bi-directional many-to-one association to PersonaMoral
	@ManyToOne
	@JoinColumn(name="PERSONA_MORAL_ID")
	private PersonaMoral personaMoral;
	
	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="ESTUDIANTE_ID")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Beneficiario
	@ManyToOne
	@JoinColumn(name="BENEFICIARIO_ID")
	private Beneficiario beneficiario;

	//bi-directional many-to-one association to Deduccion
	@ManyToOne
	@JoinColumn(name="DEDUCCION_ID")
	private Deduccion deduccion;

	//bi-directional many-to-one association to NivelEducativo
	@ManyToOne
	@JoinColumn(name="NIVEL_EDUCATIVO_ID")
	private NivelEducativo nivelEducativo;

	public Factura() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long facturaId) {
		this.id = facturaId;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date facturaFecha) {
		this.fecha = facturaFecha;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String facturaFolio) {
		this.folio = facturaFolio;
	}

	public Beneficiario getBeneficiario() {
		return this.beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Deduccion getDeduccion() {
		return this.deduccion;
	}

	public void setDeduccion(Deduccion deduccion) {
		this.deduccion = deduccion;
	}

	public NivelEducativo getNivelEducativo() {
		return this.nivelEducativo;
	}

	public void setNivelEducativo(NivelEducativo nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public PersonaFisica getPersonaFisica() {
		return personaFisica;
	}

	public void setPersonaFisica(PersonaFisica personaFisica) {
		this.personaFisica = personaFisica;
	}

	public PersonaMoral getPersonaMoral() {
		return personaMoral;
	}

	public void setPersonaMoral(PersonaMoral personaMoral) {
		this.personaMoral = personaMoral;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", folio=" + folio + ", personaFisica=" + personaFisica
				+ ", personaMoral=" + personaMoral + ", estudiante=" + estudiante + ", beneficiario=" + beneficiario
				+ ", deduccion=" + deduccion + ", nivelEducativo=" + nivelEducativo + "]";
	}

}