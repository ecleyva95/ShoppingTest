package com.shoppingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingtest.Response.Response;
import com.shoppingtest.entity.Cliente;
import com.shoppingtest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	@Qualifier("clienteservice")
	ClienteService clienteservice;
	
	@PostMapping("/registrar")
	public Response RegistrarCliente(@RequestBody Cliente cliente)
	{
		return clienteservice.registarCliente(cliente);
	}
	
	@GetMapping("/listar")
	public Response Listar()
	{
		return clienteservice.listar();
	}
}
