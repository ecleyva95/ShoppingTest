package com.shoppingtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.shoppingtest.Response.Response;
import com.shoppingtest.converter.Convertidor;
import com.shoppingtest.dao.VentaDAO;
import com.shoppingtest.dao.VentaEntryDAO;
import com.shoppingtest.entity.Cliente;
import com.shoppingtest.entity.Producto;
import com.shoppingtest.entity.Venta;
import com.shoppingtest.repository.ClienteRepository;
import com.shoppingtest.repository.ProductoRepository;
import com.shoppingtest.repository.VentaRepository;


@Service("ventaservice")
public class VentaService {

	@Autowired
	@Qualifier("ventaRepositorio")
	private VentaRepository ventaRepository;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;

	public Response registarVenta(Venta venta)
	{
		Response response = new Response();
		try {
		    ventaRepository.save(venta);
			response.httpStatus = "Ok";
			response.message = "Exito";
			response.code = 200;
			response.backendMessage = "Se ha creado con éxito";
			response.result=venta;
			
		} catch (Exception e) {
			response.httpStatus = "Internal Server Error";
			response.message ="Error" ;
			response.code = 500;
			response.backendMessage = e.getMessage();
		} return response;
	}
	
	public Response listar()
	{
		Response response = new Response();
		List<VentaDAO> ventas= convertidor.listaVentas(ventaRepository.findAll());
		response.httpStatus = "Ok";
		response.message = "Exito";
		response.code = 200;
		response.backendMessage = "La solicitud ha tenido éxito";
		response.result =ventas;
		return response;
	}
	

}