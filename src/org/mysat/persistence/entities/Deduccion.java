package org.mysat.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mysat.persistence.entities.ifc.IdNombreInterface;

import java.util.List;


/**
 * The persistent class for the DEDUCCION database table.
 * 
 */
@Entity
@NamedQuery(name="Deduccion.findAll", query="SELECT d FROM Deduccion d")
public class Deduccion implements Serializable, IdNombreInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8784488528715654017L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEDUCCION_ID")
	private long id;

	@Column(name="DEDUCCION_NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="deduccion")
	private List<Factura> facturas;

	public Deduccion() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long deduccionId) {
		this.id = deduccionId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String deduccionNombre) {
		this.nombre = deduccionNombre;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setDeduccion(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setDeduccion(null);

		return factura;
	}

	@Override
	public String toString() {
		return "Deduccion [id=" + id + ", nombre=" + nombre + ", facturas="
				+ facturas + "]";
	}

}