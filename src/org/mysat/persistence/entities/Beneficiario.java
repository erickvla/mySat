package org.mysat.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mysat.persistence.entities.ifc.IdNombreInterface;

import java.util.List;


/**
 * The persistent class for the BENEFICIARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Beneficiario.findAll", query="SELECT b FROM Beneficiario b")
public class Beneficiario implements Serializable, IdNombreInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6828274075463259007L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BENEFICIARIO_ID")
	private long id;

	@Column(name="BENEFICIARIO_NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="beneficiario")
	private List<Factura> facturas;

	public Beneficiario() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long beneficiarioId) {
		this.id = beneficiarioId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String beneficiarioNombre) {
		this.nombre = beneficiarioNombre;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setBeneficiario(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setBeneficiario(null);

		return factura;
	}

	@Override
	public String toString() {
		return "Beneficiario [id=" + id + ", nombre=" + nombre
				+ ", facturas=" + facturas + "]";
	}
	
	public String display() {
		return "[ " + getNombre() + " ]";
	}

}