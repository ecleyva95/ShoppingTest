package com.shoppingtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shoppingtest.Response.Response;
import com.shoppingtest.converter.Convertidor;
import com.shoppingtest.dao.ClienteDAO;
import com.shoppingtest.entity.Cliente;
import com.shoppingtest.repository.ClienteRepository;

@Service("clienteservice")
public class ClienteService {
@Autowired
@Qualifier("clienteRepositorio")
private ClienteRepository clienteRepository;

@Autowired
@Qualifier("convertidor")
private Convertidor convertidor;


public Response registarCliente(Cliente cliente)
{
	Response response = new Response();
	try {
		clienteRepository.save(cliente);
		response.httpStatus = "Ok";
		response.message = "Exito";
		response.code = 200;
		response.backendMessage = "Se ha creado con éxito";
		response.result = cliente;
		
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
	List<ClienteDAO> clientes= convertidor.listaClientes(clienteRepository.findAll());
	response.httpStatus = "Ok";
	response.message = "Exito";
	response.code = 200;
	response.backendMessage = "La solicitud ha tenido éxito";
	response.result =clientes;
	return response;
}
}
