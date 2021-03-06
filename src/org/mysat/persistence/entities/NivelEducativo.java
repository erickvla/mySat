package org.mysat.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.mysat.persistence.entities.ifc.IdNombreInterface;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the NIVEL_EDUCATIVO database table.
 * 
 */
@Entity
@Table(name="NIVEL_EDUCATIVO")
@NamedQuery(name="NivelEducativo.findAll", query="SELECT n FROM NivelEducativo n")
public class NivelEducativo implements Serializable, IdNombreInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9099718615673804488L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NIVEL_EDUCATIVO_ID")
	private long id;

	@Column(name="NIVEL_EDUCATIVO_NOMBRE")
	private String nombre;

	@Column(name="NIVEL_EDUCATIVO_TOPE")
	private BigDecimal tope;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="nivelEducativo")
	private List<Factura> facturas;

	public NivelEducativo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long nivelEducativoId) {
		this.id = nivelEducativoId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nivelEducativoNombre) {
		this.nombre = nivelEducativoNombre;
	}

	public BigDecimal getTope() {
		return this.tope;
	}

	public void setTope(BigDecimal nivelEducativoTope) {
		this.tope = nivelEducativoTope;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setNivelEducativo(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setNivelEducativo(null);

		return factura;
	}

	@Override
	public String toString() {
		return "NivelEducativo [id=" + id + ", nombre=" + nombre
				+ ", tope=" + tope + ", facturas=" + facturas + "]";
	}

}