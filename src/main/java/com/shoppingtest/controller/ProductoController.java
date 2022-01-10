package com.shoppingtest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingtest.Response.Response;
import com.shoppingtest.entity.Producto;
import com.shoppingtest.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoservice")
	ProductoService productoservice;
	
	
	@PostMapping("/registrar")
	public Response RegistrarProducto(@RequestBody Producto producto)
	{
		return productoservice.registarProducto(producto);
	}
	
	@GetMapping("/listar")
	public Response Listar()
	{
		return productoservice.listar();
	}
	 @GetMapping("/{id}")
	 public Response ObtenerPorId(@PathVariable int id)
	 {
		return productoservice.buscarPorId(id);
	 }
	 @PutMapping("/{id}")
	 public Response ActualizarProducto(@RequestBody Producto producto,@PathVariable int id)
	{
			return productoservice.actualizarProducto(producto,id);
	}
	  @DeleteMapping("/{id}")
	 public Response EliminarProducto(@PathVariable int id)
	{
			return productoservice.eliminarProducto(id);
	}
}
