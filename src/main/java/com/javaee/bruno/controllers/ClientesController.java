package com.javaee.bruno.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaee.bruno.objects.Cliente;
import com.javaee.bruno.service.ClienteService;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientesController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientesController.class);
	
	private ClienteService clienteService;
	
	public ClientesController() {
		clienteService = new ClienteService();
	}
	
	//-----SERVIÇOS GET
	
	//RETORNA TODOS OS CLIENTES
	@GET
	public List<Cliente> getTodosClientes() {
		logger.info("getAllCliente: {}");
		List<Cliente> clientes = clienteService.retornaTodos();
		return clientes;
	}
	
	//RETORNA O CLIENTE POR ID
	@GET
	@Path("{id : \\d+}")
	public Response getClientePorId(@PathParam("id") Integer id) {
		
		logger.info("getById : {}", id);
		Cliente cliente = clienteService.retornaPorId(id);
		
		if(cliente == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(cliente).build();
	}
	
	//-----SERVIÇOS POST
	
	//CRIAR CLIENTE
	
	@POST
	public Response criarCliente (Cliente cliente, @Context UriInfo uriInfo) {
		logger.info("create: {}", cliente);
		
		Cliente clienteSalvo = clienteService.salvarCliente(cliente); 
		logger.debug("Pedido criado com id = ", clienteSalvo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(clienteSalvo.getId().toString());
		return Response.created(builder.build()).entity(clienteSalvo).build();
	}
	
	
}
