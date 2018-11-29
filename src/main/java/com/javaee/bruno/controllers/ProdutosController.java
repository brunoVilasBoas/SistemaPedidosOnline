package com.javaee.bruno.controllers;

import java.util.ArrayList;
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

import com.javaee.bruno.objects.Produto;
import com.javaee.bruno.service.ProdutoService;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutosController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutosController.class);
	
	private ProdutoService produtoService;
	
	public ProdutosController() {
		produtoService = new ProdutoService();
	}
	
	//-----SERVIÇOS GET
	
	//RETORNA TODOS OS PRODUTOS
	@GET
	public List<Produto> getTodosProdutos() {
		logger.info("getAllPedidos: {}");
		List<Produto> produtos = produtoService.retornaTodos();
		return produtos;
	}
	
	//RETORNA O PRODUTO POR ID
	@GET
	@Path("{id : \\d+}")
	public Response getProdutoPorId(@PathParam("id") Integer id) {
		
		logger.info("getById : {}", id);
		Produto produto = produtoService.retornaPorId(id);
		
		if(produto == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(produto).build();
	}
	
	//-----SERVIÇOS POST
	
	//CRIAR PRODUTO
	@POST
	public Response criarProduto (Produto produto, @Context UriInfo uriInfo) {
		logger.info("create: {}", produto);
		
		Produto produtoSalvo = produtoService.salvarProduto(produto); 
		logger.debug("Produto criado com id = ", produtoSalvo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(produtoSalvo.getId().toString());
		return Response.created(builder.build()).entity(produtoSalvo).build();
	}
	
	
}
