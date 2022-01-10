package com.shoppingtest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Venta implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idventa;

	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name="iddetalleventa")
    @JoinTable(name = "DetalleVenta", joinColumns = @JoinColumn(name = "idventa"), inverseJoinColumns = @JoinColumn(name = "idproducto"))
	private List<Producto> productos;
	
	public Venta()
	{
		
	}
	
	public Venta(Integer idventa, Date fecha, Cliente cliente, List<Producto> productos) {
		this.idventa = idventa;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getIdventa() {
		return idventa;
	}

	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
