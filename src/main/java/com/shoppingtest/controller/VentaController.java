package com.shoppingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingtest.Response.Response;
import com.shoppingtest.dao.VentaEntryDAO;
import com.shoppingtest.entity.Venta;
import com.shoppingtest.service.VentaService;


@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	@Qualifier("ventaservice")
	VentaService ventaservice;
	@PostMapping("/registrar")
	public Response RegistrarVenta(@RequestBody Venta venta)
	{
		return ventaservice.registarVenta(venta);
	}
	
	@GetMapping("/listar")
	public Response Listar()
	{
		return ventaservice.listar();
	}
}