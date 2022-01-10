package com.shoppingtest.dao;

import java.util.Date;
import java.util.List;

import com.shoppingtest.entity.Cliente;
import com.shoppingtest.entity.Producto;
import com.shoppingtest.entity.Venta;
import com.shoppingtest.repository.ClienteRepository;

public class VentaDAO {
	
	private Integer idventa;
	private Date fecha;
	private Cliente cliente;
	private List<Producto> productos;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public VentaDAO(Venta venta) {
		this.idventa = venta.getIdventa();
		this.fecha = venta.getFecha();
		this.cliente = venta.getCliente();
		this.productos = venta.getProductos();
	}
	public VentaDAO(Integer idventa, Date fecha, Cliente cliente, List<Producto> productos) {
		this.idventa = idventa;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}
	
	
	
	
}
