package com.shoppingtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingtest.Response.Response;
import com.shoppingtest.converter.Convertidor;
import com.shoppingtest.dao.ProductoDAO;
import com.shoppingtest.entity.Producto;
import com.shoppingtest.repository.ProductoRepository;

@Service("productoservice")
public class ProductoService {

	@Autowired
	@Qualifier("productoRepositorio")
	private ProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public Response registarProducto(Producto producto)
	{
		Response response = new Response();
		try {
			productoRepository.save(producto);
			response.httpStatus = "Ok";
			response.message = "Exito";
			response.code = 200;
			response.backendMessage = "Se ha creado con éxito";
			response.result=producto;
			
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
		List<ProductoDAO> productos= convertidor.listaProductos(productoRepository.findAll());
		response.httpStatus = "Ok";
		response.message = "Exito";
		response.code = 200;
		response.backendMessage = "La solicitud ha tenido éxito";
		response.result =productos;
		return response;
	}
	
	public Response buscarPorId(int id)
	{
	Response response = new Response();
	ProductoDAO dao = null;
	try {
		dao = new ProductoDAO(productoRepository.getById(id));
		response.httpStatus = "Ok";
		response.message = "Exito";
		response.code = 200;
		response.backendMessage = "La solicitud ha tenido éxito";
		response.result =dao;
		
	} catch (Exception e) {
		response.httpStatus = "Internal Server Error";
		response.message ="Error" ;
		response.code = 500;
		response.backendMessage = e.getMessage();
	}
	if (dao==null) {
		response.httpStatus = "Not Found";
		response.message ="Error" ;
		response.code = 404;
		response.backendMessage = "El servidor no pudo encontrar el contenido solicitado";
	}
	return response;
	}
	
	public Response actualizarProducto(Producto producto,int id)
	{
		Response response = new Response();
		Producto actual = new Producto();
		try {
			actual = productoRepository.getById(id);
			actual.setNombre(producto.getNombre());
			actual.setPrecio(producto.getPrecio());
			productoRepository.save(actual);
			response.httpStatus = "Ok";
			response.message = "Exito";
			response.code = 200;
			response.backendMessage = "La actualizacion ha tenido éxito";
			response.result = actual;
			
		} catch (Exception e) {
			response.httpStatus = "Internal Server Error";
			response.message ="Error" ;
			response.code = 500;
			response.backendMessage = e.getMessage();
		}
		if (actual==null){
			response.httpStatus = "Not Found";
			response.message ="Error" ;
			response.code = 404;
			response.backendMessage = "no se pudo editar el producto con "+id+",no existe en bd";
		}
		return response;
	}
 

	public Response eliminarProducto(int id) {
		Response response = new Response();
		try {
			productoRepository.deleteById(id);
			response.httpStatus = "Ok";
			response.message = "Exito";
			response.code = 200;
			response.backendMessage = "El producto ha sido eliminado con exito";
		
		} catch (Exception e) {
			response.httpStatus = "Internal Server Error";
			response.message ="Error" ;
			response.code = 404;
			response.backendMessage = e.getMessage();
		}
		return response;	
	}
	
}
