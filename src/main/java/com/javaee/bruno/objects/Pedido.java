package com.javaee.bruno.objects;

import java.util.List;

public class Pedido {
	
	private Long id;
	private String numPedido;
	private List<Produto> produtos;
	private double valorTotal;
	
	
	public Pedido() {
		super();
	}
	
	public Pedido(Long id, String numPedido, List<Produto> produtos, double valorTotal) {
		super();
		this.id = id;
		this.numPedido = numPedido;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumPedido() {
		return numPedido;
	}
	
	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
