package com.shoppingtest.dao;

import java.util.List;

import com.shoppingtest.entity.Cliente;
import com.shoppingtest.entity.Venta;

public class ClienteDAO {
	
	private Integer idcliente;
	
	private String nombre;
	
	private String apellido;
	
	private String dni;
	
	private String telefono;
	
	private String email;
	
	private List<Venta> ventas;
    
	public ClienteDAO(Cliente cliente)
	{
		this.idcliente = cliente.getIdcliente();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.dni = cliente.getDni();
		this.telefono = cliente.getTelefono();
		this.email = cliente.getEmail();
		this.ventas = cliente.getVentas();
	}
	
	public ClienteDAO(Integer idcliente, String nombre, String apellido, String dni, String telefono, String email,List<Venta> ventas) {
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.ventas = ventas;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
