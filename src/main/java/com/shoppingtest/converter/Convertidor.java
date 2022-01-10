package com.shoppingtest.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shoppingtest.dao.ClienteDAO;
import com.shoppingtest.dao.ProductoDAO;
import com.shoppingtest.dao.VentaDAO;
import com.shoppingtest.entity.Cliente;
import com.shoppingtest.entity.Producto;
import com.shoppingtest.entity.Venta;

@Component("convertidor")
public class Convertidor {

	public List<ClienteDAO> listaClientes(List<Cliente> clientes)
	{
		List<ClienteDAO> clientesDAO= new ArrayList<>();
		for(Cliente cliente: clientes)
		{
			clientesDAO.add(new ClienteDAO(cliente));
		}return clientesDAO;
	}
	public List<ProductoDAO> listaProductos(List<Producto> productos)
	{
		List<ProductoDAO> productoDAO= new ArrayList<>();
		for(Producto producto: productos)
		{
			productoDAO.add(new ProductoDAO(producto));
		}return productoDAO;
	}
	public List<VentaDAO> listaVentas(List<Venta> ventas)
	{
		List<VentaDAO> ventaDAO= new ArrayList<>();
		for(Venta venta: ventas)
		{
			ventaDAO.add(new VentaDAO(venta));
		}return ventaDAO;
	}
	
	
}
