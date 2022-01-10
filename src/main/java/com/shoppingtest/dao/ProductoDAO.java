package com.shoppingtest.dao;

import java.util.List;

import com.shoppingtest.entity.Producto;
import com.shoppingtest.entity.Venta;

public class ProductoDAO {
	
	private Integer idproducto;
	private String nombre;
	private Double precio;
	private List<Venta> ventas;
	
	
	public ProductoDAO(Producto producto)
	{
		this.idproducto = producto.getIdproducto();
		this.nombre = producto.getNombre();
		this.precio = producto.getPrecio();
		this.ventas = producto.getVentas();
	}
	
	public ProductoDAO(Integer idproducto, String nombre, Double precio, List<Venta> ventas) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.ventas = ventas;
	}

	public Integer getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	
}
