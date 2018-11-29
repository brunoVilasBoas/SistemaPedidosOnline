package com.javaee.bruno.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.javaee.bruno.objects.Pedido;
import com.javaee.bruno.objects.Produto;

public class PedidoService {

	private List<Pedido> listaPedidos = new ArrayList<Pedido>();
	private ProdutoService produtoService;
	
	public PedidoService() {
		produtoService = new ProdutoService();
		for(int i = 0; i < 10; i++) {
			Pedido pedido = new Pedido();
			
			pedido.setId((long) i);
			
			Random rand = new Random();
			Integer number = rand.nextInt(500000 + 1);
			pedido.setNumPedido(number.toString());
			
			List<Produto> produtos = new ArrayList<Produto>();
			produtos = produtoService.retornaTodos();
			pedido.setProdutos(produtos);
			
			pedido.setValorTotal(100.00);
			listaPedidos.add(pedido);
		}
	}
	
	public List<Pedido> retornaTodos() {
		return listaPedidos;
	}

	public Pedido retornaPorId(Integer id) {
		for(Pedido pedido : listaPedidos) {
			if(pedido.getId().equals(id)) {
				return pedido;
			}
		}
		return null;
	}
	
	public Pedido salvarPedido(List<Produto> produtos) {

		Pedido pedido = new Pedido();
		Random rand = new Random();
		Integer number = rand.nextInt(500000 + 1);
		Double vlrTotal = 0.0;
		
		pedido.setNumPedido(number.toString());
		pedido.setProdutos(produtos);
		
		for(Produto produto : produtos) {
			vlrTotal = vlrTotal + produto.getValorProduto();
		}
		pedido.setValorTotal(vlrTotal);
		
		//persistencia
		listaPedidos.add(pedido);
		
		return pedido;
	}

}
