package com.javaee.bruno.service;

import java.util.ArrayList;
import java.util.List;

import com.javaee.bruno.objects.Produto;

public class ProdutoService {
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private Integer actalId = 10;
	
	public ProdutoService() {
		
	}
	
	public void init() {
		for(int i = 0; i < 10; i++) {
			Produto produto = new Produto();
			produto.setId((long) i);
			produto.setNomeProduto("Camiseta" + i);
			produto.setValorProduto(10);
			listaProdutos.add(produto);
		}
	}
	
	public List<Produto> retornaTodos() {

		return listaProdutos;
	}

	public Produto retornaPorId(Integer id) {
		for(Produto produto : listaProdutos) {
			if(produto.getId().equals(id)) {
				return produto;
			}
		}
		return null;
	}
	
	public Produto salvarProduto(Produto produto) {
		
		produto.setId((long) actalId);

		listaProdutos.add(produto);
		
		return produto;
	}

}
