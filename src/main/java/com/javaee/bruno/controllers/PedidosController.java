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

import com.javaee.bruno.objects.Pedido;
import com.javaee.bruno.objects.Produto;
import com.javaee.bruno.service.PedidoService;

@Path("/pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidosController {
	
	private static final Logger logger = LoggerFactory.getLogger(PedidosController.class);
	
	private PedidoService pedidoService;
	
	public PedidosController() {
		pedidoService = new PedidoService();
	}
	
	//-----SERVIÇOS GET
	
	//RETORNA TODOS OS PEDIDOS
	@GET
	public List<Pedido> getTodosPedidos() {
		logger.info("getAllPedidos: {}");
		List<Pedido> pedidos = pedidoService.retornaTodos();
		return pedidos;
	}
	
	//RETORNA O PEDIDO POR ID
	@GET
	@Path("{id : \\d+}")
	public Response getPedidoPorId(@PathParam("id") Integer id) {
		
		logger.info("getById : {}", id);
		Pedido pedido = pedidoService.retornaPorId(id);
		
		if(pedido == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(pedido).build();
	}
	
	//-----SERVIÇOS POST
	
	//CRIAR PEDIDO
	
	@POST
	public Response criarPedido (List<Produto> produtos, @Context UriInfo uriInfo) {
		logger.info("create: {}", produtos);
		
		Pedido pedidoSalvo = pedidoService.salvarPedido(produtos); 
		logger.debug("Pedido criado com id = ", pedidoSalvo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(pedidoSalvo.getId().toString());
		return Response.created(builder.build()).entity(pedidoSalvo).build();
	}
	
	
}
